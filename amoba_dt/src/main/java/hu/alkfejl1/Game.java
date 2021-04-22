package hu.alkfejl1;


import hu.alkfejl1.db.PlayedGameDb;
import hu.alkfejl1.db.PlayedGameDbImp;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Game {
    private Player player1;
    private Player player2;
    private String gameType;
    private String [][] table;
    private GridPane grid;
    private final int startTime = 120;
    private int timer = startTime;
    final int win=5;
    private boolean meWin = false;


    public boolean isMeWin() {
        return meWin;
    }

    public void theGame(){}
    private Player actPlayer;
    private Integer playTime;

    public Game(Player player1, Player player2, String gameType, GridPane grid) {
        this.player1 = player1;
        this.player2 = player2;
        this.gameType = gameType;
        this.table = new String[10][10];
        this.grid = grid;
    }


    public Player getPlayer2() {return player2;}

    public int getStartTime() {return startTime;}

    public Player getActPlayer() {
        return actPlayer;
    }

    public String getGameType() {
        return gameType;
    }

    public void setTimer(int timer) {
        this.timer = timer;
    }

    public void letsGame() {
/*        while (haveGameTime()||havePlayerTime()) {
            if (isWin()) {
                break;
            }
        }
        System.out.println("Nyertél");*/
        actPlayer = player1;


        //     if (gameType=="m11") {
        //        set
        //   }
    }

    public void setActPlayer(){
        if (actPlayer.equals(player1)) {
            actPlayer.setMyTime(startTime-timer-player1.getMyTime());
            actPlayer=player2;
        }
        else    {
            actPlayer.setMyTime(startTime-timer-player2.getMyTime());
            actPlayer=player1;
        }
    }

    public void takeMySign(int x, int y) throws InterruptedException {
        table[x][y] = actPlayer.getMySign();
        PlayedGameDb gpd = new PlayedGameDbImp();
        int maxGameId = gpd.maxGameId();
        gpd.insert(maxGameId,x,y,actPlayer.getMySign());
        if (isWin(actPlayer.getMySign())) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Nyert a " + actPlayer.getMySign() + " játékos");
            alert.showAndWait();


        }
        else
        if (actPlayer.equals(player1)) {
            actPlayer=player2;
        }
        else    {
            actPlayer=player1;
        }
        if (actPlayer.isMachine()) {
            int[] coordinata = new int[2];
            coordinata = TakeCpuSign();

            ((Button) getNodeFromGridPane(grid, coordinata[0],coordinata[1])).fire();
            gpd.insert(maxGameId,x,y,actPlayer.getMySign());
        }
    }


    public int[] TakeCpuSign(){
        ArrayList<int[]> indices = new ArrayList<int[]>();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                if (table[i][j] == null || table[i][j].isEmpty()) {
                    indices.add(new int[]{i, j});
                }
            }
        }

        Random rand = new Random();
        int ri = rand.nextInt(indices.size());
        int[] coordinata = new int[2];
        coordinata[0] = indices.get(ri)[0];
        coordinata[1] = indices.get(ri)[1];
        return coordinata;


    }

    public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public boolean haveGameTime() {
        return true;
    }

    public boolean havePlayerTime() {
        return true;
    }

    public boolean isWin(String mySign) {
        System.out.println("ujlepes: "+mySign);
        for (int i=0;i< table.length;i++) {
            for (int j=0;j< table.length;j++) {
                if (table[i][j] == mySign) {
                    if (!this.meWin) {
                        for (int down = 1; down < win; down++) {
                            System.out.println("Downindex i: " + (i) +"index j: " + (j) + "cikv" + down + " Table"+(table.length) + meWin);
                            if (i+down < table.length&&table[i+down][j] == mySign) {
                            }
                            else {
                                meWin = false;
                                break;
                            }
                            meWin = true;
                            System.out.println("Downindex i: " + (i) +"index j: " + (j) + "cikv" + down + " Table"+(table.length) + meWin);
                        }
                    }
                    if (!meWin) {
                        for (int right = 1; right < win ; right++) {
                            System.out.println("Rightindex i: " + (i) + "index j: " + (j) + "cikv" + right + " Table" + (table.length) + meWin);
                            if (j + right < table.length && table[i][j + right] == mySign) {
                            } else {
                                meWin = false;
                                break;
                            }
                            meWin = true;
                            System.out.println("Rightindex i: " + (i) + "index j: " + (j) + "cikv" + right + " Table" + (table.length) + meWin);
                        }
                    }
                    if (!meWin) {
                        for (int dl = 1; dl < win; dl++) {
                            System.out.println("dlindex i: " + (i) + "index j: " + (j) + "cikv" + dl + " Table" + (table.length) + meWin);
                            if (i + dl < table.length && j - dl >= 0 && table[i + dl][j - dl] == mySign) {
                            } else {
                                meWin = false;
                                break;
                            }
                            meWin = true;

                            System.out.println("dlindex i: " + (i) + "index j: " + (j) + "cikv" + dl + " Table" + (table.length) + meWin);
                        }
                    }

                    if (!meWin) {
                        for (int dr = 1; dr < win; dr++) {
                            System.out.println("drindex i: " + (i) + "index j: " + (j) + "cikv" + dr + " Table" + (table.length) + meWin);
                            if (i + dr < table.length && j + dr < table.length && table[i + dr][j + dr] == mySign) {
                            } else {
                                meWin = false;
                                break;
                            }
                            meWin = true;
                            System.out.println("drindex i: " + (i) + "index j: " + (j) + "cikv" + dr + " Table" + (table.length) + meWin);

                        }
                    }
                }
            }
        }
        System.out.println("vege: "+mySign);
        return meWin;
    }



    //public boolean

}