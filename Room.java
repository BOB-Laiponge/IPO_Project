 

public class Room
{
    // Attributs
    
    private String aDescription;
    private Room aNorthExit;
    private Room aSouthExit;
    private Room aEastExit;
    private Room aWestExit;
    
    
    
    // Getters
    /**
     * Retourne la sortie en fonction de la direction entrée. 
     */
    public Room getExit(String pDir)
    {
        if (pDir.equals("north")) return this.aNorthExit;
        if (pDir.equals("south")) return this.aSouthExit;
        if (pDir.equals("east")) return this.aEastExit;
        if (pDir.equals("west")) return this.aWestExit;
        return null;
    }
    
    
    // Constructeurs
    
    /**
     * Constructeur naturel
     * @param pDescription : Description du lieu.
     */
    public Room(final String pDescription){
        this.aDescription = pDescription;
    }//Room()
    
    // Getters 
    
    /**
     * Accesseur
     */
    public String getDescription()
    {
        return this.aDescription;
    }//getDescription()
    
    // Setters
    
    /**
     * Modifie les sorties
     */
    public void setExits(final Room pNorthExit, final Room pSouthExit,
                         final Room pEastExit, final Room pWestExit)
    {
        this.aNorthExit = pNorthExit;
        this.aSouthExit = pSouthExit;
        this.aEastExit = pEastExit;
        this.aWestExit = pWestExit;
    }
} // Room
