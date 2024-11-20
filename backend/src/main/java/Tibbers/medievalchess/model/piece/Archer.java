package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Archer extends Piece{
    public Archer(Player player) {
        super(player);
        hp = 2;
        type = "archer";
        movementSpeed = 1;
        movementType = "straight";
        weakAgainst = "knight";
        attackRange = 2;
    }

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
