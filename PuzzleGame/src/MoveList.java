import java.util.Stack;

/**
 * Used in the implementation of the undo command, maintains and manipulates the list of Moves when a move is performed or requested
 * 
 */
public class MoveList {
	
	public static int moveCount = 0;
	private Stack<Move> moves = new Stack<Move>();
	public static boolean boxInPortal = false;
	public static boolean playerInPortal = false;
	
	public MoveList() {
		
	}
	
	public void clear() {
		moves.clear();
	}
	
	public void addMove(Direction direction, boolean boxMoved) {
		Move move = new Move(direction, boxMoved);
		moves.push(move);
	}
	
	public Move undoMove() {
		
		if (moves.isEmpty()) {
			return null;
		}
		
		Move moved = moves.pop();
		boolean boxToMove = moved.getBoxMoved();
		boolean wasTeleport = moved.getTeleported();
		
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
			if (wasTeleport == true) {
				undoMove.setTeleported();
			}
			return undoMove;
		} else {
			return null;
		}

	}
	
	public void setTeleported() {
		Move lastMove = moves.peek();
		lastMove.setTeleported();
	}
	
	public boolean checkTeleported() {
		Move lastMove = moves.peek();
		return lastMove.getTeleported();
	}

}
