

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonObject;

/**
 * Servlet implementation class AccountServlet
 */
@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Vector<Review> reviews = new Vector<>();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("username");
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			// the mysql address is temporarily used, should be updated later 
			conn = DriverManager.getConnection("jdbc:mysql://localhost/CSCI201Lab9?user=root&password=Guoshuangjia1$");
			st = conn.createStatement();
			rs = st.executeQuery("SELECT username, profname, coursename, title, body FROM Reviews WHERE username=" + username);
			while(rs.next()) {
				String className = rs.getString("className");
				String profName = rs.getString("profName");
				int rating = rs.getInt("Rating");
				String title = rs.getString("title");
				String body = rs.getString("body");
//				if(classNames.indexOf(className) == -1) {
//					classNames.add(className);
//				}
				reviews.add(new Review(className, profName, rating, title, body));
			}

		} catch (SQLException sqle){
			System.out.println (sqle.getMessage());
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (st != null) {
					st.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException sqle){
				System.out.println(sqle.getMessage());
			}
		}
		
		List<JsonObject> jsonList = new ArrayList<>();
		
		for(Review r : reviews) {
			JsonObject json = new JsonObject();
			json.addProperty("classname", r.getCourseName());
			json.addProperty("profname", r.getProfName());
			json.addProperty("rating", r.getRating());
			json.addProperty("title", r.getTitle());
			json.addProperty("body", r.getBody());
			jsonList.add(json);
		}
		PrintWriter out = response.getWriter();
		if(!reviews.isEmpty()) {
			out.print(jsonList.toString());
		}
		else {
			out.print("No result found");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
