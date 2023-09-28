package crm_project_02.service;

import java.util.ArrayList;
import java.util.List;

import crm_project_02.entity.Project;
import crm_project_02.repository.ProjectRepository;

public class ProjectService {
	private ProjectRepository projectRepository = new ProjectRepository();
	
	public List<Project> getAllProject() {
		
		List<Project> listProject = new ArrayList<>();
		listProject = projectRepository.findAll();
		
		return listProject;
	}

	public boolean InsertProject (String name, String startDate, String endDate) {
		
		boolean count = projectRepository.Insert(name, startDate, endDate);
		
		return count ;
	};

}
