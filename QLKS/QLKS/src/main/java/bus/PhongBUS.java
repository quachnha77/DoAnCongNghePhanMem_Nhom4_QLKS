package bus;
import database.PhongDAO;
import java.awt.Color;
import java.util.ArrayList;
import model.PhongDTO;
public class PhongBUS {
        public static ArrayList<PhongDTO> dsPhong;
        //Đặt phòng
        public void docDatPhong()
        {
            PhongDAO dataDP = new PhongDAO();
            if(dsPhong==null)
                {
                    dsPhong = new ArrayList<PhongDTO>();
                }
            dsPhong = dataDP.selectAll();
        }
        
        public void capNhatTinhTrangPhong(int maPhong, int tinhTrang) {
                PhongDAO dataDP = new PhongDAO();
                dataDP.capNhatTinhTrangPhong(maPhong, tinhTrang);
	}  
        
        public int don = 0; 
        public int doi = 0; 
        public int vip = 0; 
        public int daDuocThue = 0; 
        public int dangDon = 0;
        public void soPhongTrong(){  
            don = 0;
            doi = 0;
            vip = 0;
            daDuocThue = 0;
            dangDon = 0;
            for (PhongDTO p : dsPhong) {
                if("ĐƠN".equals(p.getLoaiPhong()) && p.getTinhTrang()==1){
                    don++;
                }else if("ĐÔI".equals(p.getLoaiPhong()) && p.getTinhTrang()==1){
                    doi++;
                }else if("VIP".equals(p.getLoaiPhong()) && p.getTinhTrang()==1){
                    vip++;
                }else if (p.getTinhTrang()==2){ // đã đc thuê
                    daDuocThue++;
                }else if (p.getTinhTrang()==3){ // đang dọn
                    dangDon++;
                }
            } 
        } 
        public void insertPhong(PhongDTO ph) {
		PhongDAO dataPhong = new PhongDAO();
                dataPhong.insert(ph);
                dsPhong.add(ph);
	}
        public void updatePhong(PhongDTO ph, int maPhong) {
                PhongDAO dataPhong = new PhongDAO();
                dataPhong.update(ph, maPhong);
                
                dsPhong.remove(ph);
		dsPhong.add(ph);
	} 
        public void deletePhong(int maPhong, int n) {
		PhongDAO dataPhong = new PhongDAO();
                dataPhong.delete(maPhong);
                dsPhong.remove(n);
	}
}
