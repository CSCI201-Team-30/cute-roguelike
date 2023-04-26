package servlets;

import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ProjectLogin extends HttpServlet {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
    private PreparedStatement stmt = null;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email.isEmpty() || password.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Please fill all fields.')</script>");
            out.println("<script>window.location.href='ProjectLogin.html';</script>");
            return;
        }
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/PUI?user=root&password=root");
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                response.sendRedirect("project_main.html");
            } else {
                // User doesn't exist, show alert
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Invalid email or password.')</script>");
                out.println("<script>window.location.href='ProjectLogin.html';</script>");
            }
        } catch (ClassNotFoundException | SQLException e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Error logging in: " + e.getMessage() + "</h2></body></html>");
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.err.println("SQLException: " + e.getMessage());
            }
        }
    }

}
