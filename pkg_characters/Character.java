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
public class Character extends AbstractCharacter
{
    // variables d'instance - remplacez l'exemple qui suit par le vôtre
    private int aLifePoints;
    private int aMaxLifePoints;
    private String aFirstTalk;
    private String aOtherTalk;
    private boolean aIsFirstTalk;
    
    

    /**
     * Constructeur d'objets de classe Character
     */
    public Character(final String pName, final String pFirstTalk,final String pOtherTalk)
    {
        super(pName);
        this.aMaxLifePoints = 10;
        this.aLifePoints = this.aMaxLifePoints;
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
     * Retourne le nom du PNJ
     */
    public String getName()
    {
        return this.aName;
    }
    
}
