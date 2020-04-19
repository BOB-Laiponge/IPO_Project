import java.util.Scanner;
import java.util.HashMap;
import java.io.File;

/**
 * Classe principale du jeu. GameEngine permet de gérer le déroulement une partie.
 * 
 * @author PITIOT Pierre-Yves
 * @version 21/04/2020
 */
public class GameEngine
{
    // Attributs
    private Parser aParser;
    private Player aPlayer;
    private UserInterface aGui;
    private HashMap<String, Room> aRooms;
    private RoomRandomizer aRoomRandomizer;
    private boolean aTestMode;
    private Room aAleaRoom;

    // Constructeurs
    /**
     * Constructeur pour les objets de classe GameEngine.
     */
    public GameEngine()
    {
        this.aAleaRoom = null;
        this.aTestMode = false;
        this.aPlayer = new Player("Elsa Edington");
        this.aRooms = new HashMap<String,Room>();
        this.aParser = new Parser();
        this.createRooms();
        
        
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
     * Instantie les salles, le "réseau", et les items du jeu
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

        Item vBadge = new Item("badge", "Mon badge militaire de l'Union.",0);

        Room vGatesFront = new Room("in front of huge gates.","Images/gates.png");
        Door vGates = new Door("gates","Images/gates.png", vBadge);
        aRooms.put("GatesFront", vGatesFront);
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
        aRooms.put("Spaceport", vSpaceport);
        Room vMilitaryTower = new Room("in the military tower.","Images/military_tower.png");
        aRooms.put("MilitaryTower", vMilitaryTower);
        
        Room vUnionShip = new Room("in the Union Ship.","Images/spaceport.png");
        aRooms.put("UnionShip", vUnionShip);
        
        
        this.aRoomRandomizer = new RoomRandomizer(this.aRooms);
        Room vTransporterRoom = new TransporterRoom("Une salle de téléportation. Attention : Cette technologie est instable et peut vous téléporter n'importe où sur la planète","Images/spaceport.png", this.aRoomRandomizer);
        //aRooms.put("vTransporterRoom", vUnionShip);
        
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
        vDesert2.setExit("south",vGatesFront);

        vGatesFront.setExit("south", vGates);
        vGatesFront.setExit("north", vDesert2);

        vGates.setExit("south", vMainStreet1);
        vGates.setExit("north", vGatesFront);

        vMainStreet1.setExit("south", vMainStreet2);
        vMainStreet1.setExit("north", vGates);
        vMainStreet1.setExit("west", vStreet1);
        vMainStreet1.setExit("east", vStreet2);

        vStreet1.setExit("east", vMainStreet1);
        vStreet1.setExit("west", vMilitaryTower);
        vStreet1.setExit("north", vSpaceport);

        vMilitaryTower.setExit("east", vStreet1);

        vSpaceport.setExit("south", vStreet1);
        vSpaceport.setExit("east", vUnionShip);
        
        vUnionShip.setExit("west", vSpaceport);
        vUnionShip.setExit("north", vTransporterRoom);
        vTransporterRoom.setExit("south", vUnionShip);
        vTransporterRoom.setExit("beam", null);
        
        
        vStreet2.setExit("west", vMainStreet1);
        vStreet2.setExit("south", vWeaponMarket);

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

        vShipInside.addItem(vBadge);
        vShipSouth.addItem(new Item("conserves", "une boite de conserve",5));
        vDesert.addItem(new Item("débrits", "des débrits métalliques",5));
        vShipInside.addItem((Item)(new MaxWeightIncreaserItem("cookie", "Un super cookie.",1,5)));
        vWeaponMarket.addItem((Item)(new Beamer("Beamer", "un beamer",2, this)));
        // Initialisation du lieu courant
        this.aPlayer.setCurrentRoom(vDesert);
    }

    // METHODES D'AFFICHAGE

    /**
     * Affiche les informations sur les sorties de la Room courante.
     */
    public void printLocationInfo()
    {
        this.aGui.println(this.aPlayer.lookRoom());  
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

    
    // COMMANDES

    /**
     * Interprète la commande entrée
     */
    public void interpretCommand( final String pCommandLine ) 
    {
        this.aGui.println( "> " + pCommandLine );
        Command vCommand = this.aParser.getCommand(pCommandLine);
        
        vCommand.execute(this.aPlayer, this, this.aGui);
        this.aGui.println("");
    }

    
    /**
     * Effectue les étapes necessaires pour changer de pièces.
     * 
     * @params la nouvelle Room.
     */
    public void goTo(final Room pRoom)
    {
        this.aGui.print(this.aPlayer.goTo(pRoom));
        this.printLocationInfo();
    }

    // OTHER

    /**
     * Active la fin de jeu.
     */
    public void endGame()
    {
        this.aGui.println( "Merci d'avoir joué à Saand : La planète désertique.\nA bientôt." );
        this.aGui.enable( false );
    }
    
    /**
     * Indique si le jeu est en mode "test" ou non.
     * @return true si le jeu est en mode test, false sinon
     */
    public boolean getTestMode()
    {
        return this.aTestMode;
    }
    
    /**
     * Permet d'indiquer si le jeu est en mode test ou non.
     */
    public void setTestMode(final boolean pBool)
    {
        this.aTestMode = pBool;
    }
    
    /**
     * Retourne l'AleaRoom
     * @return L'AleaRoom
     */
    public Room getAleaRoom()
    {
        return this.aAleaRoom;
    }
    
    /**
     * Permet de modifier l'AleaRoom
     */
    public void setAleaRoom(final Room pRoom)
    {
        this.aAleaRoom = pRoom;
    }
    
    /**
     * Retourne le Parser.
     * @return Le Parser
     */
    public Parser getParser()
    {
        return this.aParser;
    }
    
    /**
     * Retourne les pièces du jeu.
     * @return Les pièces du jeu
     */
    public HashMap<String,Room> getRooms()
    {
        return this.aRooms;
    }
} // Game
