package mycon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection 
{
    static Connection con;
    public static Connection getcon()
    {
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ecomdata","root","root");
        } catch (Exception ex)
        {
            System.out.println("ex is "+ex);
        }
        return con;
    }
}
