package k;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
@WebServlet("/g")
public class Y extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public Y() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    
		    int id=Integer.parseInt(request.getParameter("id"));
	        String name=request.getParameter("name");
	        String gmail=request.getParameter("gmail");
	        PrintWriter out=response.getWriter();
	        if(id==0||name.equals("")||gmail.equals("")) {
	        	 RequestDispatcher rd=request.getRequestDispatcher("h.html");
	      	       rd.include(request, response);
	        }
	        try {
	        	 String driver="com.mysql.jdbc.Driver";
		      	   String url="jdbc:mysql://localhost:3306/student";
		      	   String user="root";
		      	   String pass="";
		      	   String quary="INSERT INTO class (id,name,Gmail) VALUES(?, ?, ?)";
		      	     
		      	  Class.forName(driver);
		      	   
		      	   Connection con=DriverManager.getConnection(url,user,pass);
		      	   PreparedStatement pstm=con.prepareStatement(quary);
		      	   pstm.setInt(1,id);
		      	   pstm.setString(2, name);
		      	   pstm.setString(3, gmail);
		      	        pstm.executeUpdate();
		      	      con.close();
		      	     out.println("<br alert('Data submited')>");
		      	   out.println("<a href='link'> Show all data </a>");
		      	      
		         }
		         catch(Exception e) {
		      	   System.out.println(e);
		         }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
