package view;
import bus.KhachHangBUS;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHangDTO;

public class KhachHang1 extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    int selectindex = -1;
    
   
    public KhachHang1() throws SQLException {
        initComponents();
        showAll();
    }
    public void showAll() throws SQLException {
        tableModel = (DefaultTableModel) jtbKH.getModel();
        showThongTin();
    }
    private void showThongTin() throws SQLException { 
        KhachHangBUS bus = new KhachHangBUS();
        tableModel.setRowCount(0);
        bus.docKhachHang();
        for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
            tableModel.addRow(new Object[]{ 
                kh.getMaKH(), 
                kh.getHoTen(),
                kh.getCCCD(), 
                kh.getDiaChi(),
                kh.getSoDienThoai(),
                kh.getNgaySinh(),
                kh.getGioiTinh()});
            }
    }
    public void timkiem(String timkiem, Object jcbTimkiem){
        if(jcbTimkiem == "Tên khách hàng"){
                tableModel.setRowCount(0);
                for (KhachHangDTO kh: KhachHangBUS.dsKhachHang) {
                    if(kh.getHoTen().contains(timkiem)){
                        tableModel.addRow(new Object[]{
                            kh.getMaKH(), 
                            kh.getHoTen(), 
                            kh.getCCCD(),
                            kh.getDiaChi(), 
                            kh.getSoDienThoai(),
                            kh.getNgaySinh(),
                            kh.getGioiTinh()});
                    }
                }
            }else if(jcbTimkiem == "CMND/CCCD"){
                 tableModel.setRowCount(0);
                for (KhachHangDTO kh: KhachHangBUS.dsKhachHang) {
                    if(kh.getCCCD().contains(timkiem)){
                        tableModel.addRow(new Object[]{
                            kh.getMaKH(), 
                            kh.getHoTen(), 
                            kh.getCCCD(),
                            kh.getDiaChi(), 
                            kh.getSoDienThoai(),
                            kh.getNgaySinh(),
                            kh.getGioiTinh()});
                    }
                }                       
        }else if(jcbTimkiem == "SDT"){
                 tableModel.setRowCount(0);
                for (KhachHangDTO kh: KhachHangBUS.dsKhachHang) {
                    if(String.valueOf(kh.getSoDienThoai()).contains(timkiem)){
                        tableModel.addRow(new Object[]{
                            kh.getMaKH(), 
                            kh.getHoTen(), 
                            kh.getCCCD(),
                            kh.getDiaChi(), 
                            kh.getSoDienThoai(),
                            kh.getNgaySinh(),
                            kh.getGioiTinh()});
                    }
                }                       
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbKH = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtfTimkiem = new javax.swing.JTextField();
        jbtTimkiem = new javax.swing.JButton();
        jbtHuy = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jcbTimkiem = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtfHoten = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jtfCCCD = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jtfSDT = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jcbGioitinh = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jtfDiachi = new javax.swing.JTextField();
        jbtThem = new javax.swing.JButton();
        jbtSua = new javax.swing.JButton();
        jbtXoa = new javax.swing.JButton();
        jtfNgaysinh = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        jtbKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "CMNN/CCCD", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Giới tính"
            }
        ));
        jtbKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbKHMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbKH);

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Thông tin khách hàng");

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jbtTimkiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtTimkiem.setForeground(new java.awt.Color(0, 153, 153));
        jbtTimkiem.setText("TÌM KIẾM");
        jbtTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtTimkiemActionPerformed(evt);
            }
        });

        jbtHuy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jbtHuy.setForeground(new java.awt.Color(157, 154, 154));
        jbtHuy.setText("HỦY");
        jbtHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtHuyActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 142, 142));
        jLabel2.setText("TÌM KIẾM TÊN KHÁCH HÀNG");

        jcbTimkiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên khách hàng", "CMND/CCCD", "SDT" }));
        jcbTimkiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTimkiemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfTimkiem)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbtTimkiem))
                            .addComponent(jcbTimkiem, 0, 241, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jLabel2)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jcbTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jtfTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jbtTimkiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Họ và tên khách hàng:");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Số CMNN/CCCD:");

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Số điện thoại:");

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Giới tính:");

        jLabel11.setForeground(new java.awt.Color(0, 102, 102));
        jLabel11.setText("Ngày sinh:");

        jcbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NỮ" }));
        jcbGioitinh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbGioitinhActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Địa Chỉ:");
        jLabel7.setMaximumSize(new java.awt.Dimension(93, 16));
        jLabel7.setMinimumSize(new java.awt.Dimension(93, 16));
        jLabel7.setPreferredSize(new java.awt.Dimension(93, 16));

        jbtThem.setBackground(new java.awt.Color(0, 153, 153));
        jbtThem.setForeground(new java.awt.Color(255, 255, 255));
        jbtThem.setText("THÊM");
        jbtThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtThemMouseClicked(evt);
            }
        });
        jbtThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtThemActionPerformed(evt);
            }
        });

        jbtSua.setForeground(new java.awt.Color(0, 153, 153));
        jbtSua.setText("SỬA");
        jbtSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jbtSuaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jbtSuaMousePressed(evt);
            }
        });
        jbtSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSuaActionPerformed(evt);
            }
        });

        jbtXoa.setBackground(new java.awt.Color(153, 153, 153));
        jbtXoa.setForeground(new java.awt.Color(255, 255, 255));
        jbtXoa.setText("XÓA");
        jbtXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(jtfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                            .addComponent(jtfDiachi))))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(279, 279, 279))
                            .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(43, 43, 43))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(35, 35, 35)))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jcbGioitinh, 0, 260, Short.MAX_VALUE)
                                    .addComponent(jtfNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jtfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jtfDiachi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jtfNgaysinh, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(104, 104, 104)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE, false)
                            .addComponent(jbtXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtSua, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jbtThem, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(384, 384, 384)
                        .addComponent(jLabel14)
                        .addGap(564, 564, 564)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jbtTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtTimkiemActionPerformed
        String timkiem=jtfTimkiem.getText();
        Object cbBox = jcbTimkiem.getSelectedItem();
        timkiem(timkiem, cbBox);
    }//GEN-LAST:event_jbtTimkiemActionPerformed

    private void jbtHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtHuyActionPerformed
            jtfTimkiem.setText("");
            jtbKH.repaint();
        try {
            showAll();
        } catch (SQLException ex) {
            Logger.getLogger(KhachHang1.class.getName()).log(Level.SEVERE, null, ex);
        }
            Reset();
    }//GEN-LAST:event_jbtHuyActionPerformed

    private boolean kiemTra(String cccd) throws SQLException{
        KhachHangBUS bus = new KhachHangBUS();
        bus.docKhachHang();
        for (KhachHangDTO nv : KhachHangBUS.dsKhachHang) {
            if(nv.getCCCD().equals(cccd)){
                return false;
            }
        }
        return true;
    }
    private void jbtThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtThemActionPerformed
        try {    
            KhachHangDTO kh = new KhachHangDTO();  
            kh.setMaKH(0);
            kh.setHoTen(jtfHoten.getText());
            kh.setCCCD(jtfCCCD.getText());
            kh.setDiaChi(jtfDiachi.getText());
            kh.setSoDienThoai(jtfSDT.getText());
            Date ngaySinh = jtfNgaysinh.getDate();
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime()); 
            kh.setNgaySinh(sqlDate);
            if(jcbGioitinh.getSelectedItem() == "NAM"){
                kh.setGioiTinh("NAM");
            } else if(jcbGioitinh.getSelectedItem() == "NỮ") {
                kh.setGioiTinh("NỮ");
            }
