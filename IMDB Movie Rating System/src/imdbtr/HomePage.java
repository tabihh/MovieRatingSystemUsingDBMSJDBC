package imdbtr;

import java.io.IOException; 
import java.io.PrintWriter; 
import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException; 
import javax.servlet.annotation.WebServlet; 
import javax.servlet.http.HttpServlet; 
import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 

// Import Database Connection Class file 
import imdbtr.DatabaseConnection; 

// Servlet Name 
@WebServlet("/HomePage") 
public class HomePage extends HttpServlet { 
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
		
			// Close all the connections 
			//st.close(); 
			String[][]moviedesc =new String[15][3];
		for(int i=0;i<15;i++)
		java.util.Arrays.fill(moviedesc[i], null);
			ResultSet rs;
			Statement stmt=con.createStatement();

			 rs = stmt.executeQuery("Select * from moviedesc");
			 System.out.println(rs);
		//	 String passwordfinal = null;
			 int i=0;
			 //System.out.println("beforewhile");
			 while ( rs.next() ) {
	                String movieid = rs.getString("movieid");
	             //   System.out.println("in while1");
	                String moviename = rs.getString("name");
	           //     System.out.println("in while2");

	                String rating = rs.getString("avgrating");
	               // System.out.println("in while3");

	                moviedesc[i][0]=movieid;
	              //  System.out.println("inwhile4");
	                moviedesc[i][1]=moviename;
	              //  System.out.println("inwhile5");
	               moviedesc[i][2]=rating;
	            //    System.out.println("inwhile6");
	                i++;
	               

	            //    passwordfinal=password;
			 }
		//	 moviedesc[0][0]="Movie ID \t Movie Name \t Rating";
			 
			 //System.out.println("after while");
//			 for(i=0;moviedesc[i][0]!=null;i++)
//			 {
//				 System.out.println(moviedesc[i][0]+"\t"+moviedesc[i][1]+"\t\t"+moviedesc[i][2]);
//			 }
			con.close(); 

			// Get a writer pointer 
			// to display the succesful result 
			String OutputStatement;
			OutputStatement="<html><body><head>\r\n" + 
					"	<title>VIEW TABLE</title>\r\n" + 
					"	<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
					"</head>"
					+ "<form name=\"myForm\" id=\"myForm\" action=\"AfterLogin.jsp\" method=\"POST\"> <center>\r\n" + 
					"	<div class=\"form-area\"><h2><font color=\"white\">Movie Ratings</font></h2><table border = 2px><tr><td> <font color=\"white\">Movie ID\t</font></td><td><font color=\"white\">Movie Name\t</font></td><td><font color=\"white\">Rating</font></td></tr>";
			for(i=0;moviedesc[i][0]!=null;i++)
				 {
					OutputStatement=OutputStatement+"<tr><td><font color=\"white\"><center>"+moviedesc[i][0]+"</center></font></td><td><font color=\"white\"><center>"+moviedesc[i][1]+"</center></font></td><td><font color=\"white\"><center>"+moviedesc[i][2]+"</center></font><td></tr>";
					
				 }
			OutputStatement=OutputStatement+"</table></center>\r\n" + 
					"	\r\n" + 
					"	\r\n" + 
					"\r\n" + 
					"	<!-- Add icon library -->\r\n" + 
					"<link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\r\n" + 
					"</body></form>"
					+ "<script>\r\n" + 
					"\r\n" + 
					"    var auto_refresh = setInterval(\r\n" + 
					"    function()\r\n" + 
					"    {\r\n" + 
					"    submitform();\r\n" + 
					"    }, 10000);\r\n" + 
					"\r\n" + 
					"    function submitform()\r\n" + 
					"    {\r\n" + 
					"      alert('CLICK OK TO GO BACK');\r\n" + 
					"      document.myForm.submit();\r\n" + 
					"    }\r\n" + 
					"    </script></html>";
		//	System.out.println(OutputStatement);
			PrintWriter out = response.getWriter(); 
			out.println(OutputStatement); 
				
		} 
		catch (Exception e)  {
			response.sendRedirect("HomePage8.jsp");
			System.out.println("err");
			e.printStackTrace(); 
		} 
	} 
} 
