package hu.alkfejl1;

import hu.alkfejl1.db.PlayedGameDb;
import hu.alkfejl1.db.PlayedGameDbImp;
import hu.alkfejl1.model.PlayedGame;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
import java.util.concurrent.TimeUnit;

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
    public MenuItem exit;
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
    public Menu load;


    @FXML
    public String getType() {
        return ((RadioMenuItem) type.getSelectedToggle()).getId();
    }


    //Beálltjuk a játékmódot. Különböző módon példányosítunk

    @FXML
    public void setHumanvVsHuman(ActionEvent event) throws ClassNotFoundException {
        Player player1 = new Player(false, "X");
        Player player2 = new Player(false, "O");
        startGame(player1, player2);

        PlayedGameDb gpd = new PlayedGameDbImp();
        gpd.insert(gpd.maxGameId()+1,0,0,null);

    }

    //Beálltjuk a játékmódot. Különböző módon példányosítunk
    @FXML
    public void setHumanvVsCpu(ActionEvent event) throws ClassNotFoundException {
        Player player1 = new Player(false, "X");
        Player player2 = new Player(true, "O");
        startGame(player1, player2);
        PlayedGameDb gpd = new PlayedGameDbImp();
        gpd.insert(gpd.maxGameId()+1,0,0,null);
    }

    //Játék és Timer indítás
    private void startGame(Player player1, Player player2) {
        clean();
        theGame = new Game(player1, player2, getType(), Grid01);
        theGame.letsGame();
        // Ide kell majd neked egy if hogya nem playerenkénti az idő akkor kell ezt csinálni.
        try {
            if (getType().equals("m11")){
                setGameTime(true);
                setPlayersTime(false);
            }
            else {
                setPlayersTime(true);
                setGameTime(false);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    //TÁblatér nullázás
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

    //Tábla esemlény kezelés
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


        }catch (NullPointerException | ClassNotFoundException e) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Előszőr válasz játék típust a NewGame menü alatt");
            alert.showAndWait();
        }

    }

    //A
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

    //Játékidő kezelés
    @FXML
    public void setGameTime(boolean isStarted) throws InterruptedException {
        gameTimer = new Timeline();
        if (isStarted) gameTimer.getKeyFrames().add(new KeyFrame(javafx.util.Duration.seconds(1), ae -> updateGameTimer()));
        gameTimer.setCycleCount(Timeline.INDEFINITE);
        gameTimeLeft = new SimpleObjectProperty<>();
        gameTimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()));
        if (isStarted) initializeTimer(Sum1,gameTimeLeft);
        gameTimer.playFromStart();
    }

    //Játékidő kezelés
    private void setPlayersTime(boolean isStarted) {
        player1Timer = new Timeline();
        player2Timer = new Timeline();
        if (isStarted) player1Timer.getKeyFrames().add(new KeyFrame(javafx.util.Duration.seconds(1), ae -> updatePlayerTimer()));
        player1Timer.setCycleCount(Timeline.INDEFINITE);
        player2Timer.setCycleCount(Timeline.INDEFINITE);
        player1TimeLeft = new SimpleObjectProperty<>();
        player1TimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()/2));
        player2TimeLeft = new SimpleObjectProperty<>();
        player2TimeLeft.set(java.time.Duration.ofSeconds(theGame.getStartTime()/2));
        if (isStarted) initializeTimer(player1Time,player1TimeLeft);
        if (isStarted) initializeTimer(player2Time,player2TimeLeft);
        player1Timer.playFromStart();
        player2Timer.playFromStart();
    }


    //Játékidő kezelés
    private void updateGameTimer() {
        gameTimeLeft.set(gameTimeLeft.get().minusSeconds(1));
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

    //Játékidő kezelés
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


    //Játékidő kezelés
    private static String getTimeStringFromDuration(Duration duration) {
        long seconds = duration.getSeconds();
        long absSeconds = Math.abs(seconds);
        String positive = String.format(
                "%02d:%02d",
                (absSeconds % 3600) / 60,
                absSeconds % 60);
        return positive;
    }
    @FXML
    public void onExit() {
        System.out.println("Exit");
        Platform.exit();
    }

    //Játék visszatöltés esemény kezelés
    @FXML
    public void playLoadGame(ActionEvent actionEvent) throws InterruptedException, ClassNotFoundException {
        clean();
        System.out.println("Load");
        int X;
        int Y;
        String sign;
        PlayedGameDb gpd = new PlayedGameDbImp();
        Player player1 = new Player(false, "X");
        Player player2 = new Player(false, "O");
        theGame = new Game(player1, player2, getType(), Grid01);
        List<PlayedGame> steps = new ArrayList<>();
        steps = gpd.select(gpd.maxGameId());
        for (int i=0;i< steps.size();i++) {
            X = steps.get(i).getStepX();
            Y = steps.get(i).getStepY();
            sign = steps.get(i).getSignValue();
            Button loadChoiceObj = (Button) theGame.getNodeFromGridPane(Grid01, X, Y);
            loadChoiceObj.setText(sign);
        }
    }

    public void loadwithid(ActionEvent actionEvent) {
    }
};
