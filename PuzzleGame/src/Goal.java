/**
 * Can be placed on a Tile and is used to check end game state
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Goal {
	private boolean activated;

	/**
	 * Constructor for Goal
	 */
	Goal() {
		this.activated = false;
	}

	/**
	 * author Patrick Munsey, z5020841
	 * activates a goal to record the fact that a box is at its current location
	 */
	public void activate() {
		this.activated = true;
	}

	/**
	 * author Patrick Munsey, z5020841
	 * deactivates a goal to record the fact that a box is not at its current location
	 */
	public void deactivate() {
		this.activated = false;
	}

	/**
	 * author Patrick Munsey, z5020841
	 * @return true if the goal is occupied by a box
	 */
	public boolean isactivated() {
		return this.activated;
	}
}
