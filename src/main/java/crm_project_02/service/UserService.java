package crm_project_02.service;

import java.util.ArrayList;
import java.util.List;

import crm_project_02.entity.Role;
import crm_project_02.entity.users;
import crm_project_02.repository.RoleRepository;
import crm_project_02.repository.userRepository;

public class UserService {
	userRepository userRepository = new userRepository();
	RoleRepository roleRepository = new RoleRepository();
	
	public boolean insertUser (String fullname, String email, String pwd, String phone, int role_id) {
		System.out.println(fullname + " " +  email + " "  +pwd + " "  +phone + " " + role_id );
		int  count = userRepository.Insert(fullname, email, pwd, phone, role_id);
		
		return count > 0;
	}
	public List<users> getAllUser() {
		
		return  userRepository.findAll();
		
	}

	public List<Role> getAllRole() {
		return roleRepository.findAll();
		
	}
	
	public boolean deleteUser(int id) {
		boolean isDone = userRepository.deleteById(id);
		
		return isDone;
	}
	
	public boolean UpdateUser(String firstName, String lastName, String userName, String id_role, String id) {
		return userRepository.updateUser(firstName, lastName, userName, id_role, id);
	}
	
}
