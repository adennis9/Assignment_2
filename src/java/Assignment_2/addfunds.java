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
import javax.servlet.http.HttpSession;


@WebServlet(name = "addfunds", urlPatterns = {"/addfunds"})
public class addfunds extends HttpServlet 
{
    String fundsAdded = "";
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            HttpSession mySession = request.getSession();
            
            Gameazon funds = (Gameazon)mySession.getAttribute("session");
            
            if (funds == null)
                response.sendRedirect("login");
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Add Funds</title>");
            out.println("<link rel=\"stylesheet\" href=\"main.css\">");     
            out.println("</head>");
            out.println("<body>");
            out.println("<a href=\"index\" title=\"Return to Home page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
            out.println("<h1 align=\"center\">Add Funds!</h1>");
            out.println("<form action=\"addfunds\" method= \"post\">");
            out.println("<label for=\"funds\">Funds to add:</label>");       
            out.println("<input type=\"text\" id=\"funds\" name=\"funds\">");
            out.println("<input type=\"submit\" value=\"Add Funds\">");
            out.println("</form>");
            out.println("<p style= \"color:red\" align= \"center\">" + fundsAdded + "</p>");
            out.println("<a href= \"cart\"><h3 align= \"center\">Return to cart</h3></a>");
            out.println("</body>");
            out.println("</html>");
            
            fundsAdded = "";
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
           
            //out.println("doPost!");                      
            String stringFunds = request.getParameter("funds");
            
            
            
            //out.println(stringFunds);
            //out.println(stringFunds.equals(""));
            float fundsToAdd = 0;
            
            //out.println(stringFunds);
           
            HttpSession mySession = request.getSession();
            
            Gameazon funds = (Gameazon)mySession.getAttribute("session");
            
            if (stringFunds.equals("") || funds.isFloat(stringFunds) == false || stringFunds == null)
            {
                fundsAdded = "No funds added!";
                doGet(request, response);
            }
            else
            {
                fundsToAdd = Float.valueOf(stringFunds);
                fundsAdded = "Amount of funds added: $" + stringFunds + " dollars!";                
            }
            

            
           funds.setWallet(fundsToAdd);
            
           mySession.setAttribute("session", funds);
            
           GameazonUserHashMap.userHashMap.put(funds.getUserName(), funds);
            
            doGet(request, response);
            
            
         
        }
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
