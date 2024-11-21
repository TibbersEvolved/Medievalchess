package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.repository.GameDbRepository;
import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HostService {
    private GameRepository gameRepository;
    private GameDbRepository gameDbRepository;

    public HostService(GameRepository gameRepository, GameDbRepository gameDbRepository) {
        this.gameRepository = gameRepository;
        this.gameDbRepository = gameDbRepository;
    }

    public UUID startNewGame(String gameName, String player1, String player2) {
        Game game = Game.newGame(gameName,player1,player2);
        gameDbRepository.save(game);
        return game.getGameId();
    }

    public Game getGameById(UUID id) {
        Optional<Game> game = gameDbRepository.findById(id);
        if(game.isEmpty()){
            throw new RuntimeException();
        }
        return game.get();
    }

    public List<Game> getAllGames() {
        return gameDbRepository.findAll();
    }

    public void deleteGame(String id) {
        Game game = gameDbRepository.findById(UUID.fromString(id)).get();
        game.getTiles().stream().forEach(s -> s.setPiece(null));
        gameDbRepository.delete(game);
    }
}
