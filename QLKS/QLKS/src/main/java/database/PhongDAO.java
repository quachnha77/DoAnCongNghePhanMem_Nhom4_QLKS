package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import model.PhongDTO;

public class PhongDAO {
    public static PhongDAO getInstance(){
            return new PhongDAO();
    }
    public ArrayList<PhongDTO> selectAll() {
		ArrayList<PhongDTO> ketQua = new ArrayList<PhongDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from phong";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int maPhong = rs.getInt("MaPhong");
				int soGiuong = rs.getInt("SoGiuong");
				String loaiPhong = rs.getString("LoaiPhong"); 
                                float GiaTheoNgay = rs.getFloat("GiaTheoNgay");
                                float GiaTheoGio = rs.getFloat("GiaTheoGio");
                                int tinhTrang = rs.getInt("TinhTrang"); 
				PhongDTO p = new PhongDTO(maPhong, soGiuong, loaiPhong, GiaTheoNgay, GiaTheoGio, tinhTrang);
				ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    public int capNhatTinhTrangPhong(int maPhong, int tinhTrang) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update phong set TinhTrang=? WHERE MaPhong=?";
			PreparedStatement statement = con.prepareCall(sql);
			statement.setInt(1, tinhTrang);
                        statement.setInt(2, maPhong);
			statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int insert(PhongDTO ph) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into phong(MaPhong ,SoGiuong, LoaiPhong, GiaTheoNgay, GiaTheoGio, TinhTrang) value(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, ph.getMaPhong());
			statement.setInt(2, ph.getSoGiuong());
                        statement.setString(3, ph.getLoaiPhong());
                        statement.setFloat(4, ph.getGiaTheoNgay());
                        statement.setFloat(5, ph.getGiaTheoGio());
                        statement.setInt(6,ph.getTinhTrang());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    } 
    public int update(PhongDTO ph, int maPhong) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update phong set MaPhong=?, SoGiuong=?, LoaiPhong=?, GiaTheoNgay=?, GiaTheoGio=?, TinhTrang=?  where MaPhong=?";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, ph.getMaPhong());
			statement.setInt(2, ph.getSoGiuong());
                        statement.setString(3, ph.getLoaiPhong());
                        statement.setFloat(4, ph.getGiaTheoNgay());
                        statement.setFloat(5, ph.getGiaTheoGio());
                        statement.setInt(6,ph.getTinhTrang());
                        statement.setInt(7, ph.getMaPhong());
//                        ketQua = statement.executeUpdate();
                        statement.executeUpdate();
                        statement.close();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
       
	public int delete(int maPhong) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "delete from phong where MaPhong="+maPhong;
			PreparedStatement pst = con.prepareStatement(sql);
			ketQua = pst.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    
}
