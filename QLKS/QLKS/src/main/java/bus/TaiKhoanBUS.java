package bus;

import database.TaiKhoanDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.TaiKhoanDTO;

public class TaiKhoanBUS {
    public static ArrayList<TaiKhoanDTO> dsTK;
    public void docTK() throws SQLException
    {
        TaiKhoanDAO dataTK = new TaiKhoanDAO();
        if(dsTK==null){
            dsTK = new ArrayList<TaiKhoanDTO>();
        }
        dsTK = dataTK.selectAll();
    }
    public void doiMK(TaiKhoanDTO tk) 
    {
        TaiKhoanDAO dataTK = new TaiKhoanDAO();
        dataTK.doiMK(tk);
        dsTK.remove(tk);
        dsTK.add(tk);             
    }
    public void updateTK(TaiKhoanDTO tk) {
	TaiKhoanDAO dataTK = new TaiKhoanDAO();
        dataTK.update(tk);       
        dsTK.remove(tk);
        dsTK.add(tk);
    }
    public void insertTK(TaiKhoanDTO tk) {
	TaiKhoanDAO dataTK = new TaiKhoanDAO();
        dataTK.insert(tk);       
        dsTK.add(tk);
    }      
}

/*

public void docDichVu() throws SQLException
        {
            TaiKhoanDAO dataTK = new TaiKhoanDAO();
            if(dsTK==null)
                {
                    dsTK = new ArrayList<TaiKhoanDTO>();
                }
            dsTK = dataTK.selectAll();
        }
        public void themDV(DichVuDTO dv) {
		DichVuDAO dataDV = new DichVuDAO();
                dataDV.themDichVu(dv);       
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


*/