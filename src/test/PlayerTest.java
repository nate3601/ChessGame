package test;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TileDoesNotExistException;
import model.game.Game;
import model.pieces.Piece;
import model.pieces.PieceColor;
import model.pieces.Rook;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.board.Column.A;
import static model.board.Column.B;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PlayerTest {
    Game testGame;

    @BeforeEach
    public void setup() {
        testGame = new Game();
    }

    @Test
    public void testGetPieceAtNoProblems() {
        Piece testPiece = new Rook(testGame, PieceColor.BLACK);
        try {
            testPiece = testGame.getPlayerWhite().getPieceAt(A, 1);
        } catch (PlayerDoesNotOwnPieceOnGivenTileException e) {
            fail("should not have thrown exception");
        } catch (TileDoesNotExistException e) {
            fail("should not have thrown exception");
        }
        assertEquals(PieceColor.WHITE, testPiece.getColor());
        try {
            assertEquals(testGame.getBoard().getTileAt(A, 1), testPiece.getTile());
        } catch (TileDoesNotExistException e) {
            fail("should not have thrown exception");
        }
    }

    @Test
    public void testGetPieceAtTileDoesNotExist() {
        Piece testPiece = new Rook(testGame, PieceColor.BLACK);
        try {
            testPiece = testGame.getPlayerWhite().getPieceAt(A, 9);
        } catch (PlayerDoesNotOwnPieceOnGivenTileException e) {
            fail("should not have thrown this exception");
        } catch (TileDoesNotExistException e) {
            //good
        }
        assertEquals(PieceColor.BLACK, testPiece.getColor());
    }

    @Test
    public void testGetPieceAtDoesNotHavePiece() {
        Piece testPiece = new Rook(testGame, PieceColor.BLACK);
        try {
            testPiece = testGame.getPlayerWhite().getPieceAt(A, 3);
        } catch (PlayerDoesNotOwnPieceOnGivenTileException e) {
            //good
        } catch (TileDoesNotExistException e) {
            fail("should not have thrown this exception");
        }
        assertEquals(PieceColor.BLACK, testPiece.getColor());
    }


    @Test
    public void testMovePieceToNoProblem()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException {
        Piece testPiece = testGame.getPlayerWhite().getPieceAt(A, 2);
        try {
            testGame.getPlayerWhite().movePieceTo(testPiece, A, 3);
        } catch (NewTileOccupiedException e) {
            fail("should not have thrown exception");
        }
        assertEquals(testGame.getBoard().getTileAt(A, 3), testPiece.getTile());
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
    }

    @Test
    public void testMovePieceToOwnOccupiedTile()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException {
        Piece testPiece = testGame.getPlayerWhite().getPieceAt(A, 2);
        try {
            testGame.getPlayerWhite().movePieceTo(testPiece, B, 2);
        } catch (NewTileOccupiedException e) {
            //good
        }
        assertEquals(testGame.getBoard().getTileAt(A, 2), testPiece.getTile());
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
    }

    @Test
    public void testMovePieceToOpponentOccupiedTile()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException {
        Piece testPiece = testGame.getPlayerWhite().getPieceAt(A, 2);
        try {
            testGame.getPlayerWhite().movePieceTo(testPiece, A, 7);
        } catch (NewTileOccupiedException e) {
            //good
        }
        assertEquals(testGame.getBoard().getTileAt(A, 7), testPiece.getTile());
        assertEquals(15, testGame.getPlayerBlack().getPieces().size());
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
    }
}
