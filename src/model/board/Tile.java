package model.board;

import model.pieces.Piece;
import model.pieces.PieceColor;

import java.util.Objects;

public class Tile {
    private final Position position;
    private final TileColor tileColor;
    private boolean isOccupied;
    private Piece piece;
    private boolean isPossibleDestination;

    /**
     * constructs a new tile and inserts a piece
     */
    public Tile(Position position, TileColor tileColor) {
        this.position = position;
        this.tileColor = tileColor;
    }

    /**
     * sets isOccupied for this to be false
     */
    public void makeUnoccupied() {
        this.isOccupied = false;
    }

    /**
     * getters
     *
     * @return position, tileColor, or isOccupied
     */
    public Position getPosition() {
        return position;
    }

    public TileColor getTileColor() {
        return tileColor;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public Piece getPiece() {
        return piece;
    }

    /**
     * setters
     */
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public void setPiece(Piece p) {
        if (piece != p) {
            this.piece = p;
            this.isOccupied = true;
            p.setTile(this);
        }
    }

    public void removePiece() {
        if (this.piece != null) {
            piece = null;
            makeUnoccupied();
        }
    }

    @Override
    public String toString() {
        if (isPossibleDestination) {
            if (!isOccupied) {
                return "[*" + position.toString() + " ----*]";
            } else
                return "[*" + position.toString() + " " + piece.toString() + "*]";
        } else if (!isOccupied) {
            return "[ " + position.toString() + " ---- ]";
        } else
            return "[ " + position.toString() + " " + piece.toString() + " ]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return Objects.equals(position, tile.position) &&
                tileColor == tile.tileColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, tileColor);
    }

    /**
     * checks if piece is the same color as this.piece
     *
     * @param pieceToCheckAgainst
     * @return
     */
    public boolean isOccupiedByOpponent(Piece pieceToCheckAgainst) {
        PieceColor colorToCheckAgainst = pieceToCheckAgainst.getColor();
        if (this.isOccupied) {
            return colorToCheckAgainst != this.getPiece().getColor();
        } else return false;
    }

    public void makePossibleDestination() {
        isPossibleDestination = true;
    }
}
