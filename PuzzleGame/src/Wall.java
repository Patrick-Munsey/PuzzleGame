import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * A Type of Tile that the Player is not able to move on
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Wall extends Tile {

	/**
	 * Constructor for the Wall, changes depending on level
	 * @param x
	 * @param y
	 */
	public Wall(int x, int y, int lvNum) {
		super(x,y, lvNum);
	}

	/* (non-Javadoc)
	 * @see Tile#updateLabel()
	 */
	@Override
	public void updateLabel() {
		ImageIcon image = new ImageIcon("src/images/" + lvNum + "/wall.png");
		setIcon(image);
	}

	/* (non-Javadoc)
	 * @see Tile#isMoveable()
	 */
	@Override
	public boolean isMoveable() {
		return false;
	}

}
