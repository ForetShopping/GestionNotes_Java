/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ConnexionBDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JOSEPH_POLA
 */
public class DBConnexion {
    private static String url ="jdbc:mysql://localhost:3306/pola?characterEncoding=utf8";
    private static String username="root";
    private static String password="";
    
    public static Connection connexion(){
        try {
             Class.forName("com.mysql.jdbc.Driver");
             Connection cn=DriverManager.getConnection(url, username, password);
             System.out.println("Bonne Connexion à la Base de données");
             return cn;
        } catch (ClassNotFoundException | SQLException e) {
            
            System.out.println("Erreur de Connexion à la base de donnée: "+e.getMessage());
        }
       return null;
    }
}
