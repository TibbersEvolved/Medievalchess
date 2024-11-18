package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.Archer;
import Tibbers.medievalchess.model.piece.Knight;
import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.piece.Torch;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTests {
    Player mockplayer = new Player();


    @Test
    void archerShouldTake5DamageFromTorch() {
        Piece piece = new Archer(mockplayer);
        piece.takeDamage("torch");
        assertEquals(5,piece.getHp());
    }

    @Test
    void archerShouldTake10DamageFromKnight() {
        Piece piece = new Archer(mockplayer);
        piece.takeDamage("knight");
        assertEquals(0,piece.getHp());
    }

    @Test
    void torchShouldTake5DamageFromTorch() {
        Piece piece = new Torch(mockplayer);
        piece.takeDamage("torch");
        assertEquals(5,piece.getHp());
    }

    @Test
    void torchShouldTake10DamageFromArcher() {
        Piece piece = new Torch(mockplayer);
        piece.takeDamage("archer");
        assertEquals(0,piece.getHp());
    }

    @Test
    void knightShouldTake5DamageFromArcher() {
        Piece piece = new Knight(mockplayer);
        piece.takeDamage("archer");
        assertEquals(10,piece.getHp());
    }

    @Test
    void knightShouldTake10DamageFromTorch() {
        Piece piece = new Knight(mockplayer);
        piece.takeDamage("torch");
        assertEquals(5,piece.getHp());
    }
}
