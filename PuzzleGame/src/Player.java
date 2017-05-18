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
    public void updateLabel(JLabel label) {
	label.setText("P");
    }

    

    
}
