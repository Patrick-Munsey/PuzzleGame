import java.awt.LayoutManager;

import javax.swing.JLabel;
import javax.swing.OverlayLayout;

public abstract class PieceDecorator implements Piece{
	protected Piece decoratedPiece;
	
	public PieceDecorator(Piece decoratedPiece){
		this.decoratedPiece = decoratedPiece; //looking at opening them for jlabel
	}
	
	/**
	 * implements the draw function
	 */
	public JLabel draw(JLabel oldLabel){
		JLabel newLabel = new JLabel(); //child/parent label
		//newLabel.setLayout(new OverlayLayout(newLabel));
		newLabel = decoratedPiece.draw(oldLabel);
		return newLabel;
	}
}
