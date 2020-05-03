package pkg_commands;
/**
 * Enumeration CommandWord décrit les commandes valides
 * Inspiré du travail de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public enum CommandWord
{
    GO("go"), HELP("help"), QUIT("quit"), LOOK("look"), EAT("eat"), BACK("back"), TEST("test"), TAKE("take"), DROP("drop"),
    ITEMS("items"), USE("use"), LOAD("load"), ALEA("alea"), UNKNOWN("?"), TALK("talk");
    
    private String aCommandString;
    
    /**
     * Constructeur de la classe CommandWord.
     * @param pCommandString La String de commande
     */
    CommandWord(String pCommandString)
    {
        this.aCommandString = pCommandString;
    }
    
    /**
     * @return Le CommandWord en forme de String.
     */
    @Override public String toString()
    {
        return this.aCommandString;
    }
}
