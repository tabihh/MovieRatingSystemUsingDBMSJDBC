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
@WebServlet("/SMRating") 
public class SMRating extends HttpServlet { 
	private static final long serialVersionUID = 1L; 

	protected void doPost(HttpServletRequest request, 
HttpServletResponse response) 
		throws ServletException, IOException 
	{ 
		int x = 0;
		try { 

			// Initialize the database 
			Connection con = DatabaseConnection.initializeDatabase(); 
			Statement stmt4=con.createStatement();
			ResultSet rs3;
			String b;
			 String namefinal = null,movieidfinal=null;

			String a=request.getParameter("movieid");
			System.out.println("movieid="+a);
			if(a!="")
			 {
				rs3 = stmt4.executeQuery("Select name from movies where movieid ='"+a+"'");
			 
			 while ( rs3.next() ) {
	                String name = rs3.getString("name");
	                namefinal=name;
			 }
			 if(namefinal==null) {
					PrintWriter out = response.getWriter(); 
					out.println("<html>"
							+ "<head>\r\n" + 
							"\r\n" + 
							"	<title>MOVIE RATING</title>\r\n" + 
							"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
							"</head><body>"
							+ "<form name= \"myForm\" action= \"SMRating.jsp\" method =\"post\"><b><center>MOVIE ID  DOESNT EXIST... Please ENTER VALID MOVIE ID</center> "
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
			 else
			 {
				 ResultSet rs;
					Statement stmt=con.createStatement();
				String movieid=request.getParameter("movieid");
	//			System.out.println("Before rs");
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
				//	System.out.println("after rs");
					 DecimalFormat df = new DecimalFormat("0.0");
					 float finalrating=(float)sumrating/count;
					 String finalratingfinal=df.format(finalrating);
					 System.out.println("Before Output");
						String OutputStatement = "<html><body><head>\r\n" + 
								"	<title>VIEW TABLE</title>\r\n" + 
								"	<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
								"</head>"
								+ "<form name=\"myForm\" id=\"myForm\" action=\"AfterViewing.jsp\" method=\"POST\"> <center>\r\n" + 
								"	<div class=\"form-area\"><h2><font color=\"white\">Specific Movie Rating</font></h2>"
								+ "<table><tr><td> <font color=\"white\">Movie ID :"+movieid+"\t</font></td><td><font color=\"white\">whose Movie Name is \""+namefinal+"\"\t</font>"
								+ "</td><td><font color=\"white\"> Has Rating : "+finalratingfinal+" out of "+count+" ratings</font></td></tr>"+
								"</table></center>\r\n" + 
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
								"    </script></html>";;
								PrintWriter out = response.getWriter(); 
								out.println(OutputStatement); 
			 }
			 }//System.out.println(rs);
			else
			{ b=request.getParameter("moviename");
			 rs3 = stmt4.executeQuery("Select movieid from movies where name ='"+b+"'");
			 while ( rs3.next() ) {
	                String movieid = rs3.getString("movieid");
	                movieidfinal=movieid;
			 }
			 if(movieidfinal==null) {
					PrintWriter out = response.getWriter(); 
					out.println("<html>"
							+ "<head>\r\n" + 
							"\r\n" + 
							"	<title>MOVIE RATING</title>\r\n" + 
							"		<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
							"</head><body>"
							+ "<form name= \"myForm\" action= \"SMRating.jsp\" method =\"post\"><b><center>MOVIE NAME  DOESNT EXIST... Please ENTER VALID MOVIE ID</center> "
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
			 else
			 {
				 ResultSet rs;
					Statement stmt=con.createStatement();
				String moviename=request.getParameter("moviename");
				System.out.println("Before rs");
				System.out.println("moviename"+moviename);
				rs = stmt.executeQuery("Select rating from movierating where movieid='"+movieidfinal+"'");
					// rs2= stmt.executeQuery("Select name from movies where movieid='"+movieid+"'");
					 int sumrating=0;
					 int count=0;
					 while ( rs.next() ) {
				       
				         String rating = rs.getString("rating");
				  //       System.out.println("Insiders");
					 sumrating+=(Integer.valueOf(rating));
					 count++;
					System.out.println("Ratiing="+rating);
					 }
				//	System.out.println("after rs");
					 DecimalFormat df = new DecimalFormat("0.0");
					 float finalrating=(float)sumrating/count;
					 String finalratingfinal=df.format(finalrating);
					 System.out.println("Before Output");
						String OutputStatement = "<html><body><head>\r\n" + 
								"	<title>VIEW TABLE</title>\r\n" + 
								"	<link rel=\"stylesheet\" type=\"text/css\" href=\"rthomecss.css\">\r\n" + 
								"</head>"
								+ "<form name=\"myForm\" id=\"myForm\" action=\"AfterViewing.jsp\" method=\"POST\"> <center>\r\n" + 
								"	<div class=\"form-area\"><h2><font color=\"white\">Specific Movie Rating</font></h2>"
								+ "<table><tr><td> <font color=\"white\">Movie ID :"+movieidfinal+"\t</font></td><td><font color=\"white\">whose Movie Name is \""+moviename+"\"\t</font>"
								+ "</td><td><font color=\"white\"> Has Rating : "+finalratingfinal+" out of "+count+" ratings</font></td></tr>"+
								"</table></center>\r\n" + 
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
								"    </script></html>";;
								PrintWriter out = response.getWriter(); 
								out.println(OutputStatement); 
			 }

			}
			 
}catch(Exception e)
		{
	response.sendRedirect("SMRating.jsp");
		}
}
}