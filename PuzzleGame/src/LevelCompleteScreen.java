import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class LevelCompleteScreen extends JPanel{
    private PuzzleGame puzzleGame;
    private int levelNum;
    private String time;
    private Image background_img;

    /**
     * @param puzzleGame
     * @param levelNum
     * @param time
     */
    public LevelCompleteScreen(PuzzleGame puzzleGame, int levelNum, String time) {
	this.puzzleGame = puzzleGame;
	this.levelNum = levelNum;
	this.time = time;
	this.background_img = new ImageIcon("src/images/level_complete_background.png").getImage();
	Dimension size = new Dimension(background_img.getWidth(null), background_img.getHeight(null));
	setPreferredSize(size);
	setMinimumSize(size);
	setMaximumSize(size);
	setSize(size);
	setLayout(null);
	initUI();
    }

    private void initUI() {
	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

	JLabel CompletionText = new JLabel ("LEVEL " + levelNum + " COMPLETE!!\n" + time);
	CompletionText.setFont(new Font("serif", Font.BOLD, 16));
	CompletionText.setAlignmentX(Component.CENTER_ALIGNMENT);

	this.add(Box.createVerticalStrut(100));
	this.add(CompletionText);
	this.add(Box.createVerticalStrut(20));
	
	if (levelNum != 13) {
		// have an option to go to the next level
		JButton next_level_button = new JButton("Next Level");
		next_level_button.setBackground(Color.white);
		next_level_button.setOpaque(true);
		next_level_button.setBorder(BorderFactory.createLineBorder(Color.gray,3));
		next_level_button.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseEntered(MouseEvent e) {
			next_level_button.setBorder(BorderFactory.createLineBorder(Color.blue,3));
		    }
	
		    @Override
		    public void mouseExited(MouseEvent e) {
			next_level_button.setBorder(BorderFactory.createLineBorder(Color.gray,3));
		    }
		});
		next_level_button.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			levelNum = levelNum + 1;
			puzzleGame.changeLevel(levelNum);
		    }
		});
		
		this.add(next_level_button);
		next_level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
		next_level_button.setMaximumSize(new Dimension(300, 100));
	} else {
		// don't have an option to go next level, but congratulate them on completing the game
		JLabel completion = new JLabel ("You've finished the whole game. Time for Cookies...");
		completion.setFont(new Font("serif", Font.BOLD, 16));
		this.add(completion);
		completion.setAlignmentX(Component.CENTER_ALIGNMENT);
	}
    }

    protected void paintComponent(Graphics g) {
	super.paintComponent(g); // paint the background image and scale it to fill the entire space
	g.drawImage(background_img, 0, 0, this.getWidth(), this.getHeight(), null);
    }

}
