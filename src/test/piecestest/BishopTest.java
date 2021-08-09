package test.piecestest;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.game.Game;
import model.pieces.Bishop;
import model.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BishopTest {
    Bishop testBishop;
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
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);
    }

    @Test
    public void testGetPossibleDestinationsWhiteClearBoardEdge()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.A, 1));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);
    }

    @Test
    public void testGetPossibleDestinationsWhiteOpponent1AboveLeft()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.C,5));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);

    }
    @Test
    public void testGetPossibleDestinationsWhiteOpponent1UpRight()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.E,5));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);

    }
    @Test
    public void testGetPossibleDestinationsWhiteOpponent1DownLeft()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.C,3));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);

    }

    @Test
    public void testGetPossibleDestinationsWhiteOpponent1DownRight()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(Column.E,3));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);
    }
    @Test
    public void testGetPossibleDestinationsWhiteOwnPiece1AboveLeft()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn ownPiece = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C, 2);
        ownPiece.moveTo(testGame.getBoard().getTileAt(Column.C,5));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);
    }
    @Test
    public void testGetPossibleDestinationsWhiteSurroundedByOwn()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testBishop = (Bishop) testGame.getPlayerWhite().getPieceAt(Column.C, 1);
        Pawn ownPiece1 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C, 2);
        ownPiece1.moveTo(testGame.getBoard().getTileAt(Column.D,5));
        Pawn ownPiece2 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        ownPiece2.moveTo(testGame.getBoard().getTileAt(Column.E,4));
        Pawn ownPiece3 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.E, 2);
        ownPiece3.moveTo(testGame.getBoard().getTileAt(Column.D,3));
        Pawn ownPiece4 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.F, 2);
        ownPiece4.moveTo(testGame.getBoard().getTileAt(Column.C,4));
        testBishop.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testBishop);
    }

}
