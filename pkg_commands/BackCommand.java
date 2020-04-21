package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_game.UserInterface;


/**
 * Implémentation de la commande "back".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class BackCommand extends Command
{
    /**
     * Constructeur pour les objets de classe BackCommand.
     */
    public BackCommand()
    {
    }

    /**
     * Commande "back" : Permet de revenir à la pièce précédente.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (hasSecondWord())
            pGUI.println("'back' is not supposed to have a second word.");
        else
        {
            if (pPlayer.previousRoomIsEmpty())
                pGUI.println("You can't go back now.");
            else
            {
                pPlayer.goBack();
                pGE.printLocationInfo();
            }
        }
    }
}
