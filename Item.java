
/**
 * Classe décrivant les Items du jeu
 *
 * @author PITIOT Pierre-Yves
 * @version 25/02/2020
 */
public class Item
{
    
    private String aDescription;
    private int aWeight;

    /**
     * Constructeur d'objets de classe Items
     */
    public Item(final String pDescription, final int pWeight)
    {
        this.aDescription = pDescription;
        this.aWeight = pWeight;
    }

    /**
     * Retourne la description de l'objet
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    
    /**
     * Retourne le poids de l'objet
     */
    public int getWeight()
    {
        return this.aWeight;
    }
}
