/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package diseasedisgnosis;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class CN {
    
    public static Connection Connect()
    {
        Connection conn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            
            
//            String dbURL = "jdbc:sqlserver://127.0.0.1;database=DiseaseDetection;user=sa;password=letsbuild";
            String dbURL = "jdbc:sqlserver://104.238.86.136;database=DiseaseDetection;user=ddUser;password=ddP@$$";
            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                System.out.println("CONNECTED");
            }       
            else    
            {
                System.out.println("NOT CONNECTED");
            }
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CN.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CN.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            return conn;
        }
    }   
    
}
