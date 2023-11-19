package DBConnection;

import Annotation.MyFirstAnnotation;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {

    private String DbUrl;
   private String user;
   private String password;
   private static Connection connection;
   private static ConnectionDB connectionDB;
    private ConnectionDB(){
        DbUrl=System.getenv("url");
         user=System.getenv("user");
         password=System.getenv("password");
         createStatement();
    }
    private void createStatement(){
       try{
           connection=DriverManager.getConnection(DbUrl,user,password);
       }catch (Exception e){
           e.printStackTrace();
       }

    }
public static ConnectionDB getInstance(){
        if(connectionDB==null)
            connectionDB=new ConnectionDB();
      return connectionDB;
}
public  Connection Database(){
        return connection;
}

}
