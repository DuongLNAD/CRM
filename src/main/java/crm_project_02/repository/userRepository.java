package crm_project_02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.Role;
import crm_project_02.entity.users;

public class userRepository {

	public int Insert(String fullname, String email, String pwd, String phone, int id_role) {
		int count = 0;
		String query = "INSERT INTO Users(fullname, email,pwd, phone ,id_role  ) VALUES(?, ?,? ,?, ?)";

		Connection conn = mysqlConfig.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(query);

			statement.setString(1, fullname);
			statement.setString(2, email);
			statement.setString(3, pwd);
			statement.setString(4, phone);
			statement.setInt(5, id_role);

			count = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Lỗi thêm usser" + e.getLocalizedMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("Lỗi đóng kết nối " + e.getLocalizedMessage());
			}
		}
		return count;

	}

	public List<users> findAll() {
		String query = "SELECT u.id, firstName,  lastName, userName, r.name , u.id_role  ,u.fullName, u.email  "
				+ "FROM Users u  JOIN `Role` r ON u.id_role = r.id";
		List<users> listUser = new ArrayList<users>();

		Connection conn = mysqlConfig.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();

			while (resultSet.next()) {
				users user = new users();
				user.setId(resultSet.getInt("id"));
				user.setId_role(resultSet.getInt("id_role"));
				user.setFullName(resultSet.getString("fullName"));
				user.setUserName(resultSet.getString("userName"));
				user.setEmail(resultSet.getString("email"));

				String fullName = user.getFullName();
				user.setFirstName(fullName.substring(0, fullName.indexOf(" ")));
				user.setLastName(fullName.substring(fullName.indexOf(" "), fullName.length()));

				Role role = new Role();
				role.setName(resultSet.getString("name"));
				role.setId(resultSet.getInt("id_role"));
				user.setRole(role);
				listUser.add(user);
			}

		} catch (SQLException e) {
			System.out.println("Lỗi thực thi kết nối câu query");
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
	
	public boolean deleteById(int id) {
		String query =" DELETE FROM Users u WHERE u.id = ?";
		int count = 0;
		Connection conn = mysqlConfig.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			count = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Loi xoa user " + e.getLocalizedMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("loi dong ket noi delete user " + e.getLocalizedMessage());
			
			}
		}
		
		return count > 0;
	}
	
	public boolean updateUser(String firstName,String  lastName,String userName,String id_role,String id) {
		String query = "UPDATE Users SET firstName  = ?,lastName =?, userName  = ?, id_role =? WHERE id= ?";
		int count = 0;
		Connection conn = mysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, firstName);
			statement.setString(2, lastName);
			statement.setString(3, userName);
			statement.setString(4, id_role);
			statement.setString(5, id);
			
			count = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.print("Loi thuc thi ket noi query" + e.getLocalizedMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		return count> 0;
	}
		
	
	

}
