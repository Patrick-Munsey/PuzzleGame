import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class KeyInput extends KeyAdapter {

	public KeyInput() {
		System.out.println("KeyInput created");
	}
	
    @Override
    public void keyPressed(KeyEvent e) {
    	System.out.println("Key has been presssed");

        int keycode = e.getKeyCode();

        switch (keycode) {
            
        case KeyEvent.VK_LEFT:
        	System.out.println("LEFT");
//            MovePlayer(PlayerNumber.Player1, Direction.LEFT);
            break;
            
        case KeyEvent.VK_RIGHT:
//            MovePlayer(PlayerNumber.Player1, Direction.RIGHT);
            break;
            
        case KeyEvent.VK_DOWN:
//            MovePlayer(PlayerNumber.Player1, Direction.DOWN);
            break;
            
        case KeyEvent.VK_UP:
//            MovePlayer(PlayerNumber.Player1, Direction.UP);
            break;
            
        case KeyEvent.VK_U:
//        	undoMove(PlayerNumber.Player1);
        	break;
        	
        case KeyEvent.VK_R:
//        	restart();
        	break;
        	
        case KeyEvent.VK_ESCAPE:
        	System.exit(1);
        	break;
        }
    }
}