package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Time;
import model.PhieuThueDTO;

public class PhieuThueDAO {
    public static PhieuThueDAO getInstance(){
            return new PhieuThueDAO();
    }
    public ArrayList<PhieuThueDTO> selectAll() throws SQLException{
		ArrayList<PhieuThueDTO> ketQua = new ArrayList<PhieuThueDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from phieuthue";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                                int maPT = rs.getInt("MaPT");
                                int maNV = rs.getInt("MaNV");
                                int maKH = rs.getInt("MaKH");
				int maPhong = rs.getInt("MaPhong");
				int hinhThucThue = rs.getInt("HinhThucThue"); 
                                Date ngayDen = rs.getDate("NgayDen");
                                Time gioDen = rs.getTime("GioDen");
                                Date ngayTra = rs.getDate("NgayTra"); 
                                Time gioTra = rs.getTime("GioTra");
                                int tinhTrang = rs.getInt("TinhTrang");
				PhieuThueDTO p = new PhieuThueDTO(maPT, maNV, maKH, maPhong, hinhThucThue, ngayDen, gioDen, ngayTra, gioTra,tinhTrang);
				ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
    public int insert(PhieuThueDTO ctpt) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into phieuthue(MaPT, MaNV, MaKH, MaPhong, HinhThucThue, NgayDen, GioDen, NgayTra, GioTra, TinhTrang) value(?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, 0);
			statement.setInt(2, ctpt.getMaNV());
                        statement.setInt(3, ctpt.getMaKH());
                        statement.setInt(4, ctpt.getMaPhong());
                        statement.setInt(5, ctpt.getHinhThucThue());
                        statement.setDate(6, (java.sql.Date) ctpt.getNgayDen());
                        statement.setTime(7, ctpt.getGioDen());
                        statement.setDate(8, (java.sql.Date) ctpt.getNgayTra());
                        statement.setTime(9, ctpt.getGioTra());
                        statement.setInt(10, ctpt.getTinhTrang());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int capNhatPT(int maPhong, int tinhTrang) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update phieuthue TinhTrang=? WHERE MaPhong=?";
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
    public int capNhatPTAll(int maKH, int tinhTrang) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update phieuthue set TinhTrang=? WHERE MaKH=?";
			PreparedStatement statement = con.prepareCall(sql);
			statement.setInt(1, tinhTrang);
                        statement.setInt(2, maKH);
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int suaCTPT(PhieuThueDTO ctpt) throws SQLException
    {
        int ketQua = 0;
        try{
            Connection con = KetNoiDB.getConnection();//MaPT, MaNV, MaKH, MaPhong, HinhThucThue, NgayDen, GioDen, NgayTra, GioTra, TinhTrang
            String sql = "UPDATE phieuthue SET MaNV=?, MaKH=?, MaPhong=?, HinhThucThue=?, NgayDen=?, GioDen=?, NgayTra=?, GioTra=?  WHERE MaPT=?";    
            PreparedStatement pre = con.prepareStatement(sql);    
            pre.setInt(1,ctpt.getMaNV());
            pre.setInt(2,ctpt.getMaKH());
            pre.setInt(3, ctpt.getMaPhong());
            pre.setInt(4,ctpt.getHinhThucThue());
            pre.setDate(5, (java.sql.Date)ctpt.getNgayDen());
            pre.setTime(6,(java.sql.Time)ctpt.getGioDen());
            pre.setDate(7, (java.sql.Date) ctpt.getNgayTra());
            pre.setTime(8,(java.sql.Time)ctpt.getGioTra());
            pre.setInt(9,ctpt.getMaPT());
            ketQua = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+ketQua);
            KetNoiDB.closeConnection(con);
        }
        catch (SQLException e) {
        }
        return ketQua;
    }
}