//          kh.MaKH= Integer.toString(jtbKH.getModel().getValueAt(n, 0));
            if(kiemTra(jtfCCCD.getText())){
                KhachHangBUS bus = new KhachHangBUS();  
                bus.themKH(kh);
                showAll();
                Reset();    
            }else{
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
            
    }//GEN-LAST:event_jbtThemActionPerformed

    private boolean kiemTra2(String cccd) throws SQLException{
        KhachHangBUS bus = new KhachHangBUS();
        bus.docKhachHang();
        for (KhachHangDTO nv : KhachHangBUS.dsKhachHang) {
            if(nv.getCCCD().equals(cccd)){
                return true;
            }
        }
        return false;
    }
    private void jbtSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSuaActionPerformed
        try {
            KhachHangDTO kh = new KhachHangDTO();
            int n = jtbKH.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
            if (n == -1) {
                JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
            } else {
                kh.setHoTen(jtfHoten.getText());
                kh.setCCCD(jtfCCCD.getText());
                kh.setDiaChi(jtfDiachi.getText());
                kh.setSoDienThoai(jtfSDT.getText());
                Date ngaySinh = jtfNgaysinh.getDate();
                java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
                kh.setNgaySinh(sqlDate);
                if(jcbGioitinh.getSelectedItem() == "NAM"){
                    kh.setGioiTinh("NAM");
                } else if(jcbGioitinh.getSelectedItem() == "NỮ") {
                    kh.setGioiTinh("NỮ");
                }
                kh.setMaKH(Integer.parseInt(tableModel.getValueAt(n, 0).toString()));
            }
//          kh.MaKH= Integer.toString(jtbKH.getModel().getValueAt(n, 0));
            if(kiemTra2(jtfCCCD.getText())){
                KhachHangBUS bus = new KhachHangBUS();
                bus.suaKH(kh,kh.getMaKH());
                jtbKH.repaint();
                showAll();
                Reset();        
            }else{
                JOptionPane.showMessageDialog(this, "Khách hàng đã tồn tại");
            }            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
    }//GEN-LAST:event_jbtSuaActionPerformed

    private void jbtThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtThemMouseClicked

    }//GEN-LAST:event_jbtThemMouseClicked

    private void jcbGioitinhActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbGioitinhActionPerformed
    }//GEN-LAST:event_jcbGioitinhActionPerformed

    private void jbtSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSuaMouseClicked
    }//GEN-LAST:event_jbtSuaMouseClicked

    private void jbtSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jbtSuaMousePressed

    }//GEN-LAST:event_jbtSuaMousePressed

    private void jtbKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbKHMouseClicked
        int n = jtbKH.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        } else {
            jtfHoten.setText(tableModel.getValueAt(n, 1).toString());
            jtfCCCD.setText(tableModel.getValueAt(n, 2).toString());
            jtfDiachi.setText(tableModel.getValueAt(n, 3).toString());
            jtfSDT.setText(tableModel.getValueAt(n, 4).toString());
            jtfNgaysinh.setDate((Date) tableModel.getValueAt(n, 5));
            jcbGioitinh.setSelectedItem(tableModel.getValueAt(n, 6).toString());
        }
    }//GEN-LAST:event_jtbKHMouseClicked

    private void jbtXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXoaActionPerformed
        int n = jtbKH.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        } else {
            try {
                int Ma = Integer.parseInt(tableModel.getValueAt(n, 0).toString());
                KhachHangBUS bus = new KhachHangBUS();
                bus.xoaKH(Ma);
                jtbKH.repaint();
                showAll();
                Reset();
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
    }//GEN-LAST:event_jbtXoaActionPerformed

    private void jcbTimkiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbTimkiemActionPerformed
    }//GEN-LAST:event_jcbTimkiemActionPerformed
    private void Reset(){
        jtfHoten.setText("");
        jtfCCCD.setText("");
        jtfDiachi.setText("");
        jtfSDT.setText("");
        jtfNgaysinh.setDate(null);
        jcbGioitinh.setSelectedIndex(0);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtHuy;
    private javax.swing.JButton jbtSua;
    private javax.swing.JButton jbtThem;
    private javax.swing.JButton jbtTimkiem;
    private javax.swing.JButton jbtXoa;
    private javax.swing.JComboBox<String> jcbGioitinh;
    private javax.swing.JComboBox<String> jcbTimkiem;
    private javax.swing.JTable jtbKH;
    private javax.swing.JTextField jtfCCCD;
    private javax.swing.JTextField jtfDiachi;
    private javax.swing.JTextField jtfHoten;
    private com.toedter.calendar.JDateChooser jtfNgaysinh;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTextField jtfTimkiem;
    // End of variables declaration//GEN-END:variables
}
