package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    Connection con;
    
    public Connection Conexion(){
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto_ventas","root","");
            System.out.println("Conexion exitoso");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("EEROR"+e);
        }
        return con;
    }
    
    public static void main(String[] args){
        Conexion c = new Conexion();
        c.Conexion();
    }
}
