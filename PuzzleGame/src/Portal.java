
/**
 * 
 */
public class Portal{

    private boolean activated;
    private int locX;
    private int locY;
    private Tile toTile;
    private int index;

    /**
     * @param index
     */
    public Portal(int index) {
	this.activated = false;
	this.index = index;
    }

    /**
     */
    public void activate(){
	this.activated = true;
    }

    /**
     */
    public void deactivate(){
	this.activated = false;
    }

    /**
     * @return
     */
    public boolean isActivated() {
	return this.activated;
    }

    /**
     * @return
     */
    public int getLocX() {
	return this.locX;
    }

    /**
     * @return
     */
    public int getLocY() {
	return this.locY;
    }

    /**
     * @param locX
     */
    public void setLocX(int locX) {
	this.locX = locX;
    }

    /**
     * @param locY
     */
    public void setLocY(int locY) {
	this.locY = locY;
    }

    /**
     * @return
     */
    public int getIndex() {
	return this.index;
    }

}
