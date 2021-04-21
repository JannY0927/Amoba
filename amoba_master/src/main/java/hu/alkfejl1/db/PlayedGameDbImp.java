package hu.alkfejl1.db;

import hu.alkfejl1.model.PlayedGame;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class PlayedGameDbImp implements PlayedGameDb{

    private static final String SELECT_ALL_GAME = "SELECT * FROM GAMEPLAYED";
    private static final String INSERT_STEP = "INSERT INTO GAMEPLAYED(game_id,stepx,stepy,signValue) VALUES (?,?,?,?)";
    private static final String SELECT_GAME = "SELECT * FROM GAMEPLAYED where GAME_ID = ? order by step_id";
    private Properties properties = new Properties();
    private  String connectionUrl;

    public PlayedGameDbImp() {
        try {
            properties.load(getClass().getResourceAsStream("/application.properties"));
            connectionUrl = properties.getProperty("db.url"); // obtaining DB URL
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public List<PlayedGame> findall() {
        List<PlayedGame> result = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(connectionUrl);
             Statement stat = c.createStatement();
             ResultSet rs = stat.executeQuery(SELECT_ALL_GAME);
        )
            {
                while (rs.next()){
                    PlayedGame game = new PlayedGame();
                    game.setStepId(rs.getInt("STEP_ID"));
                    game.setGameId(rs.getInt("GAME_ID"));
                    game.setStepX(rs.getInt("STEPX"));
                    game.setStepY(rs.getInt("STEPX"));
                    game.setSignValue(rs.getString("SIGNVALUE"));
                }
            }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

    @Override
    public PlayedGame save(PlayedGame playedGame) {
        try (Connection c = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = c.prepareStatement(INSERT_STEP);) {
            statement.setInt(1,playedGame.getGameId());
            statement.setInt(2,playedGame.getStepX());
            statement.setInt(3,playedGame.getStepY());
            statement.setString(4,playedGame.getSignValue());

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) return null;

            statement.close();

        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
        return playedGame;
    }

    @Override
    public List<PlayedGame> select(int  gameId) {
        System.out.println("ides" + gameId);
        List<PlayedGame> result = new ArrayList<>();
        try (Connection c = DriverManager.getConnection(connectionUrl);
             PreparedStatement statement = c.prepareStatement(SELECT_GAME);

        ){
            statement.setInt(1,gameId);
            try (ResultSet rs = statement.executeQuery();){

                while (rs.next()) {
                    System.out.println();
                    PlayedGame game = new PlayedGame();
                    game.setStepId(rs.getInt("STEP_ID"));
                    game.setGameId(rs.getInt("GAME_ID"));
                    game.setStepX(rs.getInt("STEPX"));
                    game.setStepY(rs.getInt("STEPX"));
                    game.setSignValue(rs.getString("SIGNVALUE"));
                }

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }
        return result;
    }
}
