package Tibbers.medievalchess.model.structure;

import Tibbers.medievalchess.model.Player;

public class Town extends Structure{
    public Town(Player player) {
        super(player);
        income = 20;
    }
}
