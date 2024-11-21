package Tibbers.medievalchess.model.structure;

import Tibbers.medievalchess.model.Game;
import Tibbers.medievalchess.model.Player;
import Tibbers.medievalchess.model.Tile;
import jakarta.persistence.*;

@Entity
public class Structure {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;
    @ManyToOne
    @JoinColumn(name = "player")
    protected Player player;

    @ManyToOne
    @JoinColumn(name = "game")
    private Game game;

    @OneToOne(mappedBy = "structure")
    private Tile tile;
    protected int income;
    protected String type;

    public Structure (Player player) {
        this.player = player;
    }

    public Structure() {
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

    public void setGame(Game game) {
        this.game = game;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
    }
}
