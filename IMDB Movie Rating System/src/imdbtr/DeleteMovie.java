package imdbtr;
import java.sql.*;
import java.io.IOException; 
import java.io.PrintWriter;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

// Import Database Connection Class file 
import imdbtr.DatabaseConnection; 

// Servlet Name 
@WebServlet("/DeleteMovie") 
public class DeleteMovie extends HttpServlet { 
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
			Statement st=con.createStatement();
			
//			PreparedStatement st = con.prepareStatement("delete from movies where movieid =?");
//			
//			PreparedStatement st1 = con.prepareStatement("delete from moviedesc where movieid = ?");
		//	PreparedStatement st2 = con.prepareStatement("delete from danceform where phoneno=?");

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 
			
			String movieid=request.getParameter("movieid");
			// Same for second parameter 
//			st.setString(1, request.getParameter("movieid"));  
			String query="call spdelmovies('"+movieid+"')";
	//		st.setString(2, request.getParameter("moviename"));
		//	st2.setString(1, request.getParameter("PhoneNo"));
//			st1.setString(1, request.getParameter("movieid"));  
		//	st1.setString(2, request.getParameter("moviename"));

			Statement stmt4=con.createStatement();
			ResultSet rs3;
			String a=request.getParameter("movieid");
			 rs3 = stmt4.executeQuery("Select name from movies where movieid ='"+a+"'");
			 //System.out.println(rs);
			 String passwordfinal = null;
			 while ( rs3.next() ) {
	                String password = rs3.getString("name");
	                passwordfinal=password;
			 }
			 System.out.println("password final="+passwordfinal);
if(passwordfinal==null) {
	PrintWriter out = response.getWriter(); 
	out.println("<html>"
			+ "<head>\r\n" + 
			"\r\n" + 
			"	<title>MOVIE RATING</title>\r\n" + 
			"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
			"</head><body>"
			+ "<form name= \"myForm\" action= \"DeleteMovie.jsp\" method =\"post\"><b><center>MOVIE ID OR MOVIE NAME DOESNT EXIST... Please ENTER VALID MOVIE ID</center> "
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
				"      alert('CLICK OK TO TRY AGAIN');\r\n" + 
				"      document.myForm.submit();\r\n" + 
				"    }" + 
			
				"    </script><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body></html>"); 

}
else {
			st.executeQuery(query);
			PrintWriter out = response.getWriter(); 
			out.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>MOVIE RATING</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"adminalter.jsp\" method =\"post\"><b><center>MOVIE SUCCESSFULLY DELETED</center> "
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
// Execute the insert command using executeUpdate() 
			// to make changes in database 
			
			//st2.executeUpdate();
			// Close all the connections 
			st.close();
			
			//st2.close();
			con.close(); 

			// Get a writer pointer 
			// to display the succesful result 
	
		} 
		catch (Exception e) { 
			System.out.println("Err");
			e.printStackTrace(); 
		} 
	} 
} 