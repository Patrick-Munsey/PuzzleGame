import java.awt.AlphaComposite;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;


/**
 * A GamePiece that can be placed on floor tiles
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class Box extends GamePiece{
	private int level;
	private boolean boxActive = false;
	/**
	 * 
	 */
	public Box() {
	}

	/* (non-Javadoc)
	 * @see GamePiece#updateLabel(javax.swing.JLabel)
	 */
	@Override
	public void updateLabel(JLabel label, int lvNum) {
		level = lvNum;
		ImageIcon icon = createImageIcon("images/box.png");
		if (boxActive) {
			icon = createImageIcon("images/monsterGoal2.png");
		}

		ImageIcon newIcon = applyLayer(icon);
		label.setIcon(newIcon);
		//label.setIcon(icon);
	}

	@Override
	public boolean isBox() {
		return true;
	}

	@Override
	public void updateBoxActive() {
		boxActive = true;
	}

	@Override
	public void updateBoxDeactivate() {
		boxActive = false;

	}

	public ImageIcon applyLayer(ImageIcon oldIcon) {
		JLabel newLabel = new JLabel();

		//ImageIcon oldIcon = (ImageIcon) oldLabel.getIcon();    
		int w = oldIcon.getIconWidth();
		int h = oldIcon.getIconHeight();
		BufferedImage oldImg = new BufferedImage(w, h, BufferedImage.TRANSLUCENT);
		Graphics2D g2d = (Graphics2D) oldImg.getGraphics();
		oldIcon.paintIcon(null, g2d, 0, 0);
		BufferedImage newImg = getImageOverlay(oldImg);
		g2d.dispose();
		ImageIcon newIcon = new ImageIcon(newImg);
		return newIcon;
	}

	private BufferedImage getImageOverlay(BufferedImage oldImg) {
		BufferedImage newImg = null;
		try {
			newImg = ImageIO.read(new File("src/images/floor.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}	
		//BImage = newImg;

		int w = oldImg.getWidth();
		int h = oldImg.getHeight();

		BufferedImage combined = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

		Graphics2D g2d = combined.createGraphics();

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1.0F));
		//g2d.drawImage(oldImg, null, 0, 0);
		g2d.drawImage(newImg, 0, 0, null);
		g2d.drawImage(oldImg, 0, 0, null);


		g2d.dispose();
		return combined;
	}

}
