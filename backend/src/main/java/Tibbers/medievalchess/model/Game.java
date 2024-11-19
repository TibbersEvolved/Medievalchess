package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.King;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Keep;
import Tibbers.medievalchess.model.structure.Structure;
import Tibbers.medievalchess.model.structure.Town;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Game {
    private Tile[][] tiles;
    private UUID gameId;
    private String gameName;
    private int turn;
    private int playerTurn;
    private List<Player> playerList = new ArrayList<>();
    private List<Structure> structures = new ArrayList<>();


    public static Game newGame(String gameName, String player1, String player2) {
        Game game = new Game(gameName);
        game.turn = 0;
        game.playerTurn = 0;
        game.playerList.add(new Player(player1));
        game.playerList.get(0).setTurnId(0);
        game.playerList.add(new Player(player2));
        game.playerList.get(1).setTurnId(1);
        game.tiles = game.getDefaultGameSettings();
        return game;
    }

    public Game(String name) {
        this.gameId = UUID.randomUUID();
        this.gameName = name;
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
        structures.add(tiles[3][0].setStructure(new Keep(playerList.get(0))));
        structures.add(tiles[1][1].setStructure(new Town(playerList.get(0))));
        structures.add(tiles[6][1].setStructure(new Town(playerList.get(0))));
        structures.add(tiles[4][7].setStructure(new Keep(playerList.get(1))));
        structures.add(tiles[6][6].setStructure(new Town(playerList.get(1))));
        structures.add(tiles[1][6].setStructure(new Town(playerList.get(1))));
        tiles[3][0].setPiece(new King(playerList.get(0)));
        tiles[4][7].setPiece(new King(playerList.get(1)));
        return tiles;
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public Player getPlayer(int index) {
        return playerList.get(index);
    }

    public UUID getGameId() {
        return gameId;
    }

    public String getGameName() {
        return gameName;
    }

    public int getTurn() {
        return turn;
    }

    public Tile[][] getTiles() {
        return tiles;
    }
}
