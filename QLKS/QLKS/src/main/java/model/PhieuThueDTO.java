package model;

import java.util.Date;
import java.sql.Time;

public class PhieuThueDTO {
    private int maPT;
    private int maNV;
    private int maKH;
    private int maPhong;
    private int hinhThucThue;
    private Date ngayDen;
    private Time gioDen;
    private Date ngayTra;
    private Time gioTra;
    private int tinhTrang;

    public PhieuThueDTO() {
        super();
    }

    public PhieuThueDTO(int maPT, int maNV, int maKH, int maPhong, int hinhThucThue, Date ngayDen, Time gioDen, Date ngayTra, Time gioTra, int tinhTrang) {
        super();
        this.maPT = maPT;
        this.maNV = maNV;
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.hinhThucThue = hinhThucThue;
        this.ngayDen = ngayDen;
        this.gioDen = gioDen;
        this.ngayTra = ngayTra;
        this.gioTra = gioTra;
        this.tinhTrang = tinhTrang;
    }

    public int getMaPT() {
        return maPT;
    }

    public void setMaPT(int maPT) {
        this.maPT = maPT;
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

    public int getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(int maPhong) {
        this.maPhong = maPhong;
    }

    public int getHinhThucThue() {
        return hinhThucThue;
    }

    public void setHinhThucThue(int hinhThucThue) {
        this.hinhThucThue = hinhThucThue;
    }

    public Date getNgayDen() {
        return ngayDen;
    }

    public void setNgayDen(Date ngayDen) {
        this.ngayDen = ngayDen;
    }

    public Time getGioDen() {
        return gioDen;
    }

    public void setGioDen(Time gioDen) {
        this.gioDen = gioDen;
    }

    public Date getNgayTra() {
        return ngayTra;
    }

    public void setNgayTra(Date ngayTra) {
        this.ngayTra = ngayTra;
    }

    public Time getGioTra() {
        return gioTra;
    }

    public void setGioTra(Time gioTra) {
        this.gioTra = gioTra;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}  
