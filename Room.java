 

public class Room
{
    // Attributs
    
    private String aDescription;
    public Room aNorthExit;
    public Room aSouthExit;
    public Room aEastExit;
    public Room aWestExit;
    
    
    
    
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
