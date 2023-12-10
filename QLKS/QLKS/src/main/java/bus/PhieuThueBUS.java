package bus;
import database.PhieuThueDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PhieuThueDTO;

public class PhieuThueBUS {
        public static ArrayList<PhieuThueDTO> dsCTPT;
        //Đặt phòng
        public void docCTPT() throws SQLException
        {
            PhieuThueDAO dataCTPT = new PhieuThueDAO();
            if(dsCTPT==null)
                {
                    dsCTPT = new ArrayList<PhieuThueDTO>();
                }
            dsCTPT = dataCTPT.selectAll();
        }
	 
        public void insertCTPT(PhieuThueDTO ctpt) {
		PhieuThueDAO dataCTPT = new PhieuThueDAO();
                dataCTPT.insert(ctpt);
                dsCTPT.add(ctpt);
	}
        public void capNhatPT(int maPhong, int tinhTrang) {
		PhieuThueDAO dataCTPT = new PhieuThueDAO();
                dataCTPT.capNhatPT(maPhong, tinhTrang);
	}  
        public void capNhatPTAll(int maKH, int tinhTrang) {
		PhieuThueDAO dataCTPT = new PhieuThueDAO();
                dataCTPT.capNhatPTAll(maKH, tinhTrang);
	}
        public void update(PhieuThueDTO ctpt) throws SQLException {
                PhieuThueDAO dataCTPT = new PhieuThueDAO();
                dataCTPT.suaCTPT(ctpt);
                
                dsCTPT.remove(ctpt);
		dsCTPT.add(ctpt);
	} 

}


