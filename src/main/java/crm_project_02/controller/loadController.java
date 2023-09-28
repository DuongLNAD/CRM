package crm_project_02.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_02.entity.Role;
import crm_project_02.service.RoleService;

/**
 * Servlet implementation class loadController
 */
@WebServlet(name="LoadController", urlPatterns = "/load")
public class loadController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     private RoleService roleService = new RoleService(); 
   
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Role> listRole = new ArrayList<Role>();

		listRole = roleService.getAllRole();

		req.setAttribute("listRole", listRole);
		req.getRequestDispatcher("role-table.jsp").forward(req, resp);
	}



}
