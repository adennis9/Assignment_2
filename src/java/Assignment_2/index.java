/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "index", urlPatterns = {"/index"})
public class index extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet index</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet index at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Welcome to Gameazon! Retro Gaming for the modern world</title>");
            out.println("<link rel=\"stylesheet\" href=\"main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<div id=\"container\">");
            out.println("<div id=\"main-content\">");
            out.println("<h1>Welcome to Gameazon!</h1>");
            out.println("<p>Feeling nostalgic for the games of your past? Want to rediscover the golden gaming titles of yesteryear? Need to experience classic arcade hits for the first time? Gameazon is the place to be! All the classic titles from the 80's and 90's are here, in stock, at the lowest prices around, guaranteed! Gameazon strives to preserve retro gaming for the modern world.</p>");
            out.println("</div>"); // end main-content
            out.println("<div id=\"sidebar\">");
            out.println("<div id=\"widget\">");
            out.println("<a href=\"login\"><h3>Login</h3></a>");
            out.println("</div>"); // end widget
            out.println("<div id=\"widget\">");
            out.println("<a href=\"register\"><h3>Register</h3></a>");
            out.println("</div>"); // end widget
            out.println("<div id=\"widget\">");
            out.println("<a href=\"storefront\"><h3>Browse our selection</h3>");
            out.println("</div>"); //end widget
            out.println("</div>"); // end sidebar
            
            
            
            out.println("</div>"); // end container
            out.println("</body>");
            out.println("</html>");
        }
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
