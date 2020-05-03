package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;


/**
 * Implémentation de la commande "items".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class ItemsCommand extends Command
{
    /**
     * Constructeur pour les objets de classe ItemsCommand.
     */
    public ItemsCommand()
    {
    }

    /**
     * Commande "items" : Affiche l'inventaire du joueur.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println(pPlayer.getInventory().toString());
        pGUI.println("Poids total : "+ pPlayer.getCurrentWeight() + "/" + pPlayer.getMaxWeight());
    }
}
