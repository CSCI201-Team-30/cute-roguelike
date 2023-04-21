package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.google.gson.Gson;

import models.Course;
import util.Database;

@WebServlet("/api/search")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public SearchServlet() {
		super();
	}
	
	public void init(ServletConfig config) throws ServletException {}
	
	protected void service(
		HttpServletRequest request,
		HttpServletResponse response
	) throws ServletException, IOException {
		response.setContentType("application/json");
		System.out.println("Search Servlet Called");
		
		String query = request.getHeader("query");
		List<Course> results = Database.search(query);
		System.out.println(results);
		String json = new Gson().toJson(results);
		System.out.println(json);
		
		PrintWriter pw = response.getWriter();
		pw.write(json);
		pw.flush();
		pw.close();
	}
}