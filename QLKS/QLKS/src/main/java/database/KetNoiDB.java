package database;

import com.mysql.jdbc.Driver;
import com.sun.jdi.connect.spi.Connection;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.DriverManager;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.util.Properties;
public class KetNoiDB {
    public static Connection conn = null;
    private static String severName;
    private static String dbName;
    private static String user;
    private static String pass;
	public static java.sql.Connection getConnection() {
		java.sql.Connection c = null;
                docFileText();
		try {
			// Dang ky MySQL Driver voi DriverManager
			//DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			//Cac thong so
			String url = "jdbc:mysql://"+severName+":3306/"+dbName;
			String userName = user;
			String password = pass;
			//Tao ket noi 
			c = DriverManager.getConnection(url, userName, password);
                        System.out.println("connect database");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return c;
	}
         
        public static void docFileText() {
            // Xử lý đọc file để lấy ra 4 tham số
            severName = "";
            dbName = "";
            user = "";
            pass = "";

            try {
                FileInputStream fis = new FileInputStream("ConnectVariable.txt");
                InputStreamReader isr = new InputStreamReader(fis);
                BufferedReader br = new BufferedReader(isr);

                severName = br.readLine();
                dbName = br.readLine();
                user = br.readLine();
                pass = br.readLine();

                if (pass == null) {
                    pass = "";
                }

            } catch (Exception e) {
            }
        }
        public static void closeConnection(java.sql.Connection c) {
		try {
			if(c!=null) {
				c.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}      
}
