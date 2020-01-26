 

public class Command
{
    private String aCommandWord;
    private String aSecondWord;
    
    
    /**
     * Constructeur naturel
     */
    public Command(final String pCommandWord, final String pSecondWord)
    {
        this.aCommandWord = pCommandWord;
        this.aSecondWord = pSecondWord;
    }
    
    // Getteurs
    
    /**
     * Accède à CommandWord
     */
    public String getCommandWord()
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
        return this.aCommandWord == null;
    }
} // Command
