<%-- 
    Document   : AddProduct
    Created on : Nov 26, 2019, 10:20:40 AM
    Author     : CLASSROOM01
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
     <form action="AddProductData" method="get">
            <hr>
            <center>
            <table border="1">
                <tr>
                    <th colspan="2">Add Product Here</th>
                </tr>
                  <tr>
                    <th>Product Code</th>
                    <th>
                <input type="text" name="pcode">
                    </th>
                </tr>
                <tr>
                    <th>Product Name</th>
                    <th>
                <input type="text" name="pname">
                    </th>
                </tr>
                <tr>                  
                 <th>Product description</th>
                    <th>
                <input type="text" name="pdesc">
                    </th>
                </tr>              
                          
                <tr>
          <th>Product Category</th>                 
          <th>
              <select name="pcat">
  <option value="automobile">automobile</option>
  <option value="furniture">furniture</option>
  <option value="computers">computers</option>
  <option value="grossery">grossery</option>
  <option value="hardware">hardware</option>
              </select>
          </th>
                </tr>
                  <tr>                  
                 <th>Product Price</th>
                    <th>
                <input type="text" name="pprice">
                    </th>
                </tr>                
                 <tr>
                    <th>
                        <input type="submit" name="sub" value="Add Product">
                    </th>
                    <th>
                        <input type="reset" name="res" value="Clear">
                    </th>
                </tr>
            </table>
                </center>
        </form>
        <a href="AdminHome">Back to Home</a>
    </body>
</html>
