import java.util.HashMap; 
import java.util.Set;
import java.util.Iterator;

public class Room
{
    // Attributs
    
    private String aDescription;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aEastExit;
    private Room aWestExit;
    private HashMap<String, Room> aExits;
    
    
    // Constructeurs
    
    /**
     * Constructeur naturel
     * @param pDescription : Description du lieu.
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
        aExits = new HashMap<String,Room>();
    }//Room()
    
    // Getters 
    
    /**
     * Accesseur
     */
    public String getDescription()
    {
        return this.aDescription;
    }//getDescription()
    
    /**
     * Retourne la sortie en fonction de la direction entrée. 
     */
    public Room getExit(String pDir)
    {
        return aExits.get(pDir);
    }//getExits()
    
    /**
     * Retourne les sorties de la Room
     */
    public String getExitString()
    {
        String vExits = "Exits :";
        Set<String> keys = aExits.keySet();
        for (String exit : keys)
        {
            vExits += " " + exit;
        }
        
        return vExits;
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
