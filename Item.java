
/**
 * Classe décrivant les Items du jeu
 *
 * @author PITIOT Pierre-Yves
 * @version 25/02/2020
 */
public class Item
{
    
    private String aNom;
    private String aDescription;
    private int aWeight;

    /**
     * Constructeur d'objets de classe Items
     */
    public Item(final String pNom,final String pDescription, final int pWeight)
    {
        this.aNom = pNom;
        this.aWeight = pWeight;
        this.aDescription = pDescription;
    }

    /**
     * Retourne la description de l'objet
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    public String getNom()
    {
        return this.aNom;
    }
    
    /**
     * Retourne le poids de l'objet
     */
    public int getWeight()
    {
        return this.aWeight;
    }
    
    @Override public String toString()
    {
        return this.aNom + " (Poids : " + this.aWeight +")";
    }
}
