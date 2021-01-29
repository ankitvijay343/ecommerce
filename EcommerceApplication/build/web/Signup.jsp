<%-- 
    Document   : Signup
    Created on : Nov 27, 2019, 10:07:28 AM
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
      <form action="Signupdata" method="get">
            <hr>
            <center>
            <table border="1">
                <tr>
                    <th colspan="2">Customer Registration  !...</th>
                </tr>
                  <tr>
                    <th>Name</th>
                    <th>
                <input type="text" name="uname">
                    </th>
                </tr>
                <tr>
                    <th>Email</th>
                    <th>
                <input type="text" name="uemail">
                    </th>
                </tr>
                <tr>
                    <th>Password</th>
                    <th>
                <input type="text" name="upass">
                    </th>
                </tr>  
                  <tr>
                    <th>MobileNo</th>
                    <th>
                <input type="text" name="umob">
                    </th>
                </tr>            
                 <tr>
                    <th>
                        <input type="submit" name="sub" value="Register">
                    </th>
                    <th>
                        <input type="reset" name="res">
                    </th>
                </tr>
            </table>
                </center>
        </form>
    </body>
</html>
