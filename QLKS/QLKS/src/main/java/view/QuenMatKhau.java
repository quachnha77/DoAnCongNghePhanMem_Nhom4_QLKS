package view;

import com.formdev.flatlaf.FlatLightLaf;
import database.TaiKhoanDAO;
import java.awt.CardLayout;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import database.NhanVienDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.NhanVienDTO;

public class QuenMatKhau extends javax.swing.JDialog {
    private String otpNumber;
    public static final String ACCOUNT_SID = "AC4249a373d05cdd4132628653873a6683";
    public static final String AUTH_TOKEN = "3edc9dbf5629d8722d89cc72ddc901dd";
    
    public QuenMatKhau() {
        initComponents();
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtSoDienThoai = new javax.swing.JTextField();
        btnGuiMaXacNhan = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtOtp = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnDoiMatKhau = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Khôi phục mật khẩu");
        setResizable(false);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("SF Pro Display", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("KHÔI PHỤC MẬT KHẨU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(111, 111, 111))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Nhập số điện thoại tài khoản");

        btnGuiMaXacNhan.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnGuiMaXacNhan.setForeground(new java.awt.Color(0, 153, 153));
        btnGuiMaXacNhan.setText("Gửi mã xác nhận");
        btnGuiMaXacNhan.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnGuiMaXacNhan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiMaXacNhanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 251, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnGuiMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnGuiMaXacNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSoDienThoai, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 47, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel1, "card2");

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel3.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        jLabel3.setText("Mã xác nhận gồm 6 chữ số đã được gửi vào địa chỉ email của bạn");

        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        jButton2.setText("Xác nhận");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel4.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        jLabel4.setText("Nhập mã xác nhận:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(txtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtOtp, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
        );

        jPanel3.add(jPanel5, "card3");

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("SF Pro Display", 0, 16)); // NOI18N
        jLabel5.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        jLabel5.setText("Nhập mật khẩu mới");

        btnDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnDoiMatKhau.setForeground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        btnDoiMatKhau.setText("Đổi mật khẩu");
        btnDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiMatKhauActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDoiMatKhau, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(txtPassword))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        jPanel3.add(jPanel4, "card4");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String otp = txtOtp.getText();
        if (otp.equals("")) {
            JOptionPane.showMessageDialog(this, "Không được để trống !");
        } else {
            if (otp.length() < 6 || otp.length() > 6) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng 6 chữ số !");
            } else {
                if (otp.equals(otpNumber)) {
                    CardLayout forgotPassword = (CardLayout) jPanel3.getLayout();
                    forgotPassword.next(jPanel3);
                } else {
                    JOptionPane.showMessageDialog(this, "Mã xác nhận không chính xác !");
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btnDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiMatKhauActionPerformed
        String password = txtPassword.getText();
        String sdt = txtSoDienThoai.getText();
        try {
            TaiKhoanDAO.getInstance().updatePass(timMaNV(sdt),password);
        } catch (SQLException ex) {
            Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
        }
        JOptionPane.showMessageDialog(this, "Đổi mật khẩu thành công !");
        this.dispose();
    }//GEN-LAST:event_btnDoiMatKhauActionPerformed
    private int timMaNV(String sdt) throws SQLException {
        ArrayList<NhanVienDTO> acc = NhanVienDAO.getInstance().selectAll();
        for (NhanVienDTO i : acc) {
            if (i.getSoDienThoai().equals(sdt)) {
                return i.getMaNV();
            }
        }
        return 0;
    }
    private void btnGuiMaXacNhanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiMaXacNhanActionPerformed
        String sdt = txtSoDienThoai.getText();
        if (sdt.equals("")) {
            JOptionPane.showMessageDialog(this, "Số điện thoại không được để trống !");
        } else {
            if (isValid(sdt)){
                try {
                    if (checkSDT(sdt)) {
                        otpNumber = getOTP();
                        //SendEmailSMTP.sendOTP(email, otpNumber);
                        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
                        
                        String fromPhoneNumber = "+13027039540";
                        String toPhoneNumber = "+84" + sdt;
                        //int code = 1234; // Replace with your actual code
                        
                        Message message = Message.creator(
                                new PhoneNumber(toPhoneNumber),
                                new PhoneNumber(fromPhoneNumber),
                                "Your verification code is: " + otpNumber
                        ).create();
                        
                        System.out.println("Code sent successfully" + otpNumber);
                        
                        CardLayout forgotPassword = (CardLayout) jPanel3.getLayout();
                        forgotPassword.next(jPanel3);
                    } else {
                        JOptionPane.showMessageDialog(this, "Số điện thoại không tồn tại trên hệ thống !");
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(QuenMatKhau.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else{
                JOptionPane.showMessageDialog(this, "Vui lòng nhập đúng định dạng! (+84...)");
            }
        }
    }//GEN-LAST:event_btnGuiMaXacNhanActionPerformed

    public static void main(String args[]) throws UnsupportedLookAndFeelException {
        UIManager.setLookAndFeel(new FlatLightLaf());
        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                QuenMatKhau dialog = new QuenMatKhau();
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    static boolean isValid(String sdt) {
        //String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        String regex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
        return sdt.matches(regex);
    }

    private boolean checkSDT(String sdt) throws SQLException {
        ArrayList<NhanVienDTO> acc = NhanVienDAO.getInstance().selectAll();
        for (NhanVienDTO i : acc) {
            if (i.getSoDienThoai().equals(sdt)) {
                return true;
            }
        }
        return false;
    }

    private String getOTP() {
        int min = 100000;
        int max = 999999;
        return Integer.toString((int) ((Math.random() * (max - min)) + min));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDoiMatKhau;
    private javax.swing.JButton btnGuiMaXacNhan;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField txtOtp;
    private javax.swing.JPasswordField txtPassword;
    private javax.swing.JTextField txtSoDienThoai;
    // End of variables declaration//GEN-END:variables
}
