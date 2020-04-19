 
/**
 * Classe qui permet de creer des commandes à partir des informations entrées par l'utilisateur.
 * @author PITIOT Pierre-Yves
 * @version 06/02/2020
 */
public abstract class Command
{
    private String aSecondWord;
    
    /**
     * Constructeur naturel
     */
    public Command()
    {
        this.aSecondWord = null;
    }
    
    // Getteurs
    
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
     * Define the second word of this command (the word
     * entered after the command word). Null indicates that 
     * there was no second word.
     */
    public void setSecondWord(String pSecondWord)
    {
        this.aSecondWord = pSecondWord;
    }
    
    public abstract void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI);
} // Command
