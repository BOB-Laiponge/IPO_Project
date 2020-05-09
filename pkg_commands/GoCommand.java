package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;

import pkg_rooms.Room;
import pkg_rooms.TransporterRoom;
/**
 * Implémentation de la commande "go".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class GoCommand extends Command
{
    /**
     * Constructeur pour les objets de classe GoCommand
     */
    public GoCommand()
    {
    }

    /**
     * Commande "go": Permet de se déplacer d'une pièce à l'autre.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        // On déplace les MovingCharacters
        pGE.moveCharacters();
        
        // Si un seul mot, on retourne "go where ?"
        if (!hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            pGUI.println( "Go where?" );
            return;
        }

        // On cherche la prochaine pièce
        String vDirection = this.getSecondWord();

        Room vNextRoom;

        if (pPlayer.getCurrentRoom().isTransporterRoom())
        {
            if (pGE.getTestMode() && pGE.getAleaRoom() != null)
            {
                vNextRoom = pGE.getAleaRoom();
            }
            else
            {
                vNextRoom = ((TransporterRoom)(pPlayer.getCurrentRoom())).getExit(vDirection);
            }
        }
        else
        {
            vNextRoom = pPlayer.getCurrentRoomExit(vDirection);
        }

        // On effectue ou pas le changement de lieu
        if ( vNextRoom == null )
            pGUI.println( "There is no door!" );
        else {


            pPlayer.decreaseTurnsLeft();

            if (pPlayer.TestTurnsLeft())
            {
                pGUI.println("GAME OVER : La bataille au dessus de Saand s'est achevée par l'annihilation de la planète.\nVous êtes mort !");
                pGE.endGame();
                return;
            }

            pGE.goTo(vNextRoom);

        }
    }
}
