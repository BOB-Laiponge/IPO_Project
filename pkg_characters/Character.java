package pkg_characters;

import java.util.HashMap;
import java.util.Stack;

import pkg_rooms.Room;
import pkg_rooms.Door;

import pkg_items.ItemList;
import pkg_items.Item;
import pkg_items.Beamer;
import pkg_items.EatableItem;

/**
 * Cette classe permet de créer des PNJ.
 *
 * @author PITIOT Pierre-Yves
 * @version 28/04/2020
 */
public class Character
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aLifePoints;
    private int aMaxLifePoints;
    private String aName;
    private Room aCurrentRoom;
    private String aFirstTalk;
    private String aOtherTalk;
    private boolean aIsFirstTalk;
    
    

    /**
     * Constructeur d'objets de classe Character
     */
    public Character(final String pName, final String pFirstTalk,final String pOtherTalk)
    {
        this.aMaxLifePoints = 10;
        this.aLifePoints = this.aMaxLifePoints;
        this.aCurrentRoom = null;
        this.aName = pName;
        this.aFirstTalk = pFirstTalk;
        this.aOtherTalk = pOtherTalk;
        this.aIsFirstTalk = true;

    }
    
    /**
     * Permet de faire parler le PNJ
     */
    public String talk()
    {
        if (this.aIsFirstTalk) {
            this.aIsFirstTalk = false;
            return this.aFirstTalk;
        }
        return this.aOtherTalk;
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
    
    /**
     * Retourne le nom du PNJ
     */
    public String getName()
    {
        return this.aName;
    }
    
}
