import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateReviewServlet")
public class CreateReviewServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
	// JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/coursereviews"; // need to be updated as the database created

    // Database credentials
    static final String USERNAME = "root";
    static final String PASSWORD = "root";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Get the review data from the request parameters
        String courseName = request.getParameter("courseName");
        String profName = request.getParameter("profName");
        int rating = Integer.parseInt(request.getParameter("rating"));
        String headline = request.getParameter("headline");
        String body = request.getParameter("body");

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // Open a connection
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            // Create a prepared statement
            String sql = "INSERT INTO Reviews (courseName, profName, rating, headline, body) VALUES (?, ?, ?, ?, ?)";
            ps = conn.prepareStatement(sql);

            // Set the parameters of the prepared statement
            ps.setString(1, courseName);
            ps.setString(2, profName);
            ps.setInt(3, rating);
            ps.setString(4, headline);
            ps.setString(5, body); 

            // Execute the prepared statement
            int reviewCreated = ps.executeUpdate();

            // Check if the review was successfully created
            if (reviewCreated == 1) {
                // Write a success response
                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Review Created</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Review Created</h1>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Write an error response
                response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating review");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            // Handle exceptions
            ex.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error creating review: " + ex.getMessage());
        } finally {
            // Close the statement and connection
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
                response.sendRedirect("");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
