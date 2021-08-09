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
            case BLACK: return "B(b)";
            default: return "B(w)";
        }
    }
}
