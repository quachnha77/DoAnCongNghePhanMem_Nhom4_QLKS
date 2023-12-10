package model;

import java.util.Date;

public class HoaDonDTO {
    private int maHD;
    private int maNV;
    private int maKH;
    private float soTienKM;
    private float tienDV;
    private float tongTien;
    private Date ngayGD;

    public HoaDonDTO() {
        super();
    }

    
    public HoaDonDTO(int maHD, int maNV, int maKH, float soTienKM, float tienDV, float tongTien, Date ngayGD) {
        super();
        this.maHD = maHD;
        this.maNV = maNV;
        this.maKH = maKH;
        this.soTienKM = soTienKM;
        this.tienDV = tienDV;
        this.tongTien = tongTien;
        this.ngayGD = ngayGD;
    }

    public int getMaHD() {
        return maHD;
    }

    public void setMaHD(int maHD) {
        this.maHD = maHD;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public float getSoTienKM() {
        return soTienKM;
    }

    public void setSoTienKM(float soTienKM) {
        this.soTienKM = soTienKM;
    }

    public float getTienDV() {
        return tienDV;
    }

    public void setTienDV(float tienDV) {
        this.tienDV = tienDV;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public Date getNgayGD() {
        return ngayGD;
    }

    public void setNgayGD(Date ngayGD) {
        this.ngayGD = ngayGD;
    }
    
    
    
    
}
