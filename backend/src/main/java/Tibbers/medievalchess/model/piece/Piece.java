package Tibbers.medievalchess.model.piece;

import Tibbers.medievalchess.model.Player;
import Tibbers.medievalchess.model.Tile;
import jakarta.persistence.*;

@Entity
public class Piece {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    @ManyToOne
    @JoinColumn(name = "player")
    protected Player player;
    @OneToOne(mappedBy = "piece")
    private Tile tile;
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

    public Piece() {
    }

    public Piece(Player player, int hp, String type, String movementType,
                 String weakAgainst, int movementSpeed, int attackRange, int active) {
        this.player = player;
        this.hp = hp;
        this.type = type;
        this.movementType = movementType;
        this.weakAgainst = weakAgainst;
        this.movementSpeed = movementSpeed;
        this.attackRange = attackRange;
        this.active = active;
    }

    public boolean takeDamage(String dmgType) {
        if(dmgType.equals(weakAgainst)) {
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

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
