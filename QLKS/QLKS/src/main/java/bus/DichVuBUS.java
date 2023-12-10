package bus;

import database.DichVuDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DichVuDTO;

public class DichVuBUS {
    public static ArrayList<DichVuDTO> dsDV;
        public void docDichVu() throws SQLException
        {
            DichVuDAO dataDV = new DichVuDAO();
            if(dsDV==null)
                {
                    dsDV = new ArrayList<DichVuDTO>();
                }
            dsDV = dataDV.selectAll();
        }
        
        
        
        public void themDV(DichVuDTO dv) {
		DichVuDAO dataDV = new DichVuDAO();
                dataDV.themDichVu(dv);       
                dsDV.add(dv);
	}
        public void suaDV(DichVuDTO dv,int MaDV) 
        {
            DichVuDAO dataDV = new DichVuDAO();
            dataDV.suaDichVu(dv,MaDV);
            dsDV.remove(dv);
            dsDV.add(dv);             
        }
        public void xoaDV(DichVuDTO dv,int MaDV,int n){
            DichVuDAO dataDV = new DichVuDAO();
            dataDV.xoaDichVu(MaDV);
            dsDV.remove(dv);
        }
        public void timDichVu (DichVuDTO dv, String MaDV) {
	    DichVuDAO dataDV = new DichVuDAO();
            dataDV.timDichVu(dv);
            dsDV.add(dv);
        }      
}
