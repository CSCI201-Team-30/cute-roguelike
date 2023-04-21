package ratemycourse;


import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RegisterServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Connection conn = null;
    private PreparedStatement stmt = null;

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirm-password");

        if (name == null || name.isEmpty() || email == null || email.isEmpty() || password == null || password.isEmpty() || confirmPassword == null || confirmPassword.isEmpty()) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Please fill all fields.')</script>");
            out.println("<script>window.location.href='register.html';</script>");
            return;
        }

        if (!password.equals(confirmPassword)) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Passwords do not match')</script>");
            out.println("<script>window.location.href='register.html';</script>");
            return;
        }

        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/UserInformation?user=root&password=root");
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            stmt.executeUpdate();
            response.sendRedirect("login.html");
        } catch (ClassNotFoundException | SQLException e) {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Error adding user: " + e.getMessage() + "</h2></body></html>");
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
