package pkg_items;

import pkg_game.GameEngine;
import pkg_rooms.Room;
import pkg_characters.Player;
/**
 * Un beamer permet d'enregistrer une Room, puis de s'y téléporter à volonté.
 *
 * @author Pitiot Pierre-Yves
 * @version 21/04/2020
 */
public class Beamer extends UsableItem
{
    private Room aLoadedRoom;
    private GameEngine aGE;

    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer(final String pNom,final String pDescription, final int pWeight, final GameEngine pGE)
    {
        // initialisation des variables d'instance
        super(pNom,pDescription,pWeight);
        this.aLoadedRoom = null;
        this.aGE = pGE;
    }
    
    /**
     * Charge le beamer : enregistre la currentRoom
     */
    public String load(final Player pPlayer)
    {
        this.aLoadedRoom = pPlayer.getCurrentRoom();
        return "Votre emplacement a bien été enrgistré dans le Beamer.";
    }
    
    /**
     * Utilise le Beamer : Le joueur est téléporté à la room enregistrée
     */
    public String use(final Player pPlayer)
    {
        if (this.aLoadedRoom == null) return "Téléportation impossible, merci d'enregistrer un emplacement.";
        this.aGE.goTo(this.aLoadedRoom);
        pPlayer.clearPreviousRooms();
        return "Téléportation réussie. Merci d'avoir utilisé le Beamer !";
    }
}
