package hu.alkfejl1.db;

import hu.alkfejl1.model.PlayedGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public interface PlayedGameDb {


    PlayedGame insert(PlayedGame playedGame);

    List<PlayedGame> select(int gameId);

    int maxGameId() throws ClassNotFoundException;

    void insert(int maxGameId, int x, int y, String mySign);
}
