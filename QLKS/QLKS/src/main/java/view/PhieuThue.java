package view;
import bus.PhieuThueBUS;
import bus.DichVuBUS;
import bus.KhachHangBUS;
import bus.PhieuSuDungDichVuBUS;
import bus.PhongBUS;
import bus.TaiKhoanBUS;
import java.sql.SQLException;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import model.PhieuThueDTO;
import model.DichVuDTO;
import model.KhachHangDTO;
import model.PhieuSuDungDichVuDTO;
import model.PhongDTO;
import model.TaiKhoanDTO;

public class PhieuThue extends javax.swing.JFrame {
    public int maPhong;
    public String username;
    public int maKH = -1;
    
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    DefaultTableModel tableModel3;
    
    public PhieuThue(int maphong, String user, int maKhach) throws SQLException {
        initComponents();
        maPhong = maphong;
        username = user;
        cbTheoNgay1.isSelected();
        maKH = maKhach;
        showAll();
    }

    private PhieuThue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void showAll() throws SQLException {
        tableModel = (DefaultTableModel) tbPhongDangClick.getModel();
        showThongTinPhongDangChon();
        
        loadDichVu();
        
        tinhTrangPhong();
    }
    private void loadPhieuThue(int maCTPT) throws SQLException{// nếu phòng đã đc thuê thì load data lên
        PhieuThueBUS busCTPT = new PhieuThueBUS();
        busCTPT.docCTPT();
        for (PhieuThueDTO ctpt : PhieuThueBUS.dsCTPT) {
            if(maCTPT == ctpt.getMaPT() && ctpt.getTinhTrang()==0){
                KhachHangBUS busKH = new KhachHangBUS();
                busKH.docKhachHang();
                for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
                    if(ctpt.getMaKH() == kh.getMaKH()){
                        HoVaTen1.setText(kh.getHoTen());
                        CCCD1.setText(kh.getCCCD());
                        DiaChi1.setText(kh.getDiaChi());
                        SoDienThoai1.setText(kh.getSoDienThoai() + "");
                        NgaySinh1.setDate(kh.getNgaySinh());
                        if(null == kh.getGioiTinh()){
                            GioiTinh1.setSelectedIndex(3);
                        }else switch (kh.getGioiTinh()) {
                            case "NAM", "nam", "Nam" -> GioiTinh1.setSelectedIndex(1);
                            case "NỮ", "nữ", "Nữ" -> GioiTinh1.setSelectedIndex(2);
                            default -> GioiTinh1.setSelectedIndex(3);
                        }
                    }
                }
                NgayKhachDen.setDate(ctpt.getNgayDen());
                GioKhachDen.setText(ctpt.getGioDen()+ "");
                NgayKhachDi.setDate(ctpt.getNgayTra());
                GioKhachDi.setText(ctpt.getGioTra()+ "");
                if(ctpt.getHinhThucThue() == 0){
                    cbTheoNgay1.setSelected(true);
                }else{
                    cbTheoGio1.setSelected(true);
                } 
                
                maKH = ctpt.getMaKH();
            }
        }
    }
    
    private void tinhTrangPhong() throws SQLException{// tìm MaCTPT của phòng
        PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        for (PhongDTO p : PhongBUS.dsPhong) {
            if(p.getTinhTrang() == 2 && p.getMaPhong()==maPhong){//có khách thuê
                PhieuThueBUS busCTPT = new PhieuThueBUS();
                busCTPT.docCTPT();
                int maxMaCTPT = 0;
                for (PhieuThueDTO ctpt : PhieuThueBUS.dsCTPT) {
                    if(maPhong == ctpt.getMaPhong()){
                        if(ctpt.getMaPT() > maxMaCTPT){
                            maxMaCTPT = ctpt.getMaPT();
                        }
                    }
                }
                loadPhieuThue(maxMaCTPT); 
                
                tableModel1 = (DefaultTableModel) tbChiTietVeThuePhong.getModel();
                cacPhongMaKhachThue();

                tableModel3 = (DefaultTableModel) tbDichVu.getModel();
                showPhieuSDDV();
            }
        }
    }
    private void Reset1(){
        HoVaTen1.setText("");
        CCCD1.setText("");
        DiaChi1.setText("");
        SoDienThoai1.setText("");
        NgaySinh1.setDate(null);
        GioiTinh1.setSelectedIndex(0);
    }
    private void Reset2(){
        NgayKhachDen.setDate(null);
        GioKhachDen.setText("");
        NgayKhachDi.setDate(null);
        GioKhachDi.setText("");
    }
    public void loadDichVu() throws SQLException{
        DichVuBUS bus = new DichVuBUS();
        bus.docDichVu();
        for (DichVuDTO dv : DichVuBUS.dsDV) {
            cbDichVu.addItem(dv.getTenDV());
        }
    }
    // tìm giá dịch vụ
    public float timGiaDV(int maDV) throws SQLException{
        DichVuBUS bus = new DichVuBUS();
        bus.docDichVu();
        for (DichVuDTO dv : DichVuBUS.dsDV) {
            if(maDV == dv.getMaDV()){
                return dv.getGiaDV();
            }
        }
        return 0;
    }
    public String tenDV(int maDV) throws SQLException{
        DichVuBUS bus = new DichVuBUS();
        bus.docDichVu();
        for (DichVuDTO dv : DichVuBUS.dsDV) {
            if(maDV == dv.getMaDV()){
                return dv.getTenDV();
            }
        }
        return null; 
    }
    public void showPhieuSDDV() throws SQLException{
        PhieuSuDungDichVuBUS bus = new PhieuSuDungDichVuBUS();
        bus.docPhieuSDDV();
        tableModel3.setRowCount(0);
        for (PhieuSuDungDichVuDTO p : PhieuSuDungDichVuBUS.dsPhieuSDDV) {
            if(p.getMaKH()== maKH && p.getTinhTrang()==0){
                tableModel3.addRow(new Object[]{
                p.getMaPhong(),
                tenDV(p.getMaDV()),
                p.getSoLuong(),
                timGiaDV(p.getMaDV()),
                p.getThoiGianSDDV()});
            }
        }
    }
    
    private void showThongTinPhongDangChon(){
        PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        tableModel.setRowCount(0);
        for (PhongDTO p : PhongBUS.dsPhong) {
            if(p.getMaPhong() == maPhong){
                tableModel.addRow(new Object[]{
                p.getMaPhong(),
                p.getSoGiuong(),
                p.getLoaiPhong(),
                p.getGiaTheoNgay(),
                p.getGiaTheoGio()});
            }
        }
    }
    // mã khách hàng lớn nhất trong danh sách
    private int maxMaKH() throws SQLException{
        KhachHangBUS busKH = new KhachHangBUS();
        busKH.docKhachHang();
        int maKH = -1;
        for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
            if(kh.getMaKH()>maKH){
                maKH = kh.getMaKH();
            }
        }
        return maKH;
    }
    public void cacPhongMaKhachThue() throws SQLException {
        PhieuThueBUS busCTPT = new PhieuThueBUS();
        KhachHangBUS busKH = new KhachHangBUS();
        busCTPT.docCTPT();
        busKH.docKhachHang();
        tableModel1.setRowCount(0);
        for (PhieuThueDTO pt : PhieuThueBUS.dsCTPT) {
            if(pt.getMaKH() == maKH && pt.getTinhTrang()==0){// lấy đc mã KH
                for (PhongDTO p : PhongBUS.dsPhong) {
                    if(pt.getMaPhong()== p.getMaPhong()){
                        tableModel1.addRow(new Object[]{
                        p.getMaPhong(),
                        p.getLoaiPhong(),
                        p.getSoGiuong()});
                    }
                }
            }
        }
    }
    
    private int timMaNV(String user) throws SQLException{
        TaiKhoanBUS busTK = new TaiKhoanBUS();
        busTK.docTK();
        for (TaiKhoanDTO tk : TaiKhoanBUS.dsTK) {
            if(user.equals(tk.getTaiKhoan())){
                return tk.getMaNV();
            }
        }
        return 0;
    }
    public static boolean isValidPhoneNumber(String phoneNumber) {
        // Sử dụng biểu thức chính quy để kiểm tra xem số điện thoại có chứa chữ không.
        // Biểu thức này sẽ chấp nhận chỉ các chữ số và không chấp nhận bất kỳ ký tự khác.
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
    public static boolean isValidID(String id) {
        String regex = "^[0-9]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(id);
        return matcher.matches();
    }
    private boolean kiemTra(){
        try {
            //giờ
                SimpleDateFormat gio = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time = gio.parse(GioKhachDen.getText());
                Time gioKhachDen = new Time(time.getTime()); // chuyễn java.util.Date -> java.sql.Date

                //giờ
                SimpleDateFormat gio1 = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time1 = gio1.parse(GioKhachDi.getText());
                Time gioKhachDi = new Time(time.getTime()); // chuyễn java.util.Date -> java.sql.Date    

            String hoVaTen = HoVaTen1.getText();
            String cccd = CCCD1.getText();
             
            
            String diaChi = DiaChi1.getText();
            String sdt = SoDienThoai1.getText();
            Date ngaySinh = NgaySinh1.getDate();
            int gioiTinh = GioiTinh1.getSelectedIndex();
            int hinhThucThue = -1;
            if(cbTheoNgay1.isSelected()){
                hinhThucThue = 0;
            }else if(cbTheoGio1.isSelected()){
                hinhThucThue = 1;
            }
            Date ngayKhachDen = NgayKhachDen.getDate();
            Date ngayKhachDi = NgayKhachDi.getDate();
            return !(hoVaTen.equals("") || cccd.equals("") || diaChi.equals("") || sdt.equals("") || ngaySinh == null || 
                    gioiTinh == 0 || hinhThucThue == -1 || ngayKhachDen == null || ngayKhachDi == null ||
                    GioKhachDen.getText().equals("") || GioKhachDi.getText().equals("") || !isValidPhoneNumber(sdt)  || !isValidID(cccd)); 
        } catch (Exception e) {
            return false;
        }                          
    }
    // thêm chi tiết phiếu thuê
    private void themChiTietPhieuThue() throws SQLException, ParseException{
        //maPhong;
        int hinhThucThue = -1;
        if(cbTheoNgay1.isSelected()){
            hinhThucThue = 0;
        }else if(cbTheoGio1.isSelected()){
            hinhThucThue = 1;
        }
        /*------------------*/ 
        try{
        //ngày
                Date ngayKhachDen = NgayKhachDen.getDate();
                java.sql.Date sqlIN = new java.sql.Date(ngayKhachDen.getTime());

                //giờ
                SimpleDateFormat gio = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time = gio.parse(GioKhachDen.getText());
                Time gioKhachDen = new Time(time.getTime()); // chuyễn java.util.Date -> java.sql.Date

                //ngày
                Date ngayKhachDi = NgayKhachDi.getDate();
                java.sql.Date sqlOUT = new java.sql.Date(ngayKhachDi.getTime());

                //giờ
                SimpleDateFormat gio1 = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time1 = gio1.parse(GioKhachDi.getText());
                Time gioKhachDi = new Time(time1.getTime()); // chuyễn java.util.Date -> java.sql.Date    

                
                //THÊM LÊN SQL
                PhieuThueBUS busCTPT = new PhieuThueBUS();
                PhieuThueDTO ctpt = new PhieuThueDTO(1, timMaNV(username), maxMaKH(), maPhong, hinhThucThue, sqlIN,gioKhachDen,sqlOUT,gioKhachDi,0);
                busCTPT.docCTPT();
                busCTPT.insertCTPT(ctpt);
        
        }catch(Exception ex){
        }
                
              
    }
    private int timMaPT() throws SQLException{
        int mapt = 0;
        PhieuThueBUS bus = new PhieuThueBUS();
        bus.docCTPT();
        for (PhieuThueDTO p : PhieuThueBUS.dsCTPT) {
            if(p.getMaPhong() == maPhong && p.getTinhTrang()==0){
                mapt = p.getMaPT();
                return mapt;
            }
        }
        return mapt;
        
    }
    private int timMaKH() throws SQLException{
        int makh = 0;
        PhieuThueBUS bus = new PhieuThueBUS();
        bus.docCTPT();
        for (PhieuThueDTO p : PhieuThueBUS.dsCTPT) {
            if(p.getMaPhong() == maPhong && p.getTinhTrang()==0){
                makh = p.getMaKH();
                return makh;
            }
        }
        return makh;
    }
    private void suaChiTietPhieuThue() throws ParseException, SQLException{
        //maPhong;
        int hinhThucThue = -1;
        if(cbTheoNgay1.isSelected()){
            hinhThucThue = 0;
        }else if(cbTheoGio1.isSelected()){
            hinhThucThue = 1;
        }
        /*------------------*/ 
                //ngày
                Date ngayKhachDen = NgayKhachDen.getDate();
                java.sql.Date sqlIN = new java.sql.Date(ngayKhachDen.getTime());

                //giờ
                SimpleDateFormat gio = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time = gio.parse(GioKhachDen.getText());
                Time gioKhachDen = new Time(time.getTime()); // chuyễn java.util.Date -> java.sql.Date

                //ngày
                Date ngayKhachDi = NgayKhachDi.getDate();
                java.sql.Date sqlOUT = new java.sql.Date(ngayKhachDi.getTime());

                //giờ
                SimpleDateFormat gio1 = new SimpleDateFormat("HH:mm:ss");
                java.util.Date time1 = gio1.parse(GioKhachDi.getText());
                Time gioKhachDi = new Time(time1.getTime()); // chuyễn java.util.Date -> java.sql.Date    

                
                //SỬA TRÊN SQL
                PhieuThueBUS busCTPT = new PhieuThueBUS();
                PhieuThueDTO ctpt = new PhieuThueDTO(timMaPT(), timMaNV(username), timMaKH(), maPhong, hinhThucThue, sqlIN,gioKhachDen,sqlOUT,gioKhachDi,0);
                busCTPT.docCTPT();
                busCTPT.update(ctpt);
        
    }
    // thêm khách hàng
    private void themKhachHang() throws SQLException{
            String hoVaTen = HoVaTen1.getText();
            String cccd = CCCD1.getText();
            String diaChi = DiaChi1.getText();     
            String sdt = SoDienThoai1.getText();
            Date ngaySinh = NgaySinh1.getDate();
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());  
            String gioiTinh = "";
            switch (GioiTinh1.getSelectedIndex()) {
                case 0 -> JOptionPane.showMessageDialog(rootPane, "VUI LÒNG KIỂM TRA THÔNG TIN NHẬP");
                case 1 -> gioiTinh = "NAM";
                case 2 -> gioiTinh = "Nữ";
                case 3 -> gioiTinh = "KHÁC";
                default -> {
                }
            }
            KhachHangBUS busKH = new KhachHangBUS();
            KhachHangDTO kh = new KhachHangDTO(1,hoVaTen,cccd,diaChi,sdt,sqlDate,"NAM");
            busKH.docKhachHang();
            busKH.themKH(kh);
            maKH = maxMaKH(); 
    }
    // cập nhật khách hàng
    private void capNhapKhachHang() throws SQLException{
            String hoVaTen = HoVaTen1.getText();
            String cccd = CCCD1.getText();
            String diaChi = DiaChi1.getText();     
            String sdt = SoDienThoai1.getText();
            Date ngaySinh = NgaySinh1.getDate();
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());  
            String gioiTinh = "";
            switch (GioiTinh1.getSelectedIndex()) {
                case 0 -> JOptionPane.showMessageDialog(rootPane, "VUI LÒNG KIỂM TRA THÔNG TIN NHẬP");
                case 1 -> gioiTinh = "NAM";
                case 2 -> gioiTinh = "Nữ";
                case 3 -> gioiTinh = "KHÁC";
                default -> {
                }
            }
            KhachHangBUS busKH = new KhachHangBUS();
            KhachHangDTO kh = new KhachHangDTO(maKH,hoVaTen,cccd,diaChi,sdt,sqlDate,gioiTinh);
            busKH.docKhachHang();
            busKH.suaKH(kh, maKH); 
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GbHinhThuc = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        NgayKhachDen = new com.toedter.calendar.JDateChooser();
        NgayKhachDi = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        GioKhachDen = new javax.swing.JTextField();
        GioKhachDi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        cbTheoNgay1 = new javax.swing.JRadioButton();
        cbTheoGio1 = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbChiTietVeThuePhong = new javax.swing.JTable();
        txtSoPhongDaThue = new javax.swing.JLabel();
        btnTraPhong1 = new javax.swing.JPanel();
        jLabel48 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jLabel41 = new javax.swing.JLabel();
        cbDichVu = new javax.swing.JComboBox<>();
        btnThemDichVu = new javax.swing.JPanel();
        jLabel44 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbPhongDangClick = new javax.swing.JTable();
        btnTroVe = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        btnTraPhong = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JPanel();
        jLabel43 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        HoVaTen1 = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        CCCD1 = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        SoDienThoai1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        GioiTinh1 = new javax.swing.JComboBox<>();
        NgaySinh1 = new com.toedter.calendar.JDateChooser();
        DiaChi1 = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnKhachQuen = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();
        btnLamMoi1 = new javax.swing.JPanel();
        jLabel49 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        NgayKhachDen.setDateFormatString("yyyy-MM-dd");

        NgayKhachDi.setDateFormatString("yyyy-MM-dd");

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Ngày check-in:");

        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Ngày check-out:");

        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Giờ check-out:");

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Giờ check-in:");

        GioKhachDen.setCaretColor(new java.awt.Color(204, 204, 204));

        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Hình thức:");

        GbHinhThuc.add(cbTheoNgay1);
        cbTheoNgay1.setText("Theo ngày");
        cbTheoNgay1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTheoNgay1ActionPerformed(evt);
            }
        });

        GbHinhThuc.add(cbTheoGio1);
        cbTheoGio1.setText("Theo giờ");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GioKhachDen)
                    .addComponent(NgayKhachDen, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GioKhachDi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(NgayKhachDi, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbTheoNgay1)
                    .addComponent(cbTheoGio1))
                .addGap(41, 41, 41))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(cbTheoGio1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(GioKhachDen, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NgayKhachDen, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(NgayKhachDi, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbTheoNgay1)))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GioKhachDi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(8, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4);
        jPanel4.setBounds(20, 240, 871, 110);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Tất cả các phòng mà khách thuê");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(940, 0, 220, 30);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Thông tin khách hàng");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(50, 0, 143, 30);

        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel27.setForeground(new java.awt.Color(0, 102, 102));
        jLabel27.setText("Số phòng đã thuê:");

        tbChiTietVeThuePhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã phòng", "Loại phòng", "Số giường"
            }
        ));
        jScrollPane1.setViewportView(tbChiTietVeThuePhong);

        txtSoPhongDaThue.setText("0");

        btnTraPhong1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        btnTraPhong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTraPhong1MousePressed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setText("TRẢ TẤT CẢ PHÒNG CỦA KHÁCH");

        javax.swing.GroupLayout btnTraPhong1Layout = new javax.swing.GroupLayout(btnTraPhong1);
        btnTraPhong1.setLayout(btnTraPhong1Layout);
        btnTraPhong1Layout.setHorizontalGroup(
            btnTraPhong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTraPhong1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel48)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        btnTraPhong1Layout.setVerticalGroup(
            btnTraPhong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTraPhong1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 528, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel27)
                                .addGap(18, 18, 18)
                                .addComponent(txtSoPhongDaThue)
                                .addGap(37, 37, 37)))
                        .addGap(20, 20, 20))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(btnTraPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(149, 149, 149))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(txtSoPhongDaThue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTraPhong1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8))
        );

        jPanel1.add(jPanel6);
        jPanel6.setBounds(920, 30, 570, 320);

        jLabel28.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 102, 102));
        jLabel28.setText("Dịch vụ");
        jPanel1.add(jLabel28);
        jLabel28.setBounds(50, 350, 70, 30);

        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        tbDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Dịch vụ", "Số lần gọi", "Phí dịch vụ", "       Thời gian       "
            }
        ));
        jScrollPane2.setViewportView(tbDichVu);

        jLabel41.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(0, 102, 102));
        jLabel41.setText("Chọn dịch vụ");

        cbDichVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn dịch vụ" }));

        btnThemDichVu.setBackground(new java.awt.Color(0, 153, 153));
        btnThemDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThemDichVuMousePressed(evt);
            }
        });

        jLabel44.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setText("THÊM DỊCH VỤ");

        javax.swing.GroupLayout btnThemDichVuLayout = new javax.swing.GroupLayout(btnThemDichVu);
        btnThemDichVu.setLayout(btnThemDichVuLayout);
        btnThemDichVuLayout.setHorizontalGroup(
            btnThemDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnThemDichVuLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel44)
                .addContainerGap(19, Short.MAX_VALUE))
        );
        btnThemDichVuLayout.setVerticalGroup(
            btnThemDichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemDichVuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel44, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 102, 102));
        jLabel42.setText("Số lượng thêm");

        txtSoLuong.setText("1");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1062, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel41, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addComponent(btnThemDichVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel42)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jLabel41)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbDichVu, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThemDichVu, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel42)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8);
        jPanel8.setBounds(20, 380, 1470, 240);

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        tbPhongDangClick.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Số giường", "Loại phòng", "Giá theo ngày", "Giá theo giờ"
            }
        ));
        jScrollPane3.setViewportView(tbPhongDangClick);

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1419, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel10);
        jPanel10.setBounds(20, 650, 1468, 80);

        btnTroVe.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));
        btnTroVe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTroVeMousePressed(evt);
            }
        });

        jLabel50.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("TRỞ VỀ");

        javax.swing.GroupLayout btnTroVeLayout = new javax.swing.GroupLayout(btnTroVe);
        btnTroVe.setLayout(btnTroVeLayout);
        btnTroVeLayout.setHorizontalGroup(
            btnTroVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTroVeLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel50)
                .addContainerGap(37, Short.MAX_VALUE))
        );
        btnTroVeLayout.setVerticalGroup(
            btnTroVeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTroVeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel50, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnTroVe);
        btnTroVe.setBounds(890, 760, 120, 39);

        btnTraPhong.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        btnTraPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnTraPhongMousePressed(evt);
            }
        });

        jLabel47.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setText("TRẢ PHÒNG");

        javax.swing.GroupLayout btnTraPhongLayout = new javax.swing.GroupLayout(btnTraPhong);
        btnTraPhong.setLayout(btnTraPhongLayout);
        btnTraPhongLayout.setHorizontalGroup(
            btnTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnTraPhongLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel47)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        btnTraPhongLayout.setVerticalGroup(
            btnTraPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnTraPhongLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel47, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnTraPhong);
        btnTraPhong.setBounds(720, 760, 117, 39);

        btnLuu.setBackground(new java.awt.Color(0, 153, 153));
        btnLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLuuMousePressed(evt);
            }
        });

        jLabel43.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setText("LƯU");

        javax.swing.GroupLayout btnLuuLayout = new javax.swing.GroupLayout(btnLuu);
        btnLuu.setLayout(btnLuuLayout);
        btnLuuLayout.setHorizontalGroup(
            btnLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLuuLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel43)
                .addContainerGap(46, Short.MAX_VALUE))
        );
        btnLuuLayout.setVerticalGroup(
            btnLuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLuuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel43, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(btnLuu);
        btnLuu.setBounds(540, 760, 120, 39);

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Họ và tên:");

        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Số CCCD:");

        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Số điện thoại:");

        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Giới tính:");

        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Ngày sinh:");

        GioiTinh1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn giới tính", "Nam", "Nữ", "Khác" }));

        NgaySinh1.setDateFormatString("yyyy-MM-dd");

        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Địa chỉ:");

        btnKhachQuen.setBackground(new java.awt.Color(0, 153, 153));
        btnKhachQuen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnKhachQuenMousePressed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("KHÁCH QUEN");

        javax.swing.GroupLayout btnKhachQuenLayout = new javax.swing.GroupLayout(btnKhachQuen);
        btnKhachQuen.setLayout(btnKhachQuenLayout);
        btnKhachQuenLayout.setHorizontalGroup(
            btnKhachQuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnKhachQuenLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel46)
                .addContainerGap(15, Short.MAX_VALUE))
        );
        btnKhachQuenLayout.setVerticalGroup(
            btnKhachQuenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnKhachQuenLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        btnLamMoi1.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        btnLamMoi1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLamMoi1MousePressed(evt);
            }
        });

        jLabel49.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setText("LÀM MỚI");

        javax.swing.GroupLayout btnLamMoi1Layout = new javax.swing.GroupLayout(btnLamMoi1);
        btnLamMoi1.setLayout(btnLamMoi1Layout);
        btnLamMoi1Layout.setHorizontalGroup(
            btnLamMoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLamMoi1Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel49)
                .addGap(27, 27, 27))
        );
        btnLamMoi1Layout.setVerticalGroup(
            btnLamMoi1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnLamMoi1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel49, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel24)
                    .addComponent(jLabel12))
                .addGap(23, 23, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(HoVaTen1)
                    .addComponent(DiaChi1)
                    .addComponent(CCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(76, 76, 76)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(GioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel21)
                                .addGap(35, 35, 35)))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NgaySinh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(SoDienThoai1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(51, 51, 51))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnKhachQuen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79)
                .addComponent(btnLamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(HoVaTen1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CCCD1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DiaChi1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(SoDienThoai1)
                            .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(NgaySinh1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(GioiTinh1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnLamMoi1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKhachQuen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel5);
        jPanel5.setBounds(20, 30, 871, 200);

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setText("Thông tin phòng đang chọn");
        jPanel1.add(jLabel40);
        jLabel40.setBounds(50, 620, 190, 30);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 54, 1510, 830));

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("PHIẾU THUÊ PHÒNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(651, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(625, 625, 625))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(9, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1510, 60));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capNhatTinhTrangPhong(int maPhong, int tinhTrang){
        PhongBUS busPhong = new PhongBUS();
        busPhong.capNhatTinhTrangPhong(maPhong, tinhTrang);
    }
    private boolean CheckPhong(){//kiểm tra phòng đã có phiếu thì lưu
        PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        for (PhongDTO p : PhongBUS.dsPhong) {
            if(p.getMaPhong() == maPhong && p.getTinhTrang()==2){
                return false;
            }
        }
        return true;
    }
    
    private void btnLuuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMousePressed
        if(kiemTra()==true){
            try {
                if(CheckPhong()==true){//thêm
                    //thêm khách hàng
                    if(maKH==-1){// khách hàng mới thì mới thêm
                        themKhachHang();
                    }else{
                        capNhapKhachHang();
                    }
                    capNhatTinhTrangPhong(maPhong, 2);
                    themChiTietPhieuThue();    
                }else{
                    capNhapKhachHang();
                    suaChiTietPhieuThue();    
                }
                showAll();
                JOptionPane.showMessageDialog(rootPane, "ĐÃ LƯU!");
            } catch (Exception ex) {
                Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "VUI LÒNG KIỂM TRA THÔNG TIN NHẬP");
        }  
    }//GEN-LAST:event_btnLuuMousePressed

    private void btnTroVeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTroVeMousePressed
        this.dispose(); // tắt Phiếu thuê
    }//GEN-LAST:event_btnTroVeMousePressed

    public void LoadData(){
        //lấy data từ maKH
            KhachHangBUS bus = new KhachHangBUS();
            try {
                bus.docKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
            }
        
            for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
                if (kh.getMaKH() == maKH){
                    HoVaTen1.setText(kh.getHoTen());
                    CCCD1.setText(kh.getCCCD());
                    DiaChi1.setText(kh.getDiaChi());
                    SoDienThoai1.setText(kh.getSoDienThoai()+"");
                    NgaySinh1.setDate(kh.getNgaySinh());
                    if(null != kh.getGioiTinh())switch (kh.getGioiTinh()) {
                        case "NAM" -> GioiTinh1.setSelectedIndex(1);
                        case "NỮ" -> GioiTinh1.setSelectedIndex(2);
                        case "KHÁC" -> GioiTinh1.setSelectedIndex(3);
                        default -> {
                        }
                    } 
                }
            }
    }
    private void btnLamMoi1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLamMoi1MousePressed
        Reset1();  
        maKH = -1;
        try {        
            cacPhongMaKhachThue();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            showPhieuSDDV();
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLamMoi1MousePressed

    private void cbTheoNgay1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTheoNgay1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTheoNgay1ActionPerformed

    private void btnKhachQuenMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnKhachQuenMousePressed
        KhachQuen kq = null;
        try {
            kq = new KhachQuen(maPhong,maKH, username);
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        kq.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        kq.setLocationRelativeTo(null);
        kq.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnKhachQuenMousePressed

    // tìm mã dịch vụ
    public int timMaDV(int index) throws SQLException{
        DichVuBUS bus = new DichVuBUS();
        bus.docDichVu();
        int dem = 1;
        for (DichVuDTO dv : DichVuBUS.dsDV) {
            if(dem == index){
                return dv.getMaDV();
            } 
            dem++;
        }
        return 0;
    }
    private void btnThemDichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemDichVuMousePressed
        if(cbDichVu.getSelectedIndex()!=0 && maKH != -1 && Integer.parseInt(txtSoLuong.getText())>0){
            try {
                PhieuSuDungDichVuBUS busPhieuSDDV = new PhieuSuDungDichVuBUS();
                busPhieuSDDV.docPhieuSDDV();
                
                DichVuBUS bus = new DichVuBUS();
                bus.docDichVu();
                
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                String formattedDateTime = now.format(formatter);
                Timestamp timestamp = Timestamp.valueOf(formattedDateTime);
                
                for (DichVuDTO p : DichVuBUS.dsDV) {
                    if(p.getMaDV()== timMaDV(cbDichVu.getSelectedIndex())){
                        PhieuSuDungDichVuDTO phieu = new PhieuSuDungDichVuDTO(1,maKH ,maPhong ,p.getMaDV(),Integer.parseInt(txtSoLuong.getText()),timestamp, 0);
                        busPhieuSDDV.insertKH(phieu);
                    }
                }
                showPhieuSDDV();
                
            } catch (SQLException ex) {
                Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(rootPane, "Đã có lỗi");
        }
    }//GEN-LAST:event_btnThemDichVuMousePressed

    private void btnTraPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraPhongMousePressed
        HoaDon hd = null;
        try {
            hd = new HoaDon(maKH, maPhong, timMaNV(username));
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        hd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        hd.setLocationRelativeTo(null);
        hd.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnTraPhongMousePressed

    private void btnTraPhong1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTraPhong1MousePressed
            HoaDon hd = null;
        try {
            hd = new HoaDon(maKH, -1, timMaNV(username));
        } catch (SQLException ex) {
            Logger.getLogger(PhieuThue.class.getName()).log(Level.SEVERE, null, ex);
        }
        hd.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        hd.setLocationRelativeTo(null);
        hd.setVisible(true);
        
        this.dispose();
    }//GEN-LAST:event_btnTraPhong1MousePressed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PhieuThue.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PhieuThue().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CCCD1;
    private javax.swing.JTextField DiaChi1;
    private javax.swing.ButtonGroup GbHinhThuc;
    private javax.swing.JTextField GioKhachDen;
    private javax.swing.JTextField GioKhachDi;
    private javax.swing.JComboBox<String> GioiTinh1;
    private javax.swing.JTextField HoVaTen1;
    private com.toedter.calendar.JDateChooser NgayKhachDen;
    private com.toedter.calendar.JDateChooser NgayKhachDi;
    private com.toedter.calendar.JDateChooser NgaySinh1;
    private javax.swing.JTextField SoDienThoai1;
    private javax.swing.JPanel btnKhachQuen;
    private javax.swing.JPanel btnLamMoi1;
    private javax.swing.JPanel btnLuu;
    private javax.swing.JPanel btnThemDichVu;
    private javax.swing.JPanel btnTraPhong;
    private javax.swing.JPanel btnTraPhong1;
    private javax.swing.JPanel btnTroVe;
    private javax.swing.JComboBox<String> cbDichVu;
    private javax.swing.JRadioButton cbTheoGio1;
    private javax.swing.JRadioButton cbTheoNgay1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tbChiTietVeThuePhong;
    private javax.swing.JTable tbDichVu;
    private javax.swing.JTable tbPhongDangClick;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JLabel txtSoPhongDaThue;
    // End of variables declaration//GEN-END:variables
}
