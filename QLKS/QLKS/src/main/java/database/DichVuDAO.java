package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DichVuDTO;

public class DichVuDAO {
    public static DichVuDAO getInstance(){
            return new DichVuDAO();
    }
    public ArrayList<DichVuDTO> selectAll() throws SQLException {
		ArrayList<DichVuDTO> ketQua = new ArrayList<DichVuDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from dichvu";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maDV = rs.getInt("MaDV");
                            String tenDV = rs.getString("TenDV");
                            Float giaDV = rs.getFloat("GiaDV");
                            int tinhTrangDV = rs.getInt("TTDV"); 
                            DichVuDTO p = new DichVuDTO(maDV,tenDV, giaDV, tinhTrangDV);
                            ketQua.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    
    
    
    
    
    public int themDichVu(DichVuDTO dv)
    {   
        int kq =0;
        try {
            String sql = "INSERT INTO dichvu(MaDV, TenDV, GiaDV, TTDV)" + "VALUES (?,?,?,?) ";
            Connection con = KetNoiDB.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,dv.getMaDV());
            pre.setString(2, dv.getTenDV());
            pre.setFloat(3, dv.getGiaDV());
            pre.setInt(4,dv.getTinhTrangDV());
            kq = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+kq);
            KetNoiDB.closeConnection(con);
        } catch (Exception e) {}
        return kq;
    }
    public int suaDichVu (DichVuDTO dv,int MaDV) 
    {   
        int kq =0;
        try {
            String sql ="UPDATE dichvu SET MaDV=?, TenDV=?, GiaDV= ?, TTDV= ? WHERE MaDV=?";
            Connection con = KetNoiDB.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,MaDV);
            pre.setString(2, dv.getTenDV());
            pre.setFloat(3, dv.getGiaDV());
            pre.setInt(4,dv.getTinhTrangDV());
            pre.setInt(5,dv.getMaDV());
            kq = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+kq);
            KetNoiDB.closeConnection(con);
        } catch (Exception e) {}
        return kq;
    }
    public int xoaDichVu(int MaDV){
        int kq =0;
        try{
            String sql = "DELETE FROM dichvu WHERE MaDV="+MaDV;
            Connection con = KetNoiDB.getConnection();
            PreparedStatement pre = con.prepareStatement(sql);
            kq = pre.executeUpdate(sql);
            System.out.println("So dong bi thay doi"+kq);
            KetNoiDB.closeConnection(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return kq;
    }
    public DichVuDTO timDichVu(DichVuDTO dv) {
        DichVuDTO kq = null;
        String sql = "SELECT * from dichvu where MaDV=?";
        try (
            Connection conn = KetNoiDB.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, dv.getMaDV());
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int MaDV = rs.getInt("MaDV");
                String TenDV = rs.getString("TenDV");
                Float GiaDV = rs.getFloat("GiaDV");
                int TTDV = rs.getInt("TTDV");
                kq = new DichVuDTO(MaDV, TenDV, GiaDV, TTDV);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return kq;
    }
}
