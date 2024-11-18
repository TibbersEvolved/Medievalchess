package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Piece {
    protected Player player;
    protected int id;
    protected float hp;

    public Piece(Player player) {
        this.player = player;
    }
}
