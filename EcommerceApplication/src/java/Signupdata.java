/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLASSROOM01
 */
public class Signupdata extends HttpServlet {

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
         Connection con;
       PrintWriter out = response.getWriter();
      String name=request.getParameter("uname");
      String email=request.getParameter("uemail");
       String pass=request.getParameter("upass");
       String mob=request.getParameter("umob");
       con=mycon.MyConnection.getcon();       
       String insert="insert into customer values(?,?,?,?)";
        try 
        {
            PreparedStatement pst=con.prepareStatement(insert);            
            pst.setString(1, name);
            pst.setString(2, email);
            pst.setString(3, pass);
            pst.setString(4, mob);            
            int x=pst.executeUpdate();
            if(x!=0)
            {
                  out.println("<script>alert('Registration Successful')</script>");
                  out.println("<script>window.location.href ='index.html'</script>");
                
             //   response.sendRedirect("AddProduct.jsp");
            }
        } catch (Exception ex)
        {
            System.out.println("ex handled");
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
