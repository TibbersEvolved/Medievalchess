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
}
