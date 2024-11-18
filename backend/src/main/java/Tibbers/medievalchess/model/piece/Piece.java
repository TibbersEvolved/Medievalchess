package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Piece {
    protected Player player;
    protected int id;
    protected float hp;
    protected String type;
    protected String movementType;
    protected String weakAgainst;
    protected int movementSpeed;

    public Piece(Player player) {
        this.player = player;
    }

    public boolean takeDamage(String dmgType) {
        if(dmgType == weakAgainst) {
            hp -= 10;
        } else {
            hp -= 5;
        }
        if(hp <= 0) {
            return true;
        }
        return false;
    }

    public String getType() {
        return type;
    }

    public String getMovementType() {
        return movementType;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public String getWeakAgainst() {
        return weakAgainst;
    }

    public float getHp() {
        return hp;
    }

    public Player getPlayer() {
        return player;
    }
}
