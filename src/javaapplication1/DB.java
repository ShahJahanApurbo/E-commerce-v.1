package javaapplication1;
import com.mysql.cj.jdbc.ConnectionImpl;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public static ConnectionImpl dbconnect(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            ConnectionImpl conn=(ConnectionImpl) DriverManager.getConnection("jdbc:mysql://localhost:3306/e-commerce","root","");
            return conn;
        }
        catch(ClassNotFoundException | SQLException e2){
            System.out.println(e2);
            return null;
        }
    }
}