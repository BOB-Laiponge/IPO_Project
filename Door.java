import java.util.ArrayList;

/**
 * Door : Pas plus de deux sorties
 *
 * @author PITIOT Pierre-Yves
 * @version 13/04/2020
 */
public class Door extends Room
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private boolean aIsOpen;
    private Item aKey;
    private ArrayList<Room> aExits;

    /**
     * Constructeur d'objets de classe Door
     */
    public Door(final String pDescription, final String pImage, final Item pKey)
    {
        // initialisation des variables d'instance
        super(pDescription, pImage);
        this.aIsOpen = false;
        this.aKey = pKey;
        this.aExits = new ArrayList<Room>();
    }

    public Item getKey()
    {
        return this.aKey;
    }
    
    public Room getNextRoom(final Room pCurrentRoom)
    {
        if (pCurrentRoom.equals(aExits.get(0))) return aExits.get(1);
        return aExits.get(0);
    }
    
    public void setOpen()
    {
        this.aIsOpen = true;
    }
    
    public boolean isOpen()
    {
        return this.aIsOpen;
    }
    
    @Override public void setExit(final String pDirection,final Room pNeighbor)
    {
        super.setExit(pDirection, pNeighbor);
        this.aExits.add(pNeighbor);
    }
}
