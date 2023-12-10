package view;

import bus.KhuyenMaiBUS;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.KhuyenMaiDTO;

public class KhuyenMai extends javax.swing.JPanel {
    DefaultTableModel tableModel;
    public KhuyenMai() throws SQLException {
        initComponents();
        showAll();
    }
    
    private String trangThai(int i){
        if(i==1){
            return "Đang hoạt động";
        }else{
            return "Không hoạt động";
        }
    }
    private void showThongTin() throws SQLException { 
        KhuyenMaiBUS bus = new KhuyenMaiBUS();
        tableModel.setRowCount(0);
        bus.docKhuyenMai();
        
        for (KhuyenMaiDTO km : KhuyenMaiBUS.dsKM) {
            tableModel.addRow(new Object[]{
                km.getMaKM(),
                km.getTenKM(),
                km.getPhanTramKM(),
                km.getNgayBD(),
                km.getNgayKT(), 
                trangThai(km.getTrangThai()),
                km.getDonToiThieu(),
                km.getGiamToiDa()});
        }   
    }
    
    private boolean checkMaKM(String tenKM)
    {
        KhuyenMaiBUS bus = new KhuyenMaiBUS();
        for(KhuyenMaiDTO km : KhuyenMaiBUS.dsKM)
        {
            if(tenKM.equals(km.getTenKM()))
            {
                return false;
            }
        }
        return true;
    }
    
    public void showAll() throws SQLException {
        tableModel = (DefaultTableModel) jTable1.getModel();
        showThongTin();
    }
    
    public void timkiem(String timkiem, Object cbLoc)
    {
        if(cbLoc == "Mã khuyến mãi")
        {
            tableModel.setRowCount(0);
            for(KhuyenMaiDTO km: KhuyenMaiBUS.dsKM)
            {
                if(Integer.toString(km.getMaKM()).contains(timkiem))
                {
                    tableModel.addRow(new Object[]{
                        km.getMaKM(),
                        km.getTenKM(),
                        km.getPhanTramKM(),
                        km.getNgayBD(),
                        km.getNgayKT(),
                        km.getTrangThai(),
                        km.getDonToiThieu(),
                        km.getGiamToiDa()});
                    
            }
            }
        }
        if(cbLoc == "Tên khuyến mãi")
        {
            tableModel.setRowCount(0);
            for(KhuyenMaiDTO km: KhuyenMaiBUS.dsKM)
            {
                if(km.getTenKM().contains(timkiem))
                {
                    tableModel.addRow(new Object[]{
                        km.getMaKM(),
                        km.getTenKM(),
                        km.getPhanTramKM(),
                        km.getNgayBD(),
                        km.getNgayKT(), 
                        km.getTrangThai(),
                        km.getDonToiThieu(),
                        km.getGiamToiDa()});
                    
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtTimKiem = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        cbxTimKiem = new javax.swing.JComboBox<>();
        jPanel5 = new javax.swing.JPanel();
        txtTenKM = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtGiaTri = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThem = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnSua = new javax.swing.JPanel();
        sua = new javax.swing.JLabel();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtGiaTriTT = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtGiaTriTD = new javax.swing.JTextField();
        cbTrangThai = new javax.swing.JCheckBox();
        jLabel14 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Phần trăm", "Ngày bắt đầu", "Ngày kết thúc", "Trạng thái", "Đơn tối thiểu", "Giảm tối đa"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel3.setForeground(new java.awt.Color(0, 153, 153));

        jButton7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton7.setForeground(new java.awt.Color(0, 153, 153));
        jButton7.setText("TÌM KIẾM");
        jButton7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton7MouseClicked(evt);
            }
        });
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(4, 142, 142));
        jLabel8.setText("TÌM KIẾM TÊN KHUYẾN MÃI");

