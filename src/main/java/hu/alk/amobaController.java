package hu.alk;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.InputMethodEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Line;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class amobaController implements Initializable {

    private Game theGame;

    public amobaController() {
    };

    @FXML
    public GridPane Grid01;
    @FXML
    public MenuItem m01;
    @FXML
    public MenuItem m02;
    @FXML
    public RadioMenuItem m11;
    @FXML
    public RadioMenuItem m12;
    @FXML
    public ToggleGroup type;
    @FXML
    public Label Sum1;

    @FXML
    public String getType() {
        return ((RadioMenuItem) type.getSelectedToggle()).getId();
    }

    @FXML
    public void setHumanvVsHuman(ActionEvent event) {
        Player player1 = new Player(false,"X");
        Player player2 = new Player(false,"O");
        startGame(player1,player2);

    }

    @FXML
    public void setHumanvVsCpu(ActionEvent event) {
        Player player1 = new Player(false,"X") ;
        Player player2 = new Player(true,"O") ;
        startGame(player1,player2);
        //töröljük a példányosításokat
        //töröljük a táblán a mezőket
        //példányosítunk két jétékost
        // majd a játék osztályt
        //meghívjuk a játékosztály játék methodusát
    }

    private void startGame(Player player1,Player player2) {
        clean();
        theGame = new Game(player1,player2,getType(), Grid01);
        theGame.letsGame();
        try {
            setGameTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clean() {
        List<Button> buttonList = new ArrayList<>();
        for (Node node : Grid01.getChildren()) {
            if (node instanceof Button){
                buttonList.add((Button)node);
                //    buttonList.get(0).getText();
            }
        }
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.set(i,buttonList.get(i)).setText("");
        }
    }



    @FXML
    public void handleButtonAction(ActionEvent event) throws InterruptedException {
        Button clickedButton = (Button) event.getSource();
        //    if (theGame.getGameType() =! )
        try {
            if (clickedButton.getText().isEmpty()) {
                clickedButton.setText(theGame.getActPlayer().getMySign());
                theGame.takeMySign(Grid01.getColumnIndex(clickedButton),Grid01.getRowIndex(clickedButton));
            }

        }catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Előszőr válasz játék típust a NewGame menü alatt");
            alert.showAndWait();;
        }

    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {
        System.out.println("Letsgo");
    }

    @FXML
    public void setGameTime() throws InterruptedException {
        theGame.getStartTime();
        System.out.println(theGame.getGameType());
        int i = theGame.getStartTime();
        theGame.setTimer(i);
        Sum1.setText(String.valueOf(i));
    }
};
