package Pieces;

import Game.*;

public class King extends Piece {
	
    public King(boolean isWhite) {
        super(isWhite);
    }
    
    @Override
    public char getPieceChar() {
        return 'k';
    }

    @Override
    public boolean canMove(Board board, Move move) {
        // 1. Verify that the end square isn't occupied by a piece of the same color
        if (move.getEnd().getPiece() != null && move.getEnd().getPiece().isWhite() == this.isWhite()) return false;
        
        // 2. Verify that it can move
        
        // The maximum distance it moves along the x-axis and the y-axis is 1
        if (Math.abs(move.getEnd().getX() - move.getStart().getX()) <= 1 && Math.abs(move.getEnd().getY() - move.getStart().getY()) <= 1) {
        	// Check if any piece on the board is able to attack the king
        	// if the king were to move to this square i.e. put the king in check
        	if (this.canBeCheck(board, move.getEnd())) return false;
        	
        	return true;
        }
        else {
        	return this.isValidCastling(board, move);
        }
    }
	
	/**
	 * Determines whether a move is a valid castling move.
	 * @param board The current board state.
	 * @param move The move to check.
	 * @return True if the move is a castling move, false otherwise.
	 */

    public boolean isValidCastling(Board board, Move move) {
    	if (this.hasMoved()) return false;
    	
    	//Right side castling
    	if (move.getEnd().getX() == 6) {
    		//Bottom player
    		if (move.getEnd().getY() == 7 && move.getStart().getY() == 7 && board.getSquare(5, 7).getPiece() == null && 
    			board.getSquare(7, 7).getPiece() instanceof Rook) {
    			if (this.canBeCheck(board, move.getEnd())) return false;
        		move.setCastlingMove(true);
        		return true;
    		}
    		//Top player
    		else if (move.getEnd().getY() == 0 && move.getStart().getY() == 0 && board.getSquare(5, 0).getPiece() == null && 
    			board.getSquare(7, 0).getPiece() instanceof Rook) {
    			if (this.canBeCheck(board, move.getEnd())) return false;
        		move.setCastlingMove(true);
        		return true;
    		}
    	}
    	//Left side castling
    	else if (move.getEnd().getX() == 2) {
    		//Bottom player
    		if (move.getEnd().getY() == 7 && move.getStart().getY() == 7 && board.getSquare(3, 7) == null && board.getSquare(1, 7) == null && 
    			board.getSquare(0, 7).getPiece() instanceof Rook) {
    			if (this.canBeCheck(board, move.getEnd())) return false;
        		move.setCastlingMove(true);
        		return true;
    		}
    		//Top player
    		else if (move.getEnd().getY() == 0 && move.getStart().getY() == 0 && board.getSquare(3, 0) == null && board.getSquare(1, 0) == null && 
    			board.getSquare(0, 0).getPiece() instanceof Rook) {
    			if (this.canBeCheck(board, move.getEnd())) return false;
        		move.setCastlingMove(true);
        		return true;
    		}
    	}
    	return false;
    }
}
