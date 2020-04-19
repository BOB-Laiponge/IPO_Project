/**
 * Implémentation des commandes fausses .
 * Inspiré de Michael Kolling et David J. Barnes
 * 
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class UnknownCommand extends Command
{
    /**
     * Constructeur pour les objets de classe UnknownCommand.
     */
    public UnknownCommand()
    {
    }

    /** 
     * Commande inconnue : envoie l'information sur le GUI.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println("Cette commande n'existe pas.");
    }
}