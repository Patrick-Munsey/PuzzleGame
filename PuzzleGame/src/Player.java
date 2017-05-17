/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Player extends Tile{
    private PlayerNumber playerNumber;
    
    public Player(int x, int y, PlayerNumber playerNumber) {
	super(x, y);
	this.playerNumber = playerNumber;
	updateLabel();
	// TODO Auto-generated constructor stub
    }

    @Override
    public void updateLabel() {
	label.setText("1");
    }
    

    
}
