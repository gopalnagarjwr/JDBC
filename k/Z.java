package k;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

@WebServlet("/link")
public class Z extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Z() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter out=response.getWriter();
		  try {
			  String driver="com.mysql.jdbc.Driver";
	      	   String url="jdbc:mysql://localhost:3306/student";
	      	   String user="root";
	      	   String pass="";
	      	   String quary="SELECT * FROM class;";
	      	     
	      	  Class.forName(driver);
	      	   
	      	   Connection con=DriverManager.getConnection(url,user,pass);
	      	   Statement stm=con.createStatement();
	      	       ResultSet ob= stm.executeQuery(quary);
	      	       out.println("Id "+"Name "+"Gmail");
	      	       while(ob.next()) {
	      	    	     out.println(ob.getInt(1)+" "+ob.getString(2)+" "+ob.getString(3));
	      	       }
	      	 
	      	      con.close();
	      	      
	         }
	         catch(Exception e) {
	      	   System.out.println(e);
	         }
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
