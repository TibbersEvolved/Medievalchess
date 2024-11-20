package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Torch extends Piece{
    public Torch(Player player) {
        super(player);
        hp = 10;
        type = "torch";
        movementSpeed = 1;
        movementType = "any";
        weakAgainst = "archer";
        attackRange = 1;
    }
}
