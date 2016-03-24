/**
 *
 * @author Andrew
 */
package Assignment_2;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.servlet.http.HttpSession;


@WebServlet(name = "cart", urlPatterns = {"/cart"})
public class cart extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            doPost(request, response);
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

            
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession mySession = request.getSession();
            
            Gameazon loggedIn = (Gameazon)mySession.getAttribute("session");
            
            if (loggedIn == null)
            {
                response.sendRedirect("login");
                return;
            }
            
            String userName = loggedIn.getUserName();
            
            Gameazon userCart = GameazonUserHashMap.userHashMap.get(userName);
            int quantity = 0;
            
            double total = 0;
            double completeTotal = 0;
            
            DecimalFormat df = new DecimalFormat("###.##");
            String formattedTotal = "";
            
            
            //out.println(loggedIn);

            
            if (request.getParameter("clearCart") != null)
                userCart.cartItems.clear();
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Gameazon Shopping Cart</title>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Press+Start+2P\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<div id=\"container\">");
            out.println("<div id=\"main-content\">");
            out.println("<h1>Hi, " + loggedIn.getFirstName() + " " + loggedIn.getLastName() + "</h1>");
            if (userCart.cartItems.isEmpty())
                out.println("<h2>Cart is empty!</h2>");
            if (!userCart.cartItems.isEmpty())
            {
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Title</th>");
                out.println("<th>Quantity</th>");
                out.println("<th>Total Price</th>");
                out.println("</tr>"); // end tr
            
            //out.println("<tr>");
                for (String key: userCart.cartItems.keySet())
                {
                    out.println("<tr>");
                    out.println("<td><img src=\"images/" + key  + "\"></td>" );
                    out.println("<td>" + userCart.cartItems.get(key) +  "</td>");
                    if (key.equals("contra.jpg"))
                    {
                        quantity = Integer.parseInt(userCart.cartItems.get(key));
                        total = (quantity * 49.99);

                        formattedTotal = df.format(total);
                    }
                    else if (key.equals("dd2.jpg"))
                    {
                        quantity = Integer.parseInt(userCart.cartItems.get(key));
                        total = (quantity * 39.99);
                        formattedTotal = df.format(total);

                    }
                    else if (key.equals("smw.jpg"))
                    {
                        quantity = Integer.parseInt(userCart.cartItems.get(key));
                        total = (quantity * 59.99);
                        formattedTotal = df.format(total);
                    
                    }
                    completeTotal += total;
                    out.println("<td>" + formattedTotal + "</td>");
                    out.println("</tr>");
                }
            
                //out.println("</tr>");
                out.println("</table>"); // end table
                }
            out.println("</div>"); // end main-content
            out.println("</div>"); // end container
            out.println("<div id=\"sidebar_purchase\">");
            out.println("<div id=\"widget_purchase\">");
            out.println("<h3>Subtotal: $" + df.format(completeTotal) +"</h3>");
            out.println("</div>"); // end widget_purchase
            out.println("<div id= \"widget_purchase\">");
            out.println("<h3 id= \"funds\">Funds: $" + df.format(userCart.getWallet()) +"</h3>");
            out.println("</div>");   
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"addfunds\" method=\"get\"><input type=\"submit\" value=\"Add Funds\"></form>");
            out.println("</div>");     
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"cart\"><input type=\"submit\" value=\"Clear Cart\" name= \"clearCart\"></form>");
            out.println("</div>"); // end widget_purchase            
            out.println("<div id=\"widget_purchase\">");
            out.println("<form action=\"checkout\" method= \"post\"><input type=\"submit\" value=\"Purchase\">");
            out.println("<input type= \"hidden\" value= \"" + completeTotal + "\" name= \"total\"></form>");
            out.println("</div>"); // end widget_purchase


 
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
