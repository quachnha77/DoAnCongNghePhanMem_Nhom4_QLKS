package bus;

import database.NhanVienDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhachHangDTO;
import model.NhanVienDTO;

public class NhanVienBUS {
        public static ArrayList<NhanVienDTO> dsNV;
        public void docNhanVien() throws SQLException
        {
            NhanVienDAO dataNV = new NhanVienDAO();
            if(dsNV==null)
                {
                    dsNV = new ArrayList<NhanVienDTO>();
                }
            dsNV = dataNV.selectAll();
        }
        public void themNV(NhanVienDTO nv) {
		NhanVienDAO dataKH = new NhanVienDAO();
                dataKH.insert(nv);
                dsNV.add(nv);
	}
        
	public void xoaNV(int MaNV) {
            NhanVienDAO data = new NhanVienDAO();
            data.delete(MaNV);
            
        }
        
        public void suaNV(NhanVienDTO nv, int MaNV) {
            NhanVienDAO data = new NhanVienDAO();
            data.update(nv,MaNV);
            dsNV.remove(nv);
            dsNV.add(nv);
        }    
}
