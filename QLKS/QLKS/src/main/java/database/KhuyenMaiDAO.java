package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import model.KhuyenMaiDTO;

public class KhuyenMaiDAO {
    public static KhuyenMaiDAO getInstance(){
            return new KhuyenMaiDAO();
    }
    public ArrayList<KhuyenMaiDTO> selectAll() throws SQLException {
		ArrayList<KhuyenMaiDTO> ketQua = new ArrayList<KhuyenMaiDTO>();
		try {
			Connection con = KetNoiDB.getConnection();
			String sql = "Select * from khuyenmai";
			PreparedStatement pst = con.prepareStatement(sql);
			System.out.println("Thuc thi cau lenh: "+sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
                            int maKM = rs.getInt("MaKM");
                            String tenKM = rs.getString("TenKM");
                            int phanTramKM = rs.getInt("PhanTramKM");
                            Date ngayBD = rs.getDate("NgayBD"); 
                            Date ngayKT = rs.getDate("NgayKT");
                            int trangThai = rs.getInt("TrangThai"); 
                            float donToiThieu = rs.getFloat("DonToiThieu");
                            float giamToiDa = rs.getFloat("GiamToiDa");
                            KhuyenMaiDTO km = new KhuyenMaiDTO(maKM,tenKM, phanTramKM, ngayBD, ngayKT, trangThai, donToiThieu, giamToiDa);
                            ketQua.add(km);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ketQua;
    }
    public int themKhuyenMai(KhuyenMaiDTO km) throws SQLException
    {
        int ketQua = 0;
        try{
            Connection con = KetNoiDB.getConnection();
            String sql = "insert into khuyenmai(MaKM,TenKM,PhanTramKM,NgayBD,NgayKT,TrangThai,DonToiThieu,GiamToiDa) value(?,?,?,?,?,?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1,0);
            pre.setString(2,km.getTenKM());
            pre.setInt(3,km.getPhanTramKM());
            pre.setTimestamp(4, new java.sql.Timestamp(km.getNgayBD().getTime()));
            pre.setTimestamp(5,new java.sql.Timestamp(km.getNgayKT().getTime()));
            pre.setInt(6,km.getTrangThai());
            pre.setFloat(7,km.getDonToiThieu());
            pre.setFloat(8,km.getGiamToiDa());
            ketQua = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+ketQua);
            KetNoiDB.closeConnection(con);
        }
        catch (SQLException e) {}
        return ketQua;
}
        
    public int suaKhuyenMai(KhuyenMaiDTO km, int MaKM) throws SQLException
    {
        int ketQua = 0;
        try{
            Connection con = KetNoiDB.getConnection();
            String sql = "UPDATE khuyenmai SET TenKM=?, PhanTramKM=?, NgayBD=?, NgayKT=?, TrangThai=?, DonToiThieu=?, GiamToiDa=? WHERE MaKM=?";    
            PreparedStatement pre = con.prepareStatement(sql);    
            pre.setString(1,km.getTenKM());
            pre.setInt(2,km.getPhanTramKM());
            pre.setTimestamp(3, new java.sql.Timestamp(km.getNgayBD().getTime()));
            pre.setTimestamp(4,new java.sql.Timestamp(km.getNgayKT().getTime()));
            pre.setInt(5,km.getTrangThai());
            pre.setFloat(6,km.getDonToiThieu());
            pre.setFloat(7,km.getGiamToiDa());
            pre.setInt(8,km.getMaKM());
            ketQua = pre.executeUpdate();
            System.out.println("So dong bi thay doi : "+ketQua);
            KetNoiDB.closeConnection(con);
        }
        catch (SQLException e) {
        }
        return ketQua;
    }
    
    public int xoaKhuyenMai(int MaKM)
    {
        int ketQua = 0;
        try{
        Connection con = KetNoiDB.getConnection();
        String sql = "DELETE FROM khuyenmai where MaKM=?";
        PreparedStatement pre;
        pre = con.prepareStatement(sql);
        pre.setInt(1,MaKM);
        ketQua = pre.executeUpdate();
        pre.close();
        KetNoiDB.closeConnection(con);
        } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Lỗi", "Thông báo", 1);
                    e.printStackTrace();
        }
        return ketQua;
    }
    
}
