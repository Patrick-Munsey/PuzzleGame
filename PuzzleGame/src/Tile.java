import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
class Tile extends JLabel{
    protected int x;
    protected int y;
    protected int lvNum;
    
    /**
     * @param x
     * @param y
     */
    public Tile(int x, int y, int lvNum) {
	super();
	this.x = x;
	this.y = y;
	this.lvNum = lvNum;
	updateLabel();
    }

	/**
	 * 
	 */
	// this.setIcon(Icon i)
	public void updateLabel() {
		this.setText("0");
	}

    /**
     * @return true if the Tile is able to be occupied by a GamePiece
     */
    public boolean isMoveable() {
	return false;
    }

    /**
     * @param gamepiece
     */
    public void placeGamePiece(GamePiece gamepiece) {	
    }

    /**
     * @return the GamePiece from the tile
     */
    public GamePiece removeGamePiece() {
	return null;
    }

    /**
     * @param goal
     */
    public void placeGoal(Goal goal) {
    }

    /**
     * 
     */
    public void removeGoal() {
    }

    /**
     * @param portal
     */
    public void placePortal(Portal portal) {

    }

    /**
     */
    public void setPortalLoc() {

    }

    /**
     * @param num
     */
    public void setLocNum(int num) {
    }

    /**
     * @return
     */
    public int getLocNum() {
	return -1;
    }
    
    public boolean isPortal() {
    	return false;
    }
    
    public ImageIcon createImageIcon(String path) {
	java.net.URL imgURL = Wall.class.getResource(path);
	if (imgURL != null) {
	    return new ImageIcon(imgURL);
	} else {
	    System.err.println("Couldn't find file: " + path);
	    return null;
	}
    }
}
