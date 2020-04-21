package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_game.UserInterface;
/**
 * Implémentation de la commande "drop".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class DropCommand extends Command
{
    /**
     * Constructeur pour les objets de classe DropCommand.
     */
    public DropCommand()
    {
    }

    /**
     * Commande "drop" : transfert un Item de l'inventaire du joueur vers la pièce.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println(pPlayer.drop(getSecondWord()));
    }
}
