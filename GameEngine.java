import java.util.Scanner;
import java.util.HashMap;
import java.io.File;

/**
 * Classe principale du jeu. GameEngine permet de gérer le déroulement une partie.
 * 
 * @author PITIOT Pierre-Yves
 * @version 03/04/2020
 */
public class GameEngine
{
    // Attributs
    private Parser aParser;
    private Player aPlayer;
    private UserInterface aGui;
    private HashMap<String, Room> aRooms;
    private int aTurnsLeft;

    // Constructeurs
    /**
     * Constructeur pour les objets de classe GameEngine.
     */
    public GameEngine()
    {
        this.aPlayer = new Player("Elsa Edington");
        this.aRooms = new HashMap<String,Room>();
        this.aParser = new Parser();
        this.createRooms();
        this.aTurnsLeft = 100;
    }

    // CREATION DES OBJETS NECESSAIRES AU FONCTIONNEMENT DU JEU
                    
    /**
     * Initialise le GUI dans GameEngine.
     */
    public void setGUI( final UserInterface pUserInterface )
    {
        this.aGui = pUserInterface;
        this.printWelcome();
    }

    /**
     * Instantie les salles et le "réseau" du jeu
     */
    private void createRooms()
    {
        // Déclaration des lieux
        Room vDesert = new Room("Desert","Images/desert1.png");
        aRooms.put("Desert_1", vDesert);
        Room vDesert2 = new Room("Desert","Images/desert2.png");
        aRooms.put("Desert_2", vDesert);
        Room vShipSouth = new Room("Ship - South","Images/crashedship.png");
        aRooms.put("ShipSouth", vShipSouth);
        Room vShipNorth = new Room("Ship - North","Images/crashedship.png");
        aRooms.put("ShipNorth", vShipNorth);
        Room vShipEast = new Room("Ship - East","Images/crashedship.png");
        aRooms.put("ShipEast", vShipEast);
        Room vShipWest = new Room("Ship - West","Images/crashedship.png");
        aRooms.put("ShipWest", vShipWest);
        Room vShipInside = new Room("inside the ship.","Images/shipinside.png");
        aRooms.put("ShipInside", vShipInside);

        Room vGates = new Room("in front of huge gates.","Images/gates.png");
        aRooms.put("Gates", vGates);
        Room vMainStreet1 = new Room("in the main street.","Images/main_street_1.png");
        aRooms.put("MainStreet1", vMainStreet1);
        Room vMainStreet2 = new Room("in the main street.","Images/main_street_2.png");
        aRooms.put("MainStreet2", vMainStreet2);
        Room vMainStreet3 = new Room("in the main street.","Images/main_street_3.png");
        aRooms.put("MainStreet3", vMainStreet3);
        Room vGovernorTower = new Room("in the governor's tower.","Images/governor_tower.png");
        aRooms.put("GovernorTower", vGovernorTower);
        Room vCybertaverne = new Room("in the cybertaverne.","Images/cybertaverne.png");
        aRooms.put("Cybertaverne", vCybertaverne);
        Room vWeaponMarket = new Room("in the weapon market.","Images/weapon_market.png");
        aRooms.put("WeaponMarket", vWeaponMarket);
        
        Room vStreet1 = new Room("in the street.","Images/street_1.png");
        aRooms.put("Street1", vStreet1);
        Room vStreet2 = new Room("in the street.","Images/street_2.png");
        aRooms.put("Street2", vStreet2);
        Room vSpaceport = new Room("in the spaceport.","Images/spaceport.png");
        aRooms.put("Street2", vStreet2);
        
        Room vMilitaryTower = new Room("in the military tower.","Images/military_tower.png");
        aRooms.put("MilitaryTower", vMilitaryTower);
        
        // Positionnement des sorties
        vDesert.setExit("north",vShipSouth);
        vDesert.setExit("south",vDesert2);

        vShipSouth.setExit("south", vDesert);
        vShipSouth.setExit("east", vShipEast); 
        vShipSouth.setExit("west", vShipWest);

        vShipNorth.setExit("east", vShipEast);
        vShipNorth.setExit("west", vShipWest);
        vShipNorth.setExit("up", vShipInside);

        vShipEast.setExit("north", vShipNorth);
        vShipEast.setExit("south", vShipSouth);

        vShipWest.setExit("north", vShipNorth);
        vShipWest.setExit("south", vShipSouth);

        vShipInside.setExit("down", vShipNorth);
           
        vDesert2.setExit("north",vDesert);
        vDesert2.setExit("south",vGates);
        
        vGates.setExit("south", vMainStreet1);
        vGates.setExit("north", vDesert2);
        
        vMainStreet1.setExit("south", vMainStreet2);
        vMainStreet1.setExit("north", vGates);
        vMainStreet1.setExit("west", vStreet1);
        vMainStreet1.setExit("east", vStreet2);
        
        vStreet1.setExit("east", vMainStreet1);
        vStreet1.setExit("west", vMilitaryTower);
        vStreet1.setExit("north", vSpaceport);
        
        vMilitaryTower.setExit("east", vStreet1);
        
        vSpaceport.setExit("south", vStreet1);
        
        vStreet2.setExit("west", vMainStreet1);
        
        vMainStreet2.setExit("south", vMainStreet3);
        vMainStreet2.setExit("north", vMainStreet1);
        vMainStreet2.setExit("west", vCybertaverne);
        vCybertaverne.setExit("east", vMainStreet2);
        
        vMainStreet3.setExit("south", vGovernorTower);
        vMainStreet3.setExit("north", vMainStreet2);
        vMainStreet3.setExit("east", vWeaponMarket);
        vWeaponMarket.setExit("west", vMainStreet3);
        
        vGovernorTower.setExit("north", vMainStreet3);
        
        // Ajout des items dans les pièces
        //////vShipSouth.addItem(new Item("pomme", "une pomme",5)); à modifier plus tard 
        vShipSouth.addItem(new Item("conserves", "une boite de conserve",5));
        vDesert.addItem(new Item("débrits", "des débrits métalliques",5));
        vShipInside.addItem((Item)(new MaxWeightIncreaserItem("cookie", "Un super cookie.",1,5)));

        // Initialisation du lieu courant
        this.aPlayer.setCurrentRoom(vDesert);
    }

