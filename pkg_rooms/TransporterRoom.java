package pkg_rooms;

/**
 * Les TransporterRooms permettent de se téléporter vers une pièce aléatoire
 *
 * @author PITIOT Pierre-Yves
 * @version 17/04/2020
 */
public class TransporterRoom extends Room
{
    
    private RoomRandomizer aRoomRandomizer;

    /**
     * Constructeur d'objets de classe TransporterRoom
     */
    public TransporterRoom(final String pDescription, final String pImage, final RoomRandomizer pRandomizer)
    {
        super(pDescription,pImage);
        this.aRoomRandomizer = pRandomizer;
    }

    /**
     * Retourne la sortie de la Pièce en fonction de la direction donnée.
     * Si "beam" retourne une pièce aléatoire.
     */
    @Override public Room getExit(final String pDir)
    {
        if (pDir.equals("beam"))  return findRandomRoom();  
        else {
            return super.getExit(pDir);
        }
    }
    
    /**
     * Retourne une pièce aléatoire.
     */
    public Room findRandomRoom()
    {
        return (this.aRoomRandomizer.getRoom());
    }
}
