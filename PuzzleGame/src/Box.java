import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Box extends GamePiece{

    /**
     * 
     */
    public Box() {
    }

    /* (non-Javadoc)
     * @see GamePiece#updateLabel(javax.swing.JLabel)
     */
    @Override
    public void updateLabel(JLabel label) {
    ImageIcon icon = createImageIcon("images/box.png");
    label.setIcon(icon);
    }
    
}
