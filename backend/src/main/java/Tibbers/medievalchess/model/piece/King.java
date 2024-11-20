package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class King{


    public static Piece build(Player player){
        Piece piece = new Piece(player);
        piece.setHp(4);
        piece.setType("king");
        piece.setMovementSpeed(1);
        piece.setMovementType("any");
        piece.setWeakAgainst("none");
        piece.setAttackRange(1);
        return piece;
    }
}
