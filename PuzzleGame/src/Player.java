import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Player extends GamePiece implements Piece{
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
		ImageIcon icon = createImageIcon("images/" + lvNum + "/player.png");
		label.setIcon(icon);
    	//this.draw();
    }
    
    public JLabel draw(JLabel label){
    	return label;
    }
    
    //overlaylayout
    //something needs to hold this layout
    //can try parent/child JLabels
    //each shape decorate can create the image, and return a JLabel 
    //the jlabel will take in a 'parent' label and spit out a child label with added decorator
    //each piece will then
    
    //always paint floor (parent)
    //sometimes paint goal(floor->goal->___) i.e. box is painted on or player is painted on. 
    //i.e. floor is normal, and floor is everywhere but the "walls"
    //need goalDecorator, (hand in floor Jlabel and apply goal)
    //need player decorator (hand in floor Jlabel and apply player, hand in goal/floor and add player)
    //need box decorator (hand in floor Jlabel and apply player, hand in goal/floor and add player)
    
    
    //if gamepiece "goal isactive" apply  decorator
}
