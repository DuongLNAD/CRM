package crm_project_02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.Role;

/*
 * Chứa toàn bộ câu truy vấn liên quan đến bảng Role
 * Đối với câu select tên hàm sẽ bắt đầu bằng chữ : find
 * - Nếu có điều kiện Where : by
 * - 
 * 
 * */
public class RoleRepository {

	public int Insert(String name, String desc) {
		int result = 0;

		String query = "INSERT INTO Role(name, description) VALUES(?,?)";

		Connection conn = mysqlConfig.getConnection();

		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(query);
			System.out.println("name: " + name + "desc " + desc);
			statement.setString(1, name);
			statement.setString(2, desc);

			result = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Loi add role " + e.getLocalizedMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return result;

	}

	public List<Role> findAll() {
		String query = "SELECT * FROM `Role` r ";
		List<Role> listRole = new ArrayList<Role>();
		Connection conn = mysqlConfig.getConnection();

		try {
			PreparedStatement statement = conn.prepareStatement(query);

			ResultSet resultSet = statement.executeQuery();
			int stt = 1;
			while (resultSet.next()) {
				Role role = new Role();
				role.setName(resultSet.getString("name"));
				role.setDesc(resultSet.getString("description"));
				role.setId(resultSet.getInt("id"));
				role.setStt(stt);
				listRole.add(role);
				stt++;
			}
			
		} catch (SQLException e) {
			System.out.println("Lỗi get Role from RoleRepository " + e.getLocalizedMessage());
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return listRole;
	}
	
	public boolean deleteById(int id) {
		int count = 0;
		String query = "DELETE FROM Role WHERE id= ? ";
		
		Connection conn = mysqlConfig.getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			
			count = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Loi thuc thi xoa role " + e.getLocalizedMessage() );
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count > 0;
		
	}
	
	public boolean updateRole(int id, String name, String desc) {
		String query = " UPDATE `Role`	 SET name = ? ,description  = ? WHERE id = ? " ;
		int count = 0;
		Connection conn = mysqlConfig.getConnection();
		
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(query);
			statement.setString(1, name);
			statement.setString(2, desc);
			statement.setInt(3, id);
			count = statement.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Lỗi thực thi update Role" + e.getLocalizedMessage());
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return count > 0;
		
		
	}

}
