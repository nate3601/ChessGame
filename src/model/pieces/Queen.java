package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;

public class Queen extends Piece {
    public Queen(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        return null;
    }

    @Override
    public String toString() {
        switch (super.getColor()){
            case BLACK: return "Q(b)";
            default: return "Q(w)";
        }
    }
}
