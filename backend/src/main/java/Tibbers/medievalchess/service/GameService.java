package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public UUID startNewGame(String gameName) {
        return gameRepository.startNewGame(gameName);
    }

    public Game getGameById(UUID id) {
        return gameRepository.findGameById(id);
    }

    public List<Game> getAllGames() {
        return gameRepository.getAllGames();
    }
}
