package view;

import bus.PhieuThueBUS;
import bus.DichVuBUS;
import bus.HoaDonBUS;
import bus.KhachHangBUS;
import bus.KhuyenMaiBUS;
import bus.PhieuSuDungDichVuBUS;
import bus.PhongBUS;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import model.PhieuThueDTO;
import model.DichVuDTO;
import model.HoaDonDTO;
import model.KhachHangDTO;
import model.KhuyenMaiDTO;
import model.PhieuSuDungDichVuDTO;
import model.PhongDTO;

public class HoaDon extends javax.swing.JFrame {
    private int maKhachHang = -1;
    private int maPhong = -1;
    private int maNhanVien = -1;
    
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    
    public HoaDon(int maKH, int MP, int maNV) throws SQLException {
        initComponents();
        maKhachHang = maKH;
        maPhong = MP;
        maNhanVien = maNV;
        
        lbTongTienPhong.setText(tongTienPhong() + " VND");
        lbTongTienDV.setText(tongTienDV()+ " VND");
            if (cbKM.getSelectedIndex() != 0){
                lbTongHoaDon.setText((tongTienPhong() + tongTienDV()) * timPhanTramKM(cbKM.getSelectedIndex())/100 + " VND");
            }else{
                lbTongHoaDon.setText((tongTienPhong() + tongTienDV()) + " VND");
            }
        showAll();
    }
    
    private HoaDon() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public void showAll() throws SQLException{
        tableModel = (DefaultTableModel) tbThongTinHoaDon.getModel();
        showThongTinHoaDon();
        
        tableModel1 = (DefaultTableModel) tbDichVu.getModel();
        showDichVu();
        
        showThongTinKhachHang();
        
        loadKhuyenMai();
    }
    public void loadKhuyenMai() throws SQLException{
        KhuyenMaiBUS bus = new KhuyenMaiBUS();
        bus.docKhuyenMai();
        for (KhuyenMaiDTO km : KhuyenMaiBUS.dsKM) {
            cbKM.addItem(km.getTenKM());
        }
    }
    public String hinhThucThue(int i) throws SQLException{
            if(i==0){
                return "Theo ngày";
            }
            else if(i==1){
                return "Theo giờ";
            }
        return null;
    }
    public void showThongTinHoaDon() throws SQLException{
        PhieuThueBUS busCTPT = new PhieuThueBUS(); //Phieu
        KhachHangBUS busKH = new KhachHangBUS(); //KH
        busCTPT.docCTPT();
        busKH.docKhachHang();
        tableModel.setRowCount(0);
        float gia = 0;
        if(maPhong==-1){
            for (PhieuThueDTO pt : PhieuThueBUS.dsCTPT) {
                if(pt.getMaKH() == maKhachHang && pt.getTinhTrang()==0){// lấy đc mã KH
                    for (PhongDTO p : PhongBUS.dsPhong) {
                        if(pt.getMaPhong()== p.getMaPhong()){
                            if (pt.getHinhThucThue()==1){
                                gia = p.getGiaTheoGio();
                            } else{
                                gia = p.getGiaTheoNgay();
                            }
                            tableModel.addRow(new Object[]{
                                p.getMaPhong(),
                                pt.getNgayDen(),
                                pt.getNgayTra(),
                                hinhThucThue(pt.getHinhThucThue()),
                                pt.getNgayTra(),
                                p.getLoaiPhong(),
                                gia                      
                            });
                        }
                    }
                }
            }    
        }else{
            for (PhieuThueDTO pt : PhieuThueBUS.dsCTPT) {
                if(pt.getMaPhong()== maPhong && pt.getTinhTrang()==0){// lấy đc mã KH
                    for (PhongDTO p : PhongBUS.dsPhong) {
                        if(pt.getMaPhong()== p.getMaPhong()){
                            if (pt.getHinhThucThue()==1){
                                gia = p.getGiaTheoGio();
                            } else{
                                gia = p.getGiaTheoNgay();
                            }
                            tableModel.addRow(new Object[]{
                                p.getMaPhong(),
                                pt.getNgayDen(),
                                pt.getNgayTra(),
                                hinhThucThue(pt.getHinhThucThue()),
                                pt.getNgayTra(),
                                p.getLoaiPhong(),
                                gia                      
                            });
                        }
                    }
                }
            }
        }
        
    }
    
