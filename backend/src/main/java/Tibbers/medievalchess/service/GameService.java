package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GameService {

    private GameRepository gameRepository;

    public GameService (GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Boolean buyUnit(UUID id, int posX, int posY, String type, int playerId) {
        Game game = gameRepository.findGameById(id);
        System.out.println("Type in service is: " + type);
        return game.buyUnit(posX, posY, type, playerId);
    }

    public void endGameTurn(UUID id) {
        gameRepository.findGameById(id).endTurn();
    }

    public boolean movePiece(UUID id, int xFrom, int yFrom, int xTo, int yTo) {
        return gameRepository.findGameById(id).moveUnit(xFrom, yFrom, xTo, yTo);
    }
}
