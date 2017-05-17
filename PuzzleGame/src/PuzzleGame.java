import javax.swing.JFrame;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import static javax.swing.GroupLayout.Alignment.BASELINE;
import static javax.swing.GroupLayout.DEFAULT_SIZE;
import static javax.swing.GroupLayout.PREFERRED_SIZE;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import static javax.swing.LayoutStyle.ComponentPlacement.RELATED;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

/**
 * @authors: 	Patrick Munsey
 * zID: 	z5020841
 * 
 */

public class PuzzleGame extends JFrame{

    private Board board;
    
    /**
     * @param args
     */
    public static void main(String[] args) {
	System.out.println("Hello World!\n");
	
	       EventQueue.invokeLater(() -> {
		   PuzzleGame puzzlegame = new PuzzleGame();
		   puzzlegame.setVisible(true);
	        });
    }
    
    public PuzzleGame() {
	this.board = new Board();
        initUI();
    }

    private void initUI() {

        createLayout();
        this.add(board);
        board.revalidate();
        board.repaint();
        
        setSize(400, 400);
        setTitle("Puzzle Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        addKeyListener(new BoardAdapter());
        
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);

        pack();
    }

    class BoardAdapter extends KeyAdapter {
	    
	    @Override
	    public void keyPressed(KeyEvent e) {

	        int keycode = e.getKeyCode();

	        switch (keycode) {
	            
	        case KeyEvent.VK_LEFT:
	            board.MovePlayer(1, 1);
	            break;
	            
	        case KeyEvent.VK_RIGHT:
	            
	            break;
	            
	        case KeyEvent.VK_DOWN:
	            
	            break;
	            
	        case KeyEvent.VK_UP:
	            
	            break;
	            
	        case KeyEvent.VK_SPACE:
	            
	            break;
	        }
	    }
	}
    
}

