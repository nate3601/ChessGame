package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;
import java.util.Set;

import static model.board.Board.BOARD_SIZE;

public class Pawn extends Piece {

    public Pawn(Game game, PieceColor color) {
        super(game, color);
    }

    /**
     * adds the forward movement depending on starting position, then adds opponents in striking distance
     * try/catches are to catch calls to tiles that do not exist on the board
     *
     * @return
     * @throws TileDoesNotExistException
     */
    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        PieceColor color = getColor();
        //starting positions
        if ((getColor() == PieceColor.WHITE && getTile().getPosition().getRow() == 2) ||
                (getColor() == PieceColor.BLACK && getTile().getPosition().getRow() == 7)) {
            switch (color) {
                case WHITE:
                    Tile oneUp = getGame().getBoard().getTiles()[rowInArray - 1][columnInArray];
                    if (!oneUp.isOccupied()) {
                        possibleDestinations.add(oneUp);
                    } ;
                    Tile twoUp = getGame().getBoard().getTiles()[rowInArray - 2][columnInArray];
                    if (!twoUp.isOccupied() && !oneUp.isOccupied()) {
                        possibleDestinations.add(twoUp);
                    }
                    break;
                case BLACK:
                    Tile oneDown = getGame().getBoard().getTiles()[rowInArray + 1][columnInArray];
                    if (!oneDown.isOccupied()) {
                        possibleDestinations.add(oneDown);
                    }
                    Tile twoDown = getGame().getBoard().getTiles()[rowInArray + 2][columnInArray];
                    if (!twoDown.isOccupied()) {
                        possibleDestinations.add(twoDown);
                    }
            }
            //not starting positions
        } else {
            switch (getColor()) {
                case WHITE:
                    try {
                        Tile oneUp = getGame().getBoard().getTiles()[rowInArray - 1][columnInArray];
                        if (!oneUp.isOccupied()) {
                            possibleDestinations.add(oneUp);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
                    break;
                case BLACK:
                    try {
                        Tile oneDown = getGame().getBoard().getTiles()[rowInArray + 1][columnInArray];
                        if (!oneDown.isOccupied()) {
                            possibleDestinations.add(oneDown);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                    }
            }
        }
        //opponents
        switch (getColor()) {
            case WHITE:
                try {
                    if (getGame().getBoard().getTiles()[rowInArray - 1][columnInArray - 1].isOccupiedByOpponent(this)) {
                        Tile oneUpOneLeft = getGame().getBoard().getTiles()[rowInArray - 1][columnInArray - 1];
                        possibleDestinations.add(oneUpOneLeft);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (getGame().getBoard().getTiles()[rowInArray - 1][columnInArray + 1].isOccupiedByOpponent(this)) {
                        Tile oneUpOneRight = getGame().getBoard().getTiles()[rowInArray - 1][columnInArray + 1];
                        possibleDestinations.add(oneUpOneRight);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                break;
            case BLACK:
                try {
                    if (getGame().getBoard().getTiles()[rowInArray + 1][columnInArray - 1].isOccupiedByOpponent(this)) {
                        Tile oneDownOneLeft = getGame().getBoard().getTiles()[rowInArray + 1][columnInArray - 1];
                        possibleDestinations.add(oneDownOneLeft);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
                try {
                    if (getGame().getBoard().getTiles()[rowInArray + 1][columnInArray + 1].isOccupiedByOpponent(this)) {
                        Tile oneDownOneRight = getGame().getBoard().getTiles()[rowInArray + 1][columnInArray + 1];
                        possibleDestinations.add(oneDownOneRight);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                }
        }

        return (HashSet<Tile>) possibleDestinations;
    }

    @Override
    public String toString() {
        switch (super.getColor()) {
            case BLACK:
                return "P(b)";
            default:
                return "P(w)";
        }
    }
}
