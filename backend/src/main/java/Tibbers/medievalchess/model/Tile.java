package Tibbers.medievalchess.model;

import Tibbers.medievalchess.model.piece.Piece;
import Tibbers.medievalchess.model.structure.Structure;

public class Tile {
    private Structure structure;
    private Piece piece;
    private int id;

    public Tile() {
        structure = null;
        piece = null;
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
}
