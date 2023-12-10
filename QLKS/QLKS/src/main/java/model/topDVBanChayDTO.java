package model;
public class topDVBanChayDTO {
    private int MaPhong;
    private int MaDV;
    private int SoLuong;

    public topDVBanChayDTO(int maPhong, int maDv, int soLuong) {
        this.MaPhong = maPhong;
        this.MaDV = maDv;
        this.SoLuong = soLuong;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int maPhong) {
        this.MaPhong = maPhong;
    }

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int maDv) {
        this.MaDV = maDv;
}

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        this.SoLuong = soLuong;
    }
 
    
    
}
