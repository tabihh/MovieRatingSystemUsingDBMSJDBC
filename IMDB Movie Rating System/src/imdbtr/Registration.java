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
@WebServlet("/Registration") 
public class Registration extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		int x = 0;
		try { 

			// Initialize the database 
			Connection con = DatabaseConnection.initializeDatabase(); 

			// Create a SQL query to insert data into demo table 
			// demo table consists of two columns, so two '?' is used 
			PreparedStatement st = con 
				.prepareStatement("insert into registration values(?, ?, ?)"); 

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 
			 

			// Same for second parameter 
			st.setString(1, request.getParameter("username")); 
			st.setString(2, request.getParameter("password")); 
			st.setString(3, request.getParameter("email")); 

			// Execute the insert command using executeUpdate() 
			// to make changes in database 
			//System.out.println("before update");
			try {
			x= st.executeUpdate(); 
			}catch(java.sql.SQLException e) {
				PrintWriter out = response.getWriter(); 
			out.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>REGISTRATION</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"login3.jsp\" method =\"post\"><b><center>User Already Exist... Please Login</center> "
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
						"      alert('CLICK OK TO REDIRECT TO LOGIN PAGE');\r\n" + 
						"      document.myForm.submit();\r\n" + 
						"    }" + 
					
						"    </script><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body></html>"); 
			}

			// Close all the connections 
			st.close(); 
			con.close(); 

			// Get a writer pointer 
			// to display the succesful result 
			
			if(x==1)
			{
				PrintWriter out = response.getWriter(); 
			out.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>REGISTRATION</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"login3.jsp\" method =\"post\"><b><center>Successfully Registered.. Please Login</center> "
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
						"      alert('CLICK OK TO REDIRECT TO LOGIN PAGE');\r\n" + 
						"      document.myForm.submit();\r\n" + 
						"    }" + 
					
						"    </script><link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\"></body></html>"); 
			//response.sendRedirect("login3.jsp");
			}
			
			
		} 
		catch (Exception e) { 
				response.sendRedirect("registration.jsp");
			System.out.println("err");
			e.printStackTrace(); 
		} 
	} 
} 