        cbxTimKiem.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khuyến mãi", "Tên khuyến mãi" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTimKiem)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7))
                    .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbxTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));
        jPanel5.setForeground(new java.awt.Color(0, 153, 153));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("Tên khuyến mãi:");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 153));
        jLabel2.setText("Phần trăm:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 153, 153));
        jLabel3.setText("Ngày bắt đầu:");

        btnThem.setBackground(new java.awt.Color(0, 153, 153));
        btnThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThemMousePressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("THÊM");

        javax.swing.GroupLayout btnThemLayout = new javax.swing.GroupLayout(btnThem);
        btnThem.setLayout(btnThemLayout);
        btnThemLayout.setHorizontalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnThemLayout.createSequentialGroup()
                .addContainerGap(29, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(25, 25, 25))
        );
        btnThemLayout.setVerticalGroup(
            btnThemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnXoa.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.GreyInline"));
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaMousePressed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("XÓA");

        javax.swing.GroupLayout btnXoaLayout = new javax.swing.GroupLayout(btnXoa);
        btnXoa.setLayout(btnXoaLayout);
        btnXoaLayout.setHorizontalGroup(
            btnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, btnXoaLayout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addGap(25, 25, 25))
        );
        btnXoaLayout.setVerticalGroup(
            btnXoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        btnSua.setBackground(new java.awt.Color(255, 255, 255));
        btnSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSuaMousePressed(evt);
            }
        });

        sua.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        sua.setForeground(new java.awt.Color(0, 153, 153));
        sua.setText("SỬA");

        javax.swing.GroupLayout btnSuaLayout = new javax.swing.GroupLayout(btnSua);
        btnSua.setLayout(btnSuaLayout);
        btnSuaLayout.setHorizontalGroup(
            btnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSuaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(sua)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnSuaLayout.setVerticalGroup(
            btnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(sua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Ngày kết thúc:");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 153));
        jLabel12.setText("Đơn tối thiểu:");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 153, 153));
        jLabel13.setText("Giảm tối đa:");

        cbTrangThai.setText("Đang hoạt động");
        cbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangThaiActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 153, 153));
        jLabel14.setText("Trạng thái:");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtGiaTriTT)
                                    .addComponent(txtGiaTriTD, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap())
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addComponent(cbTrangThai)
                                .addGap(34, 34, 34))))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(98, 98, 98)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTenKM, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(txtGiaTri, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                                .addComponent(cbTrangThai)
                                .addGap(18, 18, 18)
                                .addComponent(txtGiaTriTT, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtGiaTriTD, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 533, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
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

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        txtTimKiem.setText("");
        try {
            showAll();
        } catch (SQLException ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void btnThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMousePressed
            try {                                     
                KhuyenMaiDTO km = new KhuyenMaiDTO();
                KhuyenMaiBUS bus=new KhuyenMaiBUS();
                km.setMaKM(1);
                km.setTenKM(txtTenKM.getText());
                km.setPhanTramKM(Integer.parseInt(txtGiaTri.getText()));
                
                Date ngayBD = txtNgayBD.getDate();
                java.sql.Date sqlBD = new java.sql.Date(ngayBD.getTime());
                Date ngayKT = txtNgayKT.getDate();
                java.sql.Date sqlKT = new java.sql.Date(ngayBD.getTime());
                
                km.setNgayBD(ngayBD);
                km.setNgayKT(ngayKT);
                if(cbTrangThai.getText()=="Đang hoạt động"){
                    km.setTrangThai(1);
                }else{
                    km.setTrangThai(0);
                }
                km.setDonToiThieu(Float.parseFloat(txtGiaTriTT.getText()));
                km.setGiamToiDa(Float.parseFloat(txtGiaTriTD.getText()));
                bus.themkm(km);
                showAll();
                JOptionPane.showMessageDialog(this, "Thêm thành công!!!");
                txtTenKM.setText("");
                txtGiaTri.setText("");
                txtGiaTriTT.setText("");
                txtGiaTriTD.setText("");
                cbTrangThai.setSelected(false);
                long c = System.currentTimeMillis();
                java.util.Date date = new java.util.Date(c);
                //LocalDate date = java.time.LocalDate.now();
                //SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
                txtNgayBD.setDate(date);
                txtNgayKT.setDate(date);

            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }//GEN-LAST:event_btnThemMousePressed

    private void jButton7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton7MouseClicked
        String timkiem=txtTimKiem.getText();
        Object cbBox = cbxTimKiem.getSelectedItem();
        timkiem(timkiem, cbBox);
    }//GEN-LAST:event_jButton7MouseClicked

    private void cbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangThaiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbTrangThaiActionPerformed

    private void Reset(){
        txtTenKM.setText("");
        txtGiaTri.setText("");
        txtGiaTriTT.setText("");
        txtGiaTriTD.setText("");
        cbTrangThai.setSelected(false);
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null); 
    }
    private int trangThai1(){
        if(cbTrangThai.isSelected()==true){
            return 1;
        }else{
            return 0;
        } 
    }
    private void btnSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMousePressed
        try {                                     
            int n = jTable1.getSelectedRow();
            if (n == -1) {
                JOptionPane.showMessageDialog(this, "Chọn dòng để sửa");
            }else{
                float toiThieu;
                float toiDa;
                if(txtGiaTriTT.getText()==""){
                    toiThieu = (float) 0.0;
                
                }else{
                    toiThieu = Float.parseFloat(txtGiaTriTT.getText());
                }
                if(txtGiaTriTD.getText()==""){
                    toiDa = (float) 0.0;
                }else{
                    toiDa = Float.parseFloat(txtGiaTriTD.getText());
                }
                KhuyenMaiDTO newkm = new KhuyenMaiDTO(Integer.parseInt(jTable1.getModel().getValueAt(n, 0).toString()),
                        txtTenKM.getText(),Integer.parseInt(txtGiaTri.getText()),txtNgayBD.getDate(),txtNgayKT.getDate(),trangThai1(),toiThieu,toiDa);
                KhuyenMaiBUS bus = new KhuyenMaiBUS();
                bus.docKhuyenMai();
                bus.suakm(newkm,Integer.parseInt(jTable1.getModel().getValueAt(n, 0).toString()));
                showAll();
                Reset();
                JOptionPane.showMessageDialog(this, "Cập nhật thành công");
                /*
                long c = System.currentTimeMillis();
                java.util.Date date = new java.util.Date(c);
                */ 
            }  
        } catch (Exception ex) {
            Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnSuaMousePressed

    private void btnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMousePressed
        List<KhuyenMaiDTO> KMList = KhuyenMaiBUS.dsKM;
        int n = jTable1.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để xóa");
        } else {
            KhuyenMaiDTO km = KMList.get(n);    
            KhuyenMaiBUS bus = new KhuyenMaiBUS();
            bus.xoakm(km,km.getMaKM());
            try {           
                showAll();
            } catch (SQLException ex) {
                Logger.getLogger(KhuyenMai.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(this, "Xóa thành công");
        }
    }//GEN-LAST:event_btnXoaMousePressed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        int n = jTable1.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        } else {
            txtTenKM.setText(tableModel.getValueAt(n, 1).toString());
            txtGiaTri.setText(tableModel.getValueAt(n, 2).toString());
            txtNgayBD.setDate((Date) tableModel.getValueAt(n, 3));
            txtNgayKT.setDate((Date)tableModel.getValueAt(n, 4));
            if(tableModel.getValueAt(n, 5).toString()=="Đang hoạt động"){
                cbTrangThai.setSelected(true);
            }else{
                cbTrangThai.setSelected(false);
            }
            txtGiaTriTT.setText(tableModel.getValueAt(n, 6).toString());
            txtGiaTriTD.setText(tableModel.getValueAt(n, 7).toString());
            
        }
    }//GEN-LAST:event_jTable1MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSua;
    private javax.swing.JPanel btnThem;
    private javax.swing.JPanel btnXoa;
    private javax.swing.JCheckBox cbTrangThai;
    private javax.swing.JComboBox<String> cbxTimKiem;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel sua;
    private javax.swing.JTextField txtGiaTri;
    private javax.swing.JTextField txtGiaTriTD;
    private javax.swing.JTextField txtGiaTriTT;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtTenKM;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
