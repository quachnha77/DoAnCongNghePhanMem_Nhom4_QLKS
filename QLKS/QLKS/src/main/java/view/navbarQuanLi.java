package view;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class navbarQuanLi extends javax.swing.JFrame {
    public String username;
    public int maNhanVien;
    Color DefaultColor, ClickedColor;
    public navbarQuanLi(String taiKhoan, int maNV) throws UnsupportedLookAndFeelException {
        maNhanVien = maNV;
        username = taiKhoan;
        System.out.println(maNhanVien);
        
        
        UIManager.setLookAndFeel(new FlatLightLaf());
        initComponents();
        setLocationRelativeTo(null);
        DefaultColor = new Color(64,153,153);
        ClickedColor = new Color(113,178,178);
        
        Phong dp = new Phong(username);
        main.add(dp);
        main.revalidate();
        main.repaint();        
        
        //set màu
        DatPhong.setBackground(ClickedColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);  
    }

    private navbarQuanLi() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        main = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        DatPhong = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        KhachHang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        DichVu = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        KhuyenMai = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        ThongKe = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        DangXuat = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        QuanLyDieuHanh = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        TaiKhoan = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        main.setBackground(new java.awt.Color(230, 243, 243));
        getContentPane().add(main, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 0, 1170, 800));

        jPanel3.setBackground(new java.awt.Color(64, 153, 153));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        DatPhong.setBackground(new java.awt.Color(64, 153, 153));
        DatPhong.setAutoscrolls(true);
        DatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DatPhongMousePressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Phòng");

        javax.swing.GroupLayout DatPhongLayout = new javax.swing.GroupLayout(DatPhong);
        DatPhong.setLayout(DatPhongLayout);
        DatPhongLayout.setHorizontalGroup(
            DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatPhongLayout.createSequentialGroup()
                .addGap(74, 74, 74)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
        );
        DatPhongLayout.setVerticalGroup(
            DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatPhongLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(DatPhong, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 210, -1));

        KhachHang.setBackground(new java.awt.Color(64, 153, 153));
        KhachHang.setAutoscrolls(true);
        KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KhachHangMousePressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Khách Hàng");

        javax.swing.GroupLayout KhachHangLayout = new javax.swing.GroupLayout(KhachHang);
        KhachHang.setLayout(KhachHangLayout);
        KhachHangLayout.setHorizontalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addComponent(jLabel2)
                .addContainerGap(55, Short.MAX_VALUE))
        );
        KhachHangLayout.setVerticalGroup(
            KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhachHangLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel2)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(KhachHang, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 230, 210, -1));

        DichVu.setBackground(new java.awt.Color(64, 153, 153));
        DichVu.setAutoscrolls(true);
        DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DichVuMousePressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Dịch Vụ");

        javax.swing.GroupLayout DichVuLayout = new javax.swing.GroupLayout(DichVu);
        DichVu.setLayout(DichVuLayout);
        DichVuLayout.setHorizontalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DichVuLayout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addComponent(jLabel3)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        DichVuLayout.setVerticalGroup(
            DichVuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DichVuLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel3)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(DichVu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 210, -1));

        KhuyenMai.setBackground(new java.awt.Color(64, 153, 153));
        KhuyenMai.setAutoscrolls(true);
        KhuyenMai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                KhuyenMaiMousePressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Khuyến Mãi");

        javax.swing.GroupLayout KhuyenMaiLayout = new javax.swing.GroupLayout(KhuyenMai);
        KhuyenMai.setLayout(KhuyenMaiLayout);
        KhuyenMaiLayout.setHorizontalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(jLabel4)
                .addContainerGap(51, Short.MAX_VALUE))
        );
        KhuyenMaiLayout.setVerticalGroup(
            KhuyenMaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(KhuyenMaiLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel4)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(KhuyenMai, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 210, -1));

        ThongKe.setBackground(new java.awt.Color(64, 153, 153));
        ThongKe.setAutoscrolls(true);
        ThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                ThongKeMousePressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Thống Kê");

        javax.swing.GroupLayout ThongKeLayout = new javax.swing.GroupLayout(ThongKe);
        ThongKe.setLayout(ThongKeLayout);
        ThongKeLayout.setHorizontalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(52, Short.MAX_VALUE))
        );
        ThongKeLayout.setVerticalGroup(
            ThongKeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ThongKeLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel5)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(ThongKe, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 410, -1, -1));

        DangXuat.setBackground(new java.awt.Color(64, 153, 153));
        DangXuat.setAutoscrolls(true);
        DangXuat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                DangXuatMousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Đăng Xuất");

        javax.swing.GroupLayout DangXuatLayout = new javax.swing.GroupLayout(DangXuat);
        DangXuat.setLayout(DangXuatLayout);
        DangXuatLayout.setHorizontalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, DangXuatLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(57, 57, 57))
        );
        DangXuatLayout.setVerticalGroup(
            DangXuatLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        jPanel3.add(DangXuat, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 636, 210, 60));

        QuanLyDieuHanh.setBackground(new java.awt.Color(64, 153, 153));
        QuanLyDieuHanh.setAutoscrolls(true);
        QuanLyDieuHanh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                QuanLyDieuHanhMousePressed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Quản Lý Điều Hành");

        javax.swing.GroupLayout QuanLyDieuHanhLayout = new javax.swing.GroupLayout(QuanLyDieuHanh);
        QuanLyDieuHanh.setLayout(QuanLyDieuHanhLayout);
        QuanLyDieuHanhLayout.setHorizontalGroup(
            QuanLyDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyDieuHanhLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel8)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        QuanLyDieuHanhLayout.setVerticalGroup(
            QuanLyDieuHanhLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(QuanLyDieuHanhLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel8)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(QuanLyDieuHanh, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 470, -1, -1));

        TaiKhoan.setBackground(new java.awt.Color(64, 153, 153));
        TaiKhoan.setAutoscrolls(true);
        TaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TaiKhoanMousePressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tài Khoản");

        javax.swing.GroupLayout TaiKhoanLayout = new javax.swing.GroupLayout(TaiKhoan);
        TaiKhoan.setLayout(TaiKhoanLayout);
        TaiKhoanLayout.setHorizontalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );
        TaiKhoanLayout.setVerticalGroup(
            TaiKhoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TaiKhoanLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel6)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.add(TaiKhoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 530, 210, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 210, 800));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void DatPhongMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DatPhongMousePressed
        DatPhong.setBackground(ClickedColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        Phong dp = new Phong(username);
        main.add(dp);
        main.revalidate();
        main.repaint();
        
    }//GEN-LAST:event_DatPhongMousePressed

    private void KhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhachHangMousePressed
        DatPhong.setBackground(DefaultColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(ClickedColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        KhachHang1 kh = null;
        try {
            kh = new KhachHang1();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.add(kh);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_KhachHangMousePressed

    private void DichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DichVuMousePressed
        DatPhong.setBackground(DefaultColor);
        DichVu.setBackground(ClickedColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        DichVu dv = null;
        try {
            dv = new DichVu();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.add(dv);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_DichVuMousePressed

    private void KhuyenMaiMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_KhuyenMaiMousePressed
        DatPhong.setBackground(DefaultColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(ClickedColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        KhuyenMai km = null;
        try {
            km = new KhuyenMai();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.add(km);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_KhuyenMaiMousePressed

    private void ThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ThongKeMousePressed
        DatPhong.setBackground(DefaultColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(ClickedColor);
        QuanLyDieuHanh.setBackground(DefaultColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        ThongKe tk = null;
        try {
            tk = new ThongKe();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.add(tk);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_ThongKeMousePressed

    private void TaiKhoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TaiKhoanMousePressed
        try {
            DatPhong.setBackground(DefaultColor);
            DichVu.setBackground(DefaultColor);
            KhachHang.setBackground(DefaultColor);
            KhuyenMai.setBackground(DefaultColor);
            TaiKhoan.setBackground(ClickedColor);
            ThongKe.setBackground(DefaultColor);
            QuanLyDieuHanh.setBackground(DefaultColor);
            DangXuat.setBackground(DefaultColor);
            
            main.removeAll();
            TaiKhoan tk = new TaiKhoan(maNhanVien);
            main.add(tk);
            main.revalidate();
            main.repaint();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_TaiKhoanMousePressed

    private void DangXuatMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DangXuatMousePressed
        int input = JOptionPane.showConfirmDialog(null,"Bạn muốn đăng xuất", "Cảnh báo!!!", JOptionPane.DEFAULT_OPTION);
        //yes=0 no=1
        if(input==0){
            System.exit(0);
        }
    }//GEN-LAST:event_DangXuatMousePressed

    private void QuanLyDieuHanhMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_QuanLyDieuHanhMousePressed
        DatPhong.setBackground(DefaultColor);
        DichVu.setBackground(DefaultColor);
        KhachHang.setBackground(DefaultColor);
        KhuyenMai.setBackground(DefaultColor);
        TaiKhoan.setBackground(DefaultColor);
        ThongKe.setBackground(DefaultColor);
        QuanLyDieuHanh.setBackground(ClickedColor);
        DangXuat.setBackground(DefaultColor);
        
        main.removeAll();
        QuanLyDieuHanh_update qldh = null;
        try {
            qldh = new QuanLyDieuHanh_update();
        } catch (SQLException ex) {
            Logger.getLogger(navbarQuanLi.class.getName()).log(Level.SEVERE, null, ex);
        }
        main.add(qldh);
        main.revalidate();
        main.repaint();
    }//GEN-LAST:event_QuanLyDieuHanhMousePressed
    
    
    
    
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
            java.util.logging.Logger.getLogger(navbarQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(navbarQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(navbarQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(navbarQuanLi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new navbarQuanLi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DangXuat;
    private javax.swing.JPanel DatPhong;
    private javax.swing.JPanel DichVu;
    private javax.swing.JPanel KhachHang;
    private javax.swing.JPanel KhuyenMai;
    private javax.swing.JPanel QuanLyDieuHanh;
    private javax.swing.JPanel TaiKhoan;
    private javax.swing.JPanel ThongKe;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel main;
    // End of variables declaration//GEN-END:variables
}
