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
    private int aMaxWeight;
    private int aCurrentWeight;
    private ItemList aInventory;

    /**
     * Constructeur d'objets de classe Player
     */
    public Player(final String pName)
    {
        // initialisation des variables d'instance
        this.aCurrentRoom = null;
        this.aPreviousRooms = new Stack<Room>();
        this.aName = pName;
        this.aInventory = new ItemList(); 
        this.aMaxWeight = 10;
        this.aCurrentWeight = 0;
    }

    // COMMANDES

    /**
     * Permet de déplacer le joueur vers la pièce précédente.
     */
    public String eat(final String pName)
    {
        if (!this.aInventory.hasItem(pName)){
            return "Cet objet n'est pas dans votre inventaire.";
        }
        if (!(this.aInventory.getItem(pName) instanceof EatableItem)){
            return "Cet objet n'est pas commestible";
        }
        String vStr = ((EatableItem)this.aInventory.getItem(pName)).eat(this);
        this.removeItem(pName);
        return vStr;
    }
    
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
    
    /**
     * Ramasse un objet
     */
    public String take(final String pNom)
    {
        if (this.aCurrentRoom.hasItem(pNom)){
            int vItemWeight = this.aCurrentRoom.getItem(pNom).getWeight();
            if (this.aCurrentWeight + vItemWeight <= this.aMaxWeight)
            {
                this.aInventory.addItem(this.aCurrentRoom.getItem(pNom));
                this.aCurrentWeight += vItemWeight;
                this.aCurrentRoom.removeItem(pNom);
                
                return pNom + " a été ramassé.";
            }
            else return "Votre inventaire est plein";
        }
        else return "Il n'y a pas cet objet à cet endroit.";
    }
    
    /**
     * Ramasse un objet
     */
    public String drop(final String pNom)
    {
        if (this.aInventory.hasItem(pNom)){
            this.aCurrentRoom.addItem(this.aInventory.getItem(pNom));
            this.removeItem(pNom);
            
            return pNom + " a été jeté.";
        }
        else return "Il n'y a pas cet objet dans votre inventaire";
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
     * Retourne le poids total de l'inventaire.
     */
    public int getCurrentWeight()
    {
        return this.aCurrentWeight;
    }
    
    /**
     * Retourne le poids max de l'inventaire.
     */
    public int getMaxWeight()
    {
        return this.aMaxWeight;
    }

    /**
     * Retourne la sortie de la CurrentRoom vers la direction donnée.
     */

    public Room getCurrentRoomExit(final String pDirection)
    {
        return this.aCurrentRoom.getExit(pDirection);
    }
    
    /**
     * Retourne l'inventaire du joueur
     */
    public ItemList getInventory()
    {
        return this.aInventory;
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

    /**
     * Augmente le poids max de l'inventaire du joueur
     */
    public void increaseMaxWeight(final int pWeight)
    {
        this.aMaxWeight += pWeight;
    }
    
    /**
     * Retire un item de l'inventaire
     */
    public void removeItem(final String pName)
    {
        this.aCurrentWeight -= this.aInventory.getItem(pName).getWeight();
        this.aInventory.removeItem(pName);
    }
}
