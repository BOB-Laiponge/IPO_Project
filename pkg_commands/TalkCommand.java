package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;
import pkg_characters.Character;

/**
 * Implémentation de la commande "talk".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class TalkCommand extends Command
{
    /**
     * Constructeur pour les objets de classe TalkCommand.
     */
    public TalkCommand()
    {
    }

    /**
     * Commande "talk" : Permet parler à un PNJ.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        if (hasSecondWord())
        {
            if (pPlayer.getCurrentRoom().hasPNJ(getSecondWord()))
            {
                Character vPNJ = pPlayer.getCurrentRoom().getPNJ(getSecondWord());
                pGUI.print(vPNJ.getName() + " : ");
                pGUI.println(vPNJ.talk());
                return;
            }
            pGUI.println("Cette personne n'est pas ici.");
        }
        else
        {
            pGUI.println("A qui voulez vous parler ?");
        }
    }
}

