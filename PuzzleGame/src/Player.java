import javax.swing.JLabel;

/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Player extends GamePiece{
    private PlayerNumber playerNumber;
    

    public Player(PlayerNumber playerNumber) {
		this.playerNumber = playerNumber;
    }

    @Override
    public void updateLabel(JLabel label) {
	label.setText("P");
    }

    

    
}
