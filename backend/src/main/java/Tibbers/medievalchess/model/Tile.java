package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;
import jakarta.persistence.*;
import org.springframework.lang.Nullable;

@Entity
@Table(name = "tiles")
public class Tile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    int x;
    int y;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "structure")
    private Structure structure;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "piece")
    private Piece piece;

    @ManyToOne
    private Game game;

    public Tile() {
        structure = null;
        piece = null;
    }

    public Tile(int x, int y) {
        structure = null;
        piece = null;
        this.x = x;
        this.y = y;
    }

    public Structure getStructure() {
        return structure;
    }
    public String getStructureType() {
        if(structure == null) {
            return "none";
        }
        return structure.getType();
    }
    public void damagePiece(String type) {
        if(piece.takeDamage(type)) {
            piece = null;
        }
    }

    public Structure setStructure(Structure structure) {
        this.structure = structure;
        return structure;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
