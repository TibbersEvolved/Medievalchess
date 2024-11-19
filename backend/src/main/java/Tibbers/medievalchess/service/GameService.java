package Tibbers.medievalchess.service;

import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService (GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public void endGameTurn(UUID id){
        gameRepository.findGameById(id).endTurn();
    }
}
