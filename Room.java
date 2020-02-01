import java.util.HashMap; 
import java.util.Set;
import java.util.Iterator;

public class Room
{
    // Attributs
    
    private String aDescription;
    private HashMap<String, Room> aExits;
    
    
    // Constructeurs
    
    /**
     * Constructeur de Room
     * @param pDescription : Description du lieu.
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        aExits = new HashMap<String,Room>();
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
        return "You are in " + this.aDescription + ".\n" + this.getExitString();
    }// getLongDescription()
    
    // Setters
    
    /**
     * Modifie les sorties
     */
    public void setExit(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }
} // Room
