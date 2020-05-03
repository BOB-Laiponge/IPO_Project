package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;

/**
 * Implémentation de la commande "alea".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class AleaCommand extends Command
{
    /**
     * Constructeur pour les objets de classe AleaCommand.
     */
    public AleaCommand()
    {
    }

    /**
     * Commande "alea" : Permet de bloquer l'aléatoire pendant les tests.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (!pGE.getTestMode())
        {
            pGUI.println("Cette commande n'est utilisable qu'en mode test.");
            return;
        }
        if (!hasSecondWord())
        {
            pGE.setAleaRoom(null);
            pGUI.println("AleaRoom a bien été réinitialisée.");
            return;
        }
        if (!pGE.getRooms().containsKey(getSecondWord()))
        {
            pGUI.println("Cette pièce n'existe pas.");
            return;
        }
        pGE.setAleaRoom(pGE.getRooms().get(getSecondWord()));
        pGUI.println("La pièce a bien été enregistrée.");
    }
}
