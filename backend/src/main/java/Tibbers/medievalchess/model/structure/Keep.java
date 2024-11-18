package Tibbers.medievalchess.model.structure;

import Tibbers.medievalchess.model.Player;

public class Keep extends Structure{
    public Keep(Player player) {
        super(player);
        income = 10;
        type = "keep";
    }
}
