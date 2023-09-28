package crm_project_02.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm_project_02.entity.users;
import crm_project_02.payload.response.BaseResponse;
import crm_project_02.service.LoginService;

@WebServlet(name = "LoginControllerApi", urlPatterns = "/api/login")
public class LoginControllerApi extends HttpServlet {
	private LoginService loginService = new LoginService();
	private static final long serialVersionUID = 1L;
	private Gson gson = new Gson();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BaseResponse baseResponse = new BaseResponse();
		PrintWriter out = resp.getWriter();
		List<users> listUser = new ArrayList<users>();
		
		resp.setContentType("application/json");
		resp.setCharacterEncoding("UTF-8");

		String email = req.getParameter("email");
		String password = req.getParameter("password");

		
		listUser = loginService.LoginUserByEmailAndPassword(email, password);
		if (listUser.size() > 0) {
			baseResponse.setData(true);
			baseResponse.setMassage("Login thành công");
			baseResponse.setStatusCode(200);
		} else {
			baseResponse.setData(false);
			baseResponse.setMassage("Login thất bại");
			baseResponse.setStatusCode(400);
		}

		String json = gson.toJson(baseResponse);

		out.print(json);
		out.flush();

	}

}
