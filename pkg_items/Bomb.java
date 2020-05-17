package pkg_items;

import pkg_game.GameEngine;
import pkg_rooms.Room;
import pkg_characters.Player;
/**
 * Objet de quête : permet de faire exploser un bâtiment
 *
 * @author Pitiot Pierre-Yves
 * @version 17/05/2020
 */
public class Bomb extends UsableItem
{
    private GameEngine aGE;

    /**
     * Constructeur d'objets de classe Beamer
     */
    public Bomb(final String pNom,final String pDescription, final int pWeight, final GameEngine pGE)
    {
        // initialisation des variables d'instance
        super(pNom,pDescription,pWeight);
        this.aGE = pGE;
    }
    
    /**
     * Charge la bombe : inutile
     */
    public String load(final Player pPlayer)
    {
        
        return "La bombe n'a pas besoin d'être chargée.";
    }
    
    /**
     * Utilise la bombe : La bombe explose dans la pièce où se trouve le joueur.
     */
    public String use(final Player pPlayer)
    {
        String vString;
        if (pPlayer.getCurrentRoom().equals(aGE.getRoom("OldFactory")))
        {
            aGE.explosionOldFactory();
            pPlayer.removeItem("bombe");
            return "La bombe explose dans la vielle usine.\nEn sortant, vous entendez des cris de femmes, d'enfants et de bébés.";
        }
        else if (pPlayer.getCurrentRoom().equals(aGE.getRoom("GovernorTower")))
        {
            aGE.explosionGovTower();
            pPlayer.removeItem("bombe");
            return "La bombe explose dans la tour du Gouverneur.\nEn sortant, vous voyez le bâtiment s'éffondrer, avec des milliers de personnes à l'intérieur.";
        }
        else return "La bombe ne peut pas être utilisée maintenant.";
    }
}
