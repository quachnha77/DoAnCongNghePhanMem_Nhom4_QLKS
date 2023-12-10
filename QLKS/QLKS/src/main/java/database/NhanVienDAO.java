package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import model.NhanVienDTO;

public class NhanVienDAO {
    public static NhanVienDAO getInstance(){
            return new NhanVienDAO();
    }
    public ArrayList<NhanVienDTO> selectAll() throws SQLException {
		ArrayList<NhanVienDTO> ketQua = new ArrayList<NhanVienDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from nhanvien";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maNV = rs.getInt("MaNV");
                            String HoTen = rs.getString("HoTen");
                            String CCCD = rs.getString("CCCD");
                            String DiaChi = rs.getString("DiaChi"); 
                            String soDienThoai = rs.getString("SDT");
                            Date ngaySinh = rs.getDate("NgaySinh");
                            String gioiTinh = rs.getString("GioiTinh"); 
                            NhanVienDTO p = new NhanVienDTO(maNV,HoTen, CCCD, DiaChi, soDienThoai, ngaySinh, gioiTinh);
                            ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    
    public int insert(NhanVienDTO nv) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into nhanvien(MaNV ,HoTen, CCCD, DiaChi, SDT, NgaySinh, GioiTinh) value(?,?,?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, 0);
			statement.setString(2, nv.getHoTen());
                        statement.setString(3, nv.getCCCD());
                        statement.setString(4, nv.getDiaChi());
                        statement.setString(5, nv.getSoDienThoai());
                        statement.setDate(6, (java.sql.Date) nv.getNgaySinh());
                        statement.setString(7, nv.getGioiTinh());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }  
    public NhanVienDTO selectById(String ma) {
		NhanVienDTO ketQua = null;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "select * from nhanvien where maNV=?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, ma);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int MaNV = rs.getInt("MaNV");
				String HoTen = rs.getString("HoTen");
				String CCCD = rs.getString("CCCD");
				String DiaChi = rs.getString("DiaChi");
                                String SDT = rs.getString("SDT");
                                Date NgaySinh = rs.getDate("NgaySinh");
                                String GioiTinh = rs.getString("GioiTinh");
				ketQua = new NhanVienDTO(MaNV, HoTen, CCCD, DiaChi, SDT, NgaySinh, GioiTinh);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int update(NhanVienDTO nv, int MaNV) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update nhanvien set HoTen=?, CCCD=?, DiaChi=?, SDT=?, NgaySinh=?, GioiTinh=?  where MaNV=?";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setString(1, nv.getHoTen());
                        statement.setString(2, nv.getCCCD());
                        statement.setString(3, nv.getDiaChi());
                        statement.setString(4, nv.getSoDienThoai());
                        statement.setDate(5, (java.sql.Date) nv.getNgaySinh());
                        statement.setString(6, nv.getGioiTinh());
                        statement.setInt(7, nv.getMaNV());
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
       
	public int delete(int MaNV) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "delete from nhanvien where MaNV="+MaNV;
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
