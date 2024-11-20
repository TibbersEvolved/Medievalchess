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
    private List<BuyOption> buyOptions;


    public static Game newGame(String gameName, String player1, String player2) {
        Game game = new Game(gameName);
        game.turn = 0;
        game.playerTurn = 0;
        game.playerList.add(new Player(player1));
        game.playerList.get(0).setTurnId(0);
        game.playerList.add(new Player(player2));
        game.playerList.get(1).setTurnId(1);
        game.tiles = game.getDefaultGameSettings();
        game.buyOptions = game.seedBuyOptions();
        game.resetPieceMovement();
        System.out.println(game.buyOptions.toString());
        System.out.println("Game hosted with id: " + game.getGameId());
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
        resetPieceMovement();
        playerList.get(playerTurn).gainIncome(gold);
    }

    public boolean buyUnit(int posX, int posY, String type, int playerId) {
        if(isTileRangeInvalid(posX,posY)) {
            return false;
        }
        Tile tile = tiles[posY][posX];
        if (tile.getStructure() == null) {
            return false;
        }
        if (tile.getPiece() != null) {
            return false;
        }
        if (tile.getStructure().getType() != "keep") {
            return false;
        }
        buyOptions.forEach(s -> System.out.println(s.getUnit()));
        Player player = getPlayer(playerId);
        BuyOption buyOpt = null;
        for(int i = 0; i < buyOptions.size(); i++){
            if(buyOptions.get(i).getUnit().equals(type)){
                buyOpt = buyOptions.get(i);
            }
        }
        System.out.println("buyOpt = " + buyOpt);
        if (player.spendGold(buyOpt.getCost())) {
            tile.setPiece(buyOpt.getPiece(player));
            return true;
        }
        return false;
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

    public boolean moveUnit (int startX, int startY, int targetX, int targetY) {
        if(isTileRangeInvalid(startX, startY) || isTileRangeInvalid(targetX, targetY)) {
            return false;
        }
        Tile targetTile = tiles[targetY][targetX];
        if(targetTile.getPiece() != null ) {
            return false;
        }
        Tile fromTile = tiles[startY][startX];
        if(fromTile.getPiece() == null){
            return false;
        }
        if(fromTile.getPiece().isActive() != 2) {
            return false;
        }
        int moveSpeed = fromTile.getPiece().getMovementSpeed();
        if(fromTile.getPiece().getMovementType() == "any") {
            if(Math.abs(startX-targetX) <= moveSpeed && Math.abs(startY-targetY) <= moveSpeed) {
                swapPiece(fromTile,targetTile);
                return true;
            }
        }
        if (fromTile.getPiece().getMovementType() == "straight"){
            if(startX == targetX && Math.abs(startY - targetY) <= moveSpeed){
                    swapPiece(fromTile,targetTile);
                    return true;
            }
            if (startY == targetY && Math.abs(startX - targetX) <= moveSpeed) {
                swapPiece(fromTile,targetTile);
                return true;
            }
        }
        return false;
    }

    private void swapPiece(Tile tileFrom, Tile tileTo) {
        Piece piece = tileFrom.getPiece();
        piece.setActive(1);
        tileFrom.setPiece(null);
        tileTo.setPiece(piece);
    }

    private List<BuyOption> seedBuyOptions() {
        List<BuyOption> options = new ArrayList<>();
        options.add(new BuyOption(20,"archer"));
        options.add(new BuyOption(15,"torch"));
        options.add(new BuyOption(30,"knight"));
        return options;
    }

    private boolean isTileRangeInvalid(int x, int y) {
        return (x < 0 || x > 7 || y < 0 || y > 7);
    }

    private void resetPieceMovement() {
        for(int i = 0; i < tiles.length; i++) {
            for(int j = 0; j < tiles[i].length; j++) {
                Piece p = tiles[i][j].getPiece();
                if (p != null) {
                    p.setActiveNewTurn(playerTurn);
                }
            }
        }
    }
}
