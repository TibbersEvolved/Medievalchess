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
    protected int active;
    protected int attackRange;

    public Piece(Player player) {
        this.player = player;
        active = 0;
    }

    public boolean takeDamage(String dmgType) {
        if(dmgType == weakAgainst) {
            hp -= 2;
        } else {
            hp -= 1;
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

    public int isActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setActiveNewTurn(int turn) {
        if(player.getTurnId() == turn) {
            active = 2;
            if(type.equals("king") && hp < 4){
                hp += 1;
            }
            return;
        }
        active = 0;
    }

    public int getAttackRange() {
        return attackRange;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMovementType(String movementType) {
        this.movementType = movementType;
    }

    public void setWeakAgainst(String weakAgainst) {
        this.weakAgainst = weakAgainst;
    }

    public void setMovementSpeed(int movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public void setAttackRange(int attackRange) {
        this.attackRange = attackRange;
    }
}
