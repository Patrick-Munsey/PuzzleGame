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
		catch(FileNotFoundException e){System.out.println("File read failed");}
		
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
	
	public Level loadNextLevel(Board b) throws FileNotFoundException
	{
		Level nLevel = new Level();
		String filePath = "../PuzzleGame/levels/main/";
		
		filePath = filePath + this.getDiffLetter(this.diff);
		
		filePath = filePath + (b.currLevel.getNum()+1) + ".txt";
		
		//System.out.println(filePath);
		Scanner sc = null;
		try
		{
			sc = new Scanner(new FileReader(filePath));
			nLevel.diff = b.currLevel.getDiff();
		}
		catch(FileNotFoundException e){
			filePath = "../PuzzleGame/levels/main/";
			String nextLetter = this.getNextDiffLetter(this.diff);
			
			nLevel.diff = b.currLevel.getDiff().next();
			if (nextLetter != ""){
				
					filePath = filePath + "0.txt";
				}
			
			}
		
		finally{
			nLevel.makeLevelFromFile(filePath);
		}
		
		nLevel.num = b.currLevel.getNum()+1;
		System.out.println(filePath);
		return nLevel;
	}
	
	private String getDiffLetter(Difficulty diff){
		String out = "";
		switch(diff) {
		case EASY:
			out = "e";
		    break;
		case MEDIUM:
			out = "m";
		    break;
		case HARD:
			out = "h";
		    break;
		default:
		    System.out.println("Invalid difficulty");
		    break;
		}
		return out;
	}
	
	private String getNextDiffLetter(Difficulty cDiff){
		String out = "";
		switch(diff) {
		case EASY:
			out = "m";
		    break;
		case MEDIUM:
			out = "h";
		    break;
		default:
		    System.out.println("Invalid difficulty");
		    break;
		}
		return out;
	}
}


