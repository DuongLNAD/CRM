package crm_project_02.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.Role;
import crm_project_02.repository.RoleRepository;

/*
 * RoleService chuyên đi xử lí logic code cho RoleController
 * 
 * Cách đặt tên hàm ứng với chức năng sẽ làm trên giao diện hoặc bên Controller
 * 
 * 	*/

public class RoleService {
	private RoleRepository roleRepository = new RoleRepository();

	public boolean addRole(String name, String desc) {
		
		if(name =="" || desc == "") {
			System.out.println("Không thể giá giá trị rỗng cho Role");
			
			return false;
		}
		int count = roleRepository.Insert(name, desc);

		return count > 0;

	}
	
	public List<Role> getAllRole() {
		List<Role> listRole = roleRepository.findAll();
		
		return listRole;
	}
	
	
	public boolean deleteRole(int id) {
		boolean isDeleted = roleRepository.deleteById(id);
		return isDeleted;
	}
	
	public boolean updateRole(int id, String name, String desc) {
		 boolean isUpdated = roleRepository.updateRole(id, name, desc);
		
		return isUpdated;
		
	}
}
