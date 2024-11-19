package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;

public class Piece {
    protected Player player;
    protected int id;
    protected int hp;
    protected String type;
    protected String movementType;
    protected String weakAgainst;
    protected int movementSpeed;
    protected boolean active;

    public Piece(Player player) {
        this.player = player;
        active = false;
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

    public int getHp() {
        return hp;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
