package bus;

import database.HoaDonDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.HoaDonDTO;

public class HoaDonBUS {
    public static ArrayList<HoaDonDTO> dsHD;
        public void docHoaDon() throws SQLException
        {
            HoaDonDAO dataHD = new HoaDonDAO();
            if(dsHD==null)
                {
                    dsHD = new ArrayList<HoaDonDTO>();
                }
            dsHD = dataHD.selectAll();
        }
       
        public void themHD(HoaDonDTO hd) {
		HoaDonDAO dataHD = new HoaDonDAO();
                dataHD.themHoaDon(hd);       
                dsHD.add(hd);
	}
        /*
        public void suaDV(HoaDonDTO dv,int MaDV) 
        {
            DichVuDAO dataDV = new DichVuDAO();
            dataDV.suaDichVu(dv,MaDV);
            dsDV.remove(dv);
            dsDV.add(dv);             
        }
        public void xoaDV(HoaDonDTO dv,int MaDV,int n){
            DichVuDAO dataDV = new DichVuDAO();
            dataDV.xoaDichVu(MaDV);
            dsDV.remove(dv);
        }
        public void timDichVu (HoaDonDTO dv, String MaDV) {
	    DichVuDAO dataDV = new DichVuDAO();
            dataDV.timDichVu(dv);
            dsDV.add(dv);
        } 
*/
}
