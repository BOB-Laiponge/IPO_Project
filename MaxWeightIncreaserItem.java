
/**
 * Magic Cookie
 */
public class MaxWeightIncreaserItem extends EatableItem
{
    int aAddedWeight;
    
    /**
     * Constructeur d'objets de classe MagicCookie
     */
    public MaxWeightIncreaserItem(final String pNom,final String pDescription, final int pWeight, final int pAddedWeight)
    {
        super(pNom, pDescription, pWeight);
        this.aAddedWeight = pAddedWeight;
    }
    
    public String eat(final Player pPlayer)
    {
        pPlayer.increaseMaxWeight(this.aAddedWeight);
        return "Le Magic Cookie a été mangé. Vous pouvez porter " + this.aAddedWeight + "kg en plus.";
    }
}
