/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Goal {
    private boolean activated;

    Goal() {
	this.activated = false;
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    public void activate() {
	this.activated = true;
    }

    /**
     * @author Patrick Munsey, z5020841
     */
    public void deactivate() {
	this.activated = false;
    }

    /**
     * @author Patrick Munsey, z5020841
     * @return
     */
    public boolean isactivated() {
	return this.activated;
    }
}
