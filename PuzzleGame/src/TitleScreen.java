import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Box;

/**Home page
 * @author lindatruong
 *
 */
public class TitleScreen extends JPanel{
    private PuzzleGame puzzleGame;
    private BufferedImage image = null;

    TitleScreen(PuzzleGame puzzleGame) throws Exception {
	super();
	this.puzzleGame = puzzleGame;

	try {
	    image = ImageIO.read(new File("src/images/menuBackground.png"));	
	} catch (IOException e) {
	    e.printStackTrace();
	}

	initUI();

    }

    private void initUI() throws Exception{
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    	//adds start button
    	JButton start_button = new JButton("Start");
    	start_button.setBackground(Color.white);
    	start_button.setOpaque(true);
    	start_button.setBorder(BorderFactory.createLineBorder(Color.gray));
    	start_button.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			start_button.setBorder(BorderFactory.createLineBorder(Color.blue));
    		}

    		@Override
    		public void mouseExited(MouseEvent e) {
    			start_button.setBorder(BorderFactory.createLineBorder(Color.gray));
    		}
    	});
	
    	start_button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			puzzleGame.displayBoard();
    		}
    	});
	
	
    	//adds JButton
    	JButton instructions_button = new JButton("Instructions");
    	instructions_button.setBackground(Color.white);
    	instructions_button.setOpaque(true);
    	instructions_button.setBorder(BorderFactory.createLineBorder(Color.gray));
    	instructions_button.addMouseListener(new MouseAdapter() {
    		@Override
    		public void mouseEntered(MouseEvent e) {
    			instructions_button.setBorder(BorderFactory.createLineBorder(Color.blue));
    		}

    		@Override
    		public void mouseExited(MouseEvent e) {
    			instructions_button.setBorder(BorderFactory.createLineBorder(Color.gray));
    		}
    	});
	
    	instructions_button.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			puzzleGame.displayInstructionsDialog();
    		}
    	});

    	this.add(Box.createVerticalStrut(250));
    	this.add(start_button);
    	this.add(Box.createRigidArea(new Dimension(0, 50)));
    	this.add(instructions_button);

    	start_button.setAlignmentX(Component.CENTER_ALIGNMENT);
    	instructions_button.setAlignmentX(Component.CENTER_ALIGNMENT);

    	start_button.setMaximumSize(new Dimension(300, 100));
    	instructions_button.setMaximumSize(new Dimension(300, 100));
    }

    protected void paintComponent(Graphics g) {
    	super.paintComponent(g); // paint the background image and scale it to fill the entire space
    	g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}