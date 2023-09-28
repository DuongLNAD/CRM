package crm_project_02.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.Project;

public class ProjectRepository {

	public boolean Insert(String name, String startDate, String endDate ) {
		String query = "INSERT INTO Project (name, startDate,endDate) VALUES(?,?,?)";
		int count = 0;
		
		Connection conn = mysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			statement.setString(1, name);
			statement.setString(2, startDate);
			statement.setString(3, endDate);
			
			 count = statement.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Loi thuc thi cau query" + e.getLocalizedMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count > 0;
	}
	
	public List<Project> findAll() {
		String query = "SELECT * FROM Project ";
		List<Project> listProject = new ArrayList<Project>();
		Connection conn = mysqlConfig.getConnection();
		
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Project project = new Project();
				project.setName(resultSet.getString("name"));
				project.setStartDate(resultSet.getString("startDate"));
				project.setStartDate(resultSet.getString("endDate"));
				
				listProject.add(project);
			}
		} catch (SQLException e) {
			System.out.println("Loi thuc thi cau query" + e.getLocalizedMessage());
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return listProject;
	}
}
