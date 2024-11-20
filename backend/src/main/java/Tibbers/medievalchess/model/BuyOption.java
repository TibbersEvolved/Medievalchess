package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.*;


public class BuyOption {
    private int cost;
    private String unit;

    public BuyOption(int cost, String unit) {
        this.cost = cost;
        this.unit = unit;
    }

    public Piece getPiece(Player player) {
        switch (unit) {
            case "knight":
                return new Knight(player);
            case "torch":
                return new Torch(player);
            default:
                return new Archer(player);
        }
    }

    public String getUnit() {
        return unit;
    }

    public int getCost() {
        return cost;
    }
}
