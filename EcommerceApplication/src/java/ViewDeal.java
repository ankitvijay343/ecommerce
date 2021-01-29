/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLASSROOM01
 */
public class ViewDeal extends HttpServlet {

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
      String scat=request.getParameter("scat");    
        Connection con=mycon.MyConnection.getcon(); 
         out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewAllCustomer</title>");            
            out.println("</head>");
            out.println("<body>");
             out.println("<a href='CustomerHome.jsp'>Back to Home</a>");
             out.println("<br>");
                out.println("<table border='1'>");
                out.println("<tr>");
                out.println("<th>code</th><th>name</th><th>description</th><th>category</th><th>price</th>");
                out.println("</tr>");                
              
        String fetch="select * from products where pcat=?";
        try {
            PreparedStatement pst=con.prepareStatement(fetch);
            pst.setString(1, scat);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {       out.println("<tr>");
                    out.println("<th>"+rs.getString("pcode")+"</th>");                                                
                     out.println("<th>"+rs.getString("pname")+"</th>"); 
                     out.println("<th>"+rs.getString("pdesc")+"</th>");
                     out.println("<th>"+rs.getString("pcat")+"</th>");
                     out.println("<th>"+rs.getString("price")+"</th>");
                      out.println("</tr>");                    
            }
        } catch (Exception ex) 
        {
       out.println("exception handled "+ex);
        }
           
           out.println("</table>");
               out.println("<a href=''>Add to Cart?</a><br>");
                  out.println("<a href=''>Buy Product</a><br>");
             out.println("<a href='index.html'>LogOut?</a><br>");
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
