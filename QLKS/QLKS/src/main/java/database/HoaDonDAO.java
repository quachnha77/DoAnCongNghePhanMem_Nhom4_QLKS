package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.HoaDonDTO;

public class HoaDonDAO {
    public static HoaDonDAO getInstance(){
            return new HoaDonDAO();
    }
    public ArrayList<HoaDonDTO> selectAll() throws SQLException {
		ArrayList<HoaDonDTO> ketQua = new ArrayList<HoaDonDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from hoadon";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maHD = rs.getInt("MaHD");
                            int maNV = rs.getInt("MaNV");
                            int maKH = rs.getInt("MaKH");
                            float soTienKM = rs.getFloat("SoTienKM");
                            float tienDV = rs.getInt("TienDV");
                            float tongTien = rs.getInt("TongTien");
                            Date thoiGianGD = rs.getDate("ThoiGianGD");
                            HoaDonDTO p = new HoaDonDTO(maHD,maNV, maKH, soTienKM, tienDV, tongTien, thoiGianGD);
                            ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    
    public int themHoaDon(HoaDonDTO hd)
    {   
        int kq =0;
        try {
            String sql = "INSERT INTO hoadon(MaNV, MaKH, SoTienKM, TienDV, TongTien, ThoiGianGD)" + "VALUES (?,?,?,?,?,?) ";
            Connection con = KetNoiDB.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,hd.getMaNV());
            pre.setInt(2,hd.getMaKH());
            pre.setFloat(3,hd.getSoTienKM());
            pre.setFloat(4,hd.getTienDV());
            pre.setFloat(5,hd.getTongTien());
            pre.setDate(6,(java.sql.Date) hd.getNgayGD());
            
            kq = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+kq);
            KetNoiDB.closeConnection(con);
        } catch (Exception e) {}
        return kq;
    }
}
