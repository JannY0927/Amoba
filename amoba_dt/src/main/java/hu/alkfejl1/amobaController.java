package hu.alkfejl1;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Timer;

public class amobaController implements Initializable {

    private Game theGame;
    private Timeline gameTimer;
    private Timeline player1Timer;
    private Timeline player2Timer;
    private ObjectProperty<Duration> gameTimeLeft;
    private ObjectProperty<Duration> player1TimeLeft;
    private ObjectProperty<Duration> player2TimeLeft;

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
    public Label player1Time;
    @FXML
    public Label player2Time;

    @FXML
    public String getType() {
        return ((RadioMenuItem) type.getSelectedToggle()).getId();
    }

    @FXML
    public void setHumanvVsHuman(ActionEvent event) {
        Player player1 = new Player(false, "X");
        Player player2 = new Player(false, "O");
        startGame(player1, player2);

    }

    @FXML
    public void setHumanvVsCpu(ActionEvent event) {
        Player player1 = new Player(false, "X");
        Player player2 = new Player(true, "O");
        startGame(player1, player2);
        //töröljük a példányosításokat
        //töröljük a táblán a mezőket
        //példányosítunk két jétékost
        // majd a játék osztályt
        //meghívjuk a játékosztály játék methodusát
    }

    private void startGame(Player player1, Player player2) {
        clean();
        theGame = new Game(player1, player2, getType(), Grid01);
        theGame.letsGame();
        // Ide kell majd neked egy if hogya nem playerenkénti az idő akkor kell ezt csinálni.
        try {
            if (getType().equals("m11")) setGameTime();
            else setPlayersTime();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void clean() {
        List<Button> buttonList = new ArrayList<>();
        for (Node node : Grid01.getChildren()) {
            if (node instanceof Button) {
                buttonList.add((Button) node);
                //    buttonList.get(0).getText();
            }
        }
        for (int i = 0; i < buttonList.size(); i++) {
            buttonList.set(i, buttonList.get(i)).setText("");
        }
    }


    @FXML
    public void handleButtonAction(ActionEvent event) throws InterruptedException {
        Button clickedButton = (Button) event.getSource();
        //    if (theGame.getGameType() =! )
        try {
            if (theGame.isMeWin()) {
                clean();
                theGame = null;
            }
            if (clickedButton.getText().isEmpty()) {
                clickedButton.setText(theGame.getActPlayer().getMySign());
                theGame.takeMySign(Grid01.getColumnIndex(clickedButton),Grid01.getRowIndex(clickedButton));
            }


        }catch (NullPointerException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Előszőr válasz játék típust a NewGame menü alatt");
            alert.showAndWait();
        }

    }


    @FXML
    public void takeCPUSign() throws InterruptedException {
        //clickedButton.setText(theGame.getActPlayer().getMySign());
        int[]coordinata = new int[2];
        coordinata = theGame.TakeCpuSign();
        Button cpuChoiceObj = new Button();
        cpuChoiceObj = (Button) theGame.getNodeFromGridPane(Grid01, coordinata[0], coordinata[1]);
        cpuChoiceObj.setText(theGame.getPlayer2().getMySign());
    }


    @Override
    public void initialize (URL url, ResourceBundle rb) {
        System.out.println("Letsgo");
    }

    @FXML
    public void setGameTime() throws InterruptedException {
        gameTimer = new Timeline();
        gameTimer.getKeyFrames().add(new KeyFrame(javafx.util.Duration.seconds(1), ae -> updateGameTimer()));
        gameTimer.setCycleCount(Timeline.INDEFINITE);
        gameTimeLeft = new SimpleObjectProperty<>();
        gameTimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()));
        initializeTimer(Sum1,gameTimeLeft);
        gameTimer.playFromStart();
    }


    private void setPlayersTime() {
        player1Timer = new Timeline();
        player2Timer = new Timeline();
        player1Timer.getKeyFrames().add(new KeyFrame(javafx.util.Duration.seconds(1), ae -> updatePlayerTimer()));
        player1Timer.setCycleCount(Timeline.INDEFINITE);
        player2Timer.setCycleCount(Timeline.INDEFINITE);
        player1TimeLeft = new SimpleObjectProperty<>();
        player1TimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()/2));
        player2TimeLeft = new SimpleObjectProperty<>();
        player2TimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()/2));
        initializeTimer(player1Time,player1TimeLeft);
        initializeTimer(player2Time,player2TimeLeft);
        player1Timer.playFromStart();
        player2Timer.playFromStart();
    }



    private void updateGameTimer() {
        gameTimeLeft.set(gameTimeLeft.get().minusSeconds(1));
        // Ide kell egy figyelés, ha lejárt akkor dobjon hibát. Amit lekezel a program.
        if (gameTimeLeft.get() == Duration.ZERO ||theGame.isMeWin()){
            gameTimer.stop();
            if (gameTimeLeft.get() == Duration.ZERO) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Idő lejárt. A " + theGame.getActPlayer().getMySign() + " játékos vesztett.");
                alert.show();
                clean();
                theGame = null;
            }
        }
    }


    private void updatePlayerTimer() {
        if (theGame.getActPlayer() == theGame.getPlayer2())  player2TimeLeft.set(player2TimeLeft.get().minusSeconds(1));
        else player1TimeLeft.set(player1TimeLeft.get().minusSeconds(1));

        if (player1TimeLeft.get() == Duration.ZERO || player2TimeLeft.get() == Duration.ZERO || theGame.isMeWin()) {
            player1Timer.stop();
            player2Timer.stop();

            if (player1TimeLeft.get() == Duration.ZERO || player2TimeLeft.get() == Duration.ZERO ) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Idő lejárt. A " + theGame.getActPlayer().getMySign() + " játékos vesztett.");
                alert.show();
                clean();
                theGame = null;
            }
        }
    }



    public void initializeTimer(Label obj, ObjectProperty<Duration>  timelineleft) {
        obj.textProperty().bind(Bindings.createStringBinding(() -> getTimeStringFromDuration(timelineleft.get()), timelineleft));
    }

    private static String getTimeStringFromDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%02d:%02d",
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return positive;
    }


};
