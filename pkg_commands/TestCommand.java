package pkg_commands;
import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_game.UserInterface;

import java.util.Scanner;
import java.io.File;
/**
 * Implémentation de la commande "test".
 * Inspiré de Michael Kolling et David J. Barnes
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class TestCommand extends Command
{
    /**
     * Constructeur pour les objets de classe TestCommand.
     */
    public TestCommand()
    {
    }

    /**
     * Commande "back" : Permet de revenir à la pièce précédente.
     */
    public void execute(final Player pPlayer, final GameEngine pGE, final UserInterface pGUI)
    {
        String vFileName;
        if (hasSecondWord())
            vFileName = getSecondWord();
        else
            vFileName = "test";

        try
        {
            pGE.setTestMode(true);
            Scanner vSc = new Scanner(new File(vFileName+".txt"));
            while (vSc.hasNext()){
                pGE.interpretCommand(vSc.nextLine());
            }
            pGE.setTestMode(false);
        }
        catch(final java.io.FileNotFoundException pE)
        {
            pGUI.println("Le fichier demandé n'a pas été trouvé.");
        }
    }
}
