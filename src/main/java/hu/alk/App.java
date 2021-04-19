package hu.alk;

import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import java.io.IOException;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        //    VBox root = (VBox) FXMLLoader.load(getClass().getClassLoader().getResource("sample.fxml"));

        FXMLLoader loader = new FXMLLoader(getClass().getResource("amoba.fxml"));
        try {
            Parent root = loader.load();
            Scene scene = new Scene(root, 600, 500);
            stage.setTitle("Amőba F3FU1M");
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void newGame () {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
    }

    public static void main(String[] args) {
        launch();
    }

}