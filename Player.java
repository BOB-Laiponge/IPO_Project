import java.util.HashMap;
import java.util.Stack;
/**
 * Classe Player : décrit le fonctionnement d'un joueur.
 *
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
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
    
    public String load(final String pItemName)
    {
        if (!this.aInventory.hasItem(pItemName)) return "Cet objet n'est pas dans votre inventaire.";
        Item vItem = this.aInventory.getItem(pItemName);
        if (!(vItem instanceof Beamer)) return "Cet objet ne peut pas être chargé.";
        return ((Beamer)vItem).load(this);
    }
    
    public String use(final String pItemName)
    {
        if (!this.aInventory.hasItem(pItemName)) return "Cet objet n'est pas dans votre inventaire.";
        Item vItem = this.aInventory.getItem(pItemName);
        if (!(vItem instanceof Beamer)) return "Cet objet ne peut pas être utilisé.";
        return ((Beamer)vItem).use(this);
    }
    
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
    public String goTo(final Room pRoom)
    {
        this.aPreviousRooms.push(this.aCurrentRoom);
        
        if (!pRoom.isExit(this.aCurrentRoom)) 
        {
            this.clearPreviousRooms();
        }
        
        if (pRoom instanceof Door)
        {
            if (((Door)pRoom).isOpen() || this.hasKey(pRoom))
            {
                this.setCurrentRoom(((Door)pRoom).getNextRoom(this.aCurrentRoom));
                ((Door)pRoom).setOpen();
                
                return "La porte est ouverte. Vous vous êtes déplacé.\n";
            }
            
            return "La porte est fermée. Vous ne pouvez pas passer.\n";
        }
        this.setCurrentRoom(pRoom);
        return "Vous vous êtes déplacé.\n";
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
    public String lookRoom()
    {
        return this.aCurrentRoom.getLongDescription();
    }
    
    /**
     * Retourne la description de l'item demandé.
     */
    public String lookItem(final String pName)
    {
        if (this.aInventory.hasItem(pName)) return this.aInventory.getItem(pName).getDescription();
        if (this.aCurrentRoom.getItems().hasItem(pName)) return this.aCurrentRoom.getItems().getItem(pName).getDescription();
        return "Cet objet n'est pas reconnu."; 
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
     * Vide le PreviousRooms
     */
    public void clearPreviousRooms()
    {
        this.aPreviousRooms.clear();
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
    
    /**
     * Teste si le joueur possède la clé de la porte entrée.
     */
    public boolean hasKey(final Room pRoom)
    {
        return this.aInventory.hasItem((((Door)pRoom).getKey().getNom()));
    }
}
