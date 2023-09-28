package crm_project_02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.tomcat.jni.User;

import com.mysql.cj.xdevapi.Result;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.users;

public class LoginRepository {

	public List<users> findUserByEmailAndPassWord(String email, String password) {
		List<users> listUser = new ArrayList<users>();
		users user = new users();
		
		String query = "SELECT * FROM Users u \r\n" + "WHERE u.email = ? AND u.pwd = ? ";
//Mở kết nối tới CSDL; 
		Connection conn = mysqlConfig.getConnection();

		try {
//	Chuẩn bị câu query cho prepareStament truyền xuống CSDL ;
			PreparedStatement statement = conn.prepareStatement(query);
//	Gán giá trị cho tham số trong câu query thông qua PrepareStament 
			statement.setString(1, email);
			statement.setString(2, password);
			/*
			 * executeQuery : Nếu câu truy vấn là câu SELECT executeUpdate : Nếu câu truy
			 * vấn khác câu SELECT ( INSERT, UPDATE, DELETE,...)
			 * 
			 */
//	Thực thi câu query và lấy kết quả;
			
			ResultSet resultSet = statement.executeQuery();  // executeQuery sẽ trả về 1 bảng ; có thể có 1 dòng hoặc nhiều dòng ;
			
			while(resultSet.next()) { 
				user.setEmail(resultSet.getString("email"));
				user.setPassword(resultSet.getString("pwd"));		
				listUser.add(user);
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("Lỗi thực thi truy vấn: " + e.getLocalizedMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listUser;
	}
}
