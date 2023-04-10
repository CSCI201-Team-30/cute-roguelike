import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/Colors")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String getColor(int r, int g, int b) {
		String color = "";
		color += makeHex(r);
		color += makeHex(g);
		color += makeHex(b);
		return color;
	}
	private String makeHex(int color) {
		String hexString = Integer.toHexString(color);		
		if (hexString.length() == 1) {
			hexString = "0" + hexString;
		}
		return hexString;
	}
	protected void service(HttpServletRequest request, 
	                      HttpServletResponse response) 
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>My Second Servlet</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>Color Table</h1>");
		out.println("<table>");
		out.println("<tr><th>Red</th>");
		out.println("<th>Green</th>");
		out.println("<th>Blue</th>");
		out.println("<th>Color</th></tr>");
		for (int red=0; red < 255; red+=50) {
			for (int green=0; green < 255; green+=50) {
				for (int blue=0; blue < 255; blue+=50) {
					out.println("<tr>");
					out.print("<td>" + red + "</td>");
					out.print("<td>" + green + "</td>");
					out.print("<td>" + blue + "</td>");
					String color = getColor(red, green, blue);
					out.print("<td style=\"background-color:#" + color + ";\">");
					out.print("</td>");
					out.println("</tr>");
				}
			}
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
	}
}
