package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_game.UserInterface;
/**
 * Implémentation de la commande "quit".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class QuitCommand extends Command
{
    /**
     * Constructeur pour les objets de classe QuitCommand.
     */
    public QuitCommand()
    {
    }

    /**
     * Commande "quit" : Permet de quitter le jeu.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (hasSecondWord()) {
            pGUI.println("Quit what ?");
            return;
        }
        pGE.endGame();
    }
}
