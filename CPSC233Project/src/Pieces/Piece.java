package Pieces;
import Game.*;

public abstract class Piece {
	private boolean white;
	private boolean alive;

    public Piece(boolean isWhite) {
        white = isWhite;
    }

	//override this class in each subclass
	public abstract boolean canMove(Board board, Square start, Square end);
}
