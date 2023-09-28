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
import crm_project_02.entity.users;
import crm_project_02.service.RoleService;
import crm_project_02.service.UserService;

@WebServlet(name = "userController", urlPatterns = {"/user-add", "/user"})
public class UserController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String path = req.getServletPath();
		
		switch (path) {
		case "/user":
			
			req.getRequestDispatcher("user-table.jsp").forward(req, resp);
			break;
			
		case "/user-add":
			List<Role> list = new ArrayList<>();
			resp.setContentType("text/html; charset=UTF-8");
			req.setCharacterEncoding("UTF-8");
			
			list = userService.getAllRole();
			req.setAttribute("listRole", list);
			
			req.getRequestDispatcher("user-add.jsp").forward(req, resp);
			break;

		default:
			break;
		}
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
//		CHuyển hướng lại trang add -user
		req.getRequestDispatcher("user-add.jsp").forward(req, resp);
	}
	
	}

