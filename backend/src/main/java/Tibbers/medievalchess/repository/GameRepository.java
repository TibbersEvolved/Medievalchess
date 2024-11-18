package Tibbers.medievalchess.repository;

import Tibbers.medievalchess.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GameRepository {
    List<Game> activeGames = new ArrayList<>();

    public UUID startNewGame() {
       Game game = Game.newGame();
       activeGames.add(game);
       return game.getGameId();
    }

    public Game findGameById(UUID id) {
        List<Game> game = activeGames.stream()
                .filter(s -> s.getGameId() == id)
                .toList();
        return game.get(0);
    }
}
