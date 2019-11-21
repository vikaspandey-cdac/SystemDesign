package com.design.onlinechess.pieces;

import com.design.onlinechess.Board;
import com.design.onlinechess.Box;

public abstract class Piece {
	
	private boolean killed =false;
	private boolean white = false;
	
	public Piece(boolean white) {
		this.white = white;
	}
	public boolean isKilled() {
		return killed;
	}
	public void setKilled(boolean killed) {
		this.killed = killed;
	}
	public boolean isWhite() {
		return white;
	}
	public void setWhite(boolean white) {
		this.white = white;
	}
	
	public abstract boolean canMove(Board board, Box start, Box end);
	

}
