package crm_project_02.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_02.entity.Project;
import crm_project_02.service.ProjectService;

@WebServlet(name = "project", urlPatterns = { "/project", "/project-add" })
public class ProjectController extends HttpServlet {
	private ProjectService projectService = new ProjectService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		switch (path) {
		case "/project":
			List<Project> listProject = new ArrayList<>();
			listProject = projectService.getAllProject();
			req.setAttribute("listProject", listProject);
			req.getRequestDispatcher("project.jsp").forward(req, resp);
			break;
		case "/project-add":
			
			req.getRequestDispatcher("project-add.jsp").forward(req, resp);
			break;

		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		switch (path) {
		case "/project-add":
			String name = req.getParameter("name");
			String startDate = req.getParameter("startDate");
			String endDate = req.getParameter("endDate");
			
			boolean isSuccess = projectService.InsertProject(name, startDate, endDate);
			System.out.println(isSuccess + "projectController");
			req.getRequestDispatcher("project-add.jsp").forward(req, resp);
			break;

		default:
			break;
		}
		
	}

}
