import java.util.HashMap;

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
        String vExits = "Exits : ";
        if (this.aNorthExit != null) vExits += "north ";
        if (this.aSouthExit != null) vExits += "south ";
        if (this.aEastExit != null) vExits += "east ";
        if (this.aWestExit != null) vExits += "west ";
        
        return vExits;
    }//getExitString()
    
    // Setters
    
    /**
     * Modifie les sorties
     */
    public void setExit(final String pDirection,final Room pNeighbor)
    {
        this.aExits.put(pDirection, pNeighbor);
    }
} // Room
