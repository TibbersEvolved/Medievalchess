package Tibbers.medievalchess.model.structure;

import Tibbers.medievalchess.model.Player;

public class Structure {
    protected Player player;
    protected int income;
    protected int id;

    public Structure (Player player) {
        this.player = player;
    }

    public int getIncome(Player player) {
        if(this.player == player) {
            return income;
        }
        return 0;
    }
}
