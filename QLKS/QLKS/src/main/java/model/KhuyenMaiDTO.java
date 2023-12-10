package model;

import java.util.Date;

public class KhuyenMaiDTO {
    private int maKM;
    private String tenKM;
    private int phanTramKM;
    private Date ngayBD;
    private Date ngayKT;
    private int trangThai;
    private float donToiThieu;
    private float giamToiDa;      

    public KhuyenMaiDTO() {
        super();
    }

    public KhuyenMaiDTO(int maKM, String tenKM, int phanTramKM, Date ngayBD, Date ngayKT, int trangThai, float donToiThieu, float giamToiDa) {
        super();
        this.maKM = maKM;
        this.tenKM = tenKM;
        this.phanTramKM = phanTramKM;
        this.ngayBD = ngayBD;
        this.ngayKT = ngayKT;
        this.trangThai = trangThai;
        this.donToiThieu = donToiThieu;
        this.giamToiDa = giamToiDa;
    }

    public int getMaKM() {
        return maKM;
    }

    public void setMaKM(int maKM) {
        this.maKM = maKM;
    }

    public String getTenKM() {
        return tenKM;
    }

    public void setTenKM(String tenKM) {
        this.tenKM = tenKM;
    }

    public int getPhanTramKM() {
        return phanTramKM;
    }

    public void setPhanTramKM(int phanTramKM) {
        this.phanTramKM = phanTramKM;
    }

    public Date getNgayBD() {
        return ngayBD;
    }

    public void setNgayBD(Date ngayBD) {
        this.ngayBD = ngayBD;
    }

    public Date getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(Date ngayKT) {
        this.ngayKT = ngayKT;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public float getDonToiThieu() {
        return donToiThieu;
    }

    public void setDonToiThieu(float donToiThieu) {
        this.donToiThieu = donToiThieu;
    }

    public float getGiamToiDa() {
        return giamToiDa;
    }

    public void setGiamToiDa(float giamToiDa) {
        this.giamToiDa = giamToiDa;
    }
}
