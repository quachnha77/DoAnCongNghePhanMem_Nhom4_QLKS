package view;

import bus.DichVuBUS;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.DichVuDTO;
import javax.swing.table.TableModel;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DichVu1 extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    public DichVu1() throws SQLException {
        initComponents();
        showAll();  
    }
    public int TTDV(){
        if(rbtnpv.isSelected())
            return 1;
        if(rbtntn.isSelected())
            return 0;
        return -1;
    }
    private boolean checkMaDV(int ID){
        DichVuBUS bus = new DichVuBUS();
        for (DichVuDTO dv : DichVuBUS.dsDV){
            if(ID == dv.getMaDV()){
                return false;
            }
        }
        return true;
    }
    private String tinhTrangDV(int i){
        if(i==1){
            return "PHỤC VỤ";
        }else if(i==0){
            return "TẠM NGƯNG";
        }
        return null;
    }
    private void showThongTin() throws SQLException{
        DichVuBUS bus = new DichVuBUS();
        tableModel.setRowCount(0);
        bus.docDichVu();
        for(DichVuDTO dv : DichVuBUS.dsDV){
            tableModel.addRow(new Object[]{
            dv.getMaDV(),
            dv.getTenDV(),
            dv.getGiaDV(),
            tinhTrangDV(dv.getTinhTrangDV())});
        }
   }
    public void showAll() throws SQLException{
        tableModel = (DefaultTableModel) tb_DichVu.getModel();
        showThongTin();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tb_DichVu = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_giaDV = new javax.swing.JTextField();
        txt_MaDV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_tenDV = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        rbtnpv = new javax.swing.JRadioButton();
        rbtntn = new javax.swing.JRadioButton();
        jPanel3 = new javax.swing.JPanel();
        txt_TimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        btn_huy = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_them1 = new javax.swing.JPanel();
        btn_them = new javax.swing.JLabel();
        btn_sua1 = new javax.swing.JPanel();
        btn_sua = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        tb_DichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "MÃ DỊCH VỤ", "TÊN DỊCH VỤ", "PHÍ DỊCH VỤ", "TRẠNG THÁI"
            }
        ));
        tb_DichVu.setSelectionBackground(new java.awt.Color(204, 255, 255));
        tb_DichVu.setSelectionForeground(new java.awt.Color(0, 153, 153));
        tb_DichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_DichVuMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tb_DichVu);
        if (tb_DichVu.getColumnModel().getColumnCount() > 0) {
            tb_DichVu.getColumnModel().getColumn(0).setResizable(false);
            tb_DichVu.getColumnModel().getColumn(1).setResizable(false);
            tb_DichVu.getColumnModel().getColumn(2).setResizable(false);
            tb_DichVu.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel2.setForeground(new java.awt.Color(0, 204, 204));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 153));
        jLabel4.setText("PHÍ DỊCH VỤ");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("MÃ DỊCH VỤ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("TÊN DỊCH VỤ");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 153, 153));
        jLabel5.setText("TRẠNG THÁI");

        buttonGroup.add(rbtnpv);
        rbtnpv.setForeground(new java.awt.Color(0, 102, 102));
        rbtnpv.setText("PHỤC VỤ");

        buttonGroup.add(rbtntn);
        rbtntn.setForeground(new java.awt.Color(0, 102, 102));
        rbtntn.setText("TẠM NGƯNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txt_MaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txt_tenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(80, 80, 80)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(txt_giaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(25, 25, 25)
                        .addComponent(rbtnpv, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(rbtntn)))
                .addGap(14, 14, 14))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_MaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_giaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_tenDV, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(rbtnpv)
                    .addComponent(rbtntn))
                .addContainerGap(18, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(0, 204, 204));

        btnTimKiem.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnTimKiem.setForeground(new java.awt.Color(0, 153, 153));
        btnTimKiem.setText("TÌM KIẾM");
        btnTimKiem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTimKiemMouseClicked(evt);
            }
        });

        btn_huy.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_huy.setForeground(new java.awt.Color(157, 154, 154));
        btn_huy.setText("HỦY");
        btn_huy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_huyMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(4, 142, 142));
        jLabel2.setText("TÌM KIẾM DỊCH VỤ THEO MÃ DỊCH VỤ");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_TimKiem, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTimKiem))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)))
                .addContainerGap(25, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_TimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_huy, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        btn_them1.setBackground(new java.awt.Color(0, 153, 153));
        btn_them1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_them1MouseClicked(evt);
            }
        });

        btn_them.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_them.setForeground(new java.awt.Color(255, 255, 255));
        btn_them.setText("THÊM");

        javax.swing.GroupLayout btn_them1Layout = new javax.swing.GroupLayout(btn_them1);
        btn_them1.setLayout(btn_them1Layout);
        btn_them1Layout.setHorizontalGroup(
            btn_them1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btn_them1Layout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(btn_them)
                .addGap(25, 25, 25))
        );
        btn_them1Layout.setVerticalGroup(
            btn_them1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_them, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btn_sua1.setBackground(new java.awt.Color(255, 255, 255));
        btn_sua1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_sua1MouseClicked(evt);
            }
        });

        btn_sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_sua.setForeground(new java.awt.Color(0, 153, 153));
        btn_sua.setText("SỬA");

        javax.swing.GroupLayout btn_sua1Layout = new javax.swing.GroupLayout(btn_sua1);
        btn_sua1.setLayout(btn_sua1Layout);
        btn_sua1Layout.setHorizontalGroup(
            btn_sua1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_sua1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btn_sua)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btn_sua1Layout.setVerticalGroup(
            btn_sua1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btn_sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(35, 35, 35)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(btn_them1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btn_sua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_them1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_sua1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 545, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(27, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void RESET(){
        txt_MaDV.setText("");
        txt_tenDV.setText("");
        txt_giaDV.setText("");
        rbtnpv.setSelected(false);
        rbtntn.setSelected(false);
    }
    private void btn_sua1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_sua1MouseClicked
        //TableModel model = tb_DichVu.getModel();
        int n = tb_DichVu.getSelectedRow();
        if(n==-1){
            JOptionPane.showMessageDialog(this, "Chọn dòng để sửa");
        }else{
            try {
                DichVuDTO newDV = new DichVuDTO(Integer.parseInt(txt_MaDV.getText()),txt_tenDV.getText(),Float.parseFloat(txt_giaDV.getText()),TTDV());
                DichVuBUS bus = new DichVuBUS();
                bus.suaDV(newDV, Integer.parseInt(txt_MaDV.getText()));
                showAll();
                JOptionPane.showMessageDialog(this, "Sửa thành công");
                RESET();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Đã có lỗi");
                }
            }  
    }//GEN-LAST:event_btn_sua1MouseClicked

    private void tb_DichVuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_DichVuMouseClicked
        ArrayList<DichVuDTO> DichVuList = DichVuBUS.dsDV;
        int n = tb_DichVu.getSelectedRow();
        DichVuDTO dv = DichVuList.get(n);
        txt_MaDV.setText(String.valueOf(dv.getMaDV()));
        txt_tenDV.setText(dv.getTenDV());
        float giaDV = dv.getGiaDV();
        txt_giaDV.setText(String.valueOf(giaDV));
        if(1==dv.getTinhTrangDV()){
            rbtnpv.setSelected(true);
        }
        else if(0==dv.getTinhTrangDV()){
            rbtntn.setSelected(true);
        } 
    }//GEN-LAST:event_tb_DichVuMouseClicked

    private void btnTimKiemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTimKiemMouseClicked
        // TODO add your handling code here:
        tableModel.setRowCount(0);
        for (DichVuDTO dv: DichVuBUS.dsDV){
            if(String.valueOf(dv.getMaDV()).contains(txt_TimKiem.getText())){
                tableModel.addRow(new Object[]{dv.getMaDV(),
                    dv.getTenDV(),
                    dv.getGiaDV(),
                    dv.getTinhTrangDV()
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemMouseClicked

    private void btn_them1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_them1MouseClicked
        DichVuBUS bus = new DichVuBUS();
        try {
            bus.docDichVu();
        } catch (SQLException ex) {
            Logger.getLogger(DichVu1.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            int MaDV = Integer.parseInt(txt_MaDV.getText());
            String TenDV = txt_tenDV.getText();
            Float GiaDV = Float.valueOf(txt_giaDV.getText());
            int TTDV = TTDV();
            if(checkMaDV(MaDV) == false){
                JOptionPane.showMessageDialog(this, "Trùng");
            }else{
                DichVuDTO dv = new DichVuDTO(MaDV, TenDV, GiaDV, TTDV);
                //tb_DichVu.setModel(tableModel);
                bus.themDV(dv);  
                try {
                    showAll();
                } catch (SQLException ex) {
                    Logger.getLogger(DichVu1.class.getName()).log(Level.SEVERE, null, ex);
                }
                JOptionPane.showMessageDialog(this, "Thêm thành công");
                RESET();            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
        
    }//GEN-LAST:event_btn_them1MouseClicked

    private void btn_huyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_huyMouseClicked
        try {
            showAll();
        } catch (SQLException ex) {
            Logger.getLogger(DichVu1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_huyMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btn_huy;
    private javax.swing.JLabel btn_sua;
    private javax.swing.JPanel btn_sua1;
    private javax.swing.JLabel btn_them;
    private javax.swing.JPanel btn_them1;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtnpv;
    private javax.swing.JRadioButton rbtntn;
    private javax.swing.JTable tb_DichVu;
    private javax.swing.JTextField txt_MaDV;
    private javax.swing.JTextField txt_TimKiem;
    private javax.swing.JTextField txt_giaDV;
    private javax.swing.JTextField txt_tenDV;
    // End of variables declaration//GEN-END:variables
}
