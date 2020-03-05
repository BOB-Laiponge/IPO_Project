import java.util.HashMap;
/**
 * Classe Player : décrit le fonctionnement d'un joueur.
 *
 * @author PITIOT Pierre-Yves
 * @version 05/03/2020
 */
public class Player
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private Room aCurrentRoom;
    private String aName;
    private int aMaxWeight;
    private int aCurrentWeight;
    private HashMap<String, Item> aInventory;
    
    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final String pName)
    {
        // initialisation des variables d'instance
        this.aCurrentRoom = null;
        this.aName = pName;
        this.aMaxWeight = 1000;
    }

    /**
     * Change la CurrentRoom.
     *
     * @param  pRoom : La nouvelle CurrentRoom.
     */
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom; 
    }
}
