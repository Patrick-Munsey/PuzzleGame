import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * A Type of GamePiece that can be moved around the board using player input
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Player extends GamePiece{
	private PlayerNumber playerNumber;


	/**
	 * Constructor for Player
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
		ImageIcon icon = createImageIcon("images/elmo.png");
		label.setIcon(icon);
	}

}
