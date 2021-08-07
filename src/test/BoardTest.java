package test;

import exceptions.TileDoesNotExistException;
import model.board.Column;
import model.board.Position;
import model.board.Tile;
import model.board.TileColor;
import model.game.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class BoardTest {
    Game testGame;

    @BeforeEach
    public void setup(){
        testGame = new Game();
    }

    @Test
    public void testGetTileAtNoProblems(){
        Tile testTile = new Tile(new Position(Column.A, 4), TileColor.WHITE);
        try {
            testTile = testGame.getBoard().getTileAt(Column.B, 2);
        } catch (TileDoesNotExistException e) {
            fail("should not have thrown an exception");
        }
        assertEquals(2, testTile.getPosition().getRow());
        assertEquals(Column.B, testTile.getPosition().getColumn());
    }

    @Test
    public void testGetTileAtThrowException(){
        Tile testTile = new Tile(new Position(Column.A, 4), TileColor.WHITE);
        try {
            testTile = testGame.getBoard().getTileAt(Column.B, 10);
        } catch (TileDoesNotExistException e) {
            //good
        }
        assertEquals(4, testTile.getPosition().getRow());
        assertEquals(Column.A, testTile.getPosition().getColumn());
    }

}
