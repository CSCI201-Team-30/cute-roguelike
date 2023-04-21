import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;
    private Connection conn = null;
    
    @Override
    public void init() throws ServletException {
        // Initialize database connection
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/ProjectuserInformation?user=root&password=root");
        } catch (ClassNotFoundException | SQLException e) {
            throw new ServletException("Error initializing database connection: " + e.getMessage(), e);
        }
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        if (email == null || email.isEmpty() || password == null || password.isEmpty()) {
            // Display error message if either email or password is empty
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<script>alert('Please fill all fields.')</script>");
            out.println("<script>window.location.href='login.html';</script>");
            return;
        }
        
        try {
            // Check if the user exists in the database
            String query = "SELECT * FROM users WHERE email=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            
            if (rs.next()) {
                // User exists, redirect to the main page
                response.sendRedirect("main.html");
            } else {
                // User doesn't exist, show error message
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<script>alert('Invalid email or password.')</script>");
                out.println("<script>window.location.href='login.html';</script>");
            }
            
        } catch (SQLException e) {
            // Handle database errors
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<html><body><h2>Error logging in: " + e.getMessage() + "</h2></body></html>");
        }
    }
    
    @Override
    public void destroy() {
        // Close database connection
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                System.err.println("Error closing database connection: " + e.getMessage());
            }
        }
    }
}
