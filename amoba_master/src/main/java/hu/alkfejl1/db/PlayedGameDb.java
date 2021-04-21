package hu.alkfejl1.db;

import hu.alkfejl1.model.PlayedGame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

public interface PlayedGameDb {

    List<PlayedGame> findall();
    PlayedGame save(PlayedGame playedGame);

    List<PlayedGame> select(int gameId);

}
