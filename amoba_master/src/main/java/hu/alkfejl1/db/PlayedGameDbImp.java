package hu.alkfejl1.db;

import hu.alkfejl1.model.PlayedGame;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PlayedGameDbImp implements PlayedGameDb{

    private static final String SELECT_ALL_GAME = "SELECT * FROM GAMEPLAYED";
    private Properties properties = new Properties();
    private  String connectionUrl;

    public PlayedGameDbImp(String connection) {
        try {
            properties.load(getClass().getResourceAsStream("/application.properties"));
            connectionUrl = properties.getProperty("db.url");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public PlayedGameDbImp() {

    }

    @Override
    public List<PlayedGame> findall() {
        List<PlayedGame> result = new ArrayList<>();
        try (Connection c = DriverManager.getConnection("jdbc:sqlite:C:/fejlesztés/kotprogjava/Amoba/amoba_master/src/main/resources/gameplayed.db");
             Statement stat = c.createStatement();
             ResultSet rs = stat.executeQuery(SELECT_ALL_GAME);
        ) {while (rs.next()){
            PlayedGame game = new PlayedGame();
            System.out.println(rs.getInt("STEP_ID"));
            game.setStepId(rs.getInt("STEP_ID"));
            System.out.println(rs.getInt("GAME_ID"));
            game.setGameId(rs.getInt("GAME_ID"));
            game.setStepX(rs.getInt("STEPX"));
            game.setStepY(rs.getInt("STEPX"));
            game.setSignValue(rs.getString("SIGNVALUE"));
        }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public PlayedGame save(PlayedGame playedGame) {
        return null;
    }
}
