import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Player extends GamePiece{
    private PlayerNumber playerNumber;


    /**
     * @param playerNumber
     */
    public Player(PlayerNumber playerNumber) {
	this.playerNumber = playerNumber;
    }

    /* (non-Javadoc)
     * @see GamePiece#updateLabel(javax.swing.JLabel)
     */
    @Override
    public void updateLabel(JLabel label, int lvNum) {
	//ImageIcon icon = createImageIcon("images/" + lvNum + "/player.png");
	ImageIcon icon = createImageIcon("images/elmo.png");
	label.setIcon(icon);
    }
    
}
