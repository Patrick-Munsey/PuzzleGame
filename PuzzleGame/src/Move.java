
/**
 * 
 */
public class Move {

    private Direction direction; 
    private boolean boxMoved;

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

}
