import java.util.ArrayList;

/**
 * Door permet de creer des portes fermées et ouvrables avec une clé.
 * Pas plus de deux sorties
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

    /**
     * Retourne la clé nécessaire à l'ouverture de la porte
     */
    public Item getKey()
    {
        return this.aKey;
    }
    
    /**
     * Retourne la prochaine Room.
     */
    public Room getNextRoom(final Room pCurrentRoom)
    {
        if (pCurrentRoom.equals(aExits.get(0))) return aExits.get(1);
        return aExits.get(0);
    }
    
    /**
     * "Ouvre" la porte
     */
    public void setOpen()
    {
        this.aIsOpen = true;
    }
    
    /**
     * Teste si la porte est ouverte
     */
    public boolean isOpen()
    {
        return this.aIsOpen;
    }
    
    /**
     * Ajoute une sortie à la porte. Pas plus de deux sorties.
     */
    @Override public void setExit(final String pDirection,final Room pNeighbor)
    {
        super.setExit(pDirection, pNeighbor);
        this.aExits.add(pNeighbor);
    }
}
