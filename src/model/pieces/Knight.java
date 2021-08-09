package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;
import java.util.Set;

import static model.board.Board.BOARD_SIZE;

public class Knight extends Piece {
    public Knight(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        //getting 2-up 1-right
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray-2][columnInArray+1];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        //getting 1-up 2-right
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray-1][columnInArray+2];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 1-down 2-right
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray+1][columnInArray+2];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 2-down 1-right
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray+2][columnInArray+1];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 2-down 1-left
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray+2][columnInArray-1];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 1-down 2-left
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray+1][columnInArray-2];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 1-up 2-left
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray-1][columnInArray-2];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}
        //getting 2-up 1-left
        try {
            Tile tile = getGame().getBoard().getTiles()[rowInArray-2][columnInArray-1];
            if (!tile.isOccupied() || tile.isOccupiedByOpponent(this)){
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {}

        return (HashSet<Tile>) possibleDestinations;
    }



    @Override
    public String toString() {
        switch (super.getColor()){
            case BLACK: return "N(b)";
            default: return "N(w)";
        }
    }
}
