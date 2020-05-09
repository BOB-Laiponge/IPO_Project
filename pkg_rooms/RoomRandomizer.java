package pkg_rooms;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;
import java.util.Iterator;
/**
 * Un objet de RoomRandomizer permet de récupérer une pièce aléatoire.
 *
 * @author Pitiot Pierre-Yves
 * @version 17/04/2020
 */
public class RoomRandomizer
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private ArrayList<Room> aRooms;

    /**
     * Constructeur d'objets de classe RoomRandomizer.
     */
    public RoomRandomizer(final HashMap<String,Room> pRooms)
    {
        this.aRooms = new ArrayList<Room>(pRooms.values());
    }

    /**
     * Retourne une pièce aléatoire.
     */
    public Room getRoom()
    {
        return this.aRooms.get((new Random()).nextInt(aRooms.size()));
    }   
}
