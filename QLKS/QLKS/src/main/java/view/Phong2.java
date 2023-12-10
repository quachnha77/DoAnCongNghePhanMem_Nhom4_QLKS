package view;

import bus.PhongBUS;
import java.awt.Color;
import java.awt.Label;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import model.PhongDTO;

public class Phong2 extends javax.swing.JPanel {
    private final String username;
    PhongBUS bus = new PhongBUS();
    int TRANG = 1;
    int TANG = 1;
    public Phong2(String user) {
        initComponents();
        username = user;
        
        HideAll();
        showAll();
    }
    public void HideAll() {
        Phong1.setVisible(false);
        Phong2.setVisible(false);
        Phong3.setVisible(false);
        Phong4.setVisible(false);
        Phong5.setVisible(false);
        Phong6.setVisible(false);
        Phong7.setVisible(false);
        Phong8.setVisible(false);
        Phong9.setVisible(false);
        Phong10.setVisible(false);
        Phong11.setVisible(false);
        Phong12.setVisible(false);
        Phong13.setVisible(false);
        Phong14.setVisible(false);
    }
    Color colorMoved = new Color(95,153,153);
    Color colorExited = new Color(64, 153, 153);
    
    Color mauPhongTrong = new Color(64,153,153);
    Color mauPhongTrongMOVE = new Color(100,153,153);
    
    Color mauPhongCoKhach = new Color(219,88,96);
    Color mauPhongCoKhachMOVE = new Color(210,88,96);
    
    Color mauPhongDangDon = new Color(192,192,192);
    Color mauPhongDangDonMOVE = new Color(123,192,192);
    private Color setColorItem(int tinhTrang){
        return switch (tinhTrang) {
            case 1 -> mauPhongTrong;
            case 2 -> mauPhongCoKhach;
            case 3 -> mauPhongDangDon;
            default -> null;
        };
    }
    public void showAll() {
        showThongTin(1,1); //i phải là 1, 15,...
    }
    private void demSoPhong(){
        int i = 0;
        for (PhongDTO dp : PhongBUS.dsPhong) {
            i++;
        }
    }
    // chuyễn từ 1: còn trống, 2 đã được thuê, 3: đang dọn thành text
    private String tinhTrang(int trangThai){
        switch (trangThai) {
            case 1:
                return "Còn trống";
            case 2:
                return "Đã được thuê";
            case 3:
                return "Đang dọn";
        }
        return null;
    }
    private void soPhongTrong(){ 
        //PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        bus.soPhongTrong();
        PhongDonTrong.setText(bus.don + "");
        PhongDoiTrong.setText(bus.doi + "");
        PhongVIPTrong.setText(bus.vip + "");
        tongSoPhongTrong.setText(bus.don + bus.doi + bus.vip + "");
        khachDangThue.setText(bus.daDuocThue + "");
        dangDon.setText(bus.dangDon + "");
    }
    
