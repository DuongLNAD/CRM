package crm_project_02.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import crm_project_02.config.mysqlConfig;
import crm_project_02.entity.users;
import crm_project_02.service.LoginService;

/*package: 
 *  - Controller là nơi chứa toàn bộ file liên quan tới khai báo đường dẫn và xử lí.
 * 	- 
 * 
 * ---- Tính năng login: 
 * 		Bước 1: Lấy dữ liệu người dùng nhập vào ô email và ô password/
 * 		Bước 2: Viết một câu query kiểm tra email và password người dùng nhập vào 
 * 				có tồn tại trong database hay không
 * 		Bước 3: Dùng JDBC kết nối tới CDSL và truyền câu query ở bước 2 cho CSDL thực thi
 * 		Bước 4: Kiểm tra dữ liệu. Nếu có dữ liệu thì là dăng nhập thành công và ngược lại; 
 * 
 * */

@WebServlet(name = "LoginController", urlPatterns = { "/login" })
public class LoginController extends HttpServlet {

	private LoginService loginService = new LoginService();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		/*
		 * int maxAge = 2 * 60 * 60; Cookie cookie = new Cookie("hoten",
		 * URLEncoder.encode("Nguyễn  Van A", "UTF-8")); cookie.setMaxAge(maxAge);
		 * 
		 * Yeu cau client tao cookie resp.addCookie(cookie);
		 */

		req.getRequestDispatcher("login.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Load method post");
		/*
		 * String email = req.getParameter("email"); 
		 * String password = req.getParameter("password");
		 * 
		 * List<users> listUser = new ArrayList<users>(); listUser =
		 * loginService.LoginUserByEmailAndPassword(email, password); 
		 * if(listUser.size()> 0) { for (users users : listUser) { System.out.println(users.getEmail()); }
		 * }else { System.out.println("Login that bai"); }
		 * 
		 * req.getRequestDispatcher("index.jsp").forward(req, resp);
		 */

	}

}
