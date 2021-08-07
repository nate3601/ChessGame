package model.board;

import exceptions.TileDoesNotExistException;
import model.game.Game;
import model.pieces.*;

import java.util.HashSet;

public class Board {
    private Game game;
    public static final int BOARD_SIZE = 8;
    Tile[][] tiles = new Tile[BOARD_SIZE][BOARD_SIZE];

    /**
     * constructs a new board object with the correct colors and positions
    *
     * @param game*/
    public Board(Game game){
        this.game = game;
        for (int i = 0; i < tiles.length; i++){
            int currentRow = 0;
            TileColor currentColor = (i % 2 == 0) ? TileColor.WHITE : TileColor.BLACK;
            for (Column column : Column.values()) {
                Tile newTile = new Tile(new Position(column, BOARD_SIZE-i), currentColor);
                tiles[i][currentRow] = newTile;
                currentRow++;
                currentColor = (currentColor==TileColor.WHITE) ? TileColor.BLACK : TileColor.WHITE;
            }
        }
    }

    public Tile[][] getTiles() {
        return tiles;
    }

    /**
     * adds the initial pieces to the board object
     */
    public void init(){
        tiles[0][0].setPiece(new Rook(game, PieceColor.BLACK));
        tiles[0][1].setPiece(new Knight(game, PieceColor.BLACK));
        tiles[0][2].setPiece(new Bishop(game, PieceColor.BLACK));
        tiles[0][3].setPiece(new Queen(game, PieceColor.BLACK));
        tiles[0][4].setPiece(new King(game, PieceColor.BLACK));
        tiles[0][5].setPiece(new Bishop(game, PieceColor.BLACK));
        tiles[0][6].setPiece(new Knight(game, PieceColor.BLACK));
        tiles[0][7].setPiece(new Rook(game, PieceColor.BLACK));

        for (Tile tile : tiles[1]){
            tile.setPiece(new Pawn(game, PieceColor.BLACK));
        }

        for (Tile tile : tiles[6]){
            tile.setPiece(new Pawn(game, PieceColor.WHITE));
        }

        tiles[7][0].setPiece(new Rook(game, PieceColor.WHITE));
        tiles[7][1].setPiece(new Knight(game, PieceColor.WHITE));
        tiles[7][2].setPiece(new Bishop(game, PieceColor.WHITE));
        tiles[7][3].setPiece(new Queen(game, PieceColor.WHITE));
        tiles[7][4].setPiece(new King(game, PieceColor.WHITE));
        tiles[7][5].setPiece(new Bishop(game, PieceColor.WHITE));
        tiles[7][6].setPiece(new Knight(game, PieceColor.WHITE));
        tiles[7][7].setPiece(new Rook(game, PieceColor.WHITE));
    }

    public void clearBoard() {
        for (Tile[] tileArray : tiles) {
            for (Tile tile : tileArray) {
                if (tile.isOccupied()) {
                    tile.removePiece();
                }
            }
        }
    }

    /**
     * prints the board to the console
     */
    public void printBoard() {
        for (Tile[] row : tiles){
            for (Tile tile : row){
                System.out.print(tile);
            }
            System.out.println();
        }
    }

    /**
     * prints the board to the console, putting *'s on the edges of the possible destinations for piece
     */
    public void printBoardWithPossibleDestinations(Piece piece) throws TileDoesNotExistException {
        HashSet<Tile> piecePossibleDestinations = piece.getPossibleDestinations();
        for (Tile[] row : tiles){
            for (Tile tile : row){
                if (piecePossibleDestinations.contains(tile)) {
                    tile.makePossibleDestination();
                }
                System.out.print(tile);
            }
            System.out.println();
        }
    }

    /**
     * returns the tile with the corresponding column and row
     * @return
     */
    public Tile getTileAt(Column column, int row) throws TileDoesNotExistException {
        Position givenPosition = new Position(column, row);
        for (Tile[] tileArray : tiles){
            for (Tile tile : tileArray){
                if (tile.getPosition().equals(givenPosition)){
                    return tile;
                }
            }
        }
        throw new TileDoesNotExistException();
    }
}