    private float tongTienPhong() throws SQLException{
        PhieuThueBUS busCTPT = new PhieuThueBUS(); //Phieu
        busCTPT.docCTPT();
        PhongBUS bus = new PhongBUS();
        bus.docDatPhong();

        long ngay = 0;
        long gio = 0;
        float tienNgay = 0;
        float tienGio = 0;
        if (maPhong==-1){// thanh toán tất cả phòng
            for (PhieuThueDTO pt : PhieuThueBUS.dsCTPT) {
                if(pt.getMaKH() == maKhachHang && pt.getTinhTrang()==0){
                    if(pt.getHinhThucThue() == 0){
                        for (PhongDTO p : PhongBUS.dsPhong) {
                            if(p.getMaPhong() == pt.getMaPhong()){
                                ngay += (pt.getNgayTra().getTime() -  pt.getNgayDen().getTime()) / (24 * 60 * 60 * 1000);
                                tienNgay += ngay * p.getGiaTheoNgay(); // ngày
                            }
                        }                

                    }else if(pt.getHinhThucThue() == 1){
                        for (PhongDTO p : PhongBUS.dsPhong) {
                            if(p.getMaPhong() == pt.getMaPhong()){
                                gio += (pt.getGioTra().getTime() -  pt.getGioDen().getTime()) / (60 * 60 * 1000);
                                tienGio += gio * p.getGiaTheoGio(); // giờ
                            }
                        }
                    } 
                }  
            }
        }else{   // thanh toán 1 phòng
            for (PhieuThueDTO pt : PhieuThueBUS.dsCTPT) {
                if(pt.getMaPhong()== maPhong && pt.getTinhTrang()==0){
                    if(pt.getHinhThucThue() == 0){
                        for (PhongDTO p : PhongBUS.dsPhong) {
                            if(p.getMaPhong() == pt.getMaPhong()){
                                ngay += (pt.getNgayTra().getTime() -  pt.getNgayDen().getTime()) / (24 * 60 * 60 * 1000);
                                tienNgay += ngay * p.getGiaTheoNgay(); // ngày
                            }
                        }                

                    }else if(pt.getHinhThucThue() == 1){
                        for (PhongDTO p : PhongBUS.dsPhong) {
                            if(p.getMaPhong() == pt.getMaPhong()){
                                gio += (pt.getGioTra().getTime() -  pt.getGioDen().getTime()) / (60 * 60 * 1000);
                                tienGio += gio * p.getGiaTheoGio(); // giờ
                            }
                        }
                    } 
                }  
            }
        }
        
        return tienNgay + tienGio;
    }
    private float tongTienDV() throws SQLException{
        DichVuBUS busDV = new DichVuBUS(); 
        PhieuSuDungDichVuBUS busPhieu = new PhieuSuDungDichVuBUS();
        busDV.docDichVu();
        float tienDV = 0; // tổng tiền DV
        busPhieu.docPhieuSDDV();
        if (maPhong==-1){// thanh toán tất cả dịch vụ của khách
            for (PhieuSuDungDichVuDTO phieu : PhieuSuDungDichVuBUS.dsPhieuSDDV) {
                if(phieu.getMaKH() == maKhachHang && phieu.getTinhTrang()==0){
                    for (DichVuDTO dv : DichVuBUS.dsDV) {
                        if(dv.getMaDV()== phieu.getMaDV()){
                            tienDV += phieu.getSoLuong()* dv.getGiaDV();
                        }
                    }
                }
            }
        }else{
            for (PhieuSuDungDichVuDTO phieu : PhieuSuDungDichVuBUS.dsPhieuSDDV) {
                if(phieu.getMaPhong()== maPhong && phieu.getTinhTrang()==0){
                    for (DichVuDTO dv : DichVuBUS.dsDV) {
                        if(dv.getMaDV()== phieu.getMaDV()){
                            tienDV += phieu.getSoLuong()* dv.getGiaDV();
                        }
                    }
                }
            }
        }
        
        return tienDV;
    }
    
    public void showDichVu() throws SQLException{
        DichVuBUS busDV = new DichVuBUS(); 
        PhieuSuDungDichVuBUS busPhieu = new PhieuSuDungDichVuBUS();
        busDV.docDichVu();
        busPhieu.docPhieuSDDV();
        tableModel1.setRowCount(0);
        if (maPhong==-1){
            for (PhieuSuDungDichVuDTO phieu : PhieuSuDungDichVuBUS.dsPhieuSDDV) {
                if(phieu.getMaKH() == maKhachHang && phieu.getTinhTrang()==0){// lấy đc mã KH
                    for (DichVuDTO dv : DichVuBUS.dsDV) {
                        if(dv.getMaDV()== phieu.getMaDV()){
                            tableModel1.addRow(new Object[]{
                                dv.getTenDV(),
                                phieu.getThoiGianSDDV(),
                                phieu.getSoLuong(),
                                dv.getGiaDV()});
                        }
                    }
                }
            }    
        }else{
            for (PhieuSuDungDichVuDTO phieu : PhieuSuDungDichVuBUS.dsPhieuSDDV) {
                if(phieu.getMaPhong()== maPhong && phieu.getTinhTrang()==0){// lấy đc mã KH
                    for (DichVuDTO dv : DichVuBUS.dsDV) {
                        if(dv.getMaDV()== phieu.getMaDV()){
                            tableModel1.addRow(new Object[]{
                                dv.getTenDV(),
                                phieu.getThoiGianSDDV(),
                                phieu.getSoLuong(),
                                dv.getGiaDV()});
                        }
                    }
                }
            }
        }       
    }

