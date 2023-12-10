package model;

public class PhongDTO {
    public int MaPhong;
    public int SoGiuong;
    public String LoaiPhong;
    public float GiaTheoNgay;
    public float GiaTheoGio;
    public int TinhTrang;

    public PhongDTO() {
        super();
    }

    public PhongDTO(int MaPhong, int SoGiuong, String LoaiPhong, float GiaTheoNgay, float GiaTheoGio, int TinhTrang) {
        super();
        this.MaPhong = MaPhong;
        this.SoGiuong = SoGiuong;
        this.LoaiPhong = LoaiPhong;
        this.GiaTheoNgay = GiaTheoNgay;
        this.GiaTheoGio = GiaTheoGio;
        this.TinhTrang = TinhTrang;
    }

    public int getMaPhong() {
        return MaPhong;
    }

    public void setMaPhong(int MaPhong) {
        this.MaPhong = MaPhong;
    }

    public int getSoGiuong() {
        return SoGiuong;
    }

    public void setSoGiuong(int SoGiuong) {
        this.SoGiuong = SoGiuong;
    }

    public String getLoaiPhong() {
        return LoaiPhong;
    }

    public void setLoaiPhong(String LoaiPhong) {
        this.LoaiPhong = LoaiPhong;
    }

    public float getGiaTheoNgay() {
        return GiaTheoNgay;
    }

    public void setGiaTheoNgay(float GiaTheoNgay) {
        this.GiaTheoNgay = GiaTheoNgay;
    }

    public float getGiaTheoGio() {
        return GiaTheoGio;
    }

    public void setGiaTheoGio(float GiaTheoGio) {
        this.GiaTheoGio = GiaTheoGio;
    }

    public int getTinhTrang() {
        return TinhTrang;
    }

    public void setTinhTrang(int TinhTrang) {
        this.TinhTrang = TinhTrang;
    }

    @Override
    public String toString() {
        return "PhongDTO{" + "MaPhong=" + MaPhong + ", SoGiuong=" + SoGiuong + ", LoaiPhong=" + LoaiPhong + ", GiaTheoNgay=" + GiaTheoNgay + ", GiaTheoGio=" + GiaTheoGio + ", TinhTrang=" + TinhTrang + '}';
    }
}
