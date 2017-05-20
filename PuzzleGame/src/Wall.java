import java.awt.Color;

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
    public Wall(int x, int y) {
    	super(x,y);
    }

    /* (non-Javadoc)
     * @see Tile#updateLabel()
     */
    @Override
    public void updateLabel() {
    	ImageIcon icon = createImageIcon("images/wall.png");
    	setIcon(icon);
    }
}
