package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_game.UserInterface;
/**
 * Implémentation de la commande "eat".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class EatCommand extends Command
{
    /**
     * Constructeur pour les objets de classe EatCommand.
     */
    public EatCommand()
    {
    }

    /**
     * Commande "eat" : Permet de manger de l'inventaire.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println(pPlayer.eat(getSecondWord()));
    }
}
