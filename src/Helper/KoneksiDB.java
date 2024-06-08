/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Helper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author ASUS Vivobook
 */
public class KoneksiDB {
    static Connection con;
    
    public static Connection getConnection(){
        if(con == null){
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db_medcheck","root","");
            System.out.print("berhasil");
            
        } catch (ClassNotFoundException ex) {
                System.err.println("Error");
        } catch (SQLException ex) {
                System.err.println("Err DB");;
        }
        }
        return con;
    }
}
