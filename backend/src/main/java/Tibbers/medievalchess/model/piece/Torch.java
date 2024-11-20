package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Torch extends Piece{
    public Torch(Player player) {
        super(player);
        hp = 2;
        type = "torch";
        movementSpeed = 1;
        movementType = "any";
        weakAgainst = "archer";
        attackRange = 1;
    }

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
