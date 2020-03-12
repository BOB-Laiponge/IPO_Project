import java.util.HashMap;
import java.util.Stack;
/**
 * Classe Player : décrit le fonctionnement d'un joueur.
 *
 * @author PITIOT Pierre-Yves
 * @version 05/03/2020
 */
public class Player
{
    private Room aCurrentRoom;
    private Stack<Room> aPreviousRooms;
    private String aName;
    //private int aMaxWeight;
    //private int aCurrentWeight;
    //private HashMap<String, Item> aInventory;

    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final String pName)
    {
        // initialisation des variables d'instance
        this.aCurrentRoom = null;
        this.aPreviousRooms = new Stack<Room>();
        this.aName = pName;
        //this.aMaxWeight = 1000;
    }

    // COMMANDES

    /**
     * Permet de déplacer le joueur vers une nouvelle Room.
     */
    public void goTo(final Room pRoom)
    {
        this.aPreviousRooms.push(this.aCurrentRoom);
        this.setCurrentRoom(pRoom);
    }

    /**
     * Permet de déplacer le joueur vers la pièce précédente.
     */
    public void goBack()
    {
        this.setCurrentRoom(this.aPreviousRooms.pop());
    }

    /**
     * Retourne la longDesription de la CurrentRoom
     */
    public String look()
    {
        return this.aCurrentRoom.getLongDescription();
    }

    // GETTERS

    /**
     * Retourne la pièce dans laquelle se trouve le joueur.
     */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }

    /**
     * Retourne la sortie de la CurrentRoom vers la direction donnée.
     */

    public Room getCurrentRoomExit(final String pDirection)
    {
        return this.aCurrentRoom.getExit(pDirection);
    }

    // SETTERS

    /**
     * Change la CurrentRoom.
     *
     * @param  pRoom : La nouvelle CurrentRoom.
     */
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom; 
    }

    // OTHER   

    /**
     * Teste si il y a une Room précédente.
     */
    public boolean previousRoomIsEmpty()
    {
        return this.aPreviousRooms.empty();
    }

    /**
     * Ajoute une nouvelle Room à aPreviousRoom.
     */
    private void pushRoom(final Room pRoom)
    {
        this.aPreviousRooms.push(pRoom);
    }

        
}
