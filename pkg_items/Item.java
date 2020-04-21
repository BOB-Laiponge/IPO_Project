package pkg_items;

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
     * Retourne la description de l'objet.
     * @return la description de l'objet.
     */
    public String getDescription()
    {
        return this.aDescription;
    }
    
    /**
     * Retourne le nom de l'objet.
     * @return le nom de l'objet
     */
    public String getNom()
    {
        return this.aNom;
    }
    
    /**
     * Retourne le poids de l'objet
     * 
     * @return le poids de l'objet
     */
    public int getWeight()
    {
        return this.aWeight;
    }
    
    /**
     * Retourne le String correspondant à l'Item.
     * 
     * @return le String correspondant à l'Item.
     */
    @Override public String toString()
    {
        return this.aNom + " (Poids : " + this.aWeight +")";
    }
}
