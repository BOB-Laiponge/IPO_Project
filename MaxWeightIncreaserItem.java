/**
 * MaxWeightIncreaserItem permet de créer des items mangeables qui ont pour effet d'augmenter la capacité d'inventaire maximum du joueur
 * 
 * @author PITIOT Pierre-Yves
 * @version 30/03/2020
 */
public class MaxWeightIncreaserItem extends EatableItem
{
    int aAddedWeight;
    
    /**
     * Constructeur d'objets de classe MaxWeightIncreaserItem
     */
    public MaxWeightIncreaserItem(final String pNom,final String pDescription, final int pWeight, final int pAddedWeight)
    {
        super(pNom, pDescription, pWeight);
        this.aAddedWeight = pAddedWeight;
    }
    
    /**
     * Applique l'effet sur le joueur
     */
    public String eat(final Player pPlayer)
    {
        pPlayer.increaseMaxWeight(this.aAddedWeight);
        return "Le Magic Cookie a été mangé. Vous pouvez porter " + this.aAddedWeight + "kg en plus.";
    }
}
