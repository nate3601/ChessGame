package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;

public class GenericPiece extends Piece {
    public GenericPiece(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        return null;
    }
}
