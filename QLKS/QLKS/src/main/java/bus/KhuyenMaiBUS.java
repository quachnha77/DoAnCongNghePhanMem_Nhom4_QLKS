package bus;

import database.KhuyenMaiDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import model.KhuyenMaiDTO;

public class KhuyenMaiBUS {
    public static ArrayList<KhuyenMaiDTO> dsKM;
        //Đặt phòng
        public void docKhuyenMai() throws SQLException
        {
            KhuyenMaiDAO dataKM = new KhuyenMaiDAO();
            if(dsKM==null)
                {
                    dsKM = new ArrayList<KhuyenMaiDTO>();
                }
            dsKM = dataKM.selectAll();
        }
        public void themkm(KhuyenMaiDTO km) throws SQLException
        {
            KhuyenMaiDAO datakm = new KhuyenMaiDAO();
            datakm.themKhuyenMai(km);
            dsKM.add(km);
        }

        public void xoakm(KhuyenMaiDTO km, int MaKM)
        {
            KhuyenMaiDAO datakm = new KhuyenMaiDAO();
            datakm.xoaKhuyenMai(MaKM);
            dsKM.remove(km);
        }

        public void suakm(KhuyenMaiDTO km, int MaKM) throws SQLException
        {
            KhuyenMaiDAO datakm = new KhuyenMaiDAO();
            datakm.suaKhuyenMai(km, MaKM);
            dsKM.remove(km);
            dsKM.add(km);
        }
}
