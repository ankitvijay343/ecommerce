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
public class ViewCategory extends HttpServlet {

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
        out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ViewCategory</title>");            
            out.println("</head>");
            out.println("<body>");   
            out.println("<form action='ViewDeal'>");   
              out.println("<select name='scat'>");                            
        
                        /* TODO output your page here. You may use following sample code. */
            Connection con=mycon.MyConnection.getcon();
             String fetch="select distinct pcat from products";
        try {
            PreparedStatement pst=con.prepareStatement(fetch);
            ResultSet rs=pst.executeQuery();
            while(rs.next())
            {                                                    
                                                         
                    out.println("<option  value="+rs.getString("pcat")+">"+rs.getString("pcat")+"</option>");  
                    
            }
            } catch (Exception ex) 
        {
       out.println("exception handled "+ex);
        }
            
            out.println("</select>");
            out.println("<br>");
            out.println("<input type ='submit' name='sub' value='View prdoucts'>");
            out.println("</form>");   
            out.println("<a href='index.html'>Logout?</a>");   
            out.println("<br>");
            out.println("<a href='CustomerHome.jsp'>Back to Cutomer Home</a>");   
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
