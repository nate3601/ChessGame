package test.piecestest;

import exceptions.NewTileOccupiedException;
import exceptions.PlayerDoesNotOwnPieceOnGivenTileException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.game.Game;
import model.pieces.Knight;
import model.pieces.Pawn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static model.board.Column.E;

public class KnightTest {
    Knight testKnight;
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
        testKnight = (Knight) testGame.getPlayerWhite().getPieceAt(Column.B, 1);
        testKnight.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testKnight);
    }

    @Test
    public void testGetPossibleDestinationsWhiteClearBoardEdge()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testKnight = (Knight) testGame.getPlayerWhite().getPieceAt(Column.B, 1);
        testKnight.moveTo(testGame.getBoard().getTileAt(Column.A, 1));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testKnight);
    }
    @Test
    public void testGetPossibleDestinationsWhiteWithOpponent()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testKnight = (Knight) testGame.getPlayerWhite().getPieceAt(Column.B, 1);
        testKnight.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        Pawn opponentPiece = (Pawn) testGame.getPlayerBlack().getPieceAt(Column.D, 7);
        opponentPiece.moveTo(testGame.getBoard().getTileAt(E, 6));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testKnight);
    }

    @Test
    public void testGetPossibleDestinationsWhiteWithOwn()
            throws TileDoesNotExistException, PlayerDoesNotOwnPieceOnGivenTileException,
            NewTileOccupiedException, TakePieceException {
        testGame.getBoard().clearBoard();
        testKnight = (Knight) testGame.getPlayerWhite().getPieceAt(Column.B, 1);
        testKnight.moveTo(testGame.getBoard().getTileAt(Column.D, 4));
        Pawn ownPiece = (Pawn) testGame.getPlayerWhite().getPieceAt(Column.D, 2);
        ownPiece.moveTo(testGame.getBoard().getTileAt(E, 6));
        System.out.println();
        testGame.getBoard().printBoardWithPossibleDestinations(testKnight);
    }
}
