package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int gold;
    private String name;
    private int turnId;

    @OneToMany(mappedBy = "player")
    private List<Structure> structures;

    @ManyToOne(optional = false)
    @JoinColumn(name = "game")
    private Game game;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "player")
    private List<Piece> pieces;

    public Player(String name) {
        this.name = name;
        gold = 0;
    }
    public Player(String name, Game game) {
        this.name = name;
        this.game = game;
        gold = 0;
    }

    public Player() {
    }

    public void gainIncome(int income) {
        gold += income;
    }

    public int getGold() {
        return gold;
    }

    public boolean spendGold(int amount) {
        if(gold >= amount) {
            gold -= amount;
            return true;
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public int getTurnId() {
        return turnId;
    }

    public void setTurnId(int turnId) {
        this.turnId = turnId;
    }

    public List<Structure> getStructures() {
        return structures;
    }

    public List<Piece> getPieces() {
        return pieces;
    }
}
