package crm_project_02.api;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import crm_project_02.entity.Role;
import crm_project_02.payload.response.BaseResponse;
import crm_project_02.service.RoleService;

@WebServlet(name = "ApiRoleController", urlPatterns = { "/api/role", "/api/role-delete","/api/role-update" })
public class ApiRoleController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	RoleService roleService = new RoleService();
	Gson gson = new Gson();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		
		if(path.equals("/api/role")) {
			List<Role> listRole = roleService.getAllRole();
			BaseResponse baseResponse = new BaseResponse();

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			baseResponse.setMassage("OK");
			baseResponse.setStatusCode(200);
			baseResponse.setData(listRole);

			String dataJson = gson.toJson(baseResponse);

			PrintWriter out = resp.getWriter();

			out.print(dataJson);
			out.flush();
		}
	

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		BaseResponse baseResponse = new BaseResponse();
		PrintWriter out = resp.getWriter();
		switch (path) {
		case "/api/role-delete":
			List<Role> listRole = roleService.getAllRole();
			

			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");

			int id = Integer.parseInt(req.getParameter("id"));

			boolean isDeleted = roleService.deleteRole(id);
			baseResponse.setData(isDeleted);
			baseResponse.setMassage(isDeleted ? "Xoá thành công" : "Xoá thất bại");
			baseResponse.setStatusCode(isDeleted ? 200 : 400);
			String dataJson = gson.toJson(baseResponse);
			
			out.print(dataJson);
			out.flush();
			break;
			
		case "/api/role-update":
			String name = req.getParameter("name");
			String desc = req.getParameter("desc");
			int idRole = Integer.parseInt(req.getParameter("id"));
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			
			boolean isUpdate = roleService.updateRole(idRole, name, desc);
			baseResponse.setData(isUpdate ? isUpdate : false);
			baseResponse.setMassage(isUpdate ? "Thành công" : "Thất bại");
			baseResponse.setStatusCode(isUpdate? 200 : 401);
	
			String dataupdate = gson.toJson(baseResponse);

			out.print(dataupdate);
			out.flush();
			break;

		default:
			break;
		}
		
	}
	


}
