/**
 * Décrivez votre classe Beamer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class Beamer extends Item
{
    private Room aLoadedRoom;
    private GameEngine aGE;

    /**
     * Constructeur d'objets de classe Beamer
     */
    public Beamer(final String pNom,final String pDescription, final int pWeight, final GameEngine pGE)
    {
        // initialisation des variables d'instance
        super(pNom,pDescription,pWeight);
        this.aLoadedRoom = null;
        this.aGE = pGE;
    }

    public String load(final Player pPlayer)
    {
        this.aLoadedRoom = pPlayer.getCurrentRoom();
        return "Votre emplacement a bien été enrgistré dans le Beamer.";
    }
    
    public String use(final Player pPlayer)
    {
        this.aGE.goTo(this.aLoadedRoom);
        pPlayer.clearPreviousRooms();
        return "Téléportation réussie. Merci d'avoir utilisé le Beamer !";
    }
}
