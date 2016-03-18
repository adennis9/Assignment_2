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
import java.text.DecimalFormat;

/**
 *
 * @author Andrew
 */
@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gamazon Shopping Cart</title>"); 
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<h1 align=\"center\">Gamazon Shopping cart cleared!!</h1>");
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
            
        String image = request.getParameter("image");
        String stringPrice = request.getParameter("price");
        String stringQuantity = request.getParameter("quantity");
        float price = Float.valueOf(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        float total = (price * quantity);
        DecimalFormat df = new DecimalFormat("###.##");
        String formattedTotal = df.format(total);
       
        if (image == null || stringPrice == null || stringQuantity == null)
            doGet(request, response);
            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gameazon Shopping Cart</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<div id=\"container\">");
            out.println("<div id=\"main-content\">");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Title</th>");
            out.println("<th>Price</th>");
            out.println("<th>Quantity</th>");
            out.println("</tr>"); // end tr
            
            out.println("<tr>");
            out.println("<td><img src=\"" + image + "\"></td>");
            out.println("<td> $" + price + "</td>");
            out.println("<td>Quantity: " + quantity +"</td>");
            out.println("</tr>");
            out.println("</table>"); // end table
            out.println("</div>"); // end main-content
            out.println("</div>"); // end container
            out.println("<div id=\"sidebar_purchase\">");
            out.println("<div id=\"widget_purchase\">");
            
            
            out.println("<h3>Subtotal: $" + formattedTotal +"</h3>");
            out.println("</div>"); // end widget_purchase
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"checkout\"><input type=\"submit\" value=\"Purchase\"></form>");
            out.println("</div>"); // end widget_purchase
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"cart\"><input type=\"submit\" value=\"Clear Cart\"></form>");
            out.println("</div>"); // end widget_purchase
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"addfunds\" method=\"post\"><input type=\"submit\" value=\"Add Funds\"></form>");
            out.println("</div>");
            out.println("</div>"); // end sidebar_purchase
            out.println("</body>");
            out.println("</html>");
        }
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
