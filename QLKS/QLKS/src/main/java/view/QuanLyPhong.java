package view;

import bus.PhongBUS;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.PhongDTO;

public class QuanLyPhong extends javax.swing.JFrame {
    DefaultTableModel tableModel;
    int selectindex = -1;
    public QuanLyPhong() throws SQLException {
        initComponents();
        showAll();
    }
    public void showAll() throws SQLException{
        tableModel = (DefaultTableModel) tbDanhSachPhong.getModel();
        showThongTin();
    }
    private String tinhTrang(int i){
        if(i == 1){
            return "Đang trống";
        }if(i==2){
            return "Đã được thuê";
        }
        return "Đang dọn";
    }
    private void showThongTin() throws SQLException { 
        PhongBUS bus = new PhongBUS();
        tableModel.setRowCount(0);
        bus.docDatPhong();
        for (PhongDTO ph : PhongBUS.dsPhong) {
            tableModel.addRow(new Object[]{ 
                ph.getMaPhong(), 
                ph.getSoGiuong(),
                ph.getLoaiPhong(), 
                ph.getGiaTheoNgay(),
                ph.getGiaTheoGio(),
                tinhTrang(ph.getTinhTrang())});
            }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbDanhSachPhong = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtSoPhong = new javax.swing.JTextField();
        txtLoai = new javax.swing.JTextField();
        txtGiaTheoNgay = new javax.swing.JTextField();
        txtSoGiuong = new javax.swing.JTextField();
        cbTinhTrang = new javax.swing.JComboBox<>();
        btnThem = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        btnSua = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtGiaTheoGio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ PHÒNG");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(496, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(362, 362, 362))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 50, Short.MAX_VALUE)
        );

        tbDanhSachPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Số phòng", "Số giường", "Loại phòng", "Giá theo ngày", "Giá theo giờ", "Trạng thái"
            }
        ));
        tbDanhSachPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbDanhSachPhong);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 102, 102));
        jLabel2.setText("Danh sách phòng");

        jLabel3.setForeground(new java.awt.Color(0, 102, 102));
        jLabel3.setText("Số phòng:");

        jLabel4.setForeground(new java.awt.Color(0, 102, 102));
        jLabel4.setText("Loại phòng:");

        jLabel5.setForeground(new java.awt.Color(0, 102, 102));
        jLabel5.setText("Giá theo ngày:");

        jLabel6.setForeground(new java.awt.Color(0, 102, 102));
        jLabel6.setText("Số giường:");

        jLabel7.setForeground(new java.awt.Color(0, 102, 102));
        jLabel7.setText("Tình trạng:");

        cbTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang trống", "Đang dọn" }));
        cbTinhTrang.setName(""); // NOI18N

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
            .addGroup(btnXoaLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jLabel11)
                .addContainerGap(32, Short.MAX_VALUE))
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

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 153, 153));
        jLabel9.setText("SỬA");

        javax.swing.GroupLayout btnSuaLayout = new javax.swing.GroupLayout(btnSua);
        btnSua.setLayout(btnSuaLayout);
        btnSuaLayout.setHorizontalGroup(
            btnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btnSuaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addContainerGap(34, Short.MAX_VALUE))
        );
        btnSuaLayout.setVerticalGroup(
            btnSuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
        );

        jLabel40.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(0, 102, 102));
        jLabel40.setText("Thông tin phòng");

        jLabel8.setForeground(new java.awt.Color(0, 102, 102));
        jLabel8.setText("Giá theo giờ:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(211, 211, 211))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(txtSoPhong)
                                        .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtGiaTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(43, 43, 43)
                                    .addComponent(txtSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel7))
                                    .addGap(33, 33, 33)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtGiaTheoGio)
                                        .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(77, 77, 77))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel40)
                                .addGap(175, 175, 175))))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 454, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(18, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel40)
                        .addGap(41, 41, 41)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoGiuong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaTheoNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtGiaTheoGio, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnXoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(52, 52, 52))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private boolean kiemTra(int maPhong){
        PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        for (PhongDTO ph : PhongBUS.dsPhong) {
            if(ph.getMaPhong()== maPhong){
                return false;
            }
        }
        return true;
    }
    private void Reset(){
        txtSoPhong.setText("");
        txtSoGiuong.setText("");
        txtLoai.setText("");
        txtGiaTheoNgay.setText("");
        txtGiaTheoGio.setText("");
        cbTinhTrang.setSelectedIndex(0);
    }
    private boolean kiemTraLoaiPhong(String i){
        switch (i) {
            case "ĐƠN":
                return true;
            case "ĐÔI":
                return true;
            case "VIP":
                return true;
            default:
                return false;
        }
    }
    private void btnThemMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThemMousePressed
        try {    
            PhongDTO ph = new PhongDTO();  
            ph.setMaPhong(Integer.parseInt(txtSoPhong.getText()));
            ph.setSoGiuong(Integer.parseInt(txtSoGiuong.getText()));
            ph.setLoaiPhong(txtLoai.getText());
            ph.setGiaTheoNgay(Float.parseFloat(txtGiaTheoNgay.getText()));
            ph.setGiaTheoGio(Float.parseFloat(txtGiaTheoGio.getText()));
            if(cbTinhTrang.getSelectedIndex()==0){
                ph.setTinhTrang(1);
            }else{
                ph.setTinhTrang(3); //dang don
            }
                
            if(kiemTra(Integer.parseInt(txtSoPhong.getText()))  && kiemTraLoaiPhong(txtLoai.getText())  && 
                    Float.parseFloat(txtGiaTheoNgay.getText()) < 0.0  &&  Float.parseFloat(txtGiaTheoGio.getText()) < 0.0){
                    PhongBUS bus = new PhongBUS();  
                    bus.insertPhong(ph);
                    showAll();
                    Reset();    
            }else{
                JOptionPane.showMessageDialog(this, "Phòng đã tồn tại");
            }
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
    }//GEN-LAST:event_btnThemMousePressed

    private void btnSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMousePressed
        try {
            PhongDTO ph = new PhongDTO();
            int n = tbDanhSachPhong.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
            if (n == -1) {
                JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
            } else {
                //ph.setMaPhong(Integer.parseInt(txtSoPhong.getText()));
                ph.setSoGiuong(Integer.parseInt(txtSoGiuong.getText()));
                ph.setLoaiPhong(txtLoai.getText());
                ph.setGiaTheoNgay(Float.parseFloat(txtGiaTheoNgay.getText()));
                ph.setGiaTheoGio(Float.parseFloat(txtGiaTheoGio.getText()));
                if(cbTinhTrang.getSelectedIndex()==0){
                    ph.setTinhTrang(1);
                }else{
                    ph.setTinhTrang(3);
                }
                ph.setMaPhong(Integer.parseInt(tableModel.getValueAt(n, 0).toString()));
            }
            if(ph.getMaPhong() != Integer.parseInt(txtSoPhong.getText())){// nếu sửa mã phòng
                if(kiemTra(Integer.parseInt(txtSoPhong.getText()))  &&   kiemTraLoaiPhong(txtLoai.getText())  &&
                        (Float.parseFloat(txtGiaTheoNgay.getText()))<0.0  &&  Float.parseFloat(txtGiaTheoGio.getText())<0.0){
                    PhongBUS bus = new PhongBUS();
                    bus.updatePhong(ph,Integer.parseInt(txtSoPhong.getText()));
                    tbDanhSachPhong.repaint();
                    showAll();
                    Reset();   
                    JOptionPane.showMessageDialog(this, "Đã cập nhật");
                }else{
                    JOptionPane.showMessageDialog(this, "Kiểm tra thông tin nhập");
                }      
            }else{
                    PhongBUS bus = new PhongBUS();
                    bus.updatePhong(ph,ph.getMaPhong());
                    tbDanhSachPhong.repaint();
                    showAll();
                    Reset(); 
                    JOptionPane.showMessageDialog(this, "Đã cập nhật");
            }
                       
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Đã có lỗi");
        }
    }//GEN-LAST:event_btnSuaMousePressed

    private void btnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMousePressed
        int n = tbDanhSachPhong.getSelectedRow();
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        } else {
            try {
                int maPhong = Integer.parseInt(tableModel.getValueAt(n, 0).toString());
                PhongBUS bus = new PhongBUS();
                bus.deletePhong(maPhong,n);
                tbDanhSachPhong.repaint();
                showAll();
                Reset();
                JOptionPane.showMessageDialog(this, "Đã xóa 1 phòng");
            } catch (SQLException ex) {
                Logger.getLogger(KhachHang1.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }//GEN-LAST:event_btnXoaMousePressed

    private void tbDanhSachPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachPhongMouseClicked
        int n = tbDanhSachPhong.getSelectedRow();  //khi người dùng bấm bất kì dòng nào trên table
        if (n == -1) {
            JOptionPane.showMessageDialog(this, "Chọn dòng để cập nhật");
        } else {
            txtSoPhong.setText(tableModel.getValueAt(n, 0).toString());
            txtSoGiuong.setText(tableModel.getValueAt(n, 1).toString());
            txtLoai.setText(tableModel.getValueAt(n, 2).toString());
            txtGiaTheoNgay.setText(tableModel.getValueAt(n, 3).toString());
            txtGiaTheoGio.setText( tableModel.getValueAt(n, 4).toString());
            cbTinhTrang.setSelectedItem(tableModel.getValueAt(n, 5).toString());
        }
    }//GEN-LAST:event_tbDanhSachPhongMouseClicked

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
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyPhong.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new QuanLyPhong().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(QuanLyPhong.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel btnSua;
    private javax.swing.JPanel btnThem;
    private javax.swing.JPanel btnXoa;
    private javax.swing.JComboBox<String> cbTinhTrang;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbDanhSachPhong;
    private javax.swing.JTextField txtGiaTheoGio;
    private javax.swing.JTextField txtGiaTheoNgay;
    private javax.swing.JTextField txtLoai;
    private javax.swing.JTextField txtSoGiuong;
    private javax.swing.JTextField txtSoPhong;
    // End of variables declaration//GEN-END:variables
}
