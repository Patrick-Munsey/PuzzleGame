import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 
 */

/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public class LevelCompleteScreen extends JPanel{
    private PuzzleGame puzzleGame;
    private int levelNum;
    private String time;
    
    public LevelCompleteScreen(PuzzleGame puzzleGame, int levelNum, String time) {
	this.puzzleGame = puzzleGame;
	this.levelNum = levelNum;
	this.time = time;
	
	initUI();
    }
    
    private void initUI() {
    	this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

    	//adds start button
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
	
	

    	this.add(Box.createVerticalStrut(250));
    	this.add(next_level_button);
    	next_level_button.setAlignmentX(Component.CENTER_ALIGNMENT);
    	next_level_button.setMaximumSize(new Dimension(300, 100));
    }
    
}
