package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;
/**
 * Implémentation de la commande "use".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class UseCommand extends Command
{
    /**
     * Constructeur pour les objets de classe UseCommand.
     */
    public UseCommand()
    {
    }

    /**
     * Commande "use" : permet d'utiliser un item.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (hasSecondWord()) pGUI.println(pPlayer.use(getSecondWord()));
        else pGUI.println("Merci d'indiquer le nom de l'objet que vous voulez utiliser.");
    }
}
