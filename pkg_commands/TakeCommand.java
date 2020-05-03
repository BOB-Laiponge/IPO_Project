package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;


/**
 * Implémentation de la commande "take".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class TakeCommand extends Command
{
    /**
     * Constructeur pour les objets de classe TakeCommand.
     */
    public TakeCommand()
    {
    }

    /**
     * Commande "take" : transfert un Item de la pièce vers l'inventaire du joueur.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println(pPlayer.take(getSecondWord()));
    }
}
