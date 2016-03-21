/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package index;

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
@WebServlet(name = "order_history", urlPatterns = {"/order_history"})
public class order_history extends HttpServlet {

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
            out.println("<title>Servlet order_history</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet order_history at " + request.getContextPath() + "</h1>");
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
            out.println("<title>Gameazon Order History</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\"></a>");
            out.println("<div id=\"container\">");
            out.println("<div id=\"main-content\">");
            out.println("<h1>Order History</h1>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Title</th>");
            out.println("<th>Ordered By</th>");
            out.println("<th>Ordered By</th>");
            out.println("<th>Quantity Purchased</th>");
            out.println("<th>Date Purchased</th>");
            out.println("</tr>"); // end tr
            out.println("<tr>");
            out.println("<td><img src=\"images/dd2.jpg\"></td>");
            out.println("<td>Andrew Dennis</td>");
            out.println("<td>1</td>");
            out.println("<td>1/30/2016</td>");
            out.println("</tr>"); // end tr
            out.println("</table>");
            out.println("</div>"); // end main-content
            out.println("</div>"); // end container
            out.println("<div id=\"sidebar_history\">");
            out.println("<div id=\"widget_history\">");
            out.println("<a href=\"storefront\"><h3>Game Selection</h3>");
            out.println("</div>"); // end widget_history
            out.println("<div id=\"widget_history\">");
            out.println("<a href=\"cart\"><h3>View Cart</h3>");      
            out.println("</div>"); // end widget_history
            out.println("</div>"); // end sidebar_history
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
