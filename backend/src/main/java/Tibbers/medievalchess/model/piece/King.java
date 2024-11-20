package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class King extends Piece{

    public King(Player player) {
        super(player);
        hp = 4;
        type = "king";
        movementSpeed = 1;
        movementType = "any";
        weakAgainst = "none";
        attackRange = 1;
    }
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
