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
@WebServlet("/adminlogin") 
public class adminlogin extends HttpServlet { 
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

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 
			

			// Same for second parameter 
			String a=request.getParameter("adminname");
			String b=request.getParameter("adminpassword");
			PrintWriter out = response.getWriter();
if(a.equals("rayyantabih")&&b.equals("zaarasurru"))
{
	response.sendRedirect("adminalter.jsp");
//	out.println("<html><body><b>Successfully Inserted"
//			+ "</b>"
//			+ "<h1>success</h1></body></html>");
}else {
	
	PrintWriter out1 = response.getWriter(); 
	out1.println("<html>"
			+ "<head>\r\n" + 
			"\r\n" + 
			"	<title>MOVIE RATING</title>\r\n" + 
			"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
			"</head><body>"
			+ "<form name= \"myForm\" action= \"adminlogin.jsp\" method =\"post\"><b><center>WRONG ADMIN ID OR PASSWORD</center> "
				+ "</b>"
				+ "<form>"
				+ "\r\n"
				+ " <link rel=\\\"stylesheet\\\" href=\\\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\\\"></body>" + 
				"    <script>\r\n" + 
				"\r\n" + 
				"    var auto_refresh = setInterval(\r\n" + 
				"    function()\r\n" + 
				"    {\r\n" + 
				"    }, 5000);\r\n" + 
				"    submitform();\r\n"
				+ "function submitform()\r\n" + 
				"    {\r\n" + 
				"      alert('CLICK OK TO TRY AGAIN');\r\n" + 
				"      document.myForm.submit();\r\n" + 
				"    }" + 
			
				"  </script> </html>"); 

	
}
			// Close all the connections 

			// Get a writer pointer 
			// to display the succesful result 
		 
			
		} 
		catch (Exception e) { 
			System.out.println("Err");
			e.printStackTrace(); 
		} 
	} 
} 
