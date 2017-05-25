import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Wall extends Tile {

    /**
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
