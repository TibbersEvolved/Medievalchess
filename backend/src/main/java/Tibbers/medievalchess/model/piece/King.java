package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class King extends Piece{

    public King(Player player) {
        super(player);
        hp = 20;
        type = "king";
        movementSpeed = 1;
        movementType = "any";
        weakAgainst = "none";
        attackRange = 1;
    }
}
