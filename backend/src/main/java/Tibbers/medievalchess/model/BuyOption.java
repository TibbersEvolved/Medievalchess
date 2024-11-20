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
                return Knight.build(player);
            case "torch":
                return Torch.build(player);
            default:
                return Archer.build(player);
        }
    }

    public String getUnit() {
        return unit;
    }

    public int getCost() {
        return cost;
    }
}
