import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Level {

	private ArrayList<String> level = new ArrayList<String>();
	private int height;
	private int width;
	private int num;
	private Difficulty diff;
	
	public ArrayList<String> getLevel () {
		return this.level;
	}
	
	public void addRow(String row) {
		level.add(row);
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public int getWidth(){
		return this.width;
	}
	
	public void makeLevelFromFile(String filePath){
		
		/*input file format:
		x,y
		###...
		###...
		etc
		*/
		
		Scanner sc = null;
		
		try
		{
			sc = new Scanner(new FileReader(filePath));
		}
		catch(FileNotFoundException e){
			System.out.println("File read failed");
		}
		
		finally
		{
			if(sc!=null) {
				sc.useDelimiter("\n");
				ArrayList<String> inputLines = new ArrayList<String>();
				
				//populate input lines
				while (sc.hasNext()){
					inputLines.add(sc.next());
				}
				sc.close();
				
				//process input lines
				String dimLine = inputLines.remove(0);
				String[] dimensions = dimLine.split(","); //dimensions
				int width = Integer.parseInt(dimensions[0].trim());
				
				int height = Integer.parseInt(dimensions[1].trim());
				
				
				this.width = width;
				this.height = height;
				
				
				for(String currLine : inputLines){
					  this.addRow(currLine);					
				}
			}
		}
		
		return;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Difficulty getDiff() {
		return diff;
	}

	public void setDiff(Difficulty diff) {
		this.diff = diff;
	}
	
}


