/**
 * Implémentation de la commande "look".
 * Inspiré de Michael Kolling et David J. Barnes
 * 
 * @author PITIOT Pierre-Yves
 * @version 21/24/2020
 */
public class LookCommand extends Command
{
    /**
     * Constructeur pour les objets de classe LookCommand.
     */
    public LookCommand()
    {
    }

    /** 
     * Commande "look" : Si il y a un second mot, affiche la description de l'objet entré. Sinon affiche la description de la pièce.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (hasSecondWord()) pGUI.println(pPlayer.lookItem(getSecondWord()));
        else pGUI.println(pPlayer.lookRoom());
    }
}
