package test.piecestest;

import exceptions.NewTileOccupiedException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.board.Tile;
import model.game.Game;
import model.pieces.GenericPiece;
import model.pieces.Piece;
import model.pieces.PieceColor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class PieceTest {
    Game testGame;
    Piece testPiece;

    @BeforeEach
    public void setup(){
        testGame = new Game();
        testPiece = new GenericPiece(testGame, PieceColor.WHITE);
    }

    @Test
    public void testMoveToOccupiedTile() throws TileDoesNotExistException {
        testPiece.setTile( testGame.getBoard().getTileAt(Column.A, 3));
        Tile newTile = testGame.getBoard().getTileAt(Column.A, 2);
        try {
            testPiece.moveTo(newTile);
        } catch (NewTileOccupiedException e) {
            //good
        } catch (TakePieceException e) {
            fail("should not have thrown this exception");
        }
        assertEquals(testGame.getBoard().getTileAt(Column.A, 3), testPiece.getTile());
    }
}
