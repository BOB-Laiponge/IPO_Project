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
    private HashMap<String, Item> aItems;
    
    // Constructeurs
    
    /**
     * Constructeur de Room
     * @param pDescription : Description du lieu.
     */
    public Room(final String pDescription, final String pImage){
        this.aDescription = pDescription;
        this.aExits = new HashMap<String,Room>();
        this.aImageName = pImage;
        this.aItems = new HashMap<String, Item>();
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
            Collection<Item> items = aItems.values();
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
    
    /**
     * Ajoute un Item à la pièce.
     */
    public void addItem(final Item pItem)
    {
        this.aItems.put(pItem.getNom(),pItem);
    }
} // Room
