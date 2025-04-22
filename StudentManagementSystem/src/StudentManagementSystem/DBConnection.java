package StudentManagementSystem;
//<YourStrong@Passw0rd>


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class DBConnection 
{
    private  static  final String url="jdbc:sqlserver://localhost:1433;databaseName=StudentDB;encrypt=true;trustServerCertificate=true";
    private static  final String user_name="SA";
    private static  final  String password="<YourStrong@Passw0rd>";

    private DBConnection() 
    {
      // Prevent instantiation - as there is no  need to create object for DBConnection as we use only cretaed static methods and varibales[DBConnection obj=DBConnection.connect();]

    }


    public static Connection connect() // it gets object of connection line  to handle easily connect() is just a userdefined method
    {
        Connection con=null;
        try
        {
          Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

           con= DriverManager.getConnection(url, user_name, password);
           System.out.println("✅ Connection Successful!");
          
         /*  Statement stmt=con.createStatement();
          ResultSet rs=stmt.executeQuery("Sel");
          while(rs.next())
          {
            System.out.println(rs.getInt("id"));
          rs.close();
          stmt.close();
          }*/

         

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return con;
        
    }
}