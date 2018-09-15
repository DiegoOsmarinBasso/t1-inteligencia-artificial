package maze;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;

public abstract class MazePiece extends Piece {

	private Color color;
	private int moveCount;

	public MazePiece(Board board, Color color) {
		super(board);
		this.color = color;
	}

	public int getMoveCount() {
		return moveCount;
	}

	public Color getColor() {
		return color;
	}

	public void increaseMoveCount() {
		moveCount++;
	}

	public void decreaseMoveCount() {
		moveCount--;
	}

	public Position getPosition() {
		return position;
	}

	protected boolean isThereOpponentPiece(Position position) {
		MazePiece p = (MazePiece) getBoard().piece(position);
		return p != null && p.getColor() != color;
	}

}
