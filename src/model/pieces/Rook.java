package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;
import java.util.Set;

import static model.board.Board.BOARD_SIZE;

public class Rook extends Piece {

    public Rook(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        //getting up destinations
        int tilesToTop = rowInArray;
        boolean hasNotReachedPiece = true;
        int u = 1;
        while (hasNotReachedPiece && u <= tilesToTop) {
            Tile nextUp = getGame().getBoard().getTiles()[rowInArray - u][columnInArray];
            if (nextUp.isOccupied() && !nextUp.isOccupiedByOpponent(this)) {
                hasNotReachedPiece = false;
            } else if (nextUp.isOccupied() && nextUp.isOccupiedByOpponent(this)) {
                possibleDestinations.add(nextUp);
                hasNotReachedPiece = false;
            } else {
                possibleDestinations.add(nextUp);
                u++;
            }
        }

        //getting down destinations
        hasNotReachedPiece = true;
        int tilesToBottom = (BOARD_SIZE - 1) - rowInArray;
        int d = 1;
        while (hasNotReachedPiece && d <= tilesToBottom) {
            Tile nextDown = getGame().getBoard().getTiles()[rowInArray + d][columnInArray];
            if (nextDown.isOccupied() && !nextDown.isOccupiedByOpponent(this)) {
                hasNotReachedPiece = false;
            } else if (nextDown.isOccupied() && nextDown.isOccupiedByOpponent(this)) {
                possibleDestinations.add(nextDown);
                hasNotReachedPiece = false;
            } else {
                possibleDestinations.add(nextDown);
                d++;
            }
        }
        //getting left destinations
        hasNotReachedPiece = true;
        int tilesToLeft = columnInArray;
        int l = 1;
        while (hasNotReachedPiece && l <= tilesToLeft) {
            Tile nextLeft = getGame().getBoard().getTiles()[rowInArray][columnInArray - l];
            if (nextLeft.isOccupied() && !nextLeft.isOccupiedByOpponent(this)) {
                hasNotReachedPiece = false;
            } else if (nextLeft.isOccupied() && nextLeft.isOccupiedByOpponent(this)) {
                possibleDestinations.add(nextLeft);
                hasNotReachedPiece = false;
            } else {
                possibleDestinations.add(nextLeft);
                l++;
            }
        }

        //getting right destinations
        hasNotReachedPiece = true;
        int tilesToRight = (BOARD_SIZE - 1) - columnInArray;
        int r = 1;
        while (hasNotReachedPiece && r <= tilesToRight) {
            Tile nextRight = getGame().getBoard().getTiles()[rowInArray][columnInArray + r];
            if (nextRight.isOccupied() && !nextRight.isOccupiedByOpponent(this)) {
                hasNotReachedPiece = false;
            } else if (nextRight.isOccupied() && nextRight.isOccupiedByOpponent(this)) {
                possibleDestinations.add(nextRight);
                hasNotReachedPiece = false;
            } else {
                possibleDestinations.add(nextRight);
                r++;
            }
        }

        return (HashSet<Tile>) possibleDestinations;
    }

    @Override
    public String toString() {
        switch (super.getColor()) {
            case BLACK:
                return "R(b)";
            default:
                return "R(w)";
        }
    }
}
