
/**
 * 
 */
public class Move {

    private Direction direction; 
    private boolean boxMoved;
    private boolean teleported = false;

    /**
     * @param direction
     * @param boxMoved
     */
    public Move(Direction direction, boolean boxMoved) {
	this.direction = direction;
	this.boxMoved = boxMoved;
    }

    /**
     * @param boxMoved
     */
    public void setBoxMoved (boolean boxMoved) {
	this.boxMoved = boxMoved;
    }

    /**
     * @return
     */
    public Direction getDirection() {
	return this.direction;
    }

    /**
     * @return
     */
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
