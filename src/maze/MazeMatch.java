package maze;

import java.util.ArrayList;
import java.util.List;

import boardgame.Board;
import boardgame.Piece;
import boardgame.Position;
import maze.pieces.Agent;
import maze.pieces.Bag;
import maze.pieces.Chest;
import maze.pieces.Door;
import maze.pieces.Hole;
import maze.pieces.Wall;

public class MazeMatch {

	protected static final int BOARD_ROWS = 10;
	protected static final int BOARD_COLUMNS = 10;

	private Board board;
	private boolean allBags;
	private boolean finalizeMaze;

	private List<Piece> piecesOnTheBoard = new ArrayList<>();
	private List<Piece> capturedPieces = new ArrayList<>();

	public MazeMatch() {
		board = new Board(BOARD_ROWS, BOARD_COLUMNS);
		InitialSetup();
	}

	public boolean getAllBags() {
		return allBags;
	}

	public boolean getFinalizeMaze() {
		return finalizeMaze;
	}

	public MazePiece[][] getPieces() {
		MazePiece[][] mat = new MazePiece[board.getRows()][board.getColumns()];

		for (int i = 0; i < board.getRows(); i++) {
			for (int j = 0; j < board.getColumns(); j++) {
				mat[i][j] = (MazePiece) board.piece(i, j);
			}
		}

		return mat;
	}

	public Bag performMazeMove(Position source, Position target) {
		Agent a = (Agent) board.removePiece(source);
		a.increaseMoveCount();
		Bag capturedBag = (Bag)board.removePiece(target);
		board.placePiece(a, target);

		if (capturedBag != null) {
			piecesOnTheBoard.remove(capturedBag);
			capturedPieces.add(capturedBag);
		}

		return capturedBag;
	}

	public void validateSourcePosition(Position position) {
		Piece source = board.piece(position);
		if (source == null || !(source instanceof Agent)) {
			throw new MazeException("Only the Agent can move.");
		}
	}

	public void validateTargetPosition(Position position) {
		Piece target = board.piece(position);
		if (!(target == null || target instanceof Bag)) {
			throw new MazeException("It is not possible to move to position " + position + ".");
		}
	}
	
	private void placeNewPiece(int row, int column, MazePiece piece) {
		board.placePiece(piece, new Position(row, column));
		piecesOnTheBoard.add(piece);
	}

	private void InitialSetup() {

		placeNewPiece(0, 1, new Agent(board, Color.WHITE));
		
		placeNewPiece(1, 1, new Hole(board, Color.RED));
		
		placeNewPiece(3, 1, new Bag(board, Color.YELLOW));
		placeNewPiece(7, 5, new Bag(board, Color.YELLOW));
		
		placeNewPiece(2, 8, new Chest(board, Color.PURPLE));
		placeNewPiece(5, 8, new Chest(board, Color.PURPLE));
		
		placeNewPiece(4, 9, new Door(board, Color.GREEN));
		
		placeNewPiece(3, 9, new Wall(board, Color.CYAN));
		placeNewPiece(2, 9, new Wall(board, Color.CYAN));
		placeNewPiece(1, 9, new Wall(board, Color.CYAN));
		placeNewPiece(0, 9, new Wall(board, Color.CYAN));
		

	}

}
