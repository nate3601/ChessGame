package model.game;

import model.Player;
import model.board.Board;
import model.pieces.PieceColor;

public class Game {
    private Board board;
    public Player playerWhite;
    public Player playerBlack;

    public Game(){
        playerWhite = new Player(PieceColor.WHITE, this);
        playerBlack = new Player(PieceColor.BLACK, this);

        board = new Board(this);
        board.init();
        board.printBoard();
    }

    public Player getPlayerWhite() {
        return playerWhite;
    }

    public Player getPlayerBlack() {
        return playerBlack;
    }

//    /**
//     * removes all the pieces from playerWhite and playerBlack
//     */
//    public void clearBoard() {
//        for (Piece piece : playerWhite.getPieces()) {
//            playerWhite.getPieces().remove(piece);
//        }
//        for (Piece piece : playerBlack.getPieces()) {
//            playerBlack.getPieces().remove(piece);
//        }
//    }

    public Board getBoard() {
        return this.board;
    }
}
