import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;



/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
@SuppressWarnings("serial")
public class PuzzleGame extends JFrame{
    private Board board;
    private TitleScreen titleScreen;
    private JFrame frame = this;
    private GameTimer gameTimer;
    private int currentLevel;
    private int numPlayers;

    public PuzzleGame() throws Exception {
		//this.board = new Board(this);
		this.titleScreen = new TitleScreen(this);
		this.gameTimer = new GameTimer();
		initUI();
    }


    private void initUI() throws Exception {
        
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
        	displayNewGameDialog();
            }
        });

        JMenuItem optionsMenuItem = new JMenuItem("Options");
        optionsMenuItem.setMnemonic(KeyEvent.VK_O);
        optionsMenuItem.setToolTipText("Change game options");
        optionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	displayOptionsDialog();
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
            	AboutDialog about = new AboutDialog(frame);
            	about.setVisible(true);
            }
        });
        
        JMenuItem instructionsMenuItem = new JMenuItem("Instructions");
        instructionsMenuItem.setMnemonic(KeyEvent.VK_I);
        instructionsMenuItem.setToolTipText("Instructions");
        instructionsMenuItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        	displayInstructionsDialog();
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
	menuBar.add(gameTimer);

        setJMenuBar(menuBar);

<<<<<<< HEAD
       displayTitle();
=======
        //displayTitle();
        displayBoard();
>>>>>>> refs/heads/Denny_2
        
    }
    
    public void displayBoard() {
    	board = new Board(this);
    	this.getContentPane().removeAll();
    	this.add(board);
        board.revalidate();
        board.repaint();
<<<<<<< HEAD
        this.revalidate();
    	this.repaint();
        board.requestFocusInWindow();
=======
        
        System.out.println("Board Displayed");
>>>>>>> refs/heads/Denny_2
    }
    
<<<<<<< HEAD
    public void displayTitle() {
=======
    public void displayTitle() throws Exception {
    	titleScreen = new TitleScreen(this);
>>>>>>> refs/heads/Denny_2
    	this.getContentPane().removeAll();
    	this.add(titleScreen);
    	titleScreen.revalidate();
    	titleScreen.repaint();
    	this.revalidate();
    	this.repaint();
    	titleScreen.requestFocusInWindow();
    }
    
    public void displayInstructionsDialog() {
    	InstructionsDialog instructions = new InstructionsDialog(frame);
    	instructions.setVisible(true);
    }
    
    public void displayOptionsDialog() {
    	OptionsDialog optionsDialog = new OptionsDialog(this);
    	optionsDialog.setVisible(true);
    }
    
    public void displayNewGameDialog() {
	NewGameDialog newGameDialog = new NewGameDialog(this);
	newGameDialog.setVisible(true);
    }
    
    public void changeLevel(int level) {
        this.currentLevel = level;
        //tell the board to reset and init to new level number
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
