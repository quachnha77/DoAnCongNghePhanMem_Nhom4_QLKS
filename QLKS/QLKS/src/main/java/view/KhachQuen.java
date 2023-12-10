package view;

import bus.KhachHangBUS;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHangDTO;

public class KhachQuen extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    public int maPhong;
    public int maKhachHang;
    public String username;
    public KhachQuen(int maphong, int makh, String user) throws SQLException {
        initComponents();
        maKhachHang = makh;
        maPhong = maphong;
        username = user;
        showAll();
    }
    private KhachQuen() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public void showAll() throws SQLException {
        tableModel = (DefaultTableModel) tbKhachQuen.getModel();
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
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        cbTK = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachQuen = new javax.swing.JTable();
        btnNhap = new javax.swing.JPanel();
        jLabel46 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 153, 153));
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(157, 154, 154));
        jButton8.setText("HỦY");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 142, 142));
        jLabel2.setText("TÌM KIẾM TÊN KHÁCH HÀNG");

        cbTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên khách hàng", "CCCD", "Số điện thoại" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTimKiem)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem))
                            .addComponent(cbTK, 0, 241, Short.MAX_VALUE)))
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
                .addComponent(cbTK, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );

        tbKhachQuen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã KH", "Tên khách hàng", "CMNN/CCCD", "Địa chỉ", "Số điện thoại", "Giới tính", "Ngày sinh"
            }
        ));
        tbKhachQuen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachQuenMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachQuen);
        if (tbKhachQuen.getColumnModel().getColumnCount() > 0) {
            tbKhachQuen.getColumnModel().getColumn(0).setMaxWidth(100);
            tbKhachQuen.getColumnModel().getColumn(1).setMinWidth(200);
            tbKhachQuen.getColumnModel().getColumn(1).setMaxWidth(200);
            tbKhachQuen.getColumnModel().getColumn(2).setMinWidth(120);
            tbKhachQuen.getColumnModel().getColumn(2).setMaxWidth(120);
            tbKhachQuen.getColumnModel().getColumn(4).setMinWidth(100);
            tbKhachQuen.getColumnModel().getColumn(4).setMaxWidth(200);
            tbKhachQuen.getColumnModel().getColumn(5).setMaxWidth(150);
            tbKhachQuen.getColumnModel().getColumn(6).setMinWidth(100);
            tbKhachQuen.getColumnModel().getColumn(6).setMaxWidth(100);
        }

        btnNhap.setBackground(new java.awt.Color(0, 153, 153));
        btnNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNhapMousePressed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("NHẬP");

        javax.swing.GroupLayout btnNhapLayout = new javax.swing.GroupLayout(btnNhap);
        btnNhap.setLayout(btnNhapLayout);
        btnNhapLayout.setHorizontalGroup(
            btnNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnNhapLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        btnNhapLayout.setVerticalGroup(
            btnNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel46, javax.swing.GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1014, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)))
                .addGap(24, 24, 24))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void timKiem(String timKiem, Object cbBox){
        if(cbBox == "Tên khách hàng"){
            KhachHangBUS bus = new KhachHangBUS();
            tableModel.setRowCount(0);
            try {
                bus.docKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(KhachQuen.class.getName()).log(Level.SEVERE, null, ex);
            }
                for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
                if(kh.getHoTen().contains(timKiem)){
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
        }else if(cbBox == "CCCD"){
            KhachHangBUS bus = new KhachHangBUS();
            tableModel.setRowCount(0);
            try {
                bus.docKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(KhachQuen.class.getName()).log(Level.SEVERE, null, ex);
            }
                for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
                if(kh.getCCCD().contains(timKiem)){
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
        else if(cbBox == "Số điện thoại"){
            KhachHangBUS bus = new KhachHangBUS();
            tableModel.setRowCount(0);
            try {
                bus.docKhachHang();
            } catch (SQLException ex) {
                Logger.getLogger(KhachQuen.class.getName()).log(Level.SEVERE, null, ex);
            }
                for (KhachHangDTO kh : KhachHangBUS.dsKhachHang) {
                if(kh.getSoDienThoai().contains(timKiem)){
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
    
    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String timKiem = txtTimKiem.getText();
        Object cbBox = cbTK.getSelectedItem();
        timKiem(timKiem, cbBox);
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnNhapMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNhapMousePressed
        int n = tbKhachQuen.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn khách hàng!!!");
        }else{
            try {
                maKhachHang = Integer.parseInt(tableModel.getValueAt(n, 0).toString());
                
                PhieuThue pt = new PhieuThue(maPhong, username, maKhachHang);
                pt.maKH = maKhachHang;
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
                pt.LoadData();
                //pt.cacPhongMaKhachThue();
                //pt.showPhieuSDDV();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(KhachQuen.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnNhapMousePressed

    private void tbKhachQuenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachQuenMouseClicked
        
    }//GEN-LAST:event_tbKhachQuenMouseClicked

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
            java.util.logging.Logger.getLogger(KhachQuen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachQuen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachQuen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachQuen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachQuen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnNhap;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbTK;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbKhachQuen;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
