 
/**
 * Classe qui permet de creer des commandes à partir des informations entrées par l'utilisateur.
 * @author PITIOT Pierre-Yves
 * @version 06/02/2020
 */
public class Command
{
    private CommandWord aCommandWord;
    private String aSecondWord;
    
    
    /**
     * Constructeur naturel
     */
    public Command(final CommandWord pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    // Getteurs
    
    /**
     * Accède à CommandWord
     */
    public CommandWord getCommandWord()
    {
        return this.aCommandWord;
    } 
    
    /**
     * Accède à SecondWord
     */
    public String getSecondWord()
    {
        return this.aSecondWord;
    } 
    
    // méthodes
    
    /**
     * Teste si la commande a un second mot.
     */
    public boolean hasSecondWord()
    {
        return this.aSecondWord != null;
    }
    
    /**
     * Teste si le premier mot est valide
     */
    public boolean isUnknown()
    {
        return this.aCommandWord == CommandWord.UNKNOWN;
    }
} // Command
