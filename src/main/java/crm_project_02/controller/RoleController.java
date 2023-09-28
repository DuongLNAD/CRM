package crm_project_02.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.Role;
import crm_project_02.service.RoleService;

@WebServlet(name = "addRole", urlPatterns = { "/role-add", "/role", "/role-delete" })
public class RoleController extends HttpServlet {

	private static final long serialVersionUID = -3488254760537683813L;
	private RoleService roleService = new RoleService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/role":
			List<Role> listRole = new ArrayList<Role>();

			listRole = roleService.getAllRole();

			req.setAttribute("listRole", listRole);
			req.getRequestDispatcher("role-table.jsp").forward(req, resp);
			break;

		case "/role-add":

			req.getRequestDispatcher("role-add.jsp").forward(req, resp);
			break;

		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();

		switch (path) {
		case "/role-add":
			String roleName = "";
			String desc = "";
			resp.setContentType("text/html; charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			roleName = req.getParameter("roleName");
			desc = req.getParameter("roleDesc");
			boolean isSuccess = roleService.addRole(roleName, desc);

			req.setAttribute("isSuccess", isSuccess);
			System.out.println("isSuccess la: " + isSuccess);
			req.getRequestDispatcher("role-add.jsp").forward(req, resp);
			break;
			
		

		default:
			break;
		}

	}
	
}
