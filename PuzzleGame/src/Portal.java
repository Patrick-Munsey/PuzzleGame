
/**
 * Can be added to the game Board in order to teleport the Player between portals when moved into
 */
public class Portal{

	private boolean activated;
	private int locX;
	private int locY;
	private int index;

	/**
	 * Constructor for Portal
	 * @param index
	 */
	public Portal(int index) {
		this.activated = false;
		this.index = index;
	}

	/**
	 * Method to activate portal
	 */
	public void activate(){
		this.activated = true;
	}

	/**
	 * Method to deactivate portal
	 */
	public void deactivate(){
		this.activated = false;
	}

	/**
	 * Method to check if portal is activated
	 * @return whether the portal is activated
	 */
	public boolean isActivated() {
		return this.activated;
	}

	/**
	 * @return the x ordinate of the portal location
	 */
	public int getLocX() {
		return this.locX;
	}

	/**
	 * @return the y ordinate of the portal location
	 */
	public int getLocY() {
		return this.locY;
	}

	/**
	 * Method to set the X ordinate of the portal location
	 * @param locX
	 */
	public void setLocX(int locX) {
		this.locX = locX;
	}

	/**
	 * Method to set the Y ordinate of the portal location
	 * @param locY
	 */
	public void setLocY(int locY) {
		this.locY = locY;
	}

	/**
	 * @return the index of the portal: used to match portal with portal location
	 */
	public int getIndex() {
		return this.index;
	}

}
