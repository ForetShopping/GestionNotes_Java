/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ControlleurFXML;

import gestionnotes.ConnexionBDD.DBConnexion;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author JOSEPH_POLA
 */
public class InsertEleveController   {

  @FXML
  ImageView imgEleve;
  @FXML
  private TextField PrenomEleve;
  @FXML
  private TextField NomEleve;
  @FXML
  private TextField PrenomPere;
  @FXML
  private TextField NomMere;
  @FXML
  private DatePicker DateNais;
  @FXML
  private ComboBox NiveauEtudeEleve;
  private String matricule;
  
  @FXML
  private Button ParcourirPhoto;
  private PreparedStatement ps=null;
 
  private String sql="Insert into eleve Values(?,?,?,?,?,?,?,?)";
  
     FileChooser fileChooser=new FileChooser();
      FileInputStream  fileInputStream;
      Image image;
      File file;
      
      
    
  // Chargement de l'image
    
  public void parcourirPhoto() throws FileNotFoundException{
   
      fileChooser.getExtensionFilters().addAll(
              new FileChooser.ExtensionFilter("Les images PNG", "*.png"),
              new FileChooser.ExtensionFilter("Les images JPEG", "*.jpeg"),
               new FileChooser.ExtensionFilter("Les images JPG", "*.jpg")
      );
     file=fileChooser.showOpenDialog((Stage)ParcourirPhoto.getScene().getWindow());
      fileChooser.setTitle("Choisissez une image");
      if(file != null){
          fileInputStream=new FileInputStream(file);
          image= new Image(fileInputStream);
          imgEleve.setImage(image);
          //imgEleve.setImage(file);
         // System.out.println(file);
      }
      
  }
  
  
  
  public void Enregistrement(ActionEvent even){
     matricule=  PrenomEleve.getText().substring(1,4)+NomEleve.getText().subSequence(2,5)+Math.floor(Math.random()+2);
      try {
           Connection cn=DBConnexion.connexion();
           ps=cn.prepareStatement(sql);
           ps.setString(1, matricule);
           ps.setString(2, PrenomEleve.getText());
           ps.setString(3, NomEleve.getText());
           ps.setString(4, PrenomPere.getText());
           ps.setString(5, NomMere.getText());
           ps.setString(6, DateNais.getValue().toString());
           ps.setString(7, NiveauEtudeEleve.getValue().toString());
           ps.setString(8,file.toString());
           ps.executeUpdate();
          // System.out.println("Insert OK");
      } catch (Exception e) {
          System.out.println("Erreur de connexion pour l'insertion "+e.getMessage());
      }
  }
  // Remplisssage du Combo pour le Niveau
  String listNiveau="select libelleNiveau from niveau";
  Statement st=null;
  ResultSet rs=null;
  public void remplirComboNiveau(MouseEvent even){
      NiveauEtudeEleve.getItems().clear();
      try {
          Connection c=DBConnexion.connexion();
          st=c.createStatement();
          rs=st.executeQuery(listNiveau);
          while(rs.next()){
              NiveauEtudeEleve.getItems().add(rs.getString("LibelleNiveau"));
      }
          
      } catch (Exception e) {
          System.err.println("Erreur de Connexion pour Ajout dans le combo "+e.getMessage());
      }
  }

  
}
