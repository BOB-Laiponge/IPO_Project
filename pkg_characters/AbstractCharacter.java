package pkg_characters;

import pkg_rooms.Room;

/**
 * Classe décrivant les caractérisitques des personnages.
 *
 * @author  PITIOT Pierre-Yves
 * @version 09/05/2020
 */
public abstract class AbstractCharacter
{
    protected String aName;
    protected Room aCurrentRoom;
    
    public AbstractCharacter(final String pName)
    {
        this.aName = pName;
        this.aCurrentRoom = null;
    }

    /**
     * Change la CurrentRoom.
     *
     * @param  pRoom : La nouvelle CurrentRoom.
     */
    public void setCurrentRoom(final Room pRoom)
    {
        this.aCurrentRoom = pRoom;
    }
}
