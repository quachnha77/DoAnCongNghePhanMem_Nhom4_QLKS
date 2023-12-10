package model;

public class TaiKhoanDTO {
    private int maNV;
    private String taiKhoan;
    private String matKhau;
    private String quyenTK;
    private String tinhTrang;

    public TaiKhoanDTO() {
        super();
    }

    public TaiKhoanDTO(int maNV, String taiKhoan, String matKhau, String quyenTK, String tinhTrang) {
        super();
        this.maNV = maNV;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.quyenTK = quyenTK;
        this.tinhTrang = tinhTrang;
    }

    public int getMaNV() {
        return maNV;
    }

    public void setMaNV(int maNV) {
        this.maNV = maNV;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getQuyenTK() {
        return quyenTK;
    }

    public void setQuyenTK(String quyenTK) {
        this.quyenTK = quyenTK;
    }

    public String getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(String tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    
}
