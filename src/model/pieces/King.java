package model.pieces;

import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;
import java.util.Set;

import static model.board.Board.BOARD_SIZE;
import static model.pieces.Piece.XDirection.*;
import static model.pieces.Piece.YDirection.DOWN;
import static model.pieces.Piece.YDirection.UP;

public class King extends Piece {
    public King(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        int numTilesToCheck = 1;
        //getting up destinations
        try {
            HashSet<Tile> tilesToTop = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, UP, NEUTRAL);
            for (Tile tile : tilesToTop) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e){}

        //getting down destinations
        try {
            HashSet<Tile> tilesToBottom = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, DOWN, NEUTRAL);
            for (Tile tile : tilesToBottom) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }
        //getting left destinations
        try {
            HashSet<Tile> tilesToLeft = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.NEUTRAL, LEFT);
            for (Tile tile : tilesToLeft) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //getting right destinations
        try {
            HashSet<Tile> tilesToRight = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.NEUTRAL, RIGHT);
            for (Tile tile : tilesToRight) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //getting up-left destinations
        try {
            HashSet<Tile> tilesToTopLeft = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.UP, XDirection.LEFT);
            for (Tile tile : tilesToTopLeft) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }


        //getting up-right destinations
        try {
            HashSet<Tile> tilesToTopRight = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.UP, XDirection.RIGHT);
            for (Tile tile : tilesToTopRight) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //getting down-left destinations
        try {
            HashSet<Tile> tilesToBottomLeft = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.DOWN, XDirection.LEFT);
            for (Tile tile : tilesToBottomLeft) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        //getting down-right destinations
        try {
            HashSet<Tile> tilesToBottomRight = super.tilesInOneDirection(numTilesToCheck, rowInArray, columnInArray, YDirection.DOWN, XDirection.RIGHT);
            for (Tile tile : tilesToBottomRight) {
                possibleDestinations.add(tile);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
        }

        return (HashSet<Tile>) possibleDestinations;
    }

    @Override
    public String toString() {
        switch (super.getColor()){
            case BLACK: return "K(b)";
            default: return "K(w)";
        }
    }
}
