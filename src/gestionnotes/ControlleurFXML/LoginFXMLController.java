/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes.ControlleurFXML;

import gestionnotes.ConnexionBDD.DBConnexion;
import gestionnotes.GestionNotes;
import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



/**
 * FXML Controller class
 *
 * @author JOSEPH_POLA
 */
public class LoginFXMLController  {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button connection;
    @FXML
    private Label lbl_rouge;
    @FXML
    private CheckBox affpassword;
    @FXML
    private Label afpassword;
    @FXML
    private ProgressIndicator progressbar;
    
  
   
   
    //Initialisation du Label à false
    
    PreparedStatement ps=null;
    
    ResultSet rs=null;
    
    String sql="SELECT * FROM user WHERE user_name= ? AND pass_word= ?";
    // La Methode qui a permis de d'ouvrir et de fermer des fenetres
    public void actionTimer() throws IOException{
                        Parent  root = FXMLLoader.load(getClass().getResource("/gestionnotes/VueFXML/PrincipalFXML.fxml"));
                            Scene scene=new Scene(root);
                            Stage stage=new Stage();
                             stage.setScene(scene);
                             stage.setMaximized(true);                              Stage stages = (Stage) connection.getScene().getWindow();
                              stage.show();
                              stages.close();
                }
    public void loginConnexion(ActionEvent even){
                try {
            Connection cn=DBConnexion.connexion();
            ps=cn.prepareStatement(sql);
            ps.setString(1,username.getText());
            ps.setString(2,password.getText());
            rs=ps.executeQuery();
            if(rs.next()){
          
                lbl_rouge.setText(" ");
       
                progressbar.setVisible(true);
                
          
                // Declaration des timers
                Timer timer =new Timer();
               
                           
                 timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                       
                        Platform.runLater(()->{
                            try {
                                actionTimer();
                            } catch (IOException ex) {
                                Logger.getLogger(LoginFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }); //To change body of generated methods, choose Tools | Templates.
                    }
                }, 5000);
              
                        
            }else{
                lbl_rouge.setText("Erreur d'Authentification");
               
            }
        } catch (Exception e) {
            System.err.println("Erreur Authentification "+e.getMessage());
        }
           
        //timer.schedule(task,5000);
    }
    
   
    
    public void affichepassword(){
        if(affpassword.isSelected()){
            afpassword.setText(password.getText());
            password.setVisible(false);
            afpassword.setVisible(true);
            
        }else{
            password.setVisible(true);
            afpassword.setVisible(false);
        }
    }
   
    
}
