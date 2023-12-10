package view;

import bus.HoaDonBUS;
import bus.KhachHangBUS;
import bus.PhieuSuDungDichVuBUS;
import com.raven.chart.Chart;
import com.raven.chart.ModelChart;
import java.awt.Color;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDonDTO;
import model.KhachHangDTO;
import model.topDVBanChayDTO;

public class ThongKe extends javax.swing.JPanel {

    DefaultTableModel tableModel;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/YYYY HH:mm");

    public DecimalFormat getFormatter() {
        return formatter;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    //tổng tiền của hóa đơn
    private int hoaDonQuy1 = 0;
    private int hoaDonQuy2 = 0;
    private int hoaDonQuy3 = 0;
    private int hoaDonQuy4 = 0;

    //không có năm phù hợp
    private boolean checkNam = false;

    /**
     * Creates new form ThongKe
     */
    public ThongKe() throws SQLException {
        initComponents();
        thongKeBanHang();

        //panel1.remove(chart);
        chart.addLegend("Doanh thu", new Color(139, 229, 222));
        chart.addData(new ModelChart("Quý 1", new double[]{hoaDonQuy1}));
        chart.addData(new ModelChart("Quý 2", new double[]{hoaDonQuy2}));
        chart.addData(new ModelChart("Quý 3", new double[]{hoaDonQuy3}));
        chart.addData(new ModelChart("Quý 4", new double[]{hoaDonQuy4}));

        //tổng tiền của nhập hàng
        hoaDonQuy1 = 0;
        hoaDonQuy2 = 0;
        hoaDonQuy3 = 0;
        hoaDonQuy4 = 0;

        showAll();

        hoaDon.setText(tkHoaDon() + "");
        khachHang.setText(tkKhachHang() + "");
        doanhThu.setText(tkDoanhThu() / 1000000 + "M");
    }

    private void showAll() throws SQLException {
        tableModel = (DefaultTableModel) tbTopBanChay.getModel();
        showTopBanChay();

    }

    private int tkHoaDon() throws SQLException {
        HoaDonBUS bus = new HoaDonBUS();
        bus.docHoaDon();
        int slhd = 0;
        for (HoaDonDTO dsHD : HoaDonBUS.dsHD) {
            slhd++;
        }
        return slhd;
    }

    private int tkKhachHang() throws SQLException {
        KhachHangBUS bus = new KhachHangBUS();
        bus.docKhachHang();
        int soLuong = 0;
        for (KhachHangDTO dsKH : KhachHangBUS.dsKhachHang) {
            soLuong++;
        }
        return soLuong;
    }

    private int tkDoanhThu() throws SQLException {
        HoaDonBUS bus = new HoaDonBUS();
        bus.docHoaDon();
        int doanhThu = 0;
        for (HoaDonDTO dsHD : HoaDonBUS.dsHD) {
            doanhThu += dsHD.getTongTien();
        }
        return doanhThu;
    }

    private void thongKeBanHang() throws SQLException {
        HoaDonBUS bus = new HoaDonBUS();
        bus.docHoaDon();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat();//năm
        simpleDateFormat.applyPattern("yyyy");
        SimpleDateFormat simpleDateFormatThang = new SimpleDateFormat();//tháng
        simpleDateFormatThang.applyPattern("MM");
        for (HoaDonDTO hoaDon : HoaDonBUS.dsHD) {
            int nam = Integer.parseInt(simpleDateFormat.format(hoaDon.getNgayGD()));
            int thang = Integer.parseInt(simpleDateFormatThang.format(hoaDon.getNgayGD()));
            if (Integer.parseInt(cbNam.getSelectedItem().toString()) == nam) {
                if (thang >= 1 && thang <= 3) {
                    hoaDonQuy1 += hoaDon.getTongTien();
                } else if (thang >= 4 && thang <= 6) {
                    hoaDonQuy2 += hoaDon.getTongTien();
                } else if (thang >= 7 && thang <= 9) {
                    hoaDonQuy3 += hoaDon.getTongTien();
                } else {
                    hoaDonQuy4 += hoaDon.getTongTien();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        khachHang = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        doanhThu = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        hoaDon = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbTopBanChay = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        panel1 = new javax.swing.JPanel();
        chart = new com.raven.chart.Chart();
        btnCheck = new javax.swing.JButton();
        cbNam = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(230, 243, 243));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 153));
        jLabel6.setText("BIỂU ĐỒ THỐNG KÊ");

        jPanel2.setBackground(new java.awt.Color(0, 153, 153));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("KHÁCH HÀNG");

        khachHang.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        khachHang.setForeground(new java.awt.Color(255, 255, 255));
        khachHang.setText("100");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(111, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3))
                .addGap(99, 99, 99))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(khachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("DOANH THU");

        doanhThu.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        doanhThu.setForeground(new java.awt.Color(255, 255, 255));
        doanhThu.setText("100");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(107, 107, 107)
                        .addComponent(jLabel1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(doanhThu)))
                .addContainerGap(107, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(doanhThu, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(40, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("HÓA ĐƠN");

        hoaDon.setFont(new java.awt.Font("SF Pro Display", 1, 36)); // NOI18N
        hoaDon.setForeground(new java.awt.Color(255, 255, 255));
        hoaDon.setText("100");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(hoaDon)))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(hoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        tbTopBanChay.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Top", "Mã Phòng", "Mã Dịch Vụ", "Số lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbTopBanChay.setSelectionBackground(javax.swing.UIManager.getDefaults().getColor("InternalFrame.closePressedBackground"));
        tbTopBanChay.setShowGrid(true);
        jScrollPane1.setViewportView(tbTopBanChay);

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 153, 153));
        jLabel7.setText("Top 10 dịch vụ được dùng nhiều");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(204, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(362, 362, 362))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 721, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(129, 129, 129))))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel7)
                .addGap(73, 73, 73)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(206, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Dịch vụ được dùng nhiều", jPanel6);

        panel1.setLayout(null);
        panel1.add(chart);
        chart.setBounds(0, 0, 1054, 506);

        btnCheck.setText("Check");
        btnCheck.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnCheckMousePressed(evt);
            }
        });
        btnCheck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCheckActionPerformed(evt);
            }
        });
        panel1.add(btnCheck);
        btnCheck.setBounds(570, 510, 72, 23);

        cbNam.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2020", "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        cbNam.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                cbNamMousePressed(evt);
            }
        });
        cbNam.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbNamActionPerformed(evt);
            }
        });
        panel1.add(cbNam);
        cbNam.setBounds(430, 510, 72, 22);

        jTabbedPane1.addTab("Thống kê doanh thu", panel1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1054, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(63, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(97, 97, 97)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(505, Short.MAX_VALUE)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(486, 486, 486))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 572, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(39, Short.MAX_VALUE))
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

    private void cbNamMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbNamMousePressed

    }//GEN-LAST:event_cbNamMousePressed

    private void btnCheckMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCheckMousePressed
        try {
            thongKeBanHang();
        } catch (SQLException ex) {
            Logger.getLogger(ThongKe.class.getName()).log(Level.SEVERE, null, ex);
        }

        panel1.remove(chart);
        chart = new Chart();
        chart.addLegend("Doanh thu", new Color(139, 229, 222));
        chart.addData(new ModelChart("Quý 1", new double[]{hoaDonQuy1}));
        chart.addData(new ModelChart("Quý 2", new double[]{hoaDonQuy2}));
        chart.addData(new ModelChart("Quý 3", new double[]{hoaDonQuy3}));
        chart.addData(new ModelChart("Quý 4", new double[]{hoaDonQuy4}));

        //System.out.println(chart);
        chart.validate();
        chart.repaint();
        chart.setBounds(0, 0, 1054, 506);
        panel1.add(chart);
        panel1.validate();
        panel1.repaint();

        //tổng tiền của hóa đơn
        hoaDonQuy1 = 0;
        hoaDonQuy2 = 0;
        hoaDonQuy3 = 0;
        hoaDonQuy4 = 0;
    }//GEN-LAST:event_btnCheckMousePressed

    private void btnCheckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCheckActionPerformed
        
    }//GEN-LAST:event_btnCheckActionPerformed

    private void cbNamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbNamActionPerformed
    }//GEN-LAST:event_cbNamActionPerformed
    private void showTopBanChay() {
        PhieuSuDungDichVuBUS bus = new PhieuSuDungDichVuBUS();
        bus.topDVBanChay();
        int top = 0;
        tableModel.setRowCount(0);
        for (topDVBanChayDTO dvBC : PhieuSuDungDichVuBUS.dsdvbc) {
            top++;
            tableModel.addRow(new Object[]{
                top,
                dvBC.getMaPhong(),
                dvBC.getMaDV(),
                dvBC.getSoLuong()});
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCheck;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbNam;
    private com.raven.chart.Chart chart;
    private javax.swing.JLabel doanhThu;
    private javax.swing.JLabel hoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel khachHang;
    private javax.swing.JPanel panel1;
    private javax.swing.JTable tbTopBanChay;
    // End of variables declaration//GEN-END:variables
}
