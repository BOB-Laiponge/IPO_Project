
/**
 * L'interface eatable permet de décrire le fonctionnement des objets mangeables.
 */
public abstract class EatableItem extends Item
{
    public EatableItem(final String pNom,final String pDescription, final int pWeight)
    {
        super(pNom, pDescription, pWeight);
    }
    /**
     * Applique l'effet décrit sur le player.
     */
    public abstract String eat(final Player pPlayer);
}
