package imdbtr;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement; 

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

// Import Database Connection Class file 
import imdbtr.DatabaseConnection; 

// Servlet Name 
@WebServlet("/AddMovie") 
public class AddMovie extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		try { 

			// Initialize the database 
			Connection con = DatabaseConnection.initializeDatabase(); 

			// Create a SQL query to insert data into demo table 
			// demo table consists of two columns, so two '?' is used 
			PreparedStatement st = con.prepareStatement("insert into movies values(?, ?)");
			
			PreparedStatement st1 = con.prepareStatement("insert into moviedesc(movieid,name) values(?, ?)");
		//	PreparedStatement st2 = con.prepareStatement("delete from danceform where phoneno=?");

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 
			

			// Same for second parameter 
			st.setString(1, request.getParameter("movieid"));  
			st.setString(2, request.getParameter("moviename"));
		//	st2.setString(1, request.getParameter("PhoneNo"));
			st1.setString(1, request.getParameter("movieid"));  
			st1.setString(2, request.getParameter("moviename"));



			// Execute the insert command using executeUpdate() 
			// to make changes in database 
		try {
			st.executeUpdate();
			st1.executeUpdate();
			PrintWriter out2 = response.getWriter(); 
			out2.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>MOVIE RATING</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"adminalter.jsp\" method =\"post\"><b><center>MOVIE Successfully Added</center> "
						+ "</b>"
						+ "<form>"
						+ "\r\n" + 
						"    <script>\r\n" + 
						"\r\n" + 
						"    var auto_refresh = setInterval(\r\n" + 
						"    function()\r\n" + 
						"    {\r\n" + 
						"    }, 3000);\r\n" + 
						"    submitform();\r\n"
						+ "function submitform()\r\n" + 
						"    {\r\n" + 
						"      alert('CLICK OK TO REDIRECT TO PREVIOUS PAGE');\r\n" + 
						"      document.myForm.submit();\r\n" + 
						"    }" + 
					
						"    </script><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body></html>"); 

		
			
		}catch(Exception e)
		{
			PrintWriter out = response.getWriter(); 
			out.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>MOVIE RATING</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"adminalter.jsp\" method =\"post\"><b><center>MOVIE ID ALREADY PRESENT...</center> "
						+ "</b>"
						+ "<form>"
						+ "\r\n" + 
						"    <script>\r\n" + 
						"\r\n" + 
						"    var auto_refresh = setInterval(\r\n" + 
						"    function()\r\n" + 
						"    {\r\n" + 
						"    }, 3000);\r\n" + 
						"    submitform();\r\n"
						+ "function submitform()\r\n" + 
						"    {\r\n" + 
						"      alert('CLICK OK TO REDIRECT TO PREVIOUS PAGE');\r\n" + 
						"      document.myForm.submit();\r\n" + 
						"    }" + 
					
						"    </script><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body></html>"); 

			
		}
			// Close all the connections 
			st.close();
			st1.close();
			//st2.close();
			con.close(); 

			// Get a writer pointer 
			// to display the succesful result 
		//PrintWriter out = response.getWriter(); 
//		PrintWriter out = response.getWriter(); 
//		out.println("<html><body><b>Successfully deleted"
//				+ "Press back button to go back"
//				+ "</b></body></html>"); 
		//response.sendRedirect("HomePage8.jsp");

		} 
		catch (Exception e) { 
			response.sendRedirect("AddMovie.jsp");
			System.out.println("Err");
			e.printStackTrace(); 
		} 
	} 
} 