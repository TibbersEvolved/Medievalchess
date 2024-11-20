package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Torch {

    public static Piece build(Player player){
        Piece piece = new Piece(player);
        piece.setHp(2);
        piece.setType("torch");
        piece.setMovementSpeed(1);
        piece.setMovementType("any");
        piece.setWeakAgainst("archer");
        piece.setAttackRange(1);
        return piece;
    }
}
