package view;

import bus.NhanVienBUS;
import bus.TaiKhoanBUS;
import database.NhanVienDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultButtonModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVienDTO;
import model.TaiKhoanDTO;
public class QuanLyDieuHanh extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    DefaultTableModel tableModel1;
    public QuanLyDieuHanh() throws SQLException {
        initComponents();
        showAll();
        showAll1();
    }
    
    public void showAll() throws SQLException {
        tableModel = (DefaultTableModel) nvTable.getModel();
        showThongTin();
    }
    
    public void showAll1() throws SQLException {
        tableModel1 = (DefaultTableModel) accTable.getModel();
        showThongTin1();
    }
    
    private void showThongTin1() throws SQLException { 
        NhanVienBUS bus = new NhanVienBUS();
        tableModel1.setRowCount(0);
        bus.docNhanVien();
        TaiKhoanBUS bus1 = new TaiKhoanBUS();
        bus1.docTK();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            for(TaiKhoanDTO tk: TaiKhoanBUS.dsTK){
                if(tk.getMaNV() == nv.getMaNV()){
                    tableModel1.addRow(new Object[]{ 
                        nv.getMaNV(), 
                        nv.getHoTen(),
                        tk.getQuyenTK(),
                        tk.getTinhTrang()});
                    }
                }      
            }           
    }
    
    private void showThongTin() throws SQLException {        
        NhanVienBUS bus = new NhanVienBUS();
        tableModel.setRowCount(0);
        bus.docNhanVien();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            tableModel.addRow(new Object[]{ 
                nv.getMaNV(), 
                nv.getHoTen(),
                nv.getCCCD(), 
                nv.getDiaChi(),
                nv.getSoDienThoai(),
                nv.getNgaySinh(),
                nv.getGioiTinh()});
            }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chucnang = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        nvTable = new javax.swing.JTable();
        jPanel7 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jtfHoten = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtfCCCD = new javax.swing.JTextField();
        jtfSDT = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jcbGioitinh = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jtfDiachi = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        addButton = new javax.swing.JButton();
        editButton = new javax.swing.JButton();
        deleteButton = new javax.swing.JButton();
        jtfNgaysinh = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        accTable = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        cbPhanQuyen = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        cbTinhTrang = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        jTabbedPane1.setBackground(new java.awt.Color(230, 243, 243));
        jTabbedPane1.setForeground(new java.awt.Color(0, 153, 153));
        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jPanel3.setBackground(new java.awt.Color(230, 243, 243));

        nvTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "CCCD", "Địa chỉ", "Số điện thoại", "Ngày sinh", "Giới tính"
            }
        ));
        nvTable.setToolTipText("");
        nvTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nvTableMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                nvTableMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(nvTable);

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel10.setForeground(new java.awt.Color(0, 102, 102));
        jLabel10.setText("Họ và tên:");

        jtfHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfHotenActionPerformed(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Số điện thoại:");

        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Giới tính:");

        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Ngày sinh:");

        jcbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NỮ" }));

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Số CCCD:");

        jLabel14.setForeground(new java.awt.Color(0, 102, 102));
        jLabel14.setText("Địa chỉ:");

        addButton.setBackground(new java.awt.Color(0, 153, 153));
        addButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        addButton.setForeground(new java.awt.Color(255, 255, 255));
        addButton.setText("THÊM");
        addButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addButtonActionPerformed(evt);
            }
        });

        editButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        editButton.setForeground(new java.awt.Color(0, 153, 153));
        editButton.setText("SỬA");
        editButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editButtonActionPerformed(evt);
            }
        });

        deleteButton.setBackground(new java.awt.Color(204, 204, 204));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        deleteButton.setForeground(new java.awt.Color(255, 255, 255));
        deleteButton.setText("XÓA");
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel5))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfHoten, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(jtfCCCD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel14))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jtfDiachi)
                            .addComponent(jtfSDT))))
                .addGap(52, 52, 52)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jtfHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(editButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(deleteButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(addButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtfDiachi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(jtfSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(23, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1035, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE)
                .addGap(21, 21, 21))
        );

        jTabbedPane1.addTab("Quản lý nhân viên", jPanel3);

        jPanel2.setBackground(new java.awt.Color(230, 243, 243));

        accTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã nhân viên", "Họ và tên", "Phân quyền", "Tình trạng"
            }
        ));
        accTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                accTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(accTable);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 153));
        jLabel1.setText("Danh sách tài khoản");

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cbPhanQuyen.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Quản lí", "Lễ tân" }));
        cbPhanQuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPhanQuyenActionPerformed(evt);
            }
        });
        jPanel5.add(cbPhanQuyen, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 30, 230, 30));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Điều chỉnh phân quyền:");
        jPanel5.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, 30));

        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Hoạt động", "Tạm khóa" }));
        cbTinhTrang.setName(""); // NOI18N
        jPanel5.add(cbTinhTrang, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 80, 230, 30));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Tình Trạng:");
        jPanel5.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, 30));

        btnLuu.setBackground(new java.awt.Color(0, 153, 153));
        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(255, 255, 255));
        btnLuu.setText("LƯU");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });
        jPanel5.add(btnLuu, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 50, 100, 40));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1048, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(489, 489, 489)
                        .addComponent(jLabel1)))
                .addContainerGap(48, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 512, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý tài khoản", jPanel2);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 786, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    private void Reset(){
        jtfHoten.setText("");
        jtfCCCD.setText("");
        jtfDiachi.setText("");
        jtfSDT.setText("");
        jtfNgaysinh.setDate(null);
        jcbGioitinh.setSelectedIndex(0);
    }
    
    private void cbPhanQuyenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPhanQuyenActionPerformed
    }//GEN-LAST:event_cbPhanQuyenActionPerformed

    private boolean kiemTra (String cccd) throws SQLException{
        NhanVienBUS bus = new NhanVienBUS();
        bus.docNhanVien();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            if(nv.getCCCD().equals(cccd)){
                return false;
            }
        }
        return true;
    }
    public static String chuyenDoiKhongDau(String hoTen) {
        String hoTenKhongDau = java.text.Normalizer.normalize(hoTen, java.text.Normalizer.Form.NFD);
        hoTenKhongDau = hoTenKhongDau.replaceAll("[^\\p{ASCII}]", "");

        return hoTenKhongDau;
    }
    private int timMaNV() throws SQLException{
        int maNV = 0;
        NhanVienBUS bus = new NhanVienBUS();
        bus.docNhanVien();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            maNV = nv.getMaNV();
        }
        return maNV;
    }
    private void addButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addButtonActionPerformed
        try {    
            NhanVienDTO nv = new NhanVienDTO();  
            nv.setMaNV(0);
            nv.setHoTen(jtfHoten.getText());
            nv.setCCCD(jtfCCCD.getText());
            nv.setDiaChi(jtfDiachi.getText());
            nv.setSoDienThoai(jtfSDT.getText());
            Date ngaySinh = jtfNgaysinh.getDate();
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime()); 
            nv.setNgaySinh(sqlDate);
            if(jcbGioitinh.getSelectedItem() == "NAM"){
                nv.setGioiTinh("NAM");
            } else if(jcbGioitinh.getSelectedItem() == "NỮ") {
                nv.setGioiTinh("NỮ");
            }
            if(kiemTra(jtfCCCD.getText())){
                // thêm tài nhân viên
                NhanVienBUS bus = new NhanVienBUS();
                bus.docNhanVien();
                bus.themNV(nv);
                showAll();
                Reset(); 
                
                // thêm tài khoản
                bus.docNhanVien();
                TaiKhoanBUS busTK = new TaiKhoanBUS();
                busTK.docTK();
                TaiKhoanDTO tk = new TaiKhoanDTO();
                tk.setMaNV(timMaNV());
                tk.setTaiKhoan(chuyenDoiKhongDau(jtfHoten.getText()).toLowerCase());
                tk.setMatKhau("123");
                tk.setQuyenTK("Lễ tân");
                tk.setTinhTrang("Hoạt động");
                busTK.insertTK(tk);
            }else{
                JOptionPane.showMessageDialog(this, "Nhân viên đã được thêm!!");
            }     
        } catch (Exception ex)   {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }     
    }//GEN-LAST:event_addButtonActionPerformed

    private void editButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editButtonActionPerformed
        try {
            NhanVienDTO nv = new NhanVienDTO();
            int n = nvTable.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
            if (n == -1) {
                JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
            } else {
                nv.setHoTen(jtfHoten.getText());
                nv.setCCCD(jtfCCCD.getText());
                nv.setDiaChi(jtfDiachi.getText());
                nv.setSoDienThoai(jtfSDT.getText());
                Date ngaySinh = jtfNgaysinh.getDate();
                java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
                nv.setNgaySinh(sqlDate);
                if(jcbGioitinh.getSelectedItem() == "NAM"){
                    nv.setGioiTinh("NAM");
                } else if(jcbGioitinh.getSelectedItem() == "NỮ") {
                    nv.setGioiTinh("NỮ");
                }
                nv.setMaNV(Integer.parseInt(tableModel.getValueAt(n, 0).toString()));
            }
    //          kh.MaKH= Integer.toString(jtbKH.getModel().getValueAt(n, 0));  
                if(kiemTra(jtfCCCD.getText())){
                    NhanVienBUS bus = new NhanVienBUS();
                    bus.docNhanVien();
                    bus.suaNV(nv,nv.getMaNV());
                    nvTable.repaint();
                    showAll();
                    Reset();    
                }else{
                    JOptionPane.showMessageDialog(this, "Đã có lỗi");
                }              
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
    }//GEN-LAST:event_editButtonActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int n = nvTable.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để xóa");
        } else {
            try {
                int Ma = Integer.parseInt(tableModel.getValueAt(n, 0).toString()); 
                NhanVienBUS bus = new NhanVienBUS();
                bus.docNhanVien();
                bus.xoaNV(Ma);
                nvTable.repaint();
                showAll();
                Reset();
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }       
    }//GEN-LAST:event_deleteButtonActionPerformed

    private void jtfHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfHotenActionPerformed

    private void nvTableMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nvTableMousePressed
      
    }//GEN-LAST:event_nvTableMousePressed

    private void nvTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nvTableMouseClicked
        int n = nvTable.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        }else {
            jtfHoten.setText(tableModel.getValueAt(n, 1).toString());
            jtfCCCD.setText(tableModel.getValueAt(n, 2).toString());
            jtfDiachi.setText(tableModel.getValueAt(n, 3).toString());
            jtfSDT.setText(tableModel.getValueAt(n, 4).toString());
            jtfNgaysinh.setDate((Date) tableModel.getValueAt(n, 5));
            jcbGioitinh.setSelectedItem(tableModel.getValueAt(n, 6).toString());
        }
    }//GEN-LAST:event_nvTableMouseClicked

    private void accTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_accTableMouseClicked
        int n = accTable.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        }else {
            cbPhanQuyen.setSelectedItem(tableModel1.getValueAt(n, 2).toString());
            cbTinhTrang.setSelectedItem(tableModel1.getValueAt(n, 3).toString());
        }
    }//GEN-LAST:event_accTableMouseClicked

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        int n = accTable.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        }else {
            try {
                TaiKhoanDTO tk = new TaiKhoanDTO();
                if(cbPhanQuyen.getSelectedItem() == "Quản lí"){
                    tk.setQuyenTK("Quản lí");
                } else if(cbPhanQuyen.getSelectedItem() == "Lễ tân") {
                    tk.setQuyenTK("Lễ tân");
                }
                if(cbTinhTrang.getSelectedItem() == "Hoạt động"){
                    tk.setTinhTrang("Hoạt động");
                } else if(cbTinhTrang.getSelectedItem() == "Tạm khóa") {
                    tk.setTinhTrang("Tạm khóa");
                }
                int MaNV = (Integer.parseInt(tableModel1.getValueAt(n, 0).toString()));
                tk.setMaNV(MaNV);
                TaiKhoanBUS bus = new TaiKhoanBUS();
                bus.docTK();
                bus.updateTK(tk);
                showAll1();
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyDieuHanh.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }//GEN-LAST:event_btnLuuActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable accTable;
    private javax.swing.JButton addButton;
    private javax.swing.JButton btnLuu;
    private javax.swing.JComboBox<String> cbPhanQuyen;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.ButtonGroup chucnang;
    private javax.swing.JButton deleteButton;
    private javax.swing.JButton editButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> jcbGioitinh;
    private javax.swing.JTextField jtfCCCD;
    private javax.swing.JTextField jtfDiachi;
    private javax.swing.JTextField jtfHoten;
    private com.toedter.calendar.JDateChooser jtfNgaysinh;
    private javax.swing.JTextField jtfSDT;
    private javax.swing.JTable nvTable;
    // End of variables declaration//GEN-END:variables
}