    public void showThongTinKhachHang() throws SQLException{
        KhachHangBUS busKH = new KhachHangBUS();
        busKH.docKhachHang();
        for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
            if(kh.getMaKH() == maKhachHang){
                txtHoTen.setText(kh.getHoTen());
                txtCCCD.setText(kh.getCCCD());
                txtDiaChi.setText(kh.getDiaChi());
                txtSoDienThoai.setText(kh.getSoDienThoai()+"");
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String formattedDate = formatter.format(kh.getNgaySinh());
                txtNgaySinh.setText(formattedDate);
                txtGioiTinh.setText(kh.getGioiTinh());
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtNgaySinh = new javax.swing.JTextField();
        txtGioiTinh = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThongTinHoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        lbTongTienPhong = new javax.swing.JLabel();
        lbTongTienDV = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        cbKM = new javax.swing.JComboBox<>();
        jLabel31 = new javax.swing.JLabel();
        lbTienKM = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        lbTongHoaDon = new javax.swing.JLabel();
        btnInHoaDon = new javax.swing.JPanel();
        jLabel40 = new javax.swing.JLabel();
        jPanel8 = new javax.swing.JPanel();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("HÓA ĐƠN");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel1)
                .addContainerGap(460, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 1020, 50);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Thông tin khách hàng");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(64, 6, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Họ và tên khách hàng:");

