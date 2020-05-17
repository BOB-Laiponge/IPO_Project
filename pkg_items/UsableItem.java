package pkg_items;

import pkg_characters.Player;
/**
 * EatableItem permet de décrire le fonctionnement des objets mangeables.
 * Elle permet également de détecter si un objet est mangeable ou non.
 * 
 * Auteur : Pitiot Pierre-Yves
 * Version : 30/03/2020
 */
public abstract class UsableItem extends Item
{
    /**
     * Constructeur de EatableItem
     */
    public UsableItem(final String pNom,final String pDescription, final int pWeight)
    {
        super(pNom, pDescription, pWeight);
    }
    
    /**
     * Utilise l'objet
     */
    public abstract String use(final Player pPlayer);
    
    /**
     * Charge l'objet
     */
    public abstract String load(final Player pPlayer);
}