
public class Portal{
	
	private boolean activated;
	private int locX;
	private int locY;
	private Tile toTile;
	private int index;
	
	public Portal(int index) {
		this.activated = false;
		this.index = index;
	}
	
	public void activate(){
		this.activated = true;
	}
	
	public void deactivate(){
		this.activated = false;
	}
	
	public boolean isActivated() {
		return this.activated;
	}
	
	public int getLocX() {
		return this.locX;
	}
	
	public int getLocY() {
		return this.locY;
	}
	
	public void setLocX(int locX) {
		this.locX = locX;
	}
	
	public void setLocY(int locY) {
		this.locY = locY;
	}
	
	public int getIndex() {
		return this.index;
	}
		
}
