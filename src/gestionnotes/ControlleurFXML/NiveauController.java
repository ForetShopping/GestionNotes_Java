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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;



/**
 * FXML Controller class
 *
 * @author JOSEPH_POLA
 */
public class NiveauController {

    @FXML
    private ComboBox CycleNiveau;
    
    
    @FXML
    private TextField LibelleNiveau;
    
    PreparedStatement ps=null;
    //String sql="";
    
    public void RemplirComboCycleNiveau(MouseEvent even){
        CycleNiveau.getItems().removeAll(CycleNiveau.getItems());
        CycleNiveau.getItems().addAll(" ","Maternelle","Primaire","Collège","Lycée");
        CycleNiveau.getSelectionModel().selectFirst();
    }
    
      
      
    public void enregistrementNiveau(ActionEvent even){
        try {
            Connection cn=DBConnexion.connexion();
            ps=cn.prepareStatement("INSERT INTO niveau values(?,?)");
            ps.setString(1,LibelleNiveau.getText() );
            ps.setString(2,CycleNiveau.getValue().toString());
            ps.executeUpdate();
           
        } catch (Exception e) {
            System.err.println("Erreur d'Enregistrement: "+e.getMessage());
        }
    }
}
