package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TaiKhoanDTO;

public class TaiKhoanDAO {
    public static TaiKhoanDAO getInstance(){
            return new TaiKhoanDAO();
    }
    public ArrayList<TaiKhoanDTO> selectAll() throws SQLException {
		ArrayList<TaiKhoanDTO> ketQua = new ArrayList<TaiKhoanDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from taikhoan";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maNV = rs.getInt("MaNV");
                            String taiKhoan = rs.getString("TaiKhoan");
                            String matKhau = rs.getString("MatKhau");
                            String quyenTK = rs.getString("Quyen");  
                            String tinhTrang = rs.getString("TinhTrang");
                            TaiKhoanDTO p = new TaiKhoanDTO(maNV, taiKhoan, matKhau, quyenTK, tinhTrang);
                            ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
	public TaiKhoanDTO selectById(String taiKhoan) {
		TaiKhoanDTO ketQua = null;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "select * from taikhoan where TaiKhoan = '" + taiKhoan + "'";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				int maNV = rs.getInt("MaNV");
				String TK = rs.getString("TaiKhoan");
				String matKhau = rs.getString("MatKhau");
				String quyenTK = rs.getString("Quyen");
                                String tinhTrang = rs.getString("TinhTrang");
				ketQua = new TaiKhoanDTO(maNV, taiKhoan, matKhau, quyenTK, tinhTrang);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	} 
        public int doiMK(TaiKhoanDTO tk) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update taikhoan set MatKhau=? WHERE TaiKhoan=?";
			PreparedStatement statement = con.prepareCall(sql);          
                        statement.setString(1, tk.getMatKhau());
                        statement.setString(2, tk.getTaiKhoan());
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
                        System.out.println("Pass mới là : "+tk.getMatKhau());
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        public int doiMK1(int maNV,String pass) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update taikhoan set MatKhau=? WHERE MaNV=?";
			PreparedStatement statement = con.prepareCall(sql);          
                        statement.setString(1, pass);
                        statement.setInt(2, maNV);
			ketQua = statement.executeUpdate();
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        public int updatePass(int maNV,String pass) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update taikhoan set MatKhau=? WHERE MaNV=?";
			PreparedStatement statement = con.prepareCall(sql);     
                        statement.setString(1, pass);
                        statement.setInt(2, maNV);                    
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        public int update(TaiKhoanDTO tk) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update taikhoan set Quyen=?, TinhTrang=? WHERE MaNV=?";
			PreparedStatement statement = con.prepareCall(sql);     
                        statement.setString(1, tk.getQuyenTK());
                        statement.setString(2, tk.getTinhTrang());     
                        statement.setInt(3, tk.getMaNV()); 
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        public int insert(TaiKhoanDTO tk) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "insert into taikhoan(MaNV ,TaiKhoan, MatKhau, Quyen, TinhTrang) value(?,?,?,?,?)";
			PreparedStatement statement = con.prepareCall(sql);
                        statement.setInt(1, tk.getMaNV());
			statement.setString(2, tk.getTaiKhoan());
                        statement.setString(3, tk.getMatKhau());
                        statement.setString(4, tk.getQuyenTK());
                        statement.setString(5, tk.getTinhTrang());
                        ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
        }
        public int updateUser(int maNV, String user) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update taikhoan set TaiKhoan=? WHERE MaNV=?";
			PreparedStatement statement = con.prepareCall(sql);     
                        statement.setString(1, user);
                        statement.setInt(2, maNV);     
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        
        
        
        
        
        
        /*
        public int update(AccountDTO ac) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update account set fullname=?,username=?,password=?,role=?, status=?, email=? WHERE username=?";
			PreparedStatement statement = con.prepareCall(sql);          
                        statement.setString(1, ac.getFullName());
                        statement.setString(2, ac.getUserName());
                        statement.setString(3, ac.getPassWord());
                        statement.setString(4, ac.getRole());
                        statement.setInt(5, ac.getStatus());
                        statement.setString(6, ac.getEmail());
                        statement.setString(7, ac.getUserName());
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
          
	
        public int edit(AccountDTO ac) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update account set fullname=?,username=?,role=?, email=? WHERE username=?";
			PreparedStatement statement = con.prepareCall(sql);          
                        statement.setString(1, ac.getFullName());
                        statement.setString(2, ac.getUserName());
                        statement.setString(3, ac.getRole());
                        statement.setString(4, ac.getEmail());
                        statement.setString(5, ac.getUserName());
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        
        public int updatePass(String email,String pass) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "update account set password=? WHERE email=?";
			PreparedStatement statement = con.prepareCall(sql);     
                        statement.setString(1, pass);
                        statement.setString(2, email);                    
			ketQua = statement.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
	public int delete(String userName) {
		int ketQua = 0;
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "delete from account where username=N'"+userName+"'";
			PreparedStatement pst = con.prepareStatement(sql);
			ketQua = pst.executeUpdate();
			System.out.println("So dong bi thay doi : "+ketQua);
			KetNoiDB.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
	}
        */
    
}
