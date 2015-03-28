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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Laptop
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/RegisterServlet"})
public class RegisterServlet extends HttpServlet {
    
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ahihi");
        DAO dao = DAO.getInstance();
        String firstname, lastname, username, password, confirmPassword;
        firstname = request.getParameter("fname");
        lastname = request.getParameter("lname");
        username = request.getParameter("username");
        password = request.getParameter("password");
        confirmPassword = request.getParameter("configpassword");
        if(firstname == null && lastname == null && username == null && password == null && confirmPassword == null){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
            PrintWriter out= response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Please fill up all fields');");
            out.println("location='index.jsp';");
            out.println("</script>");
            String data = firstname + " " + lastname + " " + username + " " + password + " " + confirmPassword;
            Cookie cookie = new Cookie("data",data);
            response.addCookie(cookie);
            rd.include(request, response);
        } else if(!password.equals(confirmPassword)){
            RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
            PrintWriter out= response.getWriter();
            out.println("<script type=\"text/javascript\">");
            out.println("alert('Make sure both passwords match');");
            out.println("location='index.jsp';");
            out.println("</script>");
            String data = firstname + " " + lastname + " " + username + " " + password + " " + confirmPassword;
            Cookie cookie = new Cookie("data",data);
            response.addCookie(cookie);
            rd.include(request, response);
        } else{
            if((dao.get(lastname, username)) != null){
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
                PrintWriter out= response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Username already taken. Choose another.');");
                out.println("location='index.jsp';");
                out.println("</script>");
                String data = firstname + " " + lastname + " " + username + " " + password + " " + confirmPassword;
                Cookie cookie = new Cookie("data",data);
                response.addCookie(cookie);
                rd.include(request, response);
            }
            else{
                
                dao.add("user", new User(firstname, lastname, username, password));
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/register.html");
                PrintWriter out= response.getWriter();
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Register successful');");
                out.println("location='index.jsp';");
                out.println("</script>");
                rd.include(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ahihi");
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
