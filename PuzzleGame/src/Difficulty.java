/**
 * @author Patrick Munsey
 * zID: z5020841
 * 
 */
public enum Difficulty {
    EASY, MEDIUM, HARD;
    
    private static Difficulty[] vals = values();
    
    public Difficulty next()
    {
        return vals[(this.ordinal()+1) % vals.length];
    }
}
