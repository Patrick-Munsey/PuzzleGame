
/**
 * Used in the implementation of the undo command by keeping a  history of a prior move
 */
public class Move {

	private Direction direction; 
	private boolean boxMoved;
	private boolean teleported = false;

	/**
	 * Constructor for Move
	 * @param direction
	 * @param boxMoved
	 */
	public Move(Direction direction, boolean boxMoved) {
		this.direction = direction;
		this.boxMoved = boxMoved;
	}

	/**
	 * Method to set that for this move, the box was also moved
	 * @param boxMoved
	 */
	public void setBoxMoved (boolean boxMoved) {
		this.boxMoved = boxMoved;
	}

	/**
	 * Method to get the direction of this move
	 * @return
	 */
	public Direction getDirection() {
		return this.direction;
	}

	/**
	 * @return true is the object moved is a box
	 */
	public boolean getBoxMoved() {
		return this.boxMoved;
	}

	/**
	 * Method to set teleported true
	 */
	public void setTeleported() {
		this.teleported = true;
	}

	/**
	 * @return true if last move was a teleport
	 */
	public boolean getTeleported() {
		return this.teleported;
	}

}
