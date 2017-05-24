import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
class Tile extends JLabel implements Piece{
    protected int x;
    protected int y;

    /**
     * @param x
     * @param y
     */
    public Tile(int x, int y) {
	super();
	this.x = x;
	this.y = y;
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

    /**
     * @param path
     * @return
     */
    public ImageIcon createImageIcon(String path) {
    	java.net.URL imgURL = Wall.class.getResource(path);
    	if (imgURL != null) {
    		return new ImageIcon(imgURL);
    	} else {
    		System.err.println("Couldn't find file: " + path);
    		return null;
    	}
    }

	public JLabel draw(JLabel Label) {
		// TODO Auto-generated method stub
		return null;
	}
}
