package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.structure.Keep;
import Tibbers.medievalchess.model.structure.Structure;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private Tile[][] tiles;
    private UUID gameId;
    private int turn;
    private int playerTurn;
    private List<Player> playerList = new ArrayList<>();
    private List<Structure> structures = new ArrayList<>();


    public static Game newGame() {
        Game game = new Game();
        game.turn = 0;
        game.playerTurn = 0;
        game.playerList.add(new Player());
        game.playerList.add(new Player());
        game.tiles = game.getDefaultGameSettings();
        return game;
    }

    public Game() {
        this.gameId = UUID.randomUUID();
    }

    public void endTurn() {
        turn += 1;
        playerTurn += 1;
        if (playerTurn == 2) {
            playerTurn = 0;
        }
        int gold = 0;
        for(int i = 0; i < structures.size(); i++) {
            gold += structures.get(i).getIncome(playerList.get(playerTurn));
        }
        playerList.get(playerTurn).gainIncome(gold);
    }


    private Tile[][] getDefaultGameSettings() {
        Tile[][] tiles = new Tile[8][8];
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                tiles[i][j] = new Tile();
            }
        }
        structures.add(tiles[0][4].setStructure(new Keep(playerList.get(0))));
        structures.add(tiles[7][5].setStructure(new Keep(playerList.get(1))));
        return tiles;
    }

    public Player getPlayer(int index) {
        return playerList.get(index);
    }

}