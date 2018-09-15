package maze.pieces;

import boardgame.Board;
import maze.Color;
import maze.MazePiece;

public class Bag extends MazePiece {

	public Bag(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "$";
	}

}
