package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.King;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Keep;
import Tibbers.medievalchess.model.structure.Structure;
import Tibbers.medievalchess.model.structure.Town;
import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.SourceType;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Entity
public class Game {


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<Tile> tiles = new ArrayList<>();
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID gameId;
    private String gameName;
    private int turn;
    private int playerTurn;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<Player> playerList = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "game")
    private List<Structure> structures = new ArrayList<>();

    public Game() {
    }


    public static Game newGame(String gameName, String player1, String player2) {
        Game game = new Game(gameName);
        game.turn = 0;
        game.playerTurn = 0;
        game.playerList.add(new Player(player1,game));
        game.playerList.get(0).setTurnId(0);
        game.playerList.add(new Player(player2,game));
        game.playerList.get(1).setTurnId(1);
        game.tiles = game.generateBoard();
        game.generateDefaultUnits();
        game.resetPieceMovement();
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

    public boolean buyUnit(int posX, int posY, String type, int playerId, List<BuyOption> buyOptions) {
        if(isTileRangeInvalid(posX,posY)) {
            return false;
        }
        Tile tile = tileAt(posX,posY);
        if (tile.getStructure() == null) {
            return false;
        }
        if (tile.getPiece() != null) {
            return false;
        }
        if (tile.getStructure().getType().equals("keep") == false) {
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


    private List<Tile> generateBoard() {
        List<Tile> defTiles = new ArrayList<>();
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                defTiles.add(new Tile(j,i,this));
            }
        }
        return defTiles;
    }


    private void generateDefaultUnits() {
        tileAt(0,3).setPiece(King.build(getPlayer(0)));
        structures.add(tileAt(0,3).setStructure(Structure.buildKeep(getPlayer(0))));
        structures.add(tileAt(1,4).setStructure(Structure.buildKeep(getPlayer(0))));
        structures.add(tileAt(1,1).setStructure(Structure.buildTown(getPlayer(0))));
        structures.add(tileAt(1,6).setStructure(Structure.buildTown(getPlayer(0))));
        tileAt(7,4).setPiece(King.build(getPlayer(1)));
        structures.add(tileAt(7,4).setStructure(Structure.buildKeep(getPlayer(1))));
        structures.add(tileAt(6,3).setStructure(Structure.buildKeep(getPlayer(1))));
        structures.add(tileAt(6,1).setStructure(Structure.buildTown(getPlayer(1))));
        structures.add(tileAt(6,6).setStructure(Structure.buildTown(getPlayer(1))));
    }

    public int getPlayerTurn() {
        return playerTurn;
    }

    public Player getPlayer(int index) {
        return playerList.stream().filter(player -> player.getTurnId() == index)
                .findFirst().get();
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

    public List<Tile> getTiles() {
        return tiles;
    }

    public boolean moveUnit (int startX, int startY, int targetX, int targetY) {
        if(isTileRangeInvalid(startX, startY) || isTileRangeInvalid(targetX, targetY)) {
            return false;
        }
        Tile targetTile = tileAt(targetX,targetY);
        if(targetTile.getPiece() != null ) {

            return false;
        }
        Tile fromTile = tileAt(startX,startY);
        if(fromTile.getPiece() == null){
            return false;
        }
        if(fromTile.getPiece().isActive() != 2) {
            return false;
        }
        int moveSpeed = fromTile.getPiece().getMovementSpeed();
        if(fromTile.getPiece().getMovementType().equals("any")) {
            if(Math.abs(startX-targetX) <= moveSpeed && Math.abs(startY-targetY) <= moveSpeed) {
                swapPiece(fromTile, targetTile,fromTile.getPiece());
                return true;
            }
        }
        if (fromTile.getPiece().getMovementType().equals("straight")){
            if(startX == targetX && Math.abs(startY - targetY) <= moveSpeed){
                    swapPiece(fromTile,targetTile,fromTile.getPiece());
                    return true;
            }
            if (startY == targetY && Math.abs(startX - targetX) <= moveSpeed) {
                swapPiece(fromTile,targetTile, fromTile.getPiece());
                return true;
            }
        }
        return false;
    }

    private void swapPiece(Tile tileFrom, Tile tileTo, Piece p) {
        p.setActive(1);
        if (p.getType().equals("king")) {
            if (!(tileTo.getStructureType().equals("none"))) {
                tileTo.getStructure().setPlayer(p.getPlayer());
            }
        }
        Piece px = new Piece(p.getPlayer(),p.getHp(),p.getType(),p.getMovementType(),p.getWeakAgainst(),p.getMovementSpeed(),p.getAttackRange(),p.isActive());
        tileTo.setPiece(px);
        tileFrom.setPiece(null);

    }


    public boolean attackUnit(int x, int y, int xTo, int yTo) {
        if(isTileRangeInvalid(x,y) || isTileRangeInvalid(xTo,yTo)) {
            return false;
        }
        Tile fromTile = tileAt(x,y);
        Tile toTile = tileAt(xTo,yTo);
        if(fromTile.getPiece() == null || toTile.getPiece() == null){
            return false;
        }
        if(fromTile.getPiece().getPlayer().getTurnId() == toTile.getPiece().getPlayer().getTurnId()) {
            return false;
        }
        int attackRange = fromTile.getPiece().getAttackRange();

        if(Math.abs(x-xTo) <= attackRange && Math.abs(y-yTo) <= attackRange) {
            toTile.damagePiece(fromTile.getPiece().getType());
            fromTile.getPiece().setActive(0);
            return true;
        }
        return false;
    }

    private boolean isTileRangeInvalid(int x, int y) {
        return (x < 0 || x > 7 || y < 0 || y > 7);
    }

    private Tile tileAt(int x, int y) {
        Optional<Tile> t = tiles.stream()
                .filter(tile -> tile.getX() == x)
                .filter(tile -> tile.getY() == y)
                .findFirst();
        if(t.isPresent()){
            return t.get();
        }
        return null;
    }

    private void resetPieceMovement() {
        for(Tile tile : tiles) {
            Piece p = tile.getPiece();
            if(p != null) {
                p.setActiveNewTurn(playerTurn);
            }
        }

    }
}
