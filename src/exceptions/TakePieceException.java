package exceptions;

import model.pieces.Piece;

public class TakePieceException extends Exception {
    Piece opponentPiece;
    public TakePieceException(Piece opponentPiece) {
        this.opponentPiece = opponentPiece;
    }

    public Piece getOpponentPiece() {
        return opponentPiece;
    }
}
