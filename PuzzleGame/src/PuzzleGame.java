import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.ComponentOrientation;
import java.awt.Frame;
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

    private Menu menu;
    private JFrame the_frame = this;



    public PuzzleGame() throws Exception {
		this.board = new Board();
		this.menu = new Menu();
		initUI();
    }


    private void initUI() {
    	//setup the JFrame
    	this.add(menu);
    	menu.revalidate();
    	menu.repaint();

        //this.add(board);
        //board.revalidate();
        //board.repaint();
        
        setSize(950, 700);
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
            	OptionsDialog options = new OptionsDialog(the_frame);
            	options.setVisible(true);
            }
        });

        JMenuItem exitMenuItem = new JMenuItem("Exit");
        exitMenuItem.setMnemonic(KeyEvent.VK_E);
        exitMenuItem.setToolTipText("Exit application");
        exitMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	System.exit(0);
            }
        });
        
        JMenuItem aboutMenuItem = new JMenuItem("About");
        aboutMenuItem.setMnemonic(KeyEvent.VK_A);
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	AboutDialog about = new AboutDialog(the_frame);
            	about.setVisible(true);
            }
        });
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_I);
        instructionsMenuItem.setToolTipText("Instructions");
        instructionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
	        	InstructionsDialog instructions = new InstructionsDialog(the_frame);
	        	instructions.setVisible(true);
            }
        });
        
        JMenuItem restartMenuItem = new JMenuItem("Restart");
        restartMenuItem.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); 
        restartMenuItem.setMnemonic(KeyEvent.VK_R);
        restartMenuItem.setToolTipText("Restart Game");
        restartMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	board.restart(); 
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
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception {
	    PuzzleGame puzzlegame = new PuzzleGame();
	    puzzlegame.setVisible(true);
    }
}
