import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
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
    private JFrame frame;
    private BufferedImage image = null;
	
    TitleScreen(JFrame frame) throws Exception {
	super();
	this.frame = frame;
	
	try {
	    image = ImageIO.read(new File("images/menuBackground.png"));	
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
	initUI();

    }
	
	protected void paintComponent(Graphics g) {
	    super.paintComponent(g); // paint the background image and scale it to fill the entire space
	    g.drawImage(image, 0, 0, null);
	}
	
	private void initUI() throws Exception{
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.gray);
		this.setBorder(new EmptyBorder(new Insets(300, 0, 0, 0)));
	}
	
}
/*
import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**Generic button with actionlisteners already
 * 
 * @author lindatruong
 *
 */
/*
public class AButton extends JButton {
	
	public AButton(String nameButton){
		super(nameButton);
		initUI();
	}
	
	public AButton(Image image) {
		super(new ImageIcon(image));
		initUI();
	}
	
	public void initUI() {
		setBackground(Color.white);
		setOpaque(true);
		BorderFactory.createLineBorder(Color.gray); //lines the button
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.blue));
			}
	
			@Override
			public void mouseExited(MouseEvent e) {
				setBorder(BorderFactory.createLineBorder(Color.gray));
			}
		});
		
		//addActionListener(new ActionListener(){
		//	@Override
		//	public void actionPerformed(ActionEvent e) 		
		//	}
		//});

	}
}
*/


/*
 AButton start = new AButton("Start Game");
    	AButton instructions = new AButton("Instructions");
		menu.add(start);
		menu.add(Box.createRigidArea(new Dimension(0, 50)));
		menu.add(instructions);

		start.setAlignmentX(Component.CENTER_ALIGNMENT);
		instructions.setAlignmentX(Component.CENTER_ALIGNMENT);

		start.setMaximumSize(new Dimension(300, 100));
		instructions.setMaximumSize(new Dimension(300, 100));

 
 
 */
