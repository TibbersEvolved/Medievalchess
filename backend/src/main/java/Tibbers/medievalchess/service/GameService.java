package Tibbers.medievalchess.service;

import Tibbers.medievalchess.model.BuyOption;
import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.repository.GameDbRepository;
import Tibbers.medievalchess.repository.GameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class GameService {

    private List<BuyOption> buyOptionList;
    private GameRepository gameRepository;
    private GameDbRepository gameDbRepository;

    public GameService (GameRepository gameRepository, GameDbRepository gameDbRepository) {
        this.gameRepository = gameRepository;
        this.gameDbRepository = gameDbRepository;
        buyOptionList = seedBuyOptions();
    }

    public Boolean buyUnit(UUID id, int posX, int posY, String type, int playerId) {
        Game game = gameDbRepository.findById(id).get();
        Boolean result = game.buyUnit(posX, posY, type, playerId,buyOptionList);
        gameDbRepository.save(game);
        return result;
    }

    public void endGameTurn(UUID id) {
        Game game = gameDbRepository.findById(id).get();
        game.endTurn();
        gameDbRepository.save(game);
    }

    public boolean damagePiece(int x, int y, int xTo, int yTo, UUID gameId) {
        Game game = gameDbRepository.findById(gameId).get();
        Boolean result = game.attackUnit(x, y, xTo, yTo);
        gameDbRepository.save(game);
        return result;
    }

    public boolean movePiece(UUID id, int xFrom, int yFrom, int xTo, int yTo) {
        Game game = gameDbRepository.findById(id).get();
        Boolean result = game.moveUnit(xFrom, yFrom, xTo, yTo);
        gameDbRepository.save(game);
        return result;
    }

    private List<BuyOption> seedBuyOptions() {
        List<BuyOption> options = new ArrayList<>();
        options.add(new BuyOption(20,"archer"));
        options.add(new BuyOption(15,"torch"));
        options.add(new BuyOption(30,"knight"));
        return options;
    }
}
