package model;

import java.sql.Timestamp;
import java.util.Date;

public class PhieuSuDungDichVuDTO {
    private int maPSDDV;
    private int maKH;
    private int maPhong;
    private int maDV;
    private int soLuong;
    private Timestamp thoiGianSDDV;
    private int tinhTrang;

    public PhieuSuDungDichVuDTO() {
        super();
    }

    public PhieuSuDungDichVuDTO(int maPSDDV, int maKH, int maPhong, int maDV, int soLuong, Timestamp thoiGianSDDV, int tinhTrang) {
        super();
        this.maPSDDV = maPSDDV;
        this.maKH = maKH;
        this.maPhong = maPhong;
        this.maDV = maDV;
        this.soLuong = soLuong;
        this.thoiGianSDDV = thoiGianSDDV;
        this.tinhTrang = tinhTrang;
    }

    public int getMaPSDDV() {
        return maPSDDV;
    }

    public void setMaPSDDV(int maPSDDV) {
        this.maPSDDV = maPSDDV;
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

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Timestamp getThoiGianSDDV() {
        return thoiGianSDDV;
    }

    public void setThoiGianSDDV(Timestamp thoiGianSDDV) {
        this.thoiGianSDDV = thoiGianSDDV;
    }

    public int getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(int tinhTrang) {
        this.tinhTrang = tinhTrang;
    }  
}

