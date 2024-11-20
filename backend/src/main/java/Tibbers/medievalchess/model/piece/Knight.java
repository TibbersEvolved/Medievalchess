package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Knight extends Piece{
    public Knight(Player player) {
        super(player);
        hp = 3;
        type = "knight";
        movementSpeed = 2;
        movementType = "straight";
        weakAgainst = "torch";
        attackRange = 1;
    }

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
