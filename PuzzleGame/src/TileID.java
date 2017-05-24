/**
 * 
 */
public enum TileID {

    Wall('#'),
    Floor('-'),
    Portal1('X'),
    Portal2('Y'),
    PortalLoc1('1'),
    PortalLoc2('2'),
    Box('B'),
    Goal('!'),
    Player('P');
    //PlayerOnGoal('+'),
    //BoxOnGoal('*');

    private final char symbol;

    /**
     * @param symbol
     */
    private TileID(final char symbol) {
	this.symbol = symbol;
    }

    /**
     * @return
     */
    public char getSymbol() {
	return this.symbol;
    }

    /**
     * @param symbol
     * @return
     */
    public static String getTileID (char symbol){
	for (TileID tileName: TileID.values()) {
	    if (tileName.symbol == symbol) {
		return tileName.toString();
	    }
	}
	return null;
    }
}
