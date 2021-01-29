import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class ViewAllCustomer extends HttpServlet 
{

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
      PrintWriter out = response.getWriter();
        Connection con=mycon.MyConnection.getcon(); 
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewAllCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>Name</th><th>Email</th><th>MobileNo</th><th>Operation</th>");
                out.println("</tr>");                
              
        String fetch="select * from customer";
        try {
            PreparedStatement pst=con.prepareStatement(fetch);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {       out.println("<tr>");
                    out.println("<th>"+rs.getString("name")+"</th>");                                                
                     out.println("<th>"+rs.getString("email")+"</th>");      
                     out.println("<th>"+rs.getString("mobileno")+"</th>");
                     String email=rs.getString("email");
                     out.println("<th><a href='RemoveCustomer?emailid="+email+"'>Remove?</a></th>");
                      out.println("</tr>");
                    
            }
        } catch (Exception ex) 
        {
       out.println("exception handled "+ex);
        }
           
           out.println("</table>");
             out.println("<a href='AdminHome'>Back to Home</a>");
             out.println("<br>");
             out.println("<a href='index.html'>LogOut?</a>");
            out.println("</body>");
            out.println("</html>");      
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
