import javax.swing.JFrame;
import javax.swing.JLabel;
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
 * The JFrame for the swing components and contains the main function
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

	/**
	 * @throws Exception
	 */
	public PuzzleGame() throws Exception {
		this.currentLevel = 1;
		this.board = new Board(this);
		this.titleScreen = new TitleScreen(this);
		this.gameTimer = new GameTimer();
		initUI();
		displayTitleScreen();
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
				displayAboutDialog();
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
				restartLevel();
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
	}

	/**
	 * Method to display the board
	 * author Patrick Munsey, z5020841
	 */
	public void displayBoard() {
		this.getContentPane().removeAll();
		this.add(board);
		board.revalidate();
		board.repaint();
		this.revalidate();
		this.repaint();
		board.requestFocusInWindow();
		gameTimer.restart();
	}

	/**
	 * Method to display the Title Screen 
	 * author Patrick Munsey, z5020841
	 */
	public void displayTitleScreen() {
		this.getContentPane().removeAll();
		this.add(titleScreen);
		titleScreen.revalidate();
		titleScreen.repaint();
		this.revalidate();
		this.repaint();
		titleScreen.requestFocusInWindow();
	}

	/**
	 * Method to display a screen for completion of levels
	 * author Patrick Munsey, z5020841
	 */
	public void displayLevelCompleteScreen() {
		gameTimer.pause();
		this.getContentPane().removeAll();
		this.add(new LevelCompleteScreen(this, this.currentLevel, this.gameTimer.toString()));
		this.revalidate();
		this.repaint();
	}

	/**
	 * Method to display the instructions dialog
	 * author Patrick Munsey, z5020841
	 */
	public void displayInstructionsDialog() {
		InstructionsDialog instructions = new InstructionsDialog(frame);
		instructions.setVisible(true);
	}

	/**
	 * Method to display the Options dialog
	 * author Patrick Munsey, z5020841
	 */
	public void displayOptionsDialog() {
		OptionsDialog optionsDialog = new OptionsDialog(this);
		optionsDialog.setVisible(true);
	}

	/**
	 * Method to display a new game dialog to show different levels for selection
	 * author Patrick Munsey, z5020841
	 */
	public void displayNewGameDialog() {
		NewGameDialog newGameDialog = new NewGameDialog(this);
		newGameDialog.setVisible(true);
	}

	/**
	 * Method to display the About dialog
	 * author Patrick Munsey, z5020841
	 */
	public void displayAboutDialog() {
		AboutDialog about = new AboutDialog(frame);
		about.setVisible(true);
	}

	/**
	 * Method to change the number based on an integer input
	 * author Patrick Munsey, z5020841
	 * @param levelNumber
	 */
	public void changeLevel(int levelNumber) {
		this.currentLevel = levelNumber;
		board.changeLevel(levelNumber);
		displayBoard();
	}

	/**
	 * Method to restart the level
	 * author Patrick Munsey, z5020841
	 */
	public void restartLevel() {
		board.restart(); 
		gameTimer.restart();
	}

	/**
	 * Method to change the key bindings between ARROW and WASD
	 * @param presetNum
	 */
	public void changeKeyBindings(int presetNum) {
		board.changeKeyBindings(presetNum);
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
