import java.util.HashMap; 

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration table of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kolling and David J. Barnes + D.Bureau + PY.Pitiot
 * @version 2008.03.30 + 2019.09.25 + 2020.04.21
 */
public class CommandWords
{
    // a constant array that will hold all valid command words
    private HashMap<String,CommandWord> aValidCommands;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {
        this.aValidCommands = new HashMap<String,CommandWord>();
        for(CommandWord vCommand : CommandWord.values()) {
            if(vCommand != CommandWord.UNKNOWN) {
                this.aValidCommands.put(vCommand.toString(), vCommand);
            }
        }
    } // CommandWords()
    
    /**
     * Find the CommandWord associated with a command word.
     * @param commandWord The word to look up.
     * @return The CommandWord correspondng to commandWord, or UNKNOWN
     *         if it is not a valid command word.
     */
    public CommandWord getCommandWord(String pCommandWord)
    {
        CommandWord vCommand = this.aValidCommands.get(pCommandWord);
        if(vCommand != null) {
            return vCommand;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }
    
    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public boolean isCommand( final String pString )
    {
        return this.aValidCommands.containsKey(pString);
    } // isCommand()
    
    /**
     * Affiche les commandes valides 
     */
    public String getCommandList()
    {
        String vCommandString = "";
        for(String vCommand : this.aValidCommands.keySet()) {
            vCommandString += (vCommand + " ");
        }
        return vCommandString;
    }//showAll
    
} // CommandWords