import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Used to generate a new board array from selected text files
 */
public class Level {

    private ArrayList<String> level = new ArrayList<String>();
    private int height;
    private int width;
    private int levelNum;

    /**
     * @param levelNum
     */
    public Level (int levelNum) {
	this.levelNum = levelNum;
	makeLevelFromFile();
    }

    /**
     * @return returns the level number as a String
     */
    public ArrayList<String> getLevel () {
	return this.level;
    }

    /**
     * @param row
     */
    public void addRow(String row) {
	level.add(row);
    }

    /**
     * @return returns the number of vertical elements in the generated board array
     */
    public int getHeight(){
	return this.height;
    }

    /**
     * @return returns the number of horizontal elements in the generated board array
     */
    public int getWidth(){
	return this.width;
    }

    /**
     */
    public void makeLevelFromFile(){

	/*input file format:
		x,y
		###...
		###...
		etc
	 */
	String filePath = "../PuzzleGame/levels/main/" + levelNum + ".txt";

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

    /**
     * @return returns the current level number of the generated level
     */
    public int getlevelNum() {
	return levelNum;
    }

    /**
     * @param num
     */
    public void setlevelNum(int num) {
	this.levelNum = num;
    }

    /**
     * @param b
     * @return returns the next level for the given board
     * @throws FileNotFoundException
     */
    public Level loadNextLevel(Board b) throws FileNotFoundException
    {
	Level nLevel = new Level(levelNum+1);
	return nLevel;
    }
}


