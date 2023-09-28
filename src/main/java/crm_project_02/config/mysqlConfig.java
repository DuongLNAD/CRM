package crm_project_02.config;

import java.sql.Connection;
import java.sql.DriverManager;

// Cấu hình JDBC kết nối tới server mysql; 

public class mysqlConfig {

	public static Connection getConnection() {

		try {
//			Khai báo driver sử dụng cho JDBC tương ứng với CSDL cần kết nối; 
			Class.forName("com.mysql.cj.jdbc.Driver");
//			Khai báo driver sẽ mở kết nối tới CSDL nào 
			return DriverManager.getConnection("jdbc:mysql://localhost:3307/layoutcrm", "root", "admin123");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi kết nối DB" + e.getLocalizedMessage());
			return null;
		}
	}

}
