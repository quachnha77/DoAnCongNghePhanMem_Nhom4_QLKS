package bus;

import database.PhieuSuDungDichVuDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.PhieuSuDungDichVuDTO;
import model.topDVBanChayDTO;

public class PhieuSuDungDichVuBUS {
        public static ArrayList<PhieuSuDungDichVuDTO> dsPhieuSDDV;
        public static ArrayList<topDVBanChayDTO> dsdvbc;  //ds sản phẩm bán chạy
        //Đặt phòng
        public void docPhieuSDDV() throws SQLException
        {
            PhieuSuDungDichVuDAO dataPSDDV = new PhieuSuDungDichVuDAO();
            if(dsPhieuSDDV==null)
                {
                    dsPhieuSDDV = new ArrayList<PhieuSuDungDichVuDTO>();
                }
            dsPhieuSDDV = dataPSDDV.selectAll();
        }
        public void insertKH(PhieuSuDungDichVuDTO phieu) {
		PhieuSuDungDichVuDAO dataPSDDV = new PhieuSuDungDichVuDAO();
                dataPSDDV.insert(phieu);
                dsPhieuSDDV.add(phieu);
	}
        public void topDVBanChay() {
            PhieuSuDungDichVuDAO data = new PhieuSuDungDichVuDAO();
            if ( dsdvbc== null) {
                dsdvbc = new ArrayList<topDVBanChayDTO>();
            }
            dsdvbc = data.getTopDVBanChay();
        }
}