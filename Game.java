public class Game
{
    // Attributs
    private Room aCurrentRoom;
    private Parser aParser;
    // Constructeurs
    /**
     * Constructeur : va instantier les salles et le réseau du jeu.
     */
    public Game()
    {
        this.createRooms();
        this.aParser = new Parser();
        this.play();
    }

    // Methodes
    /**
     * Fonction principale du jeu.
     */
    private void play()
    {
        this.printWelcome();

        boolean vFinished = false;
        while (!vFinished)
        {
            Command vCommand = this.aParser.getCommand();
            vFinished = this.processCommand(vCommand);
        }
        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * Instantier les salles et le réseau du jeu
     */
    private void createRooms()
    {
        // Déclaration des lieux
        Room vDesert = new Room("Desert");
        Room vShipSouth = new Room("Ship - South");
        Room vShipNorth = new Room("Ship - North");
        Room vShipEast = new Room("Ship - East");
        Room vShipWest = new Room("Ship - West");
        Room vShipInside = new Room("inside the ship.");

        // Positionnement des sorties
        vDesert.setExit("north",vShipSouth);
        
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

        // Initialisation du lieu courant
        this.aCurrentRoom = vDesert;
    }

    /**
     * Gère le changement de lieu
     */
    private void goRoom(final Command pCommand)
    {
        // Si un seul mot, on retourne "go where ?"
        if (!pCommand.hasSecondWord()) {System.out.println("Go where ?"); return ;}

        // On cherche la prochaine pièce
        Room vNextRoom = null;
        String vDirection = pCommand.getSecondWord();

        vNextRoom = this.aCurrentRoom.getExit(vDirection);
        /////{System.out.println("Unknown direction !"); return;}

        // On effectue ou pas le changement de lieu
        if (vNextRoom == null) {
            System.out.println("There is no door !");
            return; 
        }

        this.aCurrentRoom = vNextRoom;
        printLocationInfo();
    }//goRoom()
    
    /**
     * Affiche les informations sur les sorties de la Room courante.
     */
    private void printLocationInfo()
    {
        System.out.println(this.aCurrentRoom.getLongDescription());      
    }//printLocationInfo()
    
    /**
     * Affiche le message de bienvenue
     */
    private void printWelcome()
    {
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("World of Zuul is a new, incredibly boring adventure game.");
        System.out.println("Type 'help' if you need help.");

        System.out.println("\nYou are outside the main entrance of the university.");

        // Affichage des sorties
        printLocationInfo();
    }//printWelcome()

    /**
     * Affiche le message d'aide
     */
    private void printHelp()
    {
        System.out.println("You are lost. You are alone.");
        System.out.println("You wander around at the university.\n");
        System.out.println("Your command words are:");
        System.out.println("go quit help");
    }//printHelp()

    /**
     * On détecte si le joueur veut quitter le jeu
     */
    private boolean quit(final Command pCommand)
    {
        if (pCommand.hasSecondWord()) {
            System.out.println("Quit what ?");
            return false;
        }
        return true;
    }//quit()

    /**
     * Appelle la bonne méthode en fonction de la commande passée en paramètre.
     */
    private boolean processCommand(final Command pCommand)
    {
        if (pCommand.isUnknown()){
            System.out.println("I don't know what you mean...");
            return false;
        }
        
        if (pCommand.getCommandWord().equals("quit")) return this.quit(pCommand);
        else if (pCommand.getCommandWord().equals("go")) this.goRoom(pCommand);
        else if (pCommand.getCommandWord().equals("help")) this.printHelp();
        else if (pCommand.getCommandWord().equals("look")) this.look();
        
        return false;
    }//processCommand()
    
    private void look()
    {
        System.out.println(this.aCurrentRoom.getLongDescription());
    }//look()
    
} // Game
