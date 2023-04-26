package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.Course;
import models.Professor;
import models.Review;
import models.User;

// This database provides a set of simple functions that all the Servlets
// can use to get the data they need from out database.
public class Database {
	
	// You will have to set this yourself or get it as a user input.
	private static final String url = "jdbc:mysql://localhost/rmc?user=root&password=root";
	
	// Helper function for your convenience. It queries the SQL server
	// for a specified string and returns the result. You can edit or
	// delete this function if it's not useful.
	private static ResultSet querySQL(String statement) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url);
			PreparedStatement ps = conn.prepareStatement(statement);
			ResultSet rs = ps.executeQuery();
			return rs;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static Course getCourseInfo(int id) {
		Course result = new Course();
		// TODO: Query database to get the course with that ID and
		//       return its data.
		return result;
	}
	
	public static Professor getProfessorInfo(int id) {
		Professor result = new Professor();
		// TODO: Query database to get the professor with that ID and
		//       return its data, e.g. firstName, lastName, etc...
		return result;
	}
	
	public static Review getReviewInfo(int id) {
		Review result = new Review();
		// TODO: Query database to get the review with that ID and
		//       return its data, e.g. title, body, rating, etc...
		return result;
	}
	
	public static User getUserInfo(int id) {
		User result = new User();
		// TODO: Query database to get the user with that ID and
		//       return its data, e.g. name, ids of all his reviews.
		return result;
	}
	
	// Find results that the user searches for.
	public static List<Course> search(String query) {
		List<Course> result = new ArrayList<Course>();
		// TODO: Query database for any courses that the query whose course
		//       name, title, or professor matches the query. Add results
		//       to the "results" list.
		//       If search term is null, return all courses.
		return result;
	}

	
}
