/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLASSROOM01
 */
public class AddProductData extends HttpServlet {

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
       int code=Integer.parseInt(request.getParameter("pcode"));
       String name=request.getParameter("pname");
       String desc=request.getParameter("pdesc");
       String cat=request.getParameter("pcat");
       int price=Integer.parseInt(request.getParameter("pprice"));
       con=mycon.MyConnection.getcon();       
       String insert="insert into products values(?,?,?,?,?)";
        try 
        {
            PreparedStatement pst=con.prepareStatement(insert);
            pst.setInt(1, code);
            pst.setString(2, name);
            pst.setString(3, desc);
            pst.setString(4, cat);
            pst.setInt(5, price);
            int x=pst.executeUpdate();
            if(x!=0)
            {
                  out.println("<script>alert('Product Added')</script>");
                  out.println("<script>window.location.href ='AddProduct.jsp'</script>");
                
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
