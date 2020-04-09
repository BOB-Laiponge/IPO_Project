
/**
 * EatableItem permet de décrire le fonctionnement des objets mangeables.
 * Elle permet également de détecter si un objet est mangeable ou non.
 * 
 * Auteur : Pitiot Pierre-Yves
 * Version : 30/03/2020
 */
public abstract class EatableItem extends Item
{
    /**
     * Constructeur de EatableItem
     */
    public EatableItem(final String pNom,final String pDescription, final int pWeight)
    {
        super(pNom, pDescription, pWeight);
    }
    
    /**
     * Applique l'effet décrit dans les classes filles sur le joueur.
     */
    public abstract String eat(final Player pPlayer);
}
