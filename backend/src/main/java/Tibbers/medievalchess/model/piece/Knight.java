package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Knight{


    public static Piece build(Player player){
        Piece piece = new Piece(player);
        piece.setHp(3);
        piece.setType("knight");
        piece.setMovementSpeed(2);
        piece.setMovementType("straight");
        piece.setWeakAgainst("torch");
        piece.setAttackRange(1);
        return piece;
    }
}
