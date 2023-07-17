/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ControlleurFXML;

import gestionnotes.ConnexionBDD.DBConnexion;
import gestionnotes.ConnexionBDD.Eleves;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;











/**
 * FXML Controller class
 *
 * @author JOSEPH_POLA
 */
public class PrincipalController implements Initializable {

    @FXML
    private AnchorPane ContenuPricipal;
    
    // Déclaration des Variables pour affichage dans la table
    @FXML private TableView<Eleves> tableAffiche;
    @FXML private TableColumn<Eleves,String> matricule;
    @FXML private TableColumn<Eleves,String> nomEL;
    @FXML private TableColumn<Eleves,String> prenomEl;
    @FXML private TableColumn<Eleves,String> nomP;
    @FXML private TableColumn<Eleves,String> nomM;
    @FXML private TableColumn<Eleves,Date> dateNais;
    @FXML private TableColumn<Eleves,String> niveau;
    @FXML private TableColumn<Eleves,String> photo;
    public ObservableList<Eleves> listeEleves= FXCollections.observableArrayList();
    PreparedStatement ps;
    String sql="SELECT * FROM eleve";
    
    

    public void ajoutEnregistrementEleve(ActionEvent even) throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/InsertEleveFXML.fxml"));
        ContenuPricipal.getChildren().setAll(root);
    }
    
     public void ajoutEnregistrementNiveau(ActionEvent even) throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/NiveauFXML.fxml"));
        ContenuPricipal.getChildren().setAll(root);
    }
     
      public void ajoutEnregistrementMatiere(ActionEvent even) throws IOException{
        AnchorPane root=FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/MatiereFXML.fxml"));
        ContenuPricipal.getChildren().setAll(root);
    }
      public void notationEleve(ActionEvent even) throws IOException{
         
          AnchorPane root=FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/NotationFXML.fxml"));
        ContenuPricipal.getChildren().setAll(root);
        
      }
       
      public void affichagesEleves(ActionEvent even) throws IOException{
          /* 
          try {
              Connection cn=DBConnexion.connexion();
              ps=cn.prepareStatement(sql);
              ResultSet   rs=ps.executeQuery();
              while(rs.next()){
                  listeEleves.add(new Eleves(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getString(5), rs.getDate(6), rs.getString(7), rs.getString(8)));
              }
              cn.close();
          } catch (Exception e) {
              System.out.println("Erreur d'Insertion dans la Table: "+e.getMessage());
          }
          matricule.setCellValueFactory(new PropertyValueFactory<Eleves,String>(matricule));
           nomEL.setCellValueFactory(new PropertyValueFactory<Eleves,String>(nomEL.toString()));
            prenomEl.setCellValueFactory(new PropertyValueFactory<Eleves,String>(prenomEl.toString()));
             nomP.setCellValueFactory(new PropertyValueFactory<Eleves,String>(nomP.toString()));
              nomM.setCellValueFactory(new PropertyValueFactory<Eleves,String>(nomM.toString()));
               dateNais.setCellValueFactory(new PropertyValueFactory<Eleves,Date>(dateNais.toString()));
                niveau.setCellValueFactory(new PropertyValueFactory<Eleves,String>(niveau.toString()));
                photo.setCellValueFactory(new PropertyValueFactory<Eleves,String>(photo.toString()));
            tableAffiche.setItems(listeEleves);
            
            */
            AnchorPane root=FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/AfficheEleveFXML.fxml"));
            ContenuPricipal.getChildren().setAll(root);
            
      }
  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
      
    }
}
