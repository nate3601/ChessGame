package model;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.board.Tile;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.PieceColor;

import java.util.HashSet;
import java.util.Set;

public class Player {
    Game game;
    Set<Piece> pieces;
    PieceColor color;

    public Player(PieceColor color, Game game) {
        pieces = new HashSet<>();
        this.color = color;
        this.game = game;
    }

    public void addPiece(Piece p){
        if (!pieces.contains(p)){
            pieces.add(p);
        }
    }

    /**
     * returns piece in the tile at the given column and row
     * @param column
     * @param row
     * @return
     */
    public Piece getPieceAt(Column column, int row)
            throws PlayerDoesNotOwnPieceOnGivenTileException, TileDoesNotExistException {
        Tile givenTile = game.getBoard().getTileAt(column, row);
        for (Piece piece : pieces) {
            if (piece.getTile().equals(givenTile)) {
                return piece;
            }
        }
        throw new PlayerDoesNotOwnPieceOnGivenTileException();
    }

    /**
     * moves piece to provided position, if newTile is occupied by opposing piece, takes that piece from opponent
     * @param piece
     * @param column
     * @param row
     * @throws TileDoesNotExistException
     * @throws NewTileOccupiedException
     * @throws PlayerDoesNotOwnPieceOnGivenTileException
     */
    public void movePieceTo(Piece piece, Column column, int row)
            throws TileDoesNotExistException, NewTileOccupiedException, PlayerDoesNotOwnPieceOnGivenTileException {
        Tile newTile = game.getBoard().getTileAt(column, row);
        try {
            piece.moveTo(newTile);
        } catch (TakePieceException e) {
            Piece opponentPiece = e.getOpponentPiece();
            switch (color) {
                case WHITE: game.getPlayerBlack().pieces.remove(opponentPiece);
                case BLACK: game.getPlayerWhite().pieces.remove(opponentPiece);
            }
        }
    }

    public HashSet<Piece> getPieces() {
        return (HashSet<Piece>) this.pieces;
    }

    public void removePiece(Piece p) {
        if (pieces.contains(p)) {
            pieces.remove(p);
        }
    }
}
