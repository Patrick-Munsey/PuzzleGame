import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JComponent;



/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
@SuppressWarnings("serial")
public class PuzzleGame extends JFrame{
    private Board board;

    public PuzzleGame() {
	this.board = new Board();
	initUI();
    }


    private void initUI() {
    	//setup the JFrame
        this.add(board);
        board.revalidate();
        board.repaint();
        
        setSize(400, 400);
        setTitle("Puzzle Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //setup the JMenu items (buttons etc)
        JMenuItem newGameMenuItem = new JMenuItem("New Game");
        newGameMenuItem.setMnemonic(KeyEvent.VK_N);
        newGameMenuItem.setToolTipText("Start a new game");
        newGameMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("New Game button pressed");
            }
        });

        JMenuItem optionsMenuItem = new JMenuItem("Options");
        optionsMenuItem.setMnemonic(KeyEvent.VK_O);
        optionsMenuItem.setToolTipText("Change game options");
        optionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("Options button pressed");
            }
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("Exit button pressed");
            }
        });
        
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("About button pressed");
            }
        });
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_I);
        instructionsMenuItem.setToolTipText("Instructions");
        instructionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("instructions button pressed");
            }
        });
        
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        restartMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
        restartMenuItem.setMnemonic(KeyEvent.VK_R);
        restartMenuItem.setToolTipText("Instructions");
        restartMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	System.out.println("Restart button pressed");
        	board.restart(); //TODO this is not restarting the game
            }
        });

        //add all of the Jmenu items to the Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu game = new JMenu("Game");
        game.add(newGameMenuItem);
        game.add(optionsMenuItem);
        game.add(exitMenuItem);
        menuBar.add(game);
        JMenu help = new JMenu("Help");
        help.add(instructionsMenuItem);
        help.add(aboutMenuItem);
        menuBar.add(help);
        menuBar.add(Box.createHorizontalGlue());
        menuBar.add(restartMenuItem);

        
        /*
	JMenu timerdisplay = new JMenu(gameTimer.toString());
	gameTimer.restart();
	gameTimer.setTimeDisplay(timerdisplay);
	timerdisplay.update(getGraphics());
	menuBar.add(timerdisplay);
	*/
        setJMenuBar(menuBar);

    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	    PuzzleGame puzzlegame = new PuzzleGame();
	    puzzlegame.setVisible(true);
    }
}