        txtHoTen.setEditable(false);
        txtHoTen.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Giới tính:");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Địa chỉ:");

        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Ngày sinh:");

        txtDiaChi.setEditable(false);

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Số điện thoại:");

        txtSoDienThoai.setEditable(false);

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("CCCD:");

        txtCCCD.setEditable(false);

        txtNgaySinh.setEditable(false);

        txtGioiTinh.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(98, 98, 98)
                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(102, 102, 102))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(35, 35, 35)
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel10)
                            .addGap(62, 62, 62)
                            .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(57, 57, 57))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(26, 26, 26))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(31, 32, 960, 170));

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Thông tin hóa đơn");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        tbThongTinHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Check-In", "Check-Out", "Hình thức thuê", "Thời gian ở", "Loại phòng", "Đơn giá"
            }
        ));
        jScrollPane1.setViewportView(tbThongTinHoaDon);

        tbDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Dịch vụ", "Thời gian gọi", "Số lần gọi", "Phí dịch vụ"
            }
        ));
        jScrollPane2.setViewportView(tbDichVu);

        jLabel15.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Tổng tiền phòng:");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Tổng tiền dịch vụ:");

        lbTongTienPhong.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTienPhong.setText("0.0 VND");

        lbTongTienDV.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTongTienDV.setText("0.0 VND");

        jLabel30.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(0, 102, 102));
        jLabel30.setText("Khuyến mãi:");

        cbKM.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Chọn khuyến mãi" }));
        cbKM.setName(""); // NOI18N
        cbKM.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbKMItemStateChanged(evt);
            }
        });

        jLabel31.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel31.setForeground(new java.awt.Color(0, 102, 102));
        jLabel31.setText("Số tiền khuyến mãi:");

        lbTienKM.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lbTienKM.setText("0.0 VND");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(158, 158, 158)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel15))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTongTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTongTienDV, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(94, 94, 94)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(42, 42, 42)
                                .addComponent(cbKM, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(jLabel31)
                                .addGap(33, 33, 33)
                                .addComponent(lbTienKM)))))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel30)
                        .addComponent(cbKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(lbTongTienPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbTongTienDV)
                    .addComponent(jLabel31)
                    .addComponent(lbTienKM))
                .addGap(19, 19, 19))
        );

        jPanel3.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 230, 960, 520));

        jLabel38.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(0, 102, 102));
        jLabel38.setText("TỔNG TIỀN KHÁCH PHẢI THANH TOÁN:");
        jPanel3.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 770, -1, -1));

        lbTongHoaDon.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lbTongHoaDon.setForeground(new java.awt.Color(0, 153, 153));
        lbTongHoaDon.setText("0.0 VND");
        jPanel3.add(lbTongHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 770, 190, -1));

        btnInHoaDon.setBackground(new java.awt.Color(0, 153, 153));
        btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnInHoaDonMousePressed(evt);
            }
        });

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setText("THANH TOÁN");

        javax.swing.GroupLayout btnInHoaDonLayout = new javax.swing.GroupLayout(btnInHoaDon);
        btnInHoaDon.setLayout(btnInHoaDonLayout);
        btnInHoaDonLayout.setHorizontalGroup(
            btnInHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnInHoaDonLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addComponent(jLabel40)
                .addGap(37, 37, 37))
        );
        btnInHoaDonLayout.setVerticalGroup(
            btnInHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel3.add(btnInHoaDon, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 830, -1, -1));

        jPanel8.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        jPanel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel8MousePressed(evt);
            }
        });

        jLabel42.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setText("HỦY THANH TOÁN");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(16, 16, 16))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel42, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        jPanel3.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 830, -1, -1));

        jPanel1.add(jPanel3);
        jPanel3.setBounds(0, 50, 1019, 910);

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 960));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void capNhatTinhTrangPhong() throws SQLException{
            //cập nhật tình trạng phòng
            PhongBUS busPhong = new PhongBUS();
            busPhong.docDatPhong();
            PhieuThueBUS busCTPT = new PhieuThueBUS();
            busCTPT.docCTPT();
            if(maPhong==-1){
                for (PhieuThueDTO p : PhieuThueBUS.dsCTPT) {
                    if(p.getTinhTrang()==0){
                        busPhong.capNhatTinhTrangPhong(p.getMaPhong(), 3);
                    }
                }
            }else{
                busPhong.capNhatTinhTrangPhong(maPhong, 3);
            }
    }
    private void capNhatPhieuThue() throws SQLException{
            PhieuThueDTO pt = new PhieuThueDTO();
            PhieuThueBUS busPT = new PhieuThueBUS();
            busPT.docCTPT();
            if(maPhong==-1){
                busPT.capNhatPTAll(maKhachHang, 1);
            }else{
                busPT.capNhatPT(maPhong, 1);
            }
    }
    private void btnInHoaDonMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnInHoaDonMousePressed
        try {
            // lưu lại hóa đơn
            long millis=System.currentTimeMillis();  
            java.sql.Date date=new java.sql.Date(millis); 
            HoaDonBUS busHD = new HoaDonBUS();
            busHD.docHoaDon();
            HoaDonDTO hd = new HoaDonDTO(1,maNhanVien, maKhachHang, (tongTienPhong() + tongTienDV()) * timPhanTramKM(cbKM.getSelectedIndex())/100,
                    tongTienDV(), tongTienPhong() + tongTienDV(),date);
            busHD.docHoaDon();
            busHD.themHD(hd);
            
            
            capNhatTinhTrangPhong();
            capNhatPhieuThue();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnInHoaDonMousePressed

    private void cbKMItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbKMItemStateChanged
        try {
            lbTienKM.setText((tongTienPhong() + tongTienDV()) * timPhanTramKM(cbKM.getSelectedIndex())/100 + " VND");
            if (cbKM.getSelectedIndex() != 0){
                lbTongHoaDon.setText((tongTienPhong() + tongTienDV()) - (tongTienPhong() + tongTienDV()) * timPhanTramKM(cbKM.getSelectedIndex())/100 + " VND");
            }else{
                lbTongHoaDon.setText((tongTienPhong() + tongTienDV()) + " VND");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_cbKMItemStateChanged

    private void jPanel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel8MousePressed
        this.dispose();
    }//GEN-LAST:event_jPanel8MousePressed

    // tìm mã dịch vụ
    public int timPhanTramKM(int index) throws SQLException{
        KhuyenMaiBUS bus = new KhuyenMaiBUS();
        bus.docKhuyenMai();
        int dem = 1;
        for (KhuyenMaiDTO km : KhuyenMaiBUS.dsKM) {
            if(dem == index){
                System.out.println(index);
                return km.getPhanTramKM();
            }
            dem++;
        }
        return 0;
    }
    
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
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnInHoaDon;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbKM;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbTienKM;
    private javax.swing.JLabel lbTongHoaDon;
    private javax.swing.JLabel lbTongTienDV;
    private javax.swing.JLabel lbTongTienPhong;
    private javax.swing.JTable tbDichVu;
    private javax.swing.JTable tbThongTinHoaDon;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtGioiTinh;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtNgaySinh;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
