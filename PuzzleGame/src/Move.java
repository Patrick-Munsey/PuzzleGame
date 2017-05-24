
public class Move {

	private Direction direction; 
	private boolean boxMoved;
	private boolean teleported = false;
	
	public Move(Direction direction, boolean boxMoved) {
		this.direction = direction;
		this.boxMoved = boxMoved;
	}
	
	public void setBoxMoved (boolean boxMoved) {
		this.boxMoved = boxMoved;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public boolean getBoxMoved() {
		return this.boxMoved;
	}
	
	public void setTeleported() {
		this.teleported = true;
	}
	
	public boolean getTeleported() {
		return this.teleported;
	}
	
}
