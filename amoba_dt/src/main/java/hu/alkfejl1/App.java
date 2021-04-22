package hu.alkfejl1;

import hu.alkfejl1.db.PlayedGameDb;
import hu.alkfejl1.db.PlayedGameDbImp;
import hu.alkfejl1.model.PlayedGame;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.xml.transform.sax.SAXSource;
import java.io.IOException;
import java.util.List;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        PlayedGameDb gpd = new PlayedGameDbImp();
      //  System.out.println(gpd);
        System.out.println("Jani" + gpd.select(1));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("amoba.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            scene.getStylesheets().add("/hu/alkfejl1/css/style.css");
            stage.setTitle("Amőba F3FU1M");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




    public static void main(String[] args) {
        launch();
    }

}