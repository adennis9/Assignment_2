/**
 * @author Andrew Dennis
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

@WebServlet(name = "register", urlPatterns = {"/register"})
public class register extends HttpServlet 
{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
            {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) 
                {
           
            
                    HttpSession mySession = request.getSession();

                    Gameazon loggedIn = (Gameazon)mySession.getAttribute("session");

                    if (loggedIn == null)
                    {
                        String firstName = request.getParameter("firstName");
                        String lastName = request.getParameter("lastName");
                        String userName = request.getParameter("userName");
                        String password = request.getParameter("password");
                        String email = request.getParameter("email");
                        String age = request.getParameter("age");

                        if (lastName == null || lastName.equals("") ||
                            firstName == null || firstName.equals("") ||
                            userName == null || userName.equals("") || 
                            password == null || password.equals("") ||
                            email == null || email.equals("") ||
                            age == null || age.equals(""))
                        {
                                out.println("<!DOCTYPE html>");
                                out.println("<html>");
                                out.println("<head>");
                                out.println("<title>Create a Gameazon Account</title>");
                                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                                out.println("</head>");
                                out.println("<body>");
                                out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
                                out.println("<div id=\"container\">");
                                out.println("<div id=\"main-content\">");
                                out.println("<h1>Sign up</h1>");
                                out.println("<form action =\"register\" method= \"post\" id= \"account\">");
                                out.println("<label for=\"first_name\">First Name</label>");
                                out.println("<input name= \"firstName\" type=\"text\" id=\"first_name\">");
                                out.println("<label for=\"last_name\">Last Name</label>");
                                out.println("<input name= \"lastName\" type=\"text\" id=\"last_name\">");
                                out.println("<label for=\"user_Name\">User Name</label>");
                                out.println("<input name= \"userName\" type= \"text\" id= \"user_Name\">");
                                out.println("<label for=\"email\">email</label>");
                                out.println("<input name= \"email\" type=\"email\" id=\"email\">");
                                out.println("<label for=\"password\">password</label>");
                                out.println("<input name= \"password\" type=\"password\" id=\"password\">");
                                out.println("<label>Age</label>");
                                out.println("<select name= \"age\" form= \"account\">");
                                out.println("<option value=\"18-24\">18-24</option>");
                                out.println("<option value=\"25-31\">25-31</option>");
                                out.println("<option value=\"32-38\">32-38</option>");
                                out.println("<option value=\"39+\">39+</option>");
                                out.println("</select>"); // end select
                                out.println("<input type=\"submit\" value=\"Create Account\">");
                                out.println("</form>"); //end form
                                out.println("</div>"); //end main-content
                                out.println("</div>"); // end container
                                out.println("</body>");
                                out.println("</html>");
                        }
                        else
                        {
                            Gameazon userSession = new Gameazon();

                            userSession.setFirstName(firstName);
                            userSession.setLastName(lastName);
                            userSession.setUserName(userName);
                            userSession.setPassword(password);
                            userSession.setEmail(email);
                            userSession.setAge(age);

                            mySession.setAttribute("session", userSession);
                            GameazonUserHashMap.userHashMap.put(lastName, userSession);

                            out.println("<!DOCTYPE html>");
                            out.println("<html>");
                            out.println("<head>");
                            out.println("<title>GOT USER ACCOUNT!</title>");
                            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                            out.println("</head>");
                            out.println("<body>");
                            out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
                            out.println("<div id=\"container\">");
                            out.println("<div id=\"main-content\">");
                            out.println("<h1>Thank you for registering!</h1>");
                            out.println("<br>");
                            out.println("<h2><a href=\"storefront\" title=\"Return to Home Page\">Click here to browse our selection!</a></h2>");
                            out.println("</div>"); //end main-content
                            out.println("</div>"); // end container
                            out.println("</body>");
                            out.println("</html>");
                                
                        }
                }
                else
                {
                    String firstName = loggedIn.getFirstName();
                    String lastName = loggedIn.getLastName();
                    
                    out.println("<!DOCTYPE html>");
                    out.println("<html>");
                    out.println("<head>");
                    out.println("<title>GOT USER ACCOUNT!</title>");
                    out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"main.css\">");
                    out.println("</head>");
                    out.println("<body>");
                    out.println("<a href=\"index\" title=\"Return to Home Page\" id=\"logo\"><img src=\"images/newlogo.png\" alt=\"Gameazon controller logo\"></a>");
                    out.println("<div id=\"container\">");
                    //out.println("<div id=\"main-content\">");
                    out.println("<h1>HI, " + firstName + " " + lastName + "! <br> You are already logged in!</h1>");
                    out.println("<br>");
                    out.println("<h2><a href=\"storefront\" title=\"Return to Home Page\">Click here to browse our selection!</a></h2>");
                    //out.println("</div>"); //end main-content
                    out.println("</div>"); // end container
                    out.println("</body>");
                    out.println("</html>");

                }
        }
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
   {
                response.setContentType("text/html;charset=UTF-8");
                try (PrintWriter out = response.getWriter()) 
                {
                      doGet(request, response);
                }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
