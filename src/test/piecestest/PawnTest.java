package test.piecestest;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.game.Game;
import model.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.board.Column.A;
import static model.board.Column.D;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PawnTest {
    Pawn testPawn;
    Game testGame;

    @BeforeEach
    public void setup() {
        testGame = new Game();
    }

    @Test
    public void testGetPossibleDestinationsWhiteStart()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }

    @Test
    public void testGetPossibleDestinationsWhiteStartWithFirstOccupied()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException, NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        Pawn opponentPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(A, 7);
        opponentPawn.moveTo(testGame.getBoard().getTileAt(D,3 ));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }

    @Test
    public void testGetPossibleDestinationsWhiteStartWithSecondOccupied()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException, NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        Pawn opponentPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(A, 7);
        opponentPawn.moveTo(testGame.getBoard().getTileAt(D,4 ));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }

    @Test
    public void testGetPossibleDestinationsBlackStart()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.G, 7);
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }

    @Test
    public void testGetPossibleDestinationsWhiteNotStart()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.D, 3));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }
    @Test
    public void testGetPossibleDestinationsBlackNotStart()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.G, 7);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.G, 6));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }
    @Test
    public void testGetPossibleDestinationsWhiteWithOneOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.D, 3));
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.C,7);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.C,4));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testPawn);
    }

    @Test
    public void testGetPossibleDestinationsWhiteWithTwoOpponents()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.D, 3));
        Pawn opponentTestPawn1 = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.C,7);
        opponentTestPawn1.moveTo(testGame.getBoard().getTileAt(Column.C,4));
        Pawn opponentTestPawn2 = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.E,7);
        opponentTestPawn2.moveTo(testGame.getBoard().getTileAt(Column.E,4));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ D4 ---- ], [ E4 P(b) ], [ C4 P(b) ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }

    @Test
    public void testGetPossibleDestinationsBlackWithOneOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.D, 6));
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C,2);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.C,5));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ D5 ---- ], [ C5 P(w) ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }

    @Test
    public void testGetPossibleDestinationsBlackWithTwoOpponents()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        testPawn.moveTo(testGame.getBoard().getTileAt(Column.D, 6));
        Pawn opponentTestPawn1 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.C,2);
        opponentTestPawn1.moveTo(testGame.getBoard().getTileAt(Column.C,5));
        Pawn opponentTestPawn2 = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.E,2);
        opponentTestPawn2.moveTo(testGame.getBoard().getTileAt(Column.E,5));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ E5 P(w) ], [ D5 ---- ], [ C5 P(w) ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }

    @Test
    public void testGetPossibleDestinationsWhiteLeftEdgeWithOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(A, 2);
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.B, 7);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.B, 3));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ B3 P(b) ], [ A3 ---- ], [ A4 ---- ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }
    @Test
    public void testGetPossibleDestinationsBlackLeftEdgeWithOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(A, 7);
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.B, 2);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.B, 6));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ A6 ---- ], [ B6 P(w) ], [ A5 ---- ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }
    @Test
    public void testGetPossibleDestinationsWhiteRightEdgeWithOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.H, 2);
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.G, 7);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.G, 3));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ G3 P(b) ], [ H3 ---- ], [ H4 ---- ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }
    @Test
    public void testGetPossibleDestinationsBlackRightEdgeWithOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testPawn = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.H, 7);
        Pawn opponentTestPawn = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.G, 2);
        opponentTestPawn.moveTo(testGame.getBoard().getTileAt(Column.G, 6));
        //visual confirmation
        System.out.println();
        testGame.getBoard().printBoard();
        assertEquals("[[ H6 ---- ], [ G6 P(w) ], [ H5 ---- ]]", testPawn.getPossibleDestinations().toString());
        System.out.println(testPawn.getPossibleDestinations());
    }
}
