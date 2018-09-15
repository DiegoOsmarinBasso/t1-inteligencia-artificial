package maze.pieces;

import boardgame.Board;
import maze.Color;
import maze.MazePiece;

public class Agent extends MazePiece {

	public Agent(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "A";
	}
	
}
