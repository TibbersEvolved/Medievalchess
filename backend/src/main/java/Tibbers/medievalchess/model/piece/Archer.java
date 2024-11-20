package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Archer{
    public static Piece build(Player player){
        Piece piece = new Piece(player);
        piece.setHp(2);
        piece.setType("archer");
        piece.setMovementSpeed(1);
        piece.setMovementType("straight");
        piece.setWeakAgainst("knight");
        piece.setAttackRange(2);
        return piece;
    }
}
