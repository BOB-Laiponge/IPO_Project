import java.util.HashMap; 
import java.util.Set;
import java.util.Iterator;
import java.util.Collection;
/**
 * Classe décrivant les pièces du jeu.
 * 
 * @author PITIOT Pierre-Yves
 * @version 06/02/2020
 */
public class Room
{
    // Attributs
    
    private String aDescription;
    private HashMap<String, Room> aExits;
    private String aImageName;
    private ItemList aItems;
    
    // Constructeurs
    
    /**
     * Constructeur de Room
     * @param pDescription : Description du lieu.
     */
    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        this.aExits = new HashMap<String,Room>();
        this.aImageName = pImage;
        this.aItems = new ItemList();
    }//Room()
    
    // Getters 
    
    /**
     * Retourne la description de la pièce
     * @return la description de la pièce
     * 
     */
    public String getDescription()
    {
        return this.aDescription;
    }//getDescription()
    
    /**
     * Retourne la sortie en fonction de la direction entrée. 
     * @return la pièce se trouvant dans la direction donnée.
     */
    public Room getExit(String pDir)
    {
        return aExits.get(pDir);
    }//getExits()
    
    /**
     * Retourne les directions où se trouvent une sortie.
     * @return les directions où se trouvent une sortie.
     */
    public String getExitString()
    {
        StringBuilder vSB = new StringBuilder("Exits :");
        Set<String> keys = aExits.keySet();
        for (String exit : keys)
        {
            vSB.append(" ").append(exit);
        }
        
        return vSB.toString();
    }//getExitString()
    
    /**
     * Retourne une longe description de cette pièce, de la forme :
     *  Vous êtes dans la cuisine.
     *  Exits : north west
     * @return Une description de la pièce et ses sorties.
     */
    public String getLongDescription()
    {
        return "You are in " + this.aDescription + ".\n"+ this.getItemDescription() + "\n" + this.getExitString();
    }// getLongDescription()
    
    /**
     * Retourne la liste des Items présents dans cette pièce
     */
    public String getItemDescription()
    {
        if (!this.aItems.isEmpty()) {
            StringBuilder vSB = new StringBuilder("Here, there are the following objects : ");
            Collection<Item> items = this.aItems.values();
            for (Item item : items)
            {
                vSB.append(" ").append(item);
            }
            return vSB.toString();
        }
        else return "No item here.";
    }
    
    // Setters
    
    /**
     * Modifie les sorties
     */
    public void setExit(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }
    
    /**
     * Return a string describing the room's image name
     */
    public String getImageName()
    {
         return this.aImageName;
    }
    
    // Other
    
    /**
     * Ajoute un item à la pièce.
     */
    public void addItem(final Item pItem)
    {
        this.aItems.addItem(pItem);
    }
    
    /**
     * Teste si la pièce contient l'item demandé.
     */
    public boolean hasItem(final String pNom)
    {
        return this.aItems.hasItem(pNom);
    }
    
    /**
     * Retire un item à la liste.
     */
    public void removeItem(final String pNom)
    {
        this.aItems.removeItem(pNom);
    }
    
    /**
     * Renvoie l'Item demandé.
     */
    public Item getItem(final String pNom)
    {
        return this.aItems.getItem(pNom);
    }
    
    /**
     * Teste si la Room entrée est une sortie de cette Room
     */
    public boolean isExit(final Room pRoom)
    {
        return this.aExits.containsValue(pRoom);
    }
} // Room