    private void showThongTin(int trang, int tang) { 
        HideAll();
        //PhongBUS bus = new PhongBUS();
        bus.docDatPhong();
        int dem = 1;
        for (PhongDTO dp : PhongBUS.dsPhong) {
            if(dp.getMaPhong()/100 == tang){
                switch (dem-trang+1){
                    case 1 -> {
                        maPhong01.setText(dp.getMaPhong() + "");
                        loaiPhong01.setText(dp.getLoaiPhong());
                        trangThai01.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong1.setText(dp.getSoGiuong() + "");
                        Phong1.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong1.setVisible(true);
                    }
                    case 2 -> {
                        maPhong02.setText(dp.getMaPhong() + "");
                        loaiPhong02.setText(dp.getLoaiPhong());
                        trangThai02.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong2.setText(dp.getSoGiuong() + "");
                        Phong2.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong2.setVisible(true);
                    }
                    case 3 -> {
                        maPhong03.setText(dp.getMaPhong() + "");
                        loaiPhong03.setText(dp.getLoaiPhong());
                        trangThai03.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong3.setText(dp.getSoGiuong() + "");
                        Phong3.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong3.setVisible(true);
                    }
                    case 4 -> {
                        maPhong04.setText(dp.getMaPhong() + "");
                        loaiPhong04.setText(dp.getLoaiPhong());
                        trangThai04.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong4.setText(dp.getSoGiuong() + "");
                        Phong4.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong4.setVisible(true);
                    }
                    case 5 -> {
                        maPhong05.setText(dp.getMaPhong() + "");
                        loaiPhong05.setText(dp.getLoaiPhong());
                        trangThai05.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong5.setText(dp.getSoGiuong() + "");
                        Phong5.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong5.setVisible(true);
                    }
                    case 6 -> {
                        maPhong06.setText(dp.getMaPhong() + "");
                        loaiPhong06.setText(dp.getLoaiPhong());
                        trangThai06.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong6.setText(dp.getSoGiuong() + "");
                        Phong6.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong6.setVisible(true);
                    }
                    case 7 -> {
                        maPhong07.setText(dp.getMaPhong() + "");
                        loaiPhong07.setText(dp.getLoaiPhong());
                        trangThai07.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong7.setText(dp.getSoGiuong() + "");
                        Phong7.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong7.setVisible(true);
                    }
                    case 8 -> {
                        maPhong08.setText(dp.getMaPhong() + "");
                        loaiPhong08.setText(dp.getLoaiPhong());
                        trangThai08.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong8.setText(dp.getSoGiuong() + "");
                        Phong8.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong8.setVisible(true);
                    }
                    case 9 -> {
                        maPhong09.setText(dp.getMaPhong() + "");
                        loaiPhong09.setText(dp.getLoaiPhong());
                        trangThai09.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong9.setText(dp.getSoGiuong() + "");
                        Phong9.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong9.setVisible(true);
                    }
                    case 10 -> {
                        maPhong10.setText(dp.getMaPhong() + "");
                        loaiPhong10.setText(dp.getLoaiPhong());
                        trangThai10.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong10.setText(dp.getSoGiuong() + "");
                        Phong10.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong10.setVisible(true);
                    }
                    case 11 -> {
                        maPhong11.setText(dp.getMaPhong() + "");
                        loaiPhong11.setText(dp.getLoaiPhong());
                        trangThai11.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong11.setText(dp.getSoGiuong() + "");
                        Phong11.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong11.setVisible(true);
                    }
                    case 12 -> {
                        maPhong12.setText(dp.getMaPhong() + "");
                        loaiPhong12.setText(dp.getLoaiPhong());
                        trangThai12.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong12.setText(dp.getSoGiuong() + "");
                        Phong12.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong12.setVisible(true);
                    }
                    case 13 -> {
                        maPhong13.setText(dp.getMaPhong() + "");
                        loaiPhong13.setText(dp.getLoaiPhong());
                        trangThai13.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong13.setText(dp.getSoGiuong() + "");
                        Phong13.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong13.setVisible(true);
                    }
                    case 14 -> {
                        maPhong14.setText(dp.getMaPhong() + "");
                        loaiPhong14.setText(dp.getLoaiPhong());
                        trangThai14.setText(tinhTrang(dp.getTinhTrang()));
                        soGiuong14.setText(dp.getSoGiuong() + "");
                        Phong14.setBackground(setColorItem(dp.getTinhTrang()));
                        Phong14.setVisible(true);
                    }
                    default -> {
                    }
                }
                dem++;
                soPhongTrong();
            }
        } 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        DatPhong = new javax.swing.JPanel();
        jPanel81 = new javax.swing.JPanel();
        jLabel220 = new javax.swing.JLabel();
        jLabel221 = new javax.swing.JLabel();
        jPanel83 = new javax.swing.JPanel();
        jLabel224 = new javax.swing.JLabel();
        tongSoPhongTrong = new javax.swing.JLabel();
        jLabel230 = new javax.swing.JLabel();
        khachDangThue = new javax.swing.JLabel();
        jLabel232 = new javax.swing.JLabel();
        jLabel234 = new javax.swing.JLabel();
        PhongVIPTrong = new javax.swing.JLabel();
        jLabel236 = new javax.swing.JLabel();
        PhongDonTrong = new javax.swing.JLabel();
        cbTrang = new javax.swing.JComboBox<>();
        cbTang = new javax.swing.JComboBox<>();
        line1 = new javax.swing.JPanel();
        Phong1 = new javax.swing.JPanel();
        maPhong01 = new javax.swing.JLabel();
        loaiPhong01 = new javax.swing.JLabel();
        trangThai01 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        soGiuong1 = new javax.swing.JLabel();
        Phong2 = new javax.swing.JPanel();
        maPhong02 = new javax.swing.JLabel();
        loaiPhong02 = new javax.swing.JLabel();
        trangThai02 = new javax.swing.JLabel();
        soGiuong2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        Phong3 = new javax.swing.JPanel();
        maPhong03 = new javax.swing.JLabel();
        loaiPhong03 = new javax.swing.JLabel();
        trangThai03 = new javax.swing.JLabel();
        soGiuong3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Phong4 = new javax.swing.JPanel();
        maPhong04 = new javax.swing.JLabel();
        loaiPhong04 = new javax.swing.JLabel();
        trangThai04 = new javax.swing.JLabel();
        soGiuong4 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Phong5 = new javax.swing.JPanel();
        maPhong05 = new javax.swing.JLabel();
        loaiPhong05 = new javax.swing.JLabel();
        trangThai05 = new javax.swing.JLabel();
        soGiuong5 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        Phong6 = new javax.swing.JPanel();
        maPhong06 = new javax.swing.JLabel();
        loaiPhong06 = new javax.swing.JLabel();
        trangThai06 = new javax.swing.JLabel();
        soGiuong6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Phong7 = new javax.swing.JPanel();
        maPhong07 = new javax.swing.JLabel();
        loaiPhong07 = new javax.swing.JLabel();
        trangThai07 = new javax.swing.JLabel();
        soGiuong7 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        line2 = new javax.swing.JPanel();
        Phong8 = new javax.swing.JPanel();
        maPhong08 = new javax.swing.JLabel();
        loaiPhong08 = new javax.swing.JLabel();
        trangThai08 = new javax.swing.JLabel();
        soGiuong8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        Phong9 = new javax.swing.JPanel();
        maPhong09 = new javax.swing.JLabel();
        loaiPhong09 = new javax.swing.JLabel();
        trangThai09 = new javax.swing.JLabel();
        soGiuong9 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        Phong10 = new javax.swing.JPanel();
        maPhong10 = new javax.swing.JLabel();
        loaiPhong10 = new javax.swing.JLabel();
        trangThai10 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        soGiuong10 = new javax.swing.JLabel();
        Phong11 = new javax.swing.JPanel();
        maPhong11 = new javax.swing.JLabel();
        loaiPhong11 = new javax.swing.JLabel();
        trangThai11 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        soGiuong11 = new javax.swing.JLabel();
        Phong12 = new javax.swing.JPanel();
        maPhong12 = new javax.swing.JLabel();
        loaiPhong12 = new javax.swing.JLabel();
        trangThai12 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        soGiuong12 = new javax.swing.JLabel();
        Phong13 = new javax.swing.JPanel();
        maPhong13 = new javax.swing.JLabel();
        loaiPhong13 = new javax.swing.JLabel();
        trangThai13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        soGiuong13 = new javax.swing.JLabel();
        Phong14 = new javax.swing.JPanel();
        maPhong14 = new javax.swing.JLabel();
        loaiPhong14 = new javax.swing.JLabel();
        trangThai14 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        soGiuong14 = new javax.swing.JLabel();
        jLabel238 = new javax.swing.JLabel();
        PhongDoiTrong = new javax.swing.JLabel();
        dangDon = new javax.swing.JLabel();
        jLabel231 = new javax.swing.JLabel();
        jLabel222 = new javax.swing.JLabel();
        jPanel84 = new javax.swing.JPanel();

        DatPhong.setBackground(new java.awt.Color(230, 243, 243));

        jPanel81.setBackground(new java.awt.Color(0, 153, 153));

        javax.swing.GroupLayout jPanel81Layout = new javax.swing.GroupLayout(jPanel81);
        jPanel81.setLayout(jPanel81Layout);
        jPanel81Layout.setHorizontalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel81Layout.setVerticalGroup(
            jPanel81Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel220.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel220.setForeground(new java.awt.Color(0, 153, 153));
        jLabel220.setText("PHÒNG TRỐNG");

        jLabel221.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel221.setForeground(new java.awt.Color(0, 153, 153));
        jLabel221.setText("PHÒNG ĐÃ ĐƯỢC THUÊ");

        jPanel83.setBackground(javax.swing.UIManager.getDefaults().getColor("Actions.Red"));

        javax.swing.GroupLayout jPanel83Layout = new javax.swing.GroupLayout(jPanel83);
        jPanel83.setLayout(jPanel83Layout);
        jPanel83Layout.setHorizontalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel83Layout.setVerticalGroup(
            jPanel83Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel224.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel224.setForeground(new java.awt.Color(0, 153, 153));
        jLabel224.setText("Phòng trống:");

        tongSoPhongTrong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        tongSoPhongTrong.setForeground(new java.awt.Color(0, 153, 153));
        tongSoPhongTrong.setText("20");

        jLabel230.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel230.setForeground(new java.awt.Color(0, 153, 153));
        jLabel230.setText("Khách đang thuê:");

        khachDangThue.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        khachDangThue.setForeground(new java.awt.Color(0, 153, 153));
        khachDangThue.setText("20");

        jLabel232.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel232.setForeground(new java.awt.Color(10, 125, 125));
        jLabel232.setText("Phòng trống");

        jLabel234.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel234.setForeground(new java.awt.Color(10, 125, 125));
        jLabel234.setText("VIP:");

        PhongVIPTrong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PhongVIPTrong.setForeground(new java.awt.Color(10, 125, 125));
        PhongVIPTrong.setText("20");

        jLabel236.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel236.setForeground(new java.awt.Color(10, 125, 125));
        jLabel236.setText("ĐƠN:");

        PhongDonTrong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PhongDonTrong.setForeground(new java.awt.Color(10, 125, 125));
        PhongDonTrong.setText("20");

        cbTrang.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        cbTrang.setForeground(new java.awt.Color(0, 102, 102));
        cbTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Trang 1", "Trang 2", "Trang 3", "Trang 4", "Trang 5", "Trang 6", "Trang 7" }));
        cbTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTrangActionPerformed(evt);
            }
        });

