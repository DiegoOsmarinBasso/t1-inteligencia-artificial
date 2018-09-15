package maze.pieces;

import boardgame.Board;
import maze.Color;
import maze.MazePiece;

public class Chest extends MazePiece {

	public Chest(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "C";
	}

}
