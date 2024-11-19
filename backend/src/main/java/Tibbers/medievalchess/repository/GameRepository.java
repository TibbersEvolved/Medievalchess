package Tibbers.medievalchess.repository;

import Tibbers.medievalchess.model.Game;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class GameRepository {
    List<Game> activeGames = new ArrayList<>();

    public GameRepository() {
        startNewGame("Testgame","Johnni","Simon");
    }

    public UUID startNewGame(String gameName, String player1, String player2) {
       Game game = Game.newGame(gameName,player1,player2);
       activeGames.add(game);
       return game.getGameId();
    }

    public Game findGameById(UUID id) {
        List<Game> game = activeGames.stream()
                .filter(s -> s.getGameId().equals(id))
                .toList();
        return game.get(0);
    }

    private int getGameIndex(UUID id) {
        for(int i = 0; i < activeGames.size(); i++) {
            if(activeGames.get(i).getGameId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public List<Game> getAllGames() {
        return activeGames;
    }

    public void deleteGame(String id) {
        UUID uuid = UUID.fromString(id);
        activeGames.remove(getGameIndex(uuid));
    }
}
