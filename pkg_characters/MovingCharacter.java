package pkg_characters;

import pkg_rooms.Room;
import pkg_rooms.Door;
import pkg_rooms.TransporterRoom;
/**
 * Décrit des personnages qui bougent.
 *
 * @author PITIOT Pierre-Yves
 * @version 09/05/2020
 */
public class MovingCharacter extends Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre

    /**
     * Constructeur d'objets de classe MovingCharacter
     */
    public MovingCharacter(final String pName, final String pFirstTalk,final String pOtherTalk) 
    {
        super(pName, pFirstTalk, pOtherTalk);
    }

    /**
     * Déplace le PNJ
     */
    public void move()
    {
        Room vNextRoom = this.aCurrentRoom.getAleaExit();
        while (vNextRoom instanceof Door || vNextRoom instanceof TransporterRoom){
            vNextRoom = this.aCurrentRoom.getAleaExit();
        }
        aCurrentRoom.removePNJ(this.aName);
        
        vNextRoom.addPNJ(this);
    }
}
