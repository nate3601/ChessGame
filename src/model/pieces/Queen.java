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

public class Queen extends Piece {
    public Queen(Game game, PieceColor color) {
        super(game, color);
    }

    @Override
    public HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException {
        Set<Tile> possibleDestinations = new HashSet<>();
        int rowInArray = (BOARD_SIZE - getTile().getPosition().getRow());
        int columnInArray = getTile().getPosition().getColumn().convertToInt();
        //getting up destinations
        int numTilesToTop = rowInArray;
        HashSet<Tile> tilesToTop = super.tilesInOneDirection(numTilesToTop, rowInArray, columnInArray, UP, NEUTRAL);
        for (Tile tile : tilesToTop) {
            possibleDestinations.add(tile);
        }

        //getting down destinations
        int numTilesToBottom = (BOARD_SIZE - 1) - rowInArray;
        HashSet<Tile> tilesToBottom = super.tilesInOneDirection(numTilesToBottom, rowInArray, columnInArray, DOWN, NEUTRAL);
        for (Tile tile : tilesToBottom) {
            possibleDestinations.add(tile);
        }
        //getting left destinations
        int numTilesToLeft = columnInArray;
        HashSet<Tile> tilesToLeft = super.tilesInOneDirection(numTilesToLeft, rowInArray, columnInArray, YDirection.NEUTRAL, LEFT);
        for (Tile tile : tilesToLeft) {
            possibleDestinations.add(tile);
        }

        //getting right destinations
        int numTilesToRight = (BOARD_SIZE - 1) - columnInArray;
        HashSet<Tile> tilesToRight = super.tilesInOneDirection(numTilesToRight, rowInArray, columnInArray, YDirection.NEUTRAL, RIGHT);
        for (Tile tile : tilesToRight) {
            possibleDestinations.add(tile);
        }
        int reversedRowInArray = (BOARD_SIZE - 1) - rowInArray;
        int reversedColumnInArray = (BOARD_SIZE - 1) - columnInArray;

        //getting up-left destinations
        int numTilesToTopLeft = (rowInArray <= columnInArray) ? rowInArray : columnInArray;
        HashSet<Tile> tilesToTopLeft = super.tilesInOneDirection(numTilesToTopLeft, rowInArray, columnInArray, YDirection.UP, XDirection.LEFT);
        for (Tile tile : tilesToTopLeft) {
            possibleDestinations.add(tile);
        }


        //getting up-right destinations
        int numTilesToTopRight = (rowInArray <= reversedColumnInArray) ? rowInArray : reversedColumnInArray;
        HashSet<Tile> tilesToTopRight = super.tilesInOneDirection(numTilesToTopRight, rowInArray, columnInArray, YDirection.UP, XDirection.RIGHT);
        for (Tile tile : tilesToTopRight) {
            possibleDestinations.add(tile);
        }

        //getting down-left destinations
        int numTilesToBottomLeft = (reversedRowInArray <= columnInArray) ? reversedRowInArray : columnInArray;
        HashSet<Tile> tilesToBottomLeft = super.tilesInOneDirection(numTilesToBottomLeft, rowInArray, columnInArray, YDirection.DOWN, XDirection.LEFT);
        for (Tile tile : tilesToBottomLeft) {
            possibleDestinations.add(tile);
        }

        //getting down-right destinations
        int numTilesToBottomRight = (reversedRowInArray <= reversedColumnInArray) ? reversedRowInArray : reversedColumnInArray;
        HashSet<Tile> tilesToBottomRight = super.tilesInOneDirection(numTilesToBottomRight, rowInArray, columnInArray, YDirection.DOWN, XDirection.RIGHT);
        for (Tile tile : tilesToBottomRight) {
            possibleDestinations.add(tile);
        }

        return (HashSet<Tile>) possibleDestinations;
    }

    @Override
    public String toString() {
        switch (super.getColor()){
            case BLACK: return "Q(b)";
            default: return "Q(w)";
        }
    }
}
