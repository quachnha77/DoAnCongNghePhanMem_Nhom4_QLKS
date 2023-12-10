package view;

import bus.NhanVienBUS;
import bus.TaiKhoanBUS;
import database.TaiKhoanDAO;
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.NhanVienDTO;
import model.TaiKhoanDTO;

public class TaiKhoan extends javax.swing.JPanel {
    public int maNhanVien;
    public TaiKhoan(int maNV) throws SQLException {
        maNhanVien = maNV;
        initComponents();
        showAll();
    }
    
    public void showAll() throws SQLException {
        showThongTin();
    }
    public void showThongTin() throws SQLException {
        NhanVienBUS bus = new NhanVienBUS();
        bus.docNhanVien();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            if(nv.getMaNV() == maNhanVien){
                txtHoten.setText(nv.getHoTen());
                txtCCCD.setText(nv.getCCCD());
                txtDiaChi.setText(nv.getDiaChi());
                txtSDT.setText(nv.getSoDienThoai());
                jtfNgaysinh.setDate(nv.getNgaySinh());
                jcbGioitinh.setSelectedItem(nv.getGioiTinh());
            }
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        chucnang = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        txtMKMoi = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        txtLapLaiMK = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnLuuMK = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        txtMKHienTai = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        txtTenDNMoi = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtLapLaiTenDN = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        btnDoiTenDN = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        txtTenDNHienTai = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        txtHoten = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtCCCD = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jcbGioitinh = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        btnLuu = new javax.swing.JButton();
        jtfNgaysinh = new com.toedter.calendar.JDateChooser();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel12.setForeground(new java.awt.Color(0, 102, 102));
        jLabel12.setText("Mật khẩu mới:");

        jLabel13.setForeground(new java.awt.Color(0, 102, 102));
        jLabel13.setText("Nhập lại mật khẩu mới:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Đổi mật khẩu");

        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Mật khẩu hiện tại:");

        btnLuuMK.setBackground(new java.awt.Color(0, 153, 153));
        btnLuuMK.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnLuuMKMouseClicked(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("LƯU");

        javax.swing.GroupLayout btnLuuMKLayout = new javax.swing.GroupLayout(btnLuuMK);
        btnLuuMK.setLayout(btnLuuMKLayout);
        btnLuuMKLayout.setHorizontalGroup(
            btnLuuMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnLuuMKLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnLuuMKLayout.setVerticalGroup(
            btnLuuMKLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(jLabel8)
                    .addComponent(jLabel13))
                .addGap(33, 33, 33)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMKMoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 263, Short.MAX_VALUE)
                        .addComponent(txtMKHienTai, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(txtLapLaiMK, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 263, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(157, 157, 157))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                        .addComponent(btnLuuMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(169, 169, 169))))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel5)
                .addGap(35, 35, 35)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtMKHienTai)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMKMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLuuMK, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel15.setForeground(new java.awt.Color(0, 102, 102));
        jLabel15.setText("Tên đăng nhập mới:");

        jLabel16.setForeground(new java.awt.Color(0, 102, 102));
        jLabel16.setText("Nhập lại tên đăng nhập mới:");

        jLabel17.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 102, 102));
        jLabel17.setText("Đổi tên đăng nhập");

        jLabel18.setForeground(new java.awt.Color(0, 102, 102));
        jLabel18.setText("Tên đăng nhập hiện tại:");

        btnDoiTenDN.setBackground(new java.awt.Color(0, 153, 153));
        btnDoiTenDN.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDoiTenDNMouseClicked(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("LƯU");

        javax.swing.GroupLayout btnDoiTenDNLayout = new javax.swing.GroupLayout(btnDoiTenDN);
        btnDoiTenDN.setLayout(btnDoiTenDNLayout);
        btnDoiTenDNLayout.setHorizontalGroup(
            btnDoiTenDNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnDoiTenDNLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel19)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnDoiTenDNLayout.setVerticalGroup(
            btnDoiTenDNLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel19, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel17)
                .addGap(200, 200, 200))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(jLabel18)
                            .addComponent(jLabel16))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtTenDNMoi, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenDNHienTai, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtLapLaiTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel10Layout.createSequentialGroup()
                        .addGap(238, 238, 238)
                        .addComponent(btnDoiTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel17)
                .addGap(31, 31, 31)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTenDNHienTai)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenDNMoi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtLapLaiTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnDoiTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jLabel20.setForeground(new java.awt.Color(0, 102, 102));
        jLabel20.setText("Họ và tên:");

        txtHoten.setText(" ");
        txtHoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHotenActionPerformed(evt);
            }
        });

        jLabel21.setForeground(new java.awt.Color(0, 102, 102));
        jLabel21.setText("Số điện thoại:");

        txtCCCD.setText(" ");
        txtCCCD.setEnabled(false);

        txtSDT.setText(" ");

        jLabel22.setForeground(new java.awt.Color(0, 102, 102));
        jLabel22.setText("Giới tính:");

        jLabel23.setForeground(new java.awt.Color(0, 102, 102));
        jLabel23.setText("Ngày sinh:");

        jcbGioitinh.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NAM", "NỮ" }));

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Số CCCD:");

        txtDiaChi.setText(" ");

        jLabel24.setForeground(new java.awt.Color(0, 102, 102));
        jLabel24.setText("Địa chỉ:");

        btnLuu.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnLuu.setForeground(new java.awt.Color(0, 153, 153));
        btnLuu.setText("LƯU");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
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
                            .addComponent(jLabel20)
                            .addComponent(jLabel6))
                        .addGap(66, 66, 66)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtHoten, javax.swing.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                            .addComponent(txtCCCD)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21)
                            .addComponent(jLabel24))
                        .addGap(48, 48, 48)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtDiaChi)
                            .addComponent(txtSDT))))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jcbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel20)
                        .addComponent(txtHoten, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel23, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtfNgaysinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtCCCD, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 30, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel21)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jcbGioitinh, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(166, Short.MAX_VALUE))
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

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        try {
            NhanVienDTO nv = new NhanVienDTO();
            nv.setMaNV(maNhanVien);
            nv.setHoTen(txtHoten.getText());
            nv.setCCCD(txtCCCD.getText());
            nv.setDiaChi(txtDiaChi.getText());
            nv.setSoDienThoai(txtSDT.getText());
            Date ngaySinh = jtfNgaysinh.getDate();
            java.sql.Date sqlDate = new java.sql.Date(ngaySinh.getTime());
            nv.setNgaySinh(sqlDate);
            if(jcbGioitinh.getSelectedItem() == "NAM"){
                nv.setGioiTinh("NAM");
            } else if(jcbGioitinh.getSelectedItem() == "NỮ") {
                nv.setGioiTinh("NỮ");
            }
            NhanVienBUS bus = new NhanVienBUS();
            bus.docNhanVien();
            bus.suaNV(nv,maNhanVien);
            showAll();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void txtHotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHotenActionPerformed
    private String timSDT() throws SQLException{
        NhanVienBUS bus = new NhanVienBUS();
        bus.docNhanVien();
        for (NhanVienDTO nv : NhanVienBUS.dsNV) {
            if(nv.getMaNV() == maNhanVien){
                return nv.getSoDienThoai();
            }
        }
        return null;  
    }
    private void btnLuuMKMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLuuMKMouseClicked
        try {
            if(txtMKMoi.getText().equals(txtLapLaiMK.getText())){
                TaiKhoanBUS bus = new TaiKhoanBUS();
                bus.docTK();
                for (TaiKhoanDTO tk : TaiKhoanBUS.dsTK) {
                    if(txtMKHienTai.getText().equals(tk.getMatKhau())){
                        TaiKhoanDAO.getInstance().doiMK1(maNhanVien,txtMKMoi.getText());
                        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công !");
                        txtMKMoi.setText("");
                        txtLapLaiMK.setText("");
                        txtMKHienTai.setText("");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Mật khẩu nhập lại không đúng!");
            }                
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnLuuMKMouseClicked

    private void btnDoiTenDNMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDoiTenDNMouseClicked
        try {
            if(txtTenDNMoi.getText().equals(txtLapLaiTenDN.getText())){
                TaiKhoanBUS bus = new TaiKhoanBUS();
                bus.docTK();
                for (TaiKhoanDTO tk : TaiKhoanBUS.dsTK) {
                    if(txtTenDNHienTai.getText().equals(tk.getTaiKhoan())){
                        TaiKhoanDAO.getInstance().updateUser(maNhanVien, txtTenDNMoi.getText());
                        JOptionPane.showMessageDialog(this, "Đổi tên tài khoản thành công !");
                        txtTenDNMoi.setText("");
                        txtLapLaiTenDN.setText("");
                        txtTenDNHienTai.setText("");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(this, "Tên tài khoản nhập lại không đúng!");
            }                
        } catch (SQLException ex) {
            Logger.getLogger(TaiKhoan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnDoiTenDNMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnDoiTenDN;
    private javax.swing.JButton btnLuu;
    private javax.swing.JPanel btnLuuMK;
    private javax.swing.ButtonGroup chucnang;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JComboBox<String> jcbGioitinh;
    private com.toedter.calendar.JDateChooser jtfNgaysinh;
    private javax.swing.JTextField txtCCCD;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoten;
    private javax.swing.JTextField txtLapLaiMK;
    private javax.swing.JTextField txtLapLaiTenDN;
    private javax.swing.JTextField txtMKHienTai;
    private javax.swing.JTextField txtMKMoi;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenDNHienTai;
    private javax.swing.JTextField txtTenDNMoi;
    // End of variables declaration//GEN-END:variables
}
