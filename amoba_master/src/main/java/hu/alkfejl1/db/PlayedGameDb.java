package hu.alkfejl1.db;

import hu.alkfejl1.model.PlayedGame;

import java.util.List;

public interface PlayedGameDb {

    List<PlayedGame> findall();
    PlayedGame save(PlayedGame playedGame);

}
