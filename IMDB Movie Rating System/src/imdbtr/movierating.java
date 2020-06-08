package imdbtr;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

// Import Database Connection Class file 
import imdbtr.DatabaseConnection; 

// Servlet Name 
@WebServlet("/movierating") 
public class movierating extends HttpServlet { 
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
				.prepareStatement("insert into movierating values(?, ?, ?)"); 

			// For the first parameter, 
			// get the data using request object 
			// sets the data to st pointer 
			 

			// Same for second parameter 
			 if(UserName.finalusername==null)
			 {
				 PrintWriter out2 = response.getWriter(); 
					out2.println("<html>"
							+ "<head>\r\n" + 
							"\r\n" + 
							"	<title>MOVIE RATING</title>\r\n" + 
							"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
							"</head><body>"
							+ "<form name= \"myForm\" action= \"login3.jsp\" method =\"post\"><b><center>USER DIDNT LOGIN...PLEASE LOGIN</center> "
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
			 else {
				 
			 
			 String b=request.getParameter("mrating");
			 if(Integer.parseInt(b)<0 || Integer.parseInt(b)>10)
			 {
					PrintWriter out = response.getWriter(); 
					out.println("<html>"
							+ "<head>\r\n" + 
							"\r\n" + 
							"	<title>MOVIE RATING</title>\r\n" + 
							"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
							"</head><body>"
							+ "<form name= \"myForm\" action= \"dorating.jsp\" method =\"post\"><b><center>ENTER A VALID INTEGER VALUE BETWEEN 0-10</center> "
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
			st.setString(1, UserName.finalusername); 
			st.setString(2, request.getParameter("movieid")); 
			st.setString(3, request.getParameter("mrating")); 
			Statement stmt4=con.createStatement();
			ResultSet rs3;
			String a=request.getParameter("movieid");
			 rs3 = stmt4.executeQuery("Select name from movies where movieid ='"+a+"'");
			 //System.out.println(rs);
			 String namefinal = null;
			 while ( rs3.next() ) {
	                String name = rs3.getString("name");
	                namefinal=name;
			 }
			 //System.out.println("password final="+passwordfinal);
if(namefinal==null) {
	PrintWriter out = response.getWriter(); 
	out.println("<html>"
			+ "<head>\r\n" + 
			"\r\n" + 
			"	<title>MOVIE RATING</title>\r\n" + 
			"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
			"</head><body>"
			+ "<form name= \"myForm\" action= \"dorating.jsp\" method =\"post\"><b><center>MOVIE ID OR MOVIE NAME DOESNT EXIST... Please ENTER VALID MOVIE ID</center> "
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
			// Execute the insert command using executeUpdate() 
			// to make changes in database 
else
{
		try {
			x= st.executeUpdate(); 
		}catch(Exception e)
{
			PrintWriter out = response.getWriter(); 
			out.println("<html>"
					+ "<head>\r\n" + 
					"\r\n" + 
					"	<title>MOVIE RATING</title>\r\n" + 
					"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head><body>"
					+ "<form name= \"myForm\" action= \"dorating.jsp\" method =\"post\"><b><center>THE USER HAS ALREADY RATED THIS MOVIE</center> "
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
}			 }}
if(x==1)
{
	ResultSet rs;
	Statement stmt=con.createStatement();
String movieid=request.getParameter("movieid");
System.out.println("Before rs");
rs = stmt.executeQuery("Select rating from movierating where movieid='"+movieid+"'");
	// rs2= stmt.executeQuery("Select name from movies where movieid='"+movieid+"'");
	 int sumrating=0;
	 int count=0;
	 while ( rs.next() ) {
       
         String rating = rs.getString("rating");
  //       System.out.println("Insiders");
	 sumrating+=(Integer.valueOf(rating));
	 count++;
	// System.out.println("Insiders2");
	 }
	System.out.println("after rs");
	 DecimalFormat df = new DecimalFormat("0.0");
	 float finalrating=(float)sumrating/count;
	 String finalratingfinal=df.format(finalrating);
	PreparedStatement st2 = con 
			.prepareStatement("update moviedesc set avgrating = ? WHERE movieid=?");
	System.out.println("after ps");
	st2.setString(1, finalratingfinal); 

	st2.setString(2, movieid); 
//	st.setString(2, movienamefinal); 
System.out.println("after final");
	st2.executeUpdate();
	System.out.println("afterfinal 2");
	response.sendRedirect("AfterLogin.jsp");
	st2.close();
}	
			
			st.close(); 
			con.close(); 
			
			// Get a writer pointer 
			// to display the succesful result 
		
		}catch (Exception e) { 
				//response.sendRedirect("registration.jsp");
			System.out.println("err");
			e.printStackTrace(); 
		} 
	} 
} 
