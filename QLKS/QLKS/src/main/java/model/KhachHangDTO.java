package model;

import java.util.Date;

public class KhachHangDTO {
    private int maKH;
    private String hoTen;
    private String CCCD;
    private String diaChi;
    private String soDienThoai;
    private Date ngaySinh;
    private String gioiTinh;

    public KhachHangDTO() {
        super();
    }

    public KhachHangDTO(int maKH, String hoTen, String CCCD, String diaChi, String soDienThoai, Date ngaySinh, String gioiTinh) {
        super();
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.CCCD = CCCD;
        this.diaChi = diaChi;
        this.soDienThoai = soDienThoai;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public int getMaKH() {
        return maKH;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
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

    @Override
    public String toString() {
        return "KhachHangDTO{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", CCCD=" + CCCD + ", diaChi=" + diaChi + ", soDienThoai=" + soDienThoai + ", ngaySinh=" + ngaySinh + ", gioiTinh=" + gioiTinh + '}';
    }
}
