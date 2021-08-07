package model.pieces;

import model.board.Tile;
import model.game.Game;

import java.util.HashSet;
import java.util.Set;

import static model.board.Board.BOARD_SIZE;

public class Bishop extends Piece {
    private Game game;

    public Bishop(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        int tilesToTopLeft;
        return null;
    }

    @Override
    public String toString() {
        switch (super.getColor()){
            case BLACK: return "B(b)";
            default: return "B(w)";
        }
    }
}
