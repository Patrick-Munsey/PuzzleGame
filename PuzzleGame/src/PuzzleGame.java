import javax.swing.JFrame;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        initUI();
    }

    private void initUI() {

        createLayout();

        setTitle("Puzzle Game");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void createLayout(JComponent... arg) {

        Container pane = getContentPane();
        GroupLayout gl = new GroupLayout(pane);

        pack();
    }

    private class ButtonListener1 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
           
        }
    }

    private class ButtonListener2 implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
          
        }
    }
}
