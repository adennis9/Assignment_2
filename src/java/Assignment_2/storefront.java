/**
 *
 * @author Andrew
 */
package Assignment_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "storefront", urlPatterns = {"/storefront"})
public class storefront extends HttpServlet {

    String successMessage = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession mySession = request.getSession();
            
            Gameazon checkUser = (Gameazon)mySession.getAttribute("session");
            
            if (checkUser != null)
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Gameazon store</title>");
                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                out.println("</head>");
                out.println("<body>");
                out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
                out.println("<div id=\"container\">");
                out.println("<div id=\"main-content\">");
                out.println("<h1 align= \"center\">Hi, " + checkUser.getFirstName() + " " + checkUser.getLastName() + "</h1><br>");
                out.println("<p style= \"color:red\">" + successMessage + "</p>");
                out.println("<table>");
                out.println("<tr>");
                out.println("<th>Title</th>");
                out.println("<th>Price</th>");
                out.println("<th>Quantity</th>");
                out.println("<th></th>");
                out.println("</tr>"); // end tr
                out.println("<tr><form action= \"storefront\" method= \"post\" id= \"table\">");
                out.println("<td><img src=\"images/contra.jpg\"></td>");
                out.println("<input type=\"hidden\" value=\"contra.jpg\" name= \"image\">");
                out.println("<td>$49.99</td>");
                out.println("<input type= \"hidden\" value= \"49.99\" name= \"price\">");
                out.println("<td>");
                out.println("<select name=\"quantity\">");
                out.println("<option value=\"1\">1</option>");
                out.println("<option value=\"2\">2</option>");
                out.println("<option value=\"3\">3</option>");
                out.println("<option value=\"4\">4</option>");
                out.println("<option value=\"5\">5</option>");
                out.println("<option value=\"6\">6</option>");
                out.println("<option value=\"7\">7</option>");
                out.println("<option value=\"8\">8</option>");
                out.println("<option value=\"9\">9</option>");
                out.println("<option value=\"10\">10</option>");
                out.println("</select>"); // end select
                out.println("</td>"); // end form and td
                out.println("<td><input type=\"submit\" value=\"Add To Cart\"></td>");
                out.println("</form></tr>"); //end tr
                out.println("<tr><form action= \"storefront\" method= \"post\">");
                out.println("<td><img src=\"images/dd2.jpg\"></td>");
                out.println("<input type= \"hidden\" value= \"dd2.jpg\" name= \"image\">");
                out.println("<td>$39.99</td>");
                out.println("<input type= \"hidden\" value= \"39.99\" name = \"price\">");
                out.println("<td>");
                out.println("<select name=\"quantity\">");
                out.println("<option value=\"1\">1</option>");
                out.println("<option value=\"2\">2</option>");
                out.println("<option value=\"3\">3</option>");
                out.println("<option value=\"4\">4</option>");
                out.println("<option value=\"5\">5</option>");
                out.println("<option value=\"6\">6</option>");
                out.println("<option value=\"7\">7</option>");
                out.println("<option value=\"8\">8</option>");
                out.println("<option value=\"9\">9</option>");
                out.println("<option value=\"10\">10</option>");
                out.println("</select>"); // end select            
                out.println("</td>"); //end td
                out.println("<td><input type=\"submit\" value=\"Add To Cart\"></td>");
                out.println("</form></tr>"); //end form and tr
                out.println("<tr><form action= \"storefront\" method= \"post\" name= \"add\">");
                out.println("<td><img src=\"images/smw.jpg\"></td>");
                out.println("<input type= \"hidden\" value= \"smw.jpg\" name= \"image\">");
                out.println("<td>$59.99</td>");
                out.println("<input type= \"hidden\" value= \"59.99\" name= \"price\">");
                out.println("<td>");
                out.println("<select name=\"quantity\">");
                out.println("<option value=\"1\">1</option>");
                out.println("<option value=\"2\">2</option>");
                out.println("<option value=\"3\">3</option>");
                out.println("<option value=\"4\">4</option>");
                out.println("<option value=\"5\">5</option>");
                out.println("<option value=\"6\">6</option>");
                out.println("<option value=\"7\">7</option>");
                out.println("<option value=\"8\">8</option>");
                out.println("<option value=\"9\">9</option>");
                out.println("<option value=\"10\">10</option>");
                out.println("</select"); // end select            
                out.println("</td>"); //end td
                out.println("<td><input type=\"submit\" value=\"Add To Cart\"></td>");            
                out.println("</form></tr>");// end form and tr
                out.println("</table>"); // end table
                out.println("</div>"); // end main-content
                out.println("</div>"); // end container
                out.println("<div id=\"sidebar_cart\">");
                out.println("<div id=\"widget_cart\">");
                out.println("<a href=\"cart\"><h3>View Cart</h3></a>");
                out.println("</div>"); //end widget_cart
                out.println("<div id=\"widget_cart\">");
                out.println("<a href=\"order_history\"><h3>View Order History</h3></a>");
                out.println("</div>");//end widget_cart
                out.println("</div>"); //end sidebar_cart
                out.println("</body>");
                out.println("</html>");
                successMessage = "";
            }
            else
                response.sendRedirect("login");
        }
            
            
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
   {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) 
                {  
                    
                    String imageName = request.getParameter("image");
                    String q = request.getParameter("quantity");
                    float price = Float.valueOf(request.getParameter("price"));
                    int quantity = Integer.parseInt(request.getParameter("quantity"));
                    float total = (price * quantity);
                    DecimalFormat df = new DecimalFormat("###.##");
                    String formattedTotal = df.format(total);
                    
                    //out.println(imageName);
                    //out.println(quantity);
                    //out.println(price);

                    GameazonUserHashMap.checkoutHash.put(imageName, q);
                    
                   // for (String key : GameazonUserHashMap.checkoutHash.keySet())
                    //{
                       // out.println(key + " - " + GameazonUserHashMap.checkoutHash.get(key));
                      //  out.println("<br>");
                    //}
;                   
                    successMessage = "Item successfully added to the cart!";
                    doGet(request, response);
                }
   }

    @Override
    public String getServletInfo() 
    {
        return "Short description";
    }// </editor-fold>

}
