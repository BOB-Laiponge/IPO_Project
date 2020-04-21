package pkg_commands;
import pkg_game.GameEngine;
import pkg_game.Player;
import pkg_game.UserInterface;

/**
 * Implémentation de la commande "help".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class HelpCommand extends Command
{
    /**
     * Constructeur pour les objets de classe HelpCommand.
     */
    public HelpCommand()
    {
    }

    /**
     * Commande "help" : Affiche le message d'aide.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        pGUI.println("Durant une bataille spatiale, vous vous êtes écrasé sur une planète désertique.");
        pGUI.println("Vous devez trouver un moyen de retourner combattre et rentrer sur Terre.");
        pGUI.println("Les commandes sont :");
        pGUI.println(pGE.getParser().getCommandString());
    }
}
