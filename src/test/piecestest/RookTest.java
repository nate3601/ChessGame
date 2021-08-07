package test.piecestest;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.game.Game;
import model.pieces.Pawn;
import model.pieces.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RookTest {
    Rook testRook;
    Game testGame;

    @BeforeEach
    public void setup() {
        testGame = new Game();
    }

    @Test
    public void testGetPossibleDestinationsWhiteClearBoard()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);
    }
    @Test
    public void testGetPossibleDestinationsWhiteClearBoardEdge()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        testRook.moveTo(testGame.getBoard().getTileAt(Column.A, 1));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);
    }

    @Test
    public void testGetPossibleDestinationsWhiteOpponent1Above()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.D,5));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);

    }
    @Test
    public void testGetPossibleDestinationsWhiteOpponent1Right()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.E,4));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);

    }
    @Test
    public void testGetPossibleDestinationsWhiteOpponent1Down()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.D,3));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);

    }

    @Test
    public void testGetPossibleDestinationsWhiteOpponent1Left()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.C,4));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);
    }
    @Test
    public void testGetPossibleDestinationsWhiteOwnPiece1Above()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn ownPiece = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C, 2);
        ownPiece.moveTo(testGame.getBoard().getTileAt(Column.D,5));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);
    }
    @Test
    public void testGetPossibleDestinationsWhiteSurroundedByOwn()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testRook = (Rook) testGame.getPlayerWhite().getPieceAt(Column.A, 1);
        Pawn ownPiece1 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C, 2);
        ownPiece1.moveTo(testGame.getBoard().getTileAt(Column.D,5));
        Pawn ownPiece2 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        ownPiece2.moveTo(testGame.getBoard().getTileAt(Column.E,4));
        Pawn ownPiece3 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.E, 2);
        ownPiece3.moveTo(testGame.getBoard().getTileAt(Column.D,3));
        Pawn ownPiece4 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.F, 2);
        ownPiece4.moveTo(testGame.getBoard().getTileAt(Column.C,4));
        testRook.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testRook);
    }
}
