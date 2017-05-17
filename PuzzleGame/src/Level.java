import java.util.ArrayList;

public class Level {

	private ArrayList<String> level = new ArrayList<String>();
	
	public ArrayList<String> getLevel () {
		return this.level;
	}
	
	public void addRow(String row) {
		level.add(row);
	}
	
}
