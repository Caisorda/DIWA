/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package otherstuff;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final String user = "user";
    private final String password = "pwd";
 
    protected void doPost(HttpServletRequest request,
         HttpServletResponse response) throws ServletException, IOException 
{
 
        // get request parameters for userID and password
        String username = request.getParameter("username");
        String pwd = request.getParameter("pwd");
        System.out.println("whoa");
        if(username.equals(user)){
            Cookie loginCookie = new Cookie("user",user);
            //setting cookie to expiry in 30 mins
            loginCookie.setMaxAge(30*60);
            response.addCookie(loginCookie);
            response.sendRedirect("savedlocations.jsp");
        }else{
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/diwahomepage.html");
            PrintWriter out= response.getWriter();
            out.println("<font color=red>Either user name or password is wrong.</font>");
            rd.include(request, response);
        }
    }
}

