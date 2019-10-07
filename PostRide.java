

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/PostRide")
public class PostRide extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		Cookie ck[]=request.getCookies();  
        if(ck!=null){ 
        			
        	String name=ck[0].getValue();  
        	if(!name.equals("")||name!=null) {
        	request.getRequestDispatcher("postride.html").include(request, response);  
        }
        	}
        else{  
        	out.println("<script type=\"text/javascript\">");
    		out.println("alert('Login First');");
    		out.println("</script>");
    		out.flush();
    		request.getRequestDispatcher("index.html").forward(request, response);  
        }  
        out.close();
	}
}
