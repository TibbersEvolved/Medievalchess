package Tibbers.medievalchess.service;

import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }
}
