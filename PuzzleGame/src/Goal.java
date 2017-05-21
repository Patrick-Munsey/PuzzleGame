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
    
    public void activate() {
    	this.activated = true;
    }
    
    public void deactivate() {
    	this.activated = false;
    }
    
    public boolean isactivated() {
    	return this.activated;
    }
}
