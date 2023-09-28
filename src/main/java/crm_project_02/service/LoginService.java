package crm_project_02.service;

import java.util.ArrayList;
import java.util.List;

import crm_project_02.entity.users;
import crm_project_02.repository.LoginRepository;

public class LoginService {
	private LoginRepository loginRepository = new LoginRepository();
	
	public List<users> LoginUserByEmailAndPassword(String email, String password) {
		List<users> listUser = new ArrayList<>();
		listUser = loginRepository.findUserByEmailAndPassWord(email, password);
		
		return listUser;
	}
}