        cbTang.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cbTang.setForeground(new java.awt.Color(0, 102, 102));
        cbTang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "TẦNG 1", "TẦNG 2", "TẦNG 3", "TẦNG 4", "TẦNG 5" }));
        cbTang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbTangActionPerformed(evt);
            }
        });

        line1.setBackground(new java.awt.Color(230, 243, 243));
        line1.setLayout(new java.awt.GridLayout(1, 0));

        Phong1.setBackground(new java.awt.Color(64, 153, 153));
        Phong1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong1.setMaximumSize(new java.awt.Dimension(143, 233));
        Phong1.setName(""); // NOI18N
        Phong1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong1MouseMoved(evt);
            }
        });
        Phong1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong1MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong1MouseExited(evt);
            }
        });

        maPhong01.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong01.setForeground(new java.awt.Color(255, 255, 255));
        maPhong01.setText("101");

        loaiPhong01.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong01.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong01.setText("VIP");

        trangThai01.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai01.setForeground(new java.awt.Color(255, 255, 255));
        trangThai01.setText("Đang trống");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Số giường:");

        soGiuong1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong1.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong1.setText("2");

        javax.swing.GroupLayout Phong1Layout = new javax.swing.GroupLayout(Phong1);
        Phong1.setLayout(Phong1Layout);
        Phong1Layout.setHorizontalGroup(
            Phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong1Layout.createSequentialGroup()
                .addGroup(Phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Phong1Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(loaiPhong01))
                    .addGroup(Phong1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(Phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(trangThai01)
                            .addComponent(maPhong01))))
                .addGap(12, 12, 12))
        );
        Phong1Layout.setVerticalGroup(
            Phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(maPhong01)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong01)
                .addGap(18, 18, 18)
                .addComponent(trangThai01)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(Phong1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16))
        );

        line1.add(Phong1);

        Phong2.setBackground(new java.awt.Color(64, 153, 153));
        Phong2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Phong2.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong2MouseMoved(evt);
            }
        });
        Phong2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong2MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong2MouseExited(evt);
            }
        });

        maPhong02.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong02.setForeground(new java.awt.Color(255, 255, 255));
        maPhong02.setText("101");

        loaiPhong02.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong02.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong02.setText("VIP");

        trangThai02.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai02.setForeground(new java.awt.Color(255, 255, 255));
        trangThai02.setText("Đang trống");

        soGiuong2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong2.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong2.setText("2");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Số giường:");

        javax.swing.GroupLayout Phong2Layout = new javax.swing.GroupLayout(Phong2);
        Phong2.setLayout(Phong2Layout);
        Phong2Layout.setHorizontalGroup(
            Phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong2Layout.createSequentialGroup()
                .addGroup(Phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong2Layout.createSequentialGroup()
                        .addContainerGap(26, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Phong2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(trangThai02))
                    .addGroup(Phong2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(maPhong02))
                    .addGroup(Phong2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(loaiPhong02)))
                .addGap(11, 11, 11))
        );
        Phong2Layout.setVerticalGroup(
            Phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong2Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong02)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong02)
                .addGap(18, 18, 18)
                .addComponent(trangThai02)
                .addGap(18, 18, 18)
                .addGroup(Phong2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong2)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong2);

        Phong3.setBackground(new java.awt.Color(64, 153, 153));
        Phong3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong3.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong3MouseMoved(evt);
            }
        });
        Phong3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong3MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong3MouseExited(evt);
            }
        });

        maPhong03.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong03.setForeground(new java.awt.Color(255, 255, 255));
        maPhong03.setText("101");

        loaiPhong03.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong03.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong03.setText("VIP");

        trangThai03.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai03.setForeground(new java.awt.Color(255, 255, 255));
        trangThai03.setText("Đang trống");

        soGiuong3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong3.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong3.setText("2");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Số giường:");

        javax.swing.GroupLayout Phong3Layout = new javax.swing.GroupLayout(Phong3);
        Phong3.setLayout(Phong3Layout);
        Phong3Layout.setHorizontalGroup(
            Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong3Layout.createSequentialGroup()
                .addGroup(Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong3Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Phong3Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(soGiuong3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trangThai03)))
                    .addGroup(Phong3Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(loaiPhong03, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(maPhong03))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(11, 11, 11))
        );
        Phong3Layout.setVerticalGroup(
            Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong03)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong03)
                .addGap(18, 18, 18)
                .addComponent(trangThai03)
                .addGap(18, 18, 18)
                .addGroup(Phong3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong3)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong3);

        Phong4.setBackground(new java.awt.Color(64, 153, 153));
        Phong4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong4.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Phong4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong4MouseMoved(evt);
            }
        });
        Phong4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong4MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong4MouseExited(evt);
            }
        });

        maPhong04.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong04.setForeground(new java.awt.Color(255, 255, 255));
        maPhong04.setText("101");

        loaiPhong04.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong04.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong04.setText("VIP");

        trangThai04.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai04.setForeground(new java.awt.Color(255, 255, 255));
        trangThai04.setText("Đang trống");

        soGiuong4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong4.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong4.setText("2");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số giường:");

        javax.swing.GroupLayout Phong4Layout = new javax.swing.GroupLayout(Phong4);
        Phong4.setLayout(Phong4Layout);
        Phong4Layout.setHorizontalGroup(
            Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong4Layout.createSequentialGroup()
                .addGroup(Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong4Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Phong4Layout.createSequentialGroup()
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soGiuong4, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trangThai04)))
                    .addGroup(Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Phong4Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(loaiPhong04, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Phong4Layout.createSequentialGroup()
                            .addGap(39, 39, 39)
                            .addComponent(maPhong04))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        Phong4Layout.setVerticalGroup(
            Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong4Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong04)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong04)
                .addGap(18, 18, 18)
                .addComponent(trangThai04)
                .addGap(18, 18, 18)
                .addGroup(Phong4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong4)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong4);

        Phong5.setBackground(new java.awt.Color(64, 153, 153));
        Phong5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong5.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong5MouseMoved(evt);
            }
        });
        Phong5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong5MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong5MouseExited(evt);
            }
        });

        maPhong05.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong05.setForeground(new java.awt.Color(255, 255, 255));
        maPhong05.setText("101");

        loaiPhong05.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong05.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong05.setText("VIP");

        trangThai05.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai05.setForeground(new java.awt.Color(255, 255, 255));
        trangThai05.setText("Đang trống");

        soGiuong5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong5.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong5.setText("2");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Số giường:");

        javax.swing.GroupLayout Phong5Layout = new javax.swing.GroupLayout(Phong5);
        Phong5.setLayout(Phong5Layout);
        Phong5Layout.setHorizontalGroup(
            Phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong5Layout.createSequentialGroup()
                .addGroup(Phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong5Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addComponent(maPhong05))
                    .addGroup(Phong5Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Phong5Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soGiuong5, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trangThai05))))
                .addContainerGap(11, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(loaiPhong05, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
        );
        Phong5Layout.setVerticalGroup(
            Phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong5Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong05)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong05)
                .addGap(18, 18, 18)
                .addComponent(trangThai05)
                .addGap(18, 18, 18)
                .addGroup(Phong5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong5)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong5);

        Phong6.setBackground(new java.awt.Color(64, 153, 153));
        Phong6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong6.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong6MouseMoved(evt);
            }
        });
        Phong6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong6MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong6MouseExited(evt);
            }
        });

        maPhong06.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong06.setForeground(new java.awt.Color(255, 255, 255));
        maPhong06.setText("101");

        loaiPhong06.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong06.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong06.setText("VIP");

        trangThai06.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai06.setForeground(new java.awt.Color(255, 255, 255));
        trangThai06.setText("Đang trống");

        soGiuong6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong6.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong6.setText("2");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Số giường:");

        javax.swing.GroupLayout Phong6Layout = new javax.swing.GroupLayout(Phong6);
        Phong6.setLayout(Phong6Layout);
        Phong6Layout.setHorizontalGroup(
            Phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong6Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(loaiPhong06, javax.swing.GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
                .addGap(50, 50, 50))
            .addGroup(Phong6Layout.createSequentialGroup()
                .addGroup(Phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong6Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(maPhong06))
                    .addGroup(Phong6Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Phong6Layout.createSequentialGroup()
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soGiuong6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trangThai06))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        Phong6Layout.setVerticalGroup(
            Phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong6Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong06)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong06)
                .addGap(18, 18, 18)
                .addComponent(trangThai06)
                .addGap(18, 18, 18)
                .addGroup(Phong6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong6)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong6);

        Phong7.setBackground(new java.awt.Color(64, 153, 153));
        Phong7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong7.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong7MouseMoved(evt);
            }
        });
        Phong7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong7MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong7MouseExited(evt);
            }
        });

        maPhong07.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong07.setForeground(new java.awt.Color(255, 255, 255));
        maPhong07.setText("101");

        loaiPhong07.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong07.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong07.setText("VIP");

        trangThai07.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai07.setForeground(new java.awt.Color(255, 255, 255));
        trangThai07.setText("Đang trống");

        soGiuong7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong7.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong7.setText("2");

        jLabel14.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Số giường:");

        javax.swing.GroupLayout Phong7Layout = new javax.swing.GroupLayout(Phong7);
        Phong7.setLayout(Phong7Layout);
        Phong7Layout.setHorizontalGroup(
            Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong7Layout.createSequentialGroup()
                .addGroup(Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong7Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Phong7Layout.createSequentialGroup()
                                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(soGiuong7, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(trangThai07)))
                    .addGroup(Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(Phong7Layout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(loaiPhong07, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, Phong7Layout.createSequentialGroup()
                            .addGap(38, 38, 38)
                            .addComponent(maPhong07))))
                .addContainerGap(11, Short.MAX_VALUE))
        );
        Phong7Layout.setVerticalGroup(
            Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong7Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong07)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong07)
                .addGap(18, 18, 18)
                .addComponent(trangThai07)
                .addGap(18, 18, 18)
                .addGroup(Phong7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(soGiuong7)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        line1.add(Phong7);

        line2.setBackground(new java.awt.Color(230, 243, 243));
        line2.setLayout(new java.awt.GridLayout(1, 0));

        Phong8.setBackground(new java.awt.Color(64, 153, 153));
        Phong8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong8.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong8MouseMoved(evt);
            }
        });
        Phong8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong8MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong8MouseExited(evt);
            }
        });

        maPhong08.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong08.setForeground(new java.awt.Color(255, 255, 255));
        maPhong08.setText("101");

        loaiPhong08.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong08.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong08.setText("VIP");

        trangThai08.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai08.setForeground(new java.awt.Color(255, 255, 255));
        trangThai08.setText("Đang trống");

        soGiuong8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong8.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong8.setText("2");

        jLabel16.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Số giường:");

        javax.swing.GroupLayout Phong8Layout = new javax.swing.GroupLayout(Phong8);
        Phong8.setLayout(Phong8Layout);
        Phong8Layout.setHorizontalGroup(
            Phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong8Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(maPhong08))
            .addGroup(Phong8Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(loaiPhong08))
            .addGroup(Phong8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong8Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong8))
                    .addComponent(trangThai08)))
        );
        Phong8Layout.setVerticalGroup(
            Phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong8Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong08)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong08)
                .addGap(18, 18, 18)
                .addComponent(trangThai08)
                .addGap(18, 18, 18)
                .addGroup(Phong8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(soGiuong8))
                .addContainerGap())
        );

        line2.add(Phong8);

        Phong9.setBackground(new java.awt.Color(64, 153, 153));
        Phong9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong9.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong9MouseMoved(evt);
            }
        });
        Phong9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong9MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong9MouseExited(evt);
            }
        });

        maPhong09.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong09.setForeground(new java.awt.Color(255, 255, 255));
        maPhong09.setText("101");

        loaiPhong09.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong09.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong09.setText("VIP");

        trangThai09.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai09.setForeground(new java.awt.Color(255, 255, 255));
        trangThai09.setText("Đang trống");

        soGiuong9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong9.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong9.setText("2");

        jLabel18.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(255, 255, 255));
        jLabel18.setText("Số giường:");

        javax.swing.GroupLayout Phong9Layout = new javax.swing.GroupLayout(Phong9);
        Phong9.setLayout(Phong9Layout);
        Phong9Layout.setHorizontalGroup(
            Phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong9Layout.createSequentialGroup()
                .addGroup(Phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(Phong9Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(maPhong09))
                    .addGroup(Phong9Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(loaiPhong09))
                    .addGroup(Phong9Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(trangThai09))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong9Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel18)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong9)))
                .addGap(31, 31, 31))
        );
        Phong9Layout.setVerticalGroup(
            Phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong9Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong09)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong09)
                .addGap(18, 18, 18)
                .addComponent(trangThai09)
                .addGap(18, 18, 18)
                .addGroup(Phong9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(soGiuong9))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        line2.add(Phong9);

        Phong10.setBackground(new java.awt.Color(64, 153, 153));
        Phong10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong10.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong10MouseMoved(evt);
            }
        });
        Phong10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong10MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong10MouseExited(evt);
            }
        });

        maPhong10.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong10.setForeground(new java.awt.Color(255, 255, 255));
        maPhong10.setText("101");

        loaiPhong10.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong10.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong10.setText("VIP");

        trangThai10.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai10.setForeground(new java.awt.Color(255, 255, 255));
        trangThai10.setText("Đang trống");

        jLabel19.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setText("Số giường:");

        soGiuong10.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong10.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong10.setText("2");

        javax.swing.GroupLayout Phong10Layout = new javax.swing.GroupLayout(Phong10);
        Phong10.setLayout(Phong10Layout);
        Phong10Layout.setHorizontalGroup(
            Phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong10Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(maPhong10))
            .addGroup(Phong10Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(loaiPhong10))
            .addGroup(Phong10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Phong10Layout.createSequentialGroup()
                        .addComponent(jLabel19)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong10))
                    .addComponent(trangThai10)))
        );
        Phong10Layout.setVerticalGroup(
            Phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong10Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong10)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong10)
                .addGap(18, 18, 18)
                .addComponent(trangThai10)
                .addGap(18, 18, 18)
                .addGroup(Phong10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(soGiuong10))
                .addContainerGap())
        );

        line2.add(Phong10);

        Phong11.setBackground(new java.awt.Color(64, 153, 153));
        Phong11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong11.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong11MouseMoved(evt);
            }
        });
        Phong11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong11MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong11MouseExited(evt);
            }
        });

        maPhong11.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong11.setForeground(new java.awt.Color(255, 255, 255));
        maPhong11.setText("101");

        loaiPhong11.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong11.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong11.setText("VIP");

        trangThai11.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai11.setForeground(new java.awt.Color(255, 255, 255));
        trangThai11.setText("Đang trống");

        jLabel21.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Số giường:");

        soGiuong11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong11.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong11.setText("2");

        javax.swing.GroupLayout Phong11Layout = new javax.swing.GroupLayout(Phong11);
        Phong11.setLayout(Phong11Layout);
        Phong11Layout.setHorizontalGroup(
            Phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong11Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(maPhong11))
            .addGroup(Phong11Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(loaiPhong11))
            .addGroup(Phong11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong11Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong11))
                    .addComponent(trangThai11)))
        );
        Phong11Layout.setVerticalGroup(
            Phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong11Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong11)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong11)
                .addGap(18, 18, 18)
                .addComponent(trangThai11)
                .addGap(18, 18, 18)
                .addGroup(Phong11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(soGiuong11))
                .addContainerGap())
        );

        line2.add(Phong11);

        Phong12.setBackground(new java.awt.Color(64, 153, 153));
        Phong12.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong12.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong12MouseMoved(evt);
            }
        });
        Phong12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong12MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong12MouseExited(evt);
            }
        });

        maPhong12.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong12.setForeground(new java.awt.Color(255, 255, 255));
        maPhong12.setText("101");

        loaiPhong12.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong12.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong12.setText("VIP");

        trangThai12.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai12.setForeground(new java.awt.Color(255, 255, 255));
        trangThai12.setText("Đang trống");

        jLabel23.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setText("Số giường:");

        soGiuong12.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong12.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong12.setText("2");

        javax.swing.GroupLayout Phong12Layout = new javax.swing.GroupLayout(Phong12);
        Phong12.setLayout(Phong12Layout);
        Phong12Layout.setHorizontalGroup(
            Phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong12Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(maPhong12))
            .addGroup(Phong12Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(loaiPhong12))
            .addGroup(Phong12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong12Layout.createSequentialGroup()
                        .addComponent(jLabel23)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong12))
                    .addComponent(trangThai12)))
        );
        Phong12Layout.setVerticalGroup(
            Phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong12Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong12)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong12)
                .addGap(18, 18, 18)
                .addComponent(trangThai12)
                .addGap(18, 18, 18)
                .addGroup(Phong12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(soGiuong12))
                .addContainerGap())
        );

        line2.add(Phong12);

        Phong13.setBackground(new java.awt.Color(64, 153, 153));
        Phong13.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong13.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong13MouseMoved(evt);
            }
        });
        Phong13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong13MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong13MouseExited(evt);
            }
        });

        maPhong13.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong13.setForeground(new java.awt.Color(255, 255, 255));
        maPhong13.setText("101");

        loaiPhong13.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong13.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong13.setText("VIP");

        trangThai13.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai13.setForeground(new java.awt.Color(255, 255, 255));
        trangThai13.setText("Đang trống");

        jLabel25.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setText("Số giường:");

        soGiuong13.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong13.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong13.setText("2");

        javax.swing.GroupLayout Phong13Layout = new javax.swing.GroupLayout(Phong13);
        Phong13.setLayout(Phong13Layout);
        Phong13Layout.setHorizontalGroup(
            Phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong13Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(maPhong13))
            .addGroup(Phong13Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(loaiPhong13))
            .addGroup(Phong13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong13Layout.createSequentialGroup()
                        .addComponent(jLabel25)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong13))
                    .addComponent(trangThai13)))
        );
        Phong13Layout.setVerticalGroup(
            Phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong13Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong13)
                .addGap(6, 6, 6)
                .addComponent(loaiPhong13)
                .addGap(18, 18, 18)
                .addComponent(trangThai13)
                .addGap(18, 18, 18)
                .addGroup(Phong13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel25)
                    .addComponent(soGiuong13))
                .addContainerGap())
        );

        line2.add(Phong13);

        Phong14.setBackground(new java.awt.Color(64, 153, 153));
        Phong14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        Phong14.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                Phong14MouseMoved(evt);
            }
        });
        Phong14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Phong14MouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Phong14MouseExited(evt);
            }
        });

        maPhong14.setFont(new java.awt.Font("Segoe UI", 1, 40)); // NOI18N
        maPhong14.setForeground(new java.awt.Color(255, 255, 255));
        maPhong14.setText("101");

        loaiPhong14.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        loaiPhong14.setForeground(new java.awt.Color(255, 255, 255));
        loaiPhong14.setText("VIP");

        trangThai14.setFont(new java.awt.Font("Segoe UI", 2, 18)); // NOI18N
        trangThai14.setForeground(new java.awt.Color(255, 255, 255));
        trangThai14.setText("Đang trống");

        jLabel27.setFont(new java.awt.Font("Segoe UI", 1, 16)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        jLabel27.setText("Số giường:");

        soGiuong14.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        soGiuong14.setForeground(new java.awt.Color(255, 255, 255));
        soGiuong14.setText("2");

        javax.swing.GroupLayout Phong14Layout = new javax.swing.GroupLayout(Phong14);
        Phong14.setLayout(Phong14Layout);
        Phong14Layout.setHorizontalGroup(
            Phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong14Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(loaiPhong14)
                .addGap(50, 50, 50))
            .addGroup(Phong14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(Phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Phong14Layout.createSequentialGroup()
                        .addComponent(jLabel27)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(soGiuong14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong14Layout.createSequentialGroup()
                        .addComponent(trangThai14)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Phong14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addComponent(maPhong14)
                        .addGap(34, 34, 34))))
        );
        Phong14Layout.setVerticalGroup(
            Phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Phong14Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(maPhong14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loaiPhong14)
                .addGap(18, 18, 18)
                .addComponent(trangThai14)
                .addGap(18, 18, 18)
                .addGroup(Phong14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel27)
                    .addComponent(soGiuong14))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        line2.add(Phong14);

        jLabel238.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel238.setForeground(new java.awt.Color(10, 125, 125));
        jLabel238.setText("ĐÔI:");

        PhongDoiTrong.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        PhongDoiTrong.setForeground(new java.awt.Color(10, 125, 125));
        PhongDoiTrong.setText("20");

        dangDon.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        dangDon.setForeground(new java.awt.Color(0, 153, 153));
        dangDon.setText("20");

        jLabel231.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel231.setForeground(new java.awt.Color(0, 153, 153));
        jLabel231.setText("Đang dọn:");

        jLabel222.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel222.setForeground(new java.awt.Color(0, 153, 153));
        jLabel222.setText("ĐANG DỌN");

        jPanel84.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout jPanel84Layout = new javax.swing.GroupLayout(jPanel84);
        jPanel84.setLayout(jPanel84Layout);
        jPanel84Layout.setHorizontalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );
        jPanel84Layout.setVerticalGroup(
            jPanel84Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout DatPhongLayout = new javax.swing.GroupLayout(DatPhong);
        DatPhong.setLayout(DatPhongLayout);
        DatPhongLayout.setHorizontalGroup(
            DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatPhongLayout.createSequentialGroup()
                .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatPhongLayout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(DatPhongLayout.createSequentialGroup()
                                .addGap(140, 140, 140)
                                .addComponent(jLabel224)
                                .addGap(10, 10, 10)
                                .addComponent(tongSoPhongTrong)
                                .addGap(150, 150, 150)
                                .addComponent(jLabel230)
                                .addGap(20, 20, 20)
                                .addComponent(khachDangThue)
                                .addGap(170, 170, 170)
                                .addComponent(jLabel231)
                                .addGap(11, 11, 11)
                                .addComponent(dangDon))
                            .addGroup(DatPhongLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(jLabel232)
                                .addGap(103, 103, 103)
                                .addComponent(jLabel236)
                                .addGap(4, 4, 4)
                                .addComponent(PhongDonTrong)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel238)
                                .addGap(2, 2, 2)
                                .addComponent(PhongDoiTrong)
                                .addGap(70, 70, 70)
                                .addComponent(jLabel234)
                                .addGap(6, 6, 6)
                                .addComponent(PhongVIPTrong)
                                .addGap(140, 140, 140)
                                .addComponent(cbTang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(DatPhongLayout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel81, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel220)
                        .addGap(62, 62, 62)
                        .addComponent(jPanel83, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel221)
                        .addGap(66, 66, 66)
                        .addComponent(jPanel84, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(jLabel222)
                        .addGap(295, 295, 295)
                        .addComponent(cbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(66, 66, 66))
        );
        DatPhongLayout.setVerticalGroup(
            DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DatPhongLayout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel220, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
                    .addGroup(DatPhongLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel222))
                    .addComponent(jPanel84, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel83, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel221, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel81, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cbTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(DatPhongLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel232)
                            .addComponent(jLabel236)
                            .addComponent(PhongDonTrong)
                            .addComponent(jLabel238)
                            .addComponent(PhongDoiTrong)
                            .addComponent(jLabel234)
                            .addComponent(PhongVIPTrong))))
                .addGap(45, 45, 45)
                .addComponent(line1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(line2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(DatPhongLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel224, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tongSoPhongTrong)
                    .addComponent(jLabel230)
                    .addComponent(khachDangThue)
                    .addComponent(jLabel231)
                    .addComponent(dangDon))
                .addGap(31, 31, 31))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DatPhong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(DatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Phong14MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong14MouseExited
        Color c = Phong14.getBackground();
        Phong14.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong14MouseExited

    private void Phong14MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong14MouseMoved
        Color c = Phong14.getBackground();
        Phong14.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong14MouseMoved

    private void Phong13MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong13MouseExited
        Color c = Phong13.getBackground();
        Phong13.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong13MouseExited

    private void Phong13MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong13MouseMoved
        Color c = Phong13.getBackground();
        Phong13.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong13MouseMoved

    private void Phong12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong12MouseExited
        Color c = Phong12.getBackground();
        Phong12.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong12MouseExited

    private void Phong12MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong12MouseMoved
        Color c = Phong12.getBackground();
        Phong12.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong12MouseMoved

    private void Phong11MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong11MouseExited
        Color c = Phong11.getBackground();
        Phong11.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong11MouseExited

    private void Phong11MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong11MouseMoved
        Color c = Phong11.getBackground();
        Phong11.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong11MouseMoved

    private void Phong10MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong10MouseExited
        Color c = Phong10.getBackground();
        Phong10.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong10MouseExited

    private void Phong10MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong10MouseMoved
        Color c = Phong10.getBackground();
        Phong10.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong10MouseMoved

    private void Phong9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong9MouseExited
        Color c = Phong9.getBackground();
        Phong9.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong9MouseExited

    private void Phong9MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong9MouseMoved
        Color c = Phong9.getBackground();
        Phong9.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong9MouseMoved

    private void Phong8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong8MouseExited
        Color c = Phong8.getBackground();
        Phong8.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong8MouseExited

    private void Phong8MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong8MouseMoved
        Color c = Phong8.getBackground();
        Phong8.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong8MouseMoved

    private void Phong7MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong7MouseExited
        Color c = Phong7.getBackground();
        Phong7.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong7MouseExited

    private void Phong7MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong7MouseMoved
        Color c = Phong7.getBackground();
        Phong7.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong7MouseMoved

    private void Phong6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong6MouseExited
        Color c = Phong6.getBackground();
        Phong6.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong6MouseExited

    private void Phong6MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong6MouseMoved
        Color c = Phong6.getBackground();
        Phong6.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong6MouseMoved

    private void Phong5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong5MouseExited
        Color c = Phong5.getBackground();
        Phong5.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong5MouseExited

    private void Phong5MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong5MouseMoved
        Color c = Phong5.getBackground();
        Phong5.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong5MouseMoved

    private void Phong4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong4MouseExited
        Color c = Phong4.getBackground();
        Phong4.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong4MouseExited

    private void Phong4MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong4MouseMoved
        Color c = Phong4.getBackground();
        Phong4.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong4MouseMoved

    private void Phong3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong3MouseExited
        Color c = Phong3.getBackground();
        Phong3.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong3MouseExited

    private void Phong3MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong3MouseMoved
        Color c = Phong3.getBackground();
        Phong3.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong3MouseMoved

    private void Phong2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong2MouseExited
        Color c = Phong2.getBackground();
        Phong2.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong2MouseExited

    private void Phong2MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong2MouseMoved
        Color c = Phong2.getBackground();
        Phong2.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong2MouseMoved

    private void Phong1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong1MouseExited
        Color c = Phong1.getBackground();
        Phong1.setBackground(MouseItemEXITED(c));
    }//GEN-LAST:event_Phong1MouseExited

    private Color MouseItemMOVE(Color c){
        if(c == mauPhongTrong){
            return mauPhongTrongMOVE;
        }else if(c == mauPhongCoKhach){
            return mauPhongCoKhachMOVE;
        }else if(c == mauPhongDangDon){
            return mauPhongDangDonMOVE;
        }else if(c == mauPhongTrongMOVE){
            return mauPhongTrongMOVE;
        }else if(c == mauPhongCoKhachMOVE){
            return mauPhongCoKhachMOVE;
        }else if(c == mauPhongDangDonMOVE){
            return mauPhongDangDonMOVE;
        }
        return null;
    }
    private Color MouseItemEXITED(Color c){
        if(c == mauPhongTrongMOVE){
            return mauPhongTrong;
        }else if(c == mauPhongCoKhachMOVE){
            return mauPhongCoKhach;
        }else if(c == mauPhongDangDonMOVE){
            return mauPhongDangDon;
        }else if(c == mauPhongTrong){
            return mauPhongTrong;
        }else if(c == mauPhongCoKhach){
            return mauPhongCoKhach;
        }else if(c == mauPhongDangDon){
            return mauPhongDangDon;
        }
        return null;
    }
    private boolean kiemTraTinhTrangPhong(int maPhong){
        bus.docDatPhong();
        for (PhongDTO dp : PhongBUS.dsPhong) { 
            if(dp.getMaPhong()==maPhong && dp.getTinhTrang()==3){
                return false;
            }
        }
        return true;
    }
    private void Phong1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong1MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong01.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong01.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong1MouseClicked

    private void Phong1MouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong1MouseMoved
        Color c = Phong1.getBackground();
        Phong1.setBackground(MouseItemMOVE(c));
    }//GEN-LAST:event_Phong1MouseMoved

    private void cbTangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTangActionPerformed
        TRANG = 1;
        TANG = 1;
        checkTangAndTrang();
        showThongTin(14*TRANG+1, TANG);
    }//GEN-LAST:event_cbTangActionPerformed

    private void cbTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbTrangActionPerformed
        TRANG = 1;
        TANG = 1;
        checkTangAndTrang();
        showThongTin(14*TRANG+1, TANG);
    }//GEN-LAST:event_cbTrangActionPerformed

    private void Phong2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong2MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong02.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong02.getText()), username, 1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong2MouseClicked

    private void Phong3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong3MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong03.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong03.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong3MouseClicked

    private void Phong4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong4MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong04.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong04.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong4MouseClicked

    private void Phong5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong5MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong05.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong05.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong5MouseClicked

    private void Phong6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong6MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong06.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong06.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong6MouseClicked

    private void Phong7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong7MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong07.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong07.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong7MouseClicked

    private void Phong8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong8MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong08.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong08.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong8MouseClicked

    private void Phong9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong9MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong09.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong09.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong9MouseClicked

    private void Phong10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong10MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong10.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong10.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong10MouseClicked

    private void Phong11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong11MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong11.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong11.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong11MouseClicked

    private void Phong12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong12MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong12.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong12.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong12MouseClicked

    private void Phong13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong13MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong13.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong13.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong13MouseClicked

    private void Phong14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Phong14MouseClicked
        if(kiemTraTinhTrangPhong(Integer.parseInt(maPhong14.getText()))){
            try {
                PhieuThue pt = new PhieuThue(Integer.parseInt(maPhong14.getText()), username,1);
                pt.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                pt.setLocationRelativeTo(null);
                pt.setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(Phong2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            JOptionPane.showMessageDialog(this, "Phòng đang dọn");
        }
    }//GEN-LAST:event_Phong14MouseClicked
 
    
    private void checkTangAndTrang(){ // tầng và trang (MAIN)
        if(cbTrang.getSelectedItem()=="Trang 1"){        
            TRANG = 0;
        }else if (cbTrang.getSelectedItem()=="Trang 2"){
            TRANG = 1;
        }else if (cbTrang.getSelectedItem()=="Trang 3"){
            TRANG = 2;
        }else if (cbTrang.getSelectedItem()=="Trang 4"){
            TRANG = 3;
        }else if (cbTrang.getSelectedItem()=="Trang 5"){
            TRANG = 4;
        }else if (cbTrang.getSelectedItem()=="Trang 6"){
            TRANG = 5;
        }else if (cbTrang.getSelectedItem()=="Trang 7"){
            TRANG = 6;
        }
        ////////
        if(cbTang.getSelectedItem()=="TẦNG 1"){        
            TANG = 1;
        }else if (cbTang.getSelectedItem()=="TẦNG 2"){
            TANG = 2;
        }else if (cbTang.getSelectedItem()=="TẦNG 3"){
            TANG = 3;
        }else if (cbTang.getSelectedItem()=="TẦNG 4"){
            TANG = 4;
        }else if (cbTang.getSelectedItem()=="TẦNG 5"){
            TANG = 5;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DatPhong;
    private javax.swing.JPanel Phong1;
    private javax.swing.JPanel Phong10;
    private javax.swing.JPanel Phong11;
    private javax.swing.JPanel Phong12;
    private javax.swing.JPanel Phong13;
    private javax.swing.JPanel Phong14;
    private javax.swing.JPanel Phong2;
    private javax.swing.JPanel Phong3;
    private javax.swing.JPanel Phong4;
    private javax.swing.JPanel Phong5;
    private javax.swing.JPanel Phong6;
    private javax.swing.JPanel Phong7;
    private javax.swing.JPanel Phong8;
    private javax.swing.JPanel Phong9;
    private javax.swing.JLabel PhongDoiTrong;
    private javax.swing.JLabel PhongDonTrong;
    private javax.swing.JLabel PhongVIPTrong;
    private javax.swing.JComboBox<String> cbTang;
    private javax.swing.JComboBox<String> cbTrang;
    private javax.swing.JLabel dangDon;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel220;
    private javax.swing.JLabel jLabel221;
    private javax.swing.JLabel jLabel222;
    private javax.swing.JLabel jLabel224;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel230;
    private javax.swing.JLabel jLabel231;
    private javax.swing.JLabel jLabel232;
    private javax.swing.JLabel jLabel234;
    private javax.swing.JLabel jLabel236;
    private javax.swing.JLabel jLabel238;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel81;
    private javax.swing.JPanel jPanel83;
    private javax.swing.JPanel jPanel84;
    private javax.swing.JLabel khachDangThue;
    private javax.swing.JPanel line1;
    private javax.swing.JPanel line2;
    private javax.swing.JLabel loaiPhong01;
    private javax.swing.JLabel loaiPhong02;
    private javax.swing.JLabel loaiPhong03;
    private javax.swing.JLabel loaiPhong04;
    private javax.swing.JLabel loaiPhong05;
    private javax.swing.JLabel loaiPhong06;
    private javax.swing.JLabel loaiPhong07;
    private javax.swing.JLabel loaiPhong08;
    private javax.swing.JLabel loaiPhong09;
    private javax.swing.JLabel loaiPhong10;
    private javax.swing.JLabel loaiPhong11;
    private javax.swing.JLabel loaiPhong12;
    private javax.swing.JLabel loaiPhong13;
    private javax.swing.JLabel loaiPhong14;
    private javax.swing.JLabel maPhong01;
    private javax.swing.JLabel maPhong02;
    private javax.swing.JLabel maPhong03;
    private javax.swing.JLabel maPhong04;
    private javax.swing.JLabel maPhong05;
    private javax.swing.JLabel maPhong06;
    private javax.swing.JLabel maPhong07;
    private javax.swing.JLabel maPhong08;
    private javax.swing.JLabel maPhong09;
    private javax.swing.JLabel maPhong10;
    private javax.swing.JLabel maPhong11;
    private javax.swing.JLabel maPhong12;
    private javax.swing.JLabel maPhong13;
    private javax.swing.JLabel maPhong14;
    private javax.swing.JLabel soGiuong1;
    private javax.swing.JLabel soGiuong10;
    private javax.swing.JLabel soGiuong11;
    private javax.swing.JLabel soGiuong12;
    private javax.swing.JLabel soGiuong13;
    private javax.swing.JLabel soGiuong14;
    private javax.swing.JLabel soGiuong2;
    private javax.swing.JLabel soGiuong3;
    private javax.swing.JLabel soGiuong4;
    private javax.swing.JLabel soGiuong5;
    private javax.swing.JLabel soGiuong6;
    private javax.swing.JLabel soGiuong7;
    private javax.swing.JLabel soGiuong8;
    private javax.swing.JLabel soGiuong9;
    private javax.swing.JLabel tongSoPhongTrong;
    private javax.swing.JLabel trangThai01;
    private javax.swing.JLabel trangThai02;
    private javax.swing.JLabel trangThai03;
    private javax.swing.JLabel trangThai04;
    private javax.swing.JLabel trangThai05;
    private javax.swing.JLabel trangThai06;
    private javax.swing.JLabel trangThai07;
    private javax.swing.JLabel trangThai08;
    private javax.swing.JLabel trangThai09;
    private javax.swing.JLabel trangThai10;
    private javax.swing.JLabel trangThai11;
    private javax.swing.JLabel trangThai12;
    private javax.swing.JLabel trangThai13;
    private javax.swing.JLabel trangThai14;
    // End of variables declaration//GEN-END:variables
}
