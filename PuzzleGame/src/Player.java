/**
 * @authors:	Patrick Munsey
 * zID: 	z5020841
 * 
 */
public class Player extends Tile{
    private int playerNumber;
    
    public Player(int x, int y, int playerNumber) {
	super(x, y);
	this.playerNumber = playerNumber;
	setText("1");
	// TODO Auto-generated constructor stub
    }

    @Override
    public int getType() {
	// TODO Auto-generated method stub
	return 1;
    }

    
}
