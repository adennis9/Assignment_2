/**
 *
 * @author Andrew
 */
package Assignment_2;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet(name = "checkout", urlPatterns = {"/checkout"})
public class checkout extends HttpServlet 
{
    String message = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            HttpSession mySession = request.getSession();

            
            Gameazon checkOut = (Gameazon)mySession.getAttribute("session");
            
            if (checkOut == null)
            {
                response.sendRedirect("login");
                return;
            }
            
            String total = "";
            float decrementTotal = 0;
            
            if (request.getParameter("total") != null)
            {
                total = request.getParameter("total");
                decrementTotal = Float.valueOf(total);
            }
            
            
            
            
            float currentWallet = checkOut.getWallet();
            
            if (decrementTotal == 0)
                message = "<a href= \"storefront\">No items in shopping cart!<br>click here to return to our storepage!</a>";
            
            else if (decrementTotal > currentWallet)
               message = "<a href= \"addfunds\">Not enough funds. Click here to add more!</a>";
           
            else
            {
                message = "<a href= \"storefront\">Transaction completed!<br>Click here to return to our store page!</a>";
                checkOut.decreaseWallet(decrementTotal);
                checkOut.cartItems.clear();
            }
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Transaction Complete</title>");
            out.println("<link rel=\"stylesheet\" href=\"main.css\">");
            out.println("<link href=\"https://fonts.googleapis.com/css?family=Press+Start+2P\" rel=\"stylesheet\" type=\"text/css\">");
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<h1 align=\"center\">" + message + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            doGet(request, response);
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
