package model.pieces;

import exceptions.NewTileOccupiedException;
import exceptions.TakePieceException;
import exceptions.TileDoesNotExistException;
import model.board.Tile;
import model.game.Game;

import java.util.HashSet;

public abstract class Piece {
    private Game game;
    private PieceColor color;
    private Tile tile;

    public enum YDirection {
        UP, DOWN, NEUTRAL;
    }
    public enum XDirection {
        LEFT, RIGHT, NEUTRAL;
    }

    public Piece(Game game, PieceColor color) {
        this.color = color;
        this.game = game;
        if (color == PieceColor.WHITE) {
            game.playerWhite.addPiece(this);
        } else {
            game.playerBlack.addPiece(this);
        }
    }

    /**
     * getters and setters
     *
     * @return
     */
    public PieceColor getColor() {
        return this.color;
    }

    public void setTile(Tile t) {
        if (tile != t) {
            this.tile = t;
            t.setPiece(this);
        }
    }

    public Tile getTile() {
        return tile;
    }

    public Game getGame() {
        return game;
    }

    /**
     * moves this to newTile, assuming newTile is unoccupied. If newTile is occupied by opposing piece, calls take()
     *
     * @param newTile
     * @throws NewTileOccupiedException
     */
    public void moveTo(Tile newTile)
            throws NewTileOccupiedException, TakePieceException {
        if (newTile.isOccupied() && (newTile.getPiece().getColor() == this.color)) {
            throw new NewTileOccupiedException();
        }
        if (newTile.isOccupied() && (newTile.getPiece().getColor() != this.color)) {
            Tile oldTile = tile;
            Piece opponentPiece = newTile.getPiece();
            setTile(newTile);
            oldTile.makeUnoccupied();
            throw new TakePieceException(opponentPiece);
        }
        Tile oldTile = tile;
        setTile(newTile);
        oldTile.makeUnoccupied();
    }

    /**
     * returns a set of the possible Tiles this could be moved to
     * @return
     * @throws TileDoesNotExistException
     */
    public abstract HashSet<Tile> getPossibleDestinations() throws TileDoesNotExistException;

    public HashSet<Tile> tilesInOneDirection(int numberOfTilesToCheck,
                                             int rowLocation,
                                             int columnLocation,
                                             YDirection y,
                                             XDirection x) {
        HashSet<Tile> possibleDestinationsInThisDirection = new HashSet<>();
        boolean hasNotReachedPiece = true;
        int i = 1;
        while (hasNotReachedPiece && i <= numberOfTilesToCheck) {
            Tile nextUp = getNextTile(rowLocation, columnLocation, y, x, i);
            if (nextUp.isOccupied() && !nextUp.isOccupiedByOpponent(this)) {
                hasNotReachedPiece = false;
            } else if (nextUp.isOccupied() && nextUp.isOccupiedByOpponent(this)) {
                possibleDestinationsInThisDirection.add(nextUp);
                hasNotReachedPiece = false;
            } else {
                possibleDestinationsInThisDirection.add(nextUp);
                i++;
            }
        }
        return possibleDestinationsInThisDirection;
    }

    public Tile getNextTile(int rowLocation, int columnLocation, YDirection y, XDirection x, int i) {
        switch (y) {
            case UP:
                switch (x) {
                    case LEFT: return getGame().getBoard().getTiles()[rowLocation - i][columnLocation - i];
                    case RIGHT: return getGame().getBoard().getTiles()[rowLocation - i][columnLocation + i];
                    default: return getGame().getBoard().getTiles()[rowLocation - i][columnLocation];
                }
            case DOWN:
                switch (x) {
                    case LEFT: return getGame().getBoard().getTiles()[rowLocation + i][columnLocation - i];
                    case RIGHT: return getGame().getBoard().getTiles()[rowLocation + i][columnLocation + i];
                    default: return getGame().getBoard().getTiles()[rowLocation + i][columnLocation];
                }
            default:
                switch (x) {
                    case LEFT: return getGame().getBoard().getTiles()[rowLocation][columnLocation - i];
                    case RIGHT: return getGame().getBoard().getTiles()[rowLocation][columnLocation + i];
                    default: return getGame().getBoard().getTiles()[rowLocation][columnLocation];
                }
        }
    }
}
