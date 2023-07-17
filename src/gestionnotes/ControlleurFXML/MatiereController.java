/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ControlleurFXML;

import gestionnotes.ConnexionBDD.DBConnexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


/**
 * FXML Controller class
 *
 * @author JOSEPH_POLA
 */
public class MatiereController {

    @FXML
        private TextField LibelleMatiere;
    @FXML
        private TextField CoefficientMatiere;
    String sql="INSERT INTO matiere values(?,?)";
    PreparedStatement ps=null;
     public void enregistrementMatiere(ActionEvent even){
         
         try {
             Connection con=DBConnexion.connexion();
             ps=con.prepareStatement(sql);
             ps.setString(1,LibelleMatiere.getText());
             ps.setString(2, CoefficientMatiere.getText());
             ps.executeUpdate();
             
             
         } catch (Exception e) {
             System.out.println("Erreur de d'insertion: "+e.getMessage());
         }
     }
}
