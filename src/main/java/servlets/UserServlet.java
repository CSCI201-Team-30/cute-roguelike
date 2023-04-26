package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import models.User;
import util.Database;

@WebServlet("/api/user")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public UserServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {}
	
	protected void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("application/json");
		System.out.println("Search Servlet Called");
		
		request.getCookies();
		
		int id = Integer.valueOf(request.getHeader("id"));
		User userInfo = Database.getUserInfo(id);
		String json = new Gson().toJson(userInfo);
		
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
}