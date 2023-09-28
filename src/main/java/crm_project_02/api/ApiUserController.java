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

import crm_project_02.entity.Role;
import crm_project_02.entity.users;
import crm_project_02.payload.response.BaseResponse;
import crm_project_02.service.UserService;

@WebServlet(name = "ApiUserController", urlPatterns = { "/api/user", "/api/user/delete", "/api/user/add",
		"/api/update-user" })
public class ApiUserController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();
	private Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		PrintWriter out = resp.getWriter();
		Gson gson = new Gson();

		BaseResponse baseResponse = new BaseResponse();

		switch (path) {
		case "/api/user":

			List<users> listUser = userService.getAllUser();

			BaseResponse response = new BaseResponse();
			response.setMassage("");
			response.setStatusCode(200);
			response.setData(listUser);
//			Chuyển list hoặc mảng về JSON;
			String listUser1 = gson.toJson(response);

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			out.print(listUser1);
			out.flush();
			break;
		case "/api/user/delete":

			int id = Integer.parseInt(req.getParameter("id"));

			boolean isDeleted = userService.deleteUser(id);
			baseResponse.setData(isDeleted);
			baseResponse.setMassage(isDeleted ? "Xoa thanh cong" : "Xoa that bai");
			baseResponse.setStatusCode(isDeleted ? 200 : 400);
			System.out.println("baseResp" + baseResponse.getMassage());
			String json = gson.toJson(baseResponse);

			out.print(json);
			out.flush();

			break;

		case "/api/user/add":
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			String fullname = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			int idRole = Integer.parseInt(req.getParameter("role"));

			boolean isSuccess = userService.insertUser(fullname, email, password, phone, idRole);

			baseResponse.setData(isSuccess);
			baseResponse.setMassage(isSuccess ? "Thêm thành công" : " Thêm thất bại");
			baseResponse.setStatusCode(isSuccess ? 200 : 400);

			String jsonAdd = gson.toJson(baseResponse);

			out.print(jsonAdd);
			out.flush();

		default:
			break;
		}

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		PrintWriter out = resp.getWriter();
		BaseResponse baseResponse = new BaseResponse();
		Gson gson = new Gson();
		switch (path) {
		case "/api/user/add":
			

			String fullName = req.getParameter("fullname");
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			String phone = req.getParameter("phone");
			int id_role = Integer.parseInt(req.getParameter("role"));

			boolean isSuccess = userService.insertUser(fullName, email, password, phone, id_role);

			baseResponse.setStatusCode(isSuccess ? 200 : 400);
			baseResponse.setMassage(isSuccess ? "Them thanh cong" : "Them that bai");
			baseResponse.setData(isSuccess);

			String json = gson.toJson(baseResponse);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			out.print(json);
			out.flush();

			break;

		case "/api/update-user":
			

			String firstName = req.getParameter("firstName");
			String lastName = req.getParameter("lastName");
			String userName = req.getParameter("userName");
			String id_role2 = req.getParameter("id_role");
			String id = req.getParameter("id");
			System.out.println(firstName + lastName +   " " + userName + " " +  id_role2 + "  " + id + " info update" );
			boolean isUpdate = userService.UpdateUser(firstName, lastName, userName, id_role2, id);
			baseResponse.setStatusCode(isUpdate ? 200 : 400);
			baseResponse.setMassage(isUpdate ? "OK" : "Failed");
			baseResponse.setData(isUpdate);

			String jsonPUT = gson.toJson(baseResponse);
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			out.print(jsonPUT);
			out.flush();
			System.out.println("update done");
			break;

		default:
			break;
		}
	}


}
