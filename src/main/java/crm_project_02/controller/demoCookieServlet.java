package crm_project_02.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "demoControllerServlet", urlPatterns = {"/demo-cookie"})
public class demoCookieServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			// Lấy giá trị lưu trữ trong cookie
		 
		Cookie[] cookies = req.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("hoten")) {
				String nameCookie = cookie.getName();
				String value = cookie.getValue();
				System.out.println("ktra cookie  " + URLDecoder.decode(value));
			};
		}
	//	System.out.println("ktra cookie  " + nameCookie);
		
	}
}
