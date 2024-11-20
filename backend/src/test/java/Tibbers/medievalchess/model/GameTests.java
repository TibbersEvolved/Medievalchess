package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.Piece;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class GameTests {

    @Test
    void shouldGainIncomeOnNewGame() {
        Game game = Game.newGame("test","","");
        game.endTurn();
        Player player = game.getPlayer(1);
        game.endTurn();
        Player player2 = game.getPlayer(0);
        assertEquals(50,player.getGold());
        assertEquals(50,player2.getGold());
    }

    @Test
    void shouldLoopPlayerTurns() {
        Game game = Game.newGame("test","","");
        game.endTurn();
        game.endTurn();
        assertEquals(0,game.getPlayerTurn());
    }

    @Test
    void shouldAllowToMoveKing() {
        Game game = Game.newGame("test","","");
        game.moveUnit(0,3,1,3);
        Tile[][] tiles = game.getTiles();
        Piece king = tiles[3][1].getPiece();
        assertNotEquals(null, king);
    }

    @Test
    void shouldNotAllowToMoveKingBeyondMovementSpeed() {
        Game game = Game.newGame("test","","");
        game.moveUnit(0,3,4,3);
        Tile[][] tiles = game.getTiles();
        Piece empty = tiles[3][4].getPiece();
        Piece king = tiles[3][0].getPiece();
        assertEquals(null, empty);
        assertNotEquals(null, king);
    }
}
