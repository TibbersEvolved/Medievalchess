package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Knight extends Piece{
    public Knight(Player player) {
        super(player);
        hp = 15;
        type = "knight";
        movementSpeed = 2;
        movementType = "straight";
        weakAgainst = "torch";
        attackRange = 1;
    }
}
