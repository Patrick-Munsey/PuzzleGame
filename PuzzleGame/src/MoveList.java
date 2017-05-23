import java.util.Stack;

public class MoveList {
	
	public static int moveCount = 0;
	private Stack<Move> moves = new Stack<Move>();
	public static boolean boxInPortal = false;
	
	public MoveList() {
		
	}
	
	public void clear() {
		moves.clear();
	}
	
	public void addMove(Direction direction, boolean boxMoved) {
		Move move = new Move(direction, boxMoved);
		moves.push(move);
		moveCount++;
	}
	
	public Move undoMove() {
		
		if (moves.isEmpty()) {
			return null;
		}
		
		Move moved = moves.pop();
		moveCount--;
		boolean boxToMove = moved.getBoxMoved(); 
		
		Direction undo = null;
		Move undoMove;
		
		switch(moved.getDirection()) {
		
		case UP: 
			undo = Direction.DOWN;
			break;
		
		case DOWN: 
			undo = Direction.UP;
			break;
			
		case LEFT: 
			undo = Direction.RIGHT;
			break;
			
		case RIGHT: 
			undo = Direction.LEFT;
			break;
			
		default:
			break;
		}
		
		if (undo != null) {
			undoMove = new Move(undo, boxToMove);
			return undoMove;
		} else {
			return null;
		}

	}

}
