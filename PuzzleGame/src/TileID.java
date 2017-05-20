public enum TileID {

	Wall('#'),
	Floor('-'),
	Box('$'),
	Goal('.'),
	Player('@');
	//PlayerOnGoal('+'),
	//BoxOnGoal('*');
	
	private final char symbol;
	
	private TileID(final char symbol) {
		this.symbol = symbol;
	}
	
	public char getSymbol() {
		return this.symbol;
	}
	
	public static String getTileID (char symbol){
		for (TileID tileName: TileID.values()) {
			if (tileName.symbol == symbol) {
				return tileName.toString();
			}
		}
		return null;
	}
}
