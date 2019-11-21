package com.design.onlinechess.pieces;

import com.design.onlinechess.Board;
import com.design.onlinechess.Box;

public class Knight extends Piece {
	

	public Knight(boolean white) {
		super(white);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean canMove(Board board, Box start, Box end) {
		
		if(end.getPiece().isWhite() == this.isWhite()) {
			return false;
		}
		
		int x = Math.abs(start.getX() - end.getY());
		int y = Math.abs(start.getX() - end.getY());
		
		return x * y == 2;
	}

}
