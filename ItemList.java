import java.util.HashMap;
import java.util.Collection;
/**
 * Cette lasse permet de creer les listes d'item.
 *
 * @author Pierre-Yves PITIOT
 * @version 21/04/20
 */
public class ItemList
{
    private HashMap<String, Item> aList;

    /**
     * Constructeur d'objets de classe ItemList
     */
    public ItemList()
    {
        this.aList = new HashMap<String, Item>();
    }

    /**
     * Teste si la liste contient l'item demandé.
     */
    public boolean hasItem(final String pNom)
    {
        return this.aList.containsKey(pNom);
    }
    
    /**
     * Ajoute un item à la liste.
     */
    public void addItem(final Item pItem)
    {
        
        this.aList.put(pItem.getNom(), pItem); 
    }
    
    /**
     * Retire un item à la liste.
     */
    public void removeItem(final String pNom)
    {
        this.aList.remove(pNom);
    }
    
    /**
     * Renvoie l'Item demandé.
     */
    public Item getItem(final String pNom)
    {
        return this.aList.get(pNom);
    }
    
    /**
     * Teste si la liste est vide.
     */
    public boolean isEmpty()
    {
        return this.aList.isEmpty();
    }
    
    /**
     * Retourne une collection des valeurs de la liste.
     */
    public Collection<Item> values()
    {
        return this.aList.values();
    }
    
    /**
     * Convertit la liste d'items en String
     */
    @Override public String toString()
    {
        String vStr = "";
        for(Item vItem : this.aList.values()){
            vStr += vItem.toString() + "\n";
        }
        return vStr;
    
    }
}
