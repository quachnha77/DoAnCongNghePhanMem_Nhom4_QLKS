package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.KhachHangDTO;

public class KhachHangDAO {
    public static KhachHangDAO getInstance(){
            return new KhachHangDAO();
    }
    public ArrayList<KhachHangDTO> selectAll() throws SQLException {
		ArrayList<KhachHangDTO> ketQua = new ArrayList<KhachHangDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from khachhang";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maKH = rs.getInt("MaKH");
                            String HoTen = rs.getString("HoTen");
                            String CCCD = rs.getString("CCCD");
                            String DiaChi = rs.getString("DiaChi"); 
                            String soDienThoai = rs.getString("SDT");
                            Date ngaySinh = rs.getDate("NgaySinh");
                            String gioiTinh = rs.getString("GioiTinh"); 
                            KhachHangDTO p = new KhachHangDTO(maKH,HoTen, CCCD, DiaChi, soDienThoai, ngaySinh, gioiTinh);
                            ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int insert(KhachHangDTO kh) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into khachhang(MaKH ,HoTen, CCCD, DiaChi, SDT, NgaySinh, GioiTinh) value(?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, 0);
			statement.setString(2, kh.getHoTen());
                        statement.setString(3, kh.getCCCD());
                        statement.setString(4, kh.getDiaChi());
                        statement.setString(5, kh.getSoDienThoai());
                        statement.setDate(6, (java.sql.Date) kh.getNgaySinh());
                        statement.setString(7, kh.getGioiTinh());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }  
    public KhachHangDTO selectById(String ma) {
		KhachHangDTO ketQua = null;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "select * from khachhang where maKH=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int MaKH = rs.getInt("MaKH");
				String HoTen = rs.getString("HoTen");
				String CCCD = rs.getString("CCCD");
				String DiaChi = rs.getString("DiaChi");
                                String SDT = rs.getString("SDT");
                                Date NgaySinh = rs.getDate("NgaySinh");
                                String GioiTinh = rs.getString("GioiTinh");
				ketQua = new KhachHangDTO(MaKH, HoTen, CCCD, DiaChi, SDT, NgaySinh, GioiTinh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int update(KhachHangDTO kh, int MaKH) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update khachhang set HoTen=?, CCCD=?, DiaChi=?, SDT=?, NgaySinh=?, GioiTinh=?  where MaKH=?";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setString(1, kh.getHoTen());
                        statement.setString(2, kh.getCCCD());
                        statement.setString(3, kh.getDiaChi());
                        statement.setString(4, kh.getSoDienThoai());
                        statement.setDate(5, (java.sql.Date) kh.getNgaySinh());
                        statement.setString(6, kh.getGioiTinh());
                        statement.setInt(7, kh.getMaKH());
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
       
	public int delete(int MaKH) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "delete from khachhang where MaKH="+MaKH;
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
