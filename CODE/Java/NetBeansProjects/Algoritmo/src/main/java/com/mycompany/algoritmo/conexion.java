
package com.mycompany.algoritmo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
    public static Connection getConexion(){
        String url = "jdbc:sqlserver://localhost:1433;database=Estudiantes;user=SA;password=30640838Cda$!1521;encrypt=true;trustServerCertificate=true";
        
        try{
            Connection c = DriverManager.getConnection(url);
            return c;
        }
        catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
