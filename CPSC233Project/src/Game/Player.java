package Game;
import Pieces.*;

public abstract class Player {
	private boolean white;
	private boolean human;
	private boolean inCheck = false;
	private int difficulty = 0;
	
	public boolean isWhite() {
		return this.white;
	}
	
	public void setWhite(boolean white) {
		this.white = white;
	}
	
	public boolean isHuman() {
		return this.human;
	}
	
	public void setHuman(boolean human) {
		this.human = human;
	}
	
	public boolean isInCheck() {
		return this.inCheck;
	}
	
	public void setCheck(boolean check) {
		this.inCheck = check;
	}

	public int getDifficulty() {
		return this.difficulty;
	}

	public void setDifficulty(int difficulty) {
		this.difficulty = difficulty;
	}
	
	public String printColor() {
		if (this.isWhite()) return "white";
		else return "black";
	}
	
	public Square findKingSquare(Board board) {
		Square kingSquare = null;
		
		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				Square square = board.getSquare(x, y);
				Piece pieceOnSquare = square.getPiece();
				if (pieceOnSquare != null) {
					if (pieceOnSquare instanceof King && pieceOnSquare.isWhite() == this.isWhite()) {
						kingSquare = square;
					}
				}
			}
		}
		
		return kingSquare;
	}
	
	public abstract Move generateMove(Board board);
	
}
