package Tibbers.medievalchess.model.structure;

import Tibbers.medievalchess.model.Player;

public class Structure {
    protected Player player;
    protected int income;
    protected int id;
    protected String type;

    public Structure (Player player) {
        this.player = player;
    }

    public static Structure buildTown(Player player) {
        Structure structure = new Structure(player);
        structure.setIncome(10);
        structure.setType("town");
        return structure;
    }

    public static Structure buildKeep(Player player) {
        Structure structure = new Structure(player);
        structure.setIncome(5);
        structure.setType("keep");
        return structure;
    }

    public int getIncome(Player player) {
        if(this.player == player) {
            return income;
        }
        return 0;
    }

    public Player getPlayer() {
        return player;
    }

    public String getType() {
        return type;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public void setType(String type) {
        this.type = type;
    }
}
