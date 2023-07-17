/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestionnotes;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author JOSEPH_POLA
 */
public class GestionNotes extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    

    @Override
    public void start(Stage primaryStage) throws Exception {
       Parent root= FXMLLoader.load(getClass().getResource("VueFXML/loginFXML.fxml"));
       Scene scene=new Scene(root);
        scene.getStylesheets().add("StyleCSS/stylesheet.css");
        scene.getStylesheets().add("StyleCSS/niveauStyle.css");
       primaryStage.setScene(scene);
       
       primaryStage.setTitle("Page de Connexion");
       primaryStage.show();
    }
}
