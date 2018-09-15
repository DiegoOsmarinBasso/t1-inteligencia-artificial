package maze.pieces;

import boardgame.Board;
import maze.Color;
import maze.MazePiece;

public class Hole extends MazePiece {

	public Hole(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "O";
	}

}
