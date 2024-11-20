package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.BuyOption;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private List<BuyOption> buyOptionList;
    private GameRepository gameRepository;

    public GameService (GameRepository gameRepository) {
        this.gameRepository = gameRepository;
        buyOptionList = seedBuyOptions();
    }

    public Boolean buyUnit(UUID id, int posX, int posY, String type, int playerId) {
        Game game = gameRepository.findGameById(id);
        return game.buyUnit(posX, posY, type, playerId,buyOptionList);
    }

    public void endGameTurn(UUID id) {
        gameRepository.findGameById(id).endTurn();
    }

    public boolean damagePiece(int x, int y, int xTo, int yTo, UUID gameId) {
        Game game = gameRepository.findGameById(gameId);
        return game.attackUnit(x, y, xTo, yTo);
    }

    public boolean movePiece(UUID id, int xFrom, int yFrom, int xTo, int yTo) {
        return gameRepository.findGameById(id).moveUnit(xFrom, yFrom, xTo, yTo);
    }

    private List<BuyOption> seedBuyOptions() {
        List<BuyOption> options = new ArrayList<>();
        options.add(new BuyOption(20,"archer"));
        options.add(new BuyOption(15,"torch"));
        options.add(new BuyOption(30,"knight"));
        return options;
    }
}
