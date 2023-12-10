package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import model.PhieuSuDungDichVuDTO;
import model.topDVBanChayDTO;

public class PhieuSuDungDichVuDAO {
    public static PhieuSuDungDichVuDAO getInstance(){
            return new PhieuSuDungDichVuDAO();
    }
    public ArrayList<PhieuSuDungDichVuDTO> selectAll() {
		ArrayList<PhieuSuDungDichVuDTO> ketQua = new ArrayList<PhieuSuDungDichVuDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from phieusudungdv";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int maPhieuSDDV = rs.getInt("MaPSDDV");
				int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
                                int maDV = rs.getInt("MaDV");
                                int soLuong = rs.getInt("SoLuong");
                                Timestamp thoiGianSDDV = rs.getTimestamp("ThoiGianSDDV");
                                int tinhTrang = rs.getInt("TinhTrang");
				PhieuSuDungDichVuDTO p = new PhieuSuDungDichVuDTO(maPhieuSDDV, maKH, maPhong, maDV, soLuong, thoiGianSDDV, tinhTrang);
				ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int insert(PhieuSuDungDichVuDTO phieusddv) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into phieusudungdv(MaKH, MaPhong, MaDV, SoLuong, ThoiGianSDDV, TinhTrang) value(?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
			statement.setInt(1, phieusddv.getMaKH());
                        statement.setInt(2, phieusddv.getMaPhong());
                        statement.setInt(3, phieusddv.getMaDV());
                        statement.setInt(4, phieusddv.getSoLuong());
                        statement.setTimestamp(5,phieusddv.getThoiGianSDDV());
                        statement.setInt(6,phieusddv.getTinhTrang());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int update(PhieuSuDungDichVuDTO phieusddv) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update phieusudungdv set MaKH=?,MaPhong=?,MaDV=?, SoLuong=?, ThoiGianSDDV=? TinhTrang =? WHERE MaPSDDV=?";
			PreparedStatement statement = con.prepareCall(sql);
			statement.setInt(1, phieusddv.getMaKH());
                        statement.setInt(2, phieusddv.getMaPhong());
                        statement.setInt(3, phieusddv.getMaDV());
                        statement.setInt(4, phieusddv.getSoLuong());
                        statement.setTimestamp(5,phieusddv.getThoiGianSDDV());
                        statement.setInt(6,phieusddv.getTinhTrang());
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int delete(int phieuSDDV) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "delete from phieusudungdv where MaPSDDV= "+phieuSDDV;
			PreparedStatement pst = con.prepareStatement(sql);
			ketQua = pst.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public ArrayList<topDVBanChayDTO> getTopDVBanChay(){
            ArrayList<topDVBanChayDTO> ketQua = new ArrayList<topDVBanChayDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = """
                                     SELECT DISTINCT MaPhong, MaDV, SL
                                     FROM (
                                         SELECT MaPhong, MaDV, SUM(SoLuong) AS SL
                                         FROM phieusudungdv
                                         GROUP BY MaPhong, MaDV
                                     ) temp
                                     ORDER BY SL DESC
                                     LIMIT 5;""";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int maPhong = rs.getInt("MaPhong");
                                int maDV = rs.getInt("MaDV");
                                int SL = rs.getInt("SL");
				topDVBanChayDTO p = new topDVBanChayDTO(maPhong,maDV,SL);
				ketQua.add(p);		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    
}
