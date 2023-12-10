package model;
public class DichVuDTO {
    public int maDV;
    public String tenDV;
    public float giaDV;
    public int tinhTrangDV;

    public DichVuDTO() {
        super();
    }

    public DichVuDTO(int maDV, String tenDV, float giaDV, int tinhTrangDV) {
        super();
        this.maDV = maDV;
        this.tenDV = tenDV;
        this.giaDV = giaDV;
        this.tinhTrangDV = tinhTrangDV;
    }

    public int getMaDV() {
        return maDV;
    }

    public void setMaDV(int maDV) {
        this.maDV = maDV;
    }

    public String getTenDV() {
        return tenDV;
    }

    public void setTenDV(String tenDV) {
        this.tenDV = tenDV;
    }

    public float getGiaDV() {
        return giaDV;
    }

    public void setGiaDV(float giaDV) {
        this.giaDV = giaDV;
    }

    public int getTinhTrangDV() {
        return tinhTrangDV;
    }

    public void setTinhTrangDV(int tinhTrangDV) {
        this.tinhTrangDV = tinhTrangDV;
    }
    
}
