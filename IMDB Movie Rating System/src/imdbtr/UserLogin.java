package imdbtr;
import java.sql.*;

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
import java.sql.Statement;

// Servlet Name 
@WebServlet("/UserLogin") 
public class UserLogin extends HttpServlet { 
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
			String a=request.getParameter("loginun");
			String b=request.getParameter("loginpass");
			
			Statement stmt=con.createStatement();
			ResultSet rs;
			
			 rs = stmt.executeQuery("Select password from registration where username ='"+a+"'");
			 System.out.println(rs);
			 String passwordfinal = null;
			 while ( rs.next() ) {
	                String password = rs.getString("password");
	                passwordfinal=password;
			 }
			 if(passwordfinal==null)
			 {
				 PrintWriter out2 = response.getWriter(); 
					out2.println("<html>"
							+ "<head>\r\n" + 
							"\r\n" + 
							"	<title>NO USER</title>\r\n"
							+ "<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
							"" + 
						
							"</head><body>"
							+ "<form name= \"myForm\" action= \"registration.jsp\" method =\"post\"><b><center>USERNAME DOESNT EXIST</center> "
								+ "</b>"
								+ "<form>"
								+ "\r\n"
								+ "<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body>" + 
								"    <script>\r\n" + 
								"\r\n" + 
								"    var auto_refresh = setInterval(\r\n" + 
								"    function()\r\n" + 
								"    {\r\n" + 
								"    },3000);\r\n" + 
								"    submitform();\r\n"
								+ "function submitform()\r\n" + 
								"    {\r\n" + 
								"      alert('CLICK OK TO REDIRECT TO REGISTER');\r\n" + 
								"      document.myForm.submit();\r\n" + 
								"    }</script>" + 
							
							"</html>"); 
							
			 }
			 
	//		PrintWriter out = response.getWriter();
//if(a.equals("zaarasurru")&&b.equals("rayyantabih"))
//{
//	response.sendRedirect("admindel.html");
//	out.println("<html><body><b>Successfully Inserted"
//			+ "</b>"
//			+ "<h1>success</h1></body></html>");
//}
			// Close all the connections 
System.out.println(passwordfinal);
			// Get a writer pointer 
			// to display the succesful result 
		if(b.equals(passwordfinal))
		{
			 UserName.finalusername = a;

			response.sendRedirect("AfterLogin.jsp");
		}
			else
				{PrintWriter out = response.getWriter(); 
				out.println("<html>"
						+ "<head>\r\n" + 
						"\r\n" + 
						"	<title>REGISTRATION</title>\r\n" + 
						"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
						"</head><body>"
						+ "<form name= \"myForm\" action= \"login3.jsp\" method =\"post\"><b><center>WRONG PASSWORD</center> "
							+ "</b>"
							+ "<form>"
							+ "\r\n"
							+ "<link rel=\\\"stylesheet\\\" href=\\\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\\\"></body>" + 
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
							"    }</script>" + 
						
							"  </html>"); 
						}
		
		
		} 
		catch (Exception e) { 
			System.out.println("Err");
			e.printStackTrace(); 
		} 
	} 
} 