    // METHODES D'AFFICHAGE
    
    /**
     * Affiche les informations sur les sorties de la Room courante.
     */
    private void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.look());  
        if ( this.aPlayer.getCurrentRoom().getImageName() != null )
            this.aGui.showImage( this.aPlayer.getCurrentRoom().getImageName() );
    }//printLocationInfo()

    /**
     * Affiche le message de bienvenue au joueur.
     */
    private void printWelcome()
    {
        this.aGui.println("Welcome to the game !");
        this.aGui.println("After a space battle, you crashed on a desertic planet.");
        this.aGui.println("Type 'help' if you need help.");

        // Affichage des sorties
        this.printLocationInfo();
    }//printWelcome()

    /**
     * Affiche le message d'aide
     */
    private void printHelp()
    {
        this.aGui.println("You are lost. You are alone.");
        this.aGui.println("You wander around in the desert.\n");
        this.aGui.println("Your command words are:");
        this.aGui.println(aParser.getCommandString());
    }//printHelp()

    // COMMANDES
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand( pCommandLine );

        if ( vCommand.isUnknown() ) {
            this.aGui.println( "I don't know what you mean..." );
            return;
        }

        String vCommandWord = vCommand.getCommandWord();
        if ( vCommandWord.equals( "help" ) )
            this.printHelp();
        else if ( vCommandWord.equals( "go" ) )
            this.goRoom(vCommand);
        else if ( vCommandWord.equals( "eat" ) )
            this.eat(vCommand);
        else if ( vCommandWord.equals( "look" ) )
            this.look();
        else if ( vCommandWord.equals( "quit" ) ) 
            this.quit(vCommand);
        else if ( vCommandWord.equals( "back" ) ) 
            this.back(vCommand);
        else if (vCommandWord.equals("test"))
            this.test(vCommand);
        else if (vCommandWord.equals("take"))
            this.take(vCommand);
        else if (vCommandWord.equals("drop"))
            this.drop(vCommand);
        else if (vCommandWord.equals("items"))
            this.items(vCommand);
    }

    /**
     * Commande "items" : Affiche l'inventaire du joueur. 
     */
    private void items(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.getInventory().toString());
        this.aGui.println("Poids total : "+ this.aPlayer.getCurrentWeight() + "/" + this.aPlayer.getMaxWeight());
    }

    /**
     * Commande "take" : transfert un Item de la pièce vers l'inventaire du joueur.
     */
    private void take(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.take(pCommand.getSecondWord()));
    }

    /**
     * Commande "drop" : transfert un Item de l'inventaire du joueur vers la pièce .
     */
    private void drop(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.drop(pCommand.getSecondWord()));
    }

    /**
     * Gère le changement de lieu
     * 
     * @params La commande entrée par le joueur
     */
    private void goRoom(final Command pCommand)
    {
        // Si un seul mot, on retourne "go where ?"
        if ( ! pCommand.hasSecondWord() ) {
            // if there is no second word, we don't know where to go...
            this.aGui.println( "Go where?" );
            return;
        }

        // On cherche la prochaine pièce
        String vDirection = pCommand.getSecondWord();

        Room vNextRoom = this.aPlayer.getCurrentRoomExit(vDirection);

        // On effectue ou pas le changement de lieu
        if ( vNextRoom == null )
            this.aGui.println( "There is no door!" );
        else {
            this.goTo(vNextRoom);
        }

    }//goRoom()

    /**
     * Effectue les étapes necessaires pour changer de pièces.
     * 
     * @params la nouvelle Room.
     */
    private void goTo(final Room pRoom)
    {
        this.aTurnsLeft -= 1;
        if (aTurnsLeft <= 0){
            this.aGui.println("GAME OVER : La bataille au dessus de Saand s'est achevée par l'annihilation de la planète.\nVous êtes mort !");
            this.endGame();
            return;
        }
        this.aPlayer.goTo(pRoom);
        this.printLocationInfo();
    }

    /**
     * Commande "look" : Affiche la description de la pièce.
     */
    private void look()
    {
        this.aGui.println(this.aPlayer.look());
    }//look()

    /**
     * Commande "eat" : Permet de manger.
     */
    private void eat(final Command pCommand)
    {
        this.aGui.println(this.aPlayer.eat(pCommand.getSecondWord()));
    }//eat()

    /**
     * Commande "back" : Permet de revenir à la pièce précédente.
     */
    private void back(final Command pCommand)
    {
        if (pCommand.hasSecondWord())
            this.aGui.println("'back' is not supposed to have a second word.");
        else
        { 
            if (this.aPlayer.previousRoomIsEmpty())
                this.aGui.println("You can't go back now.");
            else
            {
                this.aPlayer.goBack();
                this.printLocationInfo();
            }
        }
    }//back()

    /**
     * Commande "test" : permet de lire un fichier pour executer des commandes.
     */
    private void test(final Command pCommand)
    {
        String vFileName;
        if (pCommand.hasSecondWord()) 
            vFileName = pCommand.getSecondWord();
        else 
            vFileName = "test";

        try
        {
            Scanner vSc = new Scanner(new File(vFileName+".txt"));
            while (vSc.hasNext()){
                this.interpretCommand(vSc.nextLine());
            }
        }
        catch(final java.io.FileNotFoundException pE)
        {
            this.aGui.println("Le fichier demandé n'a pas été trouvé.");
        }
    }

    /**
     * Détecte si le joueur veut quitter le jeu
     */
    private boolean quit(final Command pCommand)
    {
        if (pCommand.hasSecondWord()) {
            this.aGui.println("Quit what ?");
            return false;
        }
        this.endGame();
        return true;
    }//quit()

    // OTHER

    /**
     * Active la fin de jeu.
     */
    private void endGame()
    {
        this.aGui.println( "Thank you for playing.  Good bye." );
        this.aGui.enable( false );
    }
} // Game
