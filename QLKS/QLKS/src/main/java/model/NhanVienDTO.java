package model;

import java.util.Date;

public class NhanVienDTO {
    private int maNV;
    private String hoTen;
    private String CCCD;
    private String diaChi;
    private String soDienThoai;
    private Date ngaySinh;
    private String gioiTinh;

    public NhanVienDTO() {
        super();
    }

    public NhanVienDTO(int maNV, String hoTen, String CCCD, String diaChi, String soDienThoai, Date ngaySinh, String gioiTinh) {
        super();
        this.maNV = maNV;
        this.hoTen = hoTen;
        this.CCCD = CCCD;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getCCCD() {
        return CCCD;
    }

    public void setCCCD(String CCCD) {
        this.CCCD = CCCD;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }
}
