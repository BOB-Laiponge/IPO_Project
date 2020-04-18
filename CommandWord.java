/**
 * Enumeration CommandWord décrit les commandes valides
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public enum CommandWord
{
    GO("go"), HELP("help"), QUIT("quit"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"),
    ITEMS("items"), USE("use"), LOAD("load"), ALEA("alea"), UNKNOWN("?");
    
    private String aCommandString;
    
    /**
     * Initialise with the corresponding command word.
     * @param commandWord The command string.
     */
    CommandWord(String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    
    /**
     * @return The command word as a string.
     */
    @Override public String toString()
    {
        return this.aCommandString;
    }
}
