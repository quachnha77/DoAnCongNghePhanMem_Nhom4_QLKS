package bus;
import database.KhachHangDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHangDTO;
public class KhachHangBUS {
        public static ArrayList<KhachHangDTO> dsKhachHang;
        public void docKhachHang() throws SQLException
        {
            KhachHangDAO dataKH = new KhachHangDAO();
            if(dsKhachHang==null)
                {
                    dsKhachHang = new ArrayList<KhachHangDTO>();
                }
            dsKhachHang = dataKH.selectAll();
        }
	 
        public void themKH(KhachHangDTO kh) {
		KhachHangDAO dataKH = new KhachHangDAO();
                dataKH.insert(kh);
                dsKhachHang.add(kh);
	}
        
	public void xoaKH(int MaKH) {
            KhachHangDAO data = new KhachHangDAO();
            data.delete(MaKH);
            //dsKhachHang.remove(MaKH);
        }
        
        public void suaKH(KhachHangDTO kh, int MaKH) {
            KhachHangDAO data = new KhachHangDAO();
            data.update(kh,MaKH);
            dsKhachHang.remove(kh);
            dsKhachHang.add(kh);
        }      
}

