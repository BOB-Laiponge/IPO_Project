package pkg_game;



import java.util.Scanner;
import java.util.HashMap;
import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

import pkg_game.GameEngine;
import pkg_characters.Player;
import pkg_characters.Character;
import pkg_characters.MovingCharacter;
import pkg_game.UserInterface;

import pkg_commands.Parser;
import pkg_commands.Command;

import pkg_rooms.Room;
import pkg_rooms.TransporterRoom;
import pkg_rooms.RoomRandomizer;
import pkg_rooms.Door;

import pkg_items.Item;
import pkg_items.MaxWeightIncreaserItem;
import pkg_items.Beamer;
import pkg_items.Bomb;

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
    private ArrayList<MovingCharacter> aMovingCharacters;
    
    private HashMap<String, Door> aDoors;
    private boolean aIsBombInGame;
    
    // Constructeurs
    /**
     * Constructeur pour les objets de classe GameEngine.
     */
    public GameEngine()
    {
        this.aMovingCharacters = new ArrayList<MovingCharacter>();
        this.aAleaRoom = null;
        this.aTestMode = false;
        this.aPlayer = new Player("Player");
        this.aRooms = new HashMap<String,Room>();
        this.aParser = new Parser();
        this.aDoors = new HashMap<String,Door>();
        this.createRooms();
        this.aIsBombInGame = false;
        
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
        Room vDesert = new Room("dans le désert de Saand","Images/desert1.png");
        aRooms.put("Desert_1", vDesert);
        Room vDesert2 = new Room("dans le désert de Saand","Images/desert2.png");
        aRooms.put("Desert_2", vDesert);
        Room vShipSouth = new Room("au sud du vaisseau écrasé","Images/crashedship.png");
        aRooms.put("ShipSouth", vShipSouth);
        Room vShipNorth = new Room("au nord du vaisseau écrasé","Images/crashedship.png");
        aRooms.put("ShipNorth", vShipNorth);
        Room vShipEast = new Room("à l'est du vaisseau écrasé","Images/crashedship.png");
        aRooms.put("ShipEast", vShipEast);
        Room vShipWest = new Room("à l'ouest du vaisseau écrasé","Images/crashedship.png");
        aRooms.put("ShipWest", vShipWest);
        Room vShipInside = new Room("à l'intérieur vaisseau écrasé","Images/shipinside.png");
        aRooms.put("ShipInside", vShipInside);

        Item vBadge = new Item("badge", "Votre badge militaire de l'Union.",0);
        Item vOldKey = new Item("clé", "Une clé ancienne.",2);
        
        Room vGatesFront = new Room("devant les portes de Saand City","Images/gates.png");
        Door vGates = new Door("Gates","Images/gates.png", vBadge);
        aDoors.put("Gate", vGates);
        aRooms.put("GatesFront", vGatesFront);
        Room vMainStreet1 = new Room("dans l'avenue principale de Saand City","Images/main_street_1.png");
        aRooms.put("MainStreet1", vMainStreet1);
        Room vMainStreet2 = new Room("dans l'avenue principale de Saand City","Images/main_street_2.png");
        aRooms.put("MainStreet2", vMainStreet2);
        Room vMainStreet3 = new Room("dans l'avenue principale de Saand City","Images/main_street_3.png");
        aRooms.put("MainStreet3", vMainStreet3);
        Room vGovernorTower = new Room("dans la tour du gouverneur","Images/governor_tower.png");
        aRooms.put("GovernorTower", vGovernorTower);
        Room vCybertaverne = new Room("dans la Cybertaverne","Images/cybertaverne.png");
        aRooms.put("Cybertaverne", vCybertaverne);
        Room vWeaponMarket = new Room("dans un marché d'arme","Images/weapon_market.png");
        aRooms.put("WeaponMarket", vWeaponMarket);
        
        Room vOldTemple = new Room("dans un temple d'une autre époque","Images/old_temple.png");
        Door vTempleDoor = new Door("OldTemple", "Images/old_temple.png", vOldKey);
        aDoors.put("TempleDoor", vTempleDoor);
        
        Room vOldFactory = new Room("dans une vielle usine","Images/old_factory.png");
        aRooms.put("OldFactory", vOldFactory);
        Room vOldBuilding = new Room("dans un immeuble abandonné","Images/old_building.png");
        aRooms.put("OldBuilding", vOldBuilding);
        
        Room vStreet1 = new Room("dans une rue à l'Ouest de la ville","Images/street_1.png");
        aRooms.put("Street1", vStreet1);
        Room vStreet2 = new Room("dans une rue à l'Est de la ville.","Images/street_2.png");
        aRooms.put("Street2", vStreet2);
        Room vSpaceport = new Room("dans le Spaceport","Images/spaceport.png");
        aRooms.put("Spaceport", vSpaceport);
        Room vMilitaryTower = new Room("dans la tour militaire","Images/military_tower.png");
        aRooms.put("MilitaryTower", vMilitaryTower);
        
        Door vDock1 = new Door("Quai 1", "Images/spaceport.png", null);
        aDoors.put("Dock1", vDock1);
        Door vDock2 = new Door("Quai 2", "Images/spaceport.png", null);
        aDoors.put("Dock2", vDock2);
        Room vUnionShip = new Room("dans le vaisseau de l'Union","Images/union_ship.png");
        aRooms.put("UnionShip", vUnionShip);
        Room vRebelShip = new Room("dans le cargo rebelle","Images/rebel_ship.png");

        this.aRoomRandomizer = new RoomRandomizer(this.aRooms);
        Room vTransporterRoom = new TransporterRoom("Une salle de téléportation. Attention : Cette technologie est instable et peut vous téléporter n'importe où sur la planète","Images/spaceport.png", this.aRoomRandomizer);
        

        // Positionnement des sorties
        
        
        vDesert.setExit("north",vShipSouth);
        vDesert.setExit("south",vDesert2);
        vDesert.setExit("east",vTempleDoor);
        vOldTemple.setExit("west",vTempleDoor);
        vTempleDoor.setExit("", vDesert);
        vTempleDoor.setExit("", vOldTemple);

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
        vSpaceport.setExit("quai1", vDock1);
        vSpaceport.setExit("quai2", vDock2);
        
        vDock1.setExit("", vUnionShip);
        vDock1.setExit("", vSpaceport);
        vDock2.setExit("", vRebelShip);
        vDock2.setExit("", vSpaceport);
        
        vRebelShip.setExit("quai2", vDock2);
        vUnionShip.setExit("quai1", vDock1);
        vUnionShip.setExit("north", vTransporterRoom);
        vTransporterRoom.setExit("south", vUnionShip);
        vTransporterRoom.setExit("beam", null);


        vStreet2.setExit("west", vMainStreet1);
        vStreet2.setExit("south", vWeaponMarket);
        vStreet2.setExit("up", vOldBuilding);
        vStreet2.setExit("east", vOldFactory);
        
        vOldBuilding.setExit("down", vStreet2);
        vOldFactory.setExit("west", vStreet2);
        
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
        vUnionShip.addItem(vOldKey);
        vDesert.addItem(new Item("débrits", "Des débrits métalliques",5));
        vShipInside.addItem((Item)(new MaxWeightIncreaserItem("cookie", "Un super cookie.",1,5)));
        vWeaponMarket.addItem((Item)(new Beamer("Beamer", "Un Beamer made-in-Earth.",2, this)));
        vOldTemple.addItem(new Item("Nanites", "Des nanites qui peuvent prendre n'importe quelle forme sur demande.", 5));
        
        vGatesFront.addPNJ(new Character("Garde","Bonjour, des rebelles sont dans la ville.\nJe ne peux laisser entrer personne sans badge.","Sans badge, vous n'entrez pas."));
        
        vCybertaverne.addPNJ(new Character(
        "Tavernier", "Bonjour. Vous cherchez à quittez la planète ? \nMalheureusement, il y a un couvre feu.\nEssayez d'aller au poste de l'Union.\nSinon, essayez d'aller dans les vielles habitation à l'Est."
        ,"Allez au poste de l'Union ou aux habitations abandonnées."));
        
        vOldBuilding.addPNJ(new Character("Ragnar",
        "Bonjour, je suis le commandant des rebelles sur Saand.\nJ'ai appris que tu cherchais à quitter la planète.\nJe peux te faire monter dans notre cargo pour la Terre.\nMais pour cela, tu devras d'abord faire exploser une bombe dans la tour du gouverneur."
        , "Tu peux trouver une bombe au Marché d'Armes.\nUne fois la bombe activée, rejoins le cargo sur le Quai 2 du spatioport, à l'Ouest de la ville."));
        
        vMilitaryTower.addPNJ(new Character("Commandant",
        "Bonjour, Je suis le Commandant de l'Union sur Saand.\nVous voulez nous aider à gagner la bataille au dessus de nous ?\nPour cela, il va faloir nous aider à vaincre les rebelles.\nVa chercher une bombe au Marché d'Armes, et fais la exploser dans la vielle usine. \nC'est le repère des rebelles.",
        "Fais exploser la bombe dans la vielle usine, et rejoins le vaisseau de l'union sur le Quai 1 du Spatioport."
        ));
        vRebelShip.addPNJ(new Character("Conducteur",
        "Bien le bonjour ! Bienvenue sur le cargo des rebelles !\nC’était une très belle explosion tout à l’heure, bravo !\nMaintenant nous allons pouvoir enfin prendre le contrôle de Saand, et de ses usines d’armement.\nPréparez-vous au décollage !!!\n\n*Le vaisseau décolle dans un grand bruit. \nAu loin vous apercevez la bataille qui fait rage entre les rebelles et l’Union.\nSoudain, le cargo est immobilisé, et des troupes de l’Union entrent. \nVous êtes fait prisonnier et vous êtes amené devant le Commandant des forces de l’Union. *\n\n> Commandant : Alors… Voici le pilote de l’Union qui a détruit la tour du Gouverneur.\nIl est clair que vous avez fait ça sous la contrainte. \nJe vous offre donc une chance de vous racheter.\nNous avons entendu des rumeurs quant à l’existence d’une arme très ancienne sur Saand.\nElle serait dans le désert. Ramenez-la au vaisseau de l’Union et tout sera pardonné. \n\n> Prisonnier rebelle : NOON, les rebelles ont besoin de cette arme !!! Ramenez là aux rebelles !!!\n\n> Commandant : Silence ! Dépêchez-vous de nous ramener l’arme.\nPrener cette clé et descendez sur la planète par le Rayon de téléportation, dans la pièce à coté.\n ",""
        ));
        
        vMainStreet1.addPNJ(new Character("Citoyenne", "Bonjour. Vous semblez perdu.\nAllez à la CyberTaverne pour tout renseignement.", "Allez à la CyberTaverne pour tout renseignement."));
        
        MovingCharacter vMC1 = new MovingCharacter("Citoyen", "Bonjour. Il fait beau aujourd'hui.", "Allez à la CyberTaverne pour tout renseignement.");
        vMainStreet1.addPNJ(vMC1);
        this.aMovingCharacters.add(vMC1);
        
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
        if (this.aPlayer.getCurrentRoom().getImageName() != null)
            this.aGui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }//printLocationInfo()

    /**
     * Affiche le message de bienvenue au joueur.
     */
    private void printWelcome()
    {
        this.aGui.println("Bienvenue sur Saand : La planète désertique");
        this.aGui.println("La guerre fait rage entre l'Union Galactique et les Rebelles.");
        this.aGui.println("Une bataille a éclaté au dessus de Saand, le dernier point de passage avant la Terre.");
        this.aGui.println("Vous êtes une jeune pilote de l'Union. Pour votre première mission, vous deviez vous battre dans cette bataille.");
        this.aGui.println("Mais votre vaisseau a été touché, et s'est écrasé sur Saand."); 
        this.aGui.println("Vous avez eu le temps de vous éjecter."); 
        this.aGui.println("Vous devez rapidement trouver un moyen de retourner combattre pour pouvoir rentrer sur Terre."); 
        this.aGui.println("Appuiyez sur (ou tapez) 'help' pour voir les commandes possibles.\n");

        // Affichage des sorties
        this.printLocationInfo();
    }//printWelcome()


    // COMMANDES

    /**
     * Interprète la commande entrée.
     * @param La commande à exécuter
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
     * @param la nouvelle Room.
     */
    public void goTo(final Room pRoom)
    {
        this.aGui.print(this.aPlayer.goTo(pRoom));
        this.printLocationInfo();
    }

    // OTHER
    /**
     * Déplace les MovingCharacters.
     */
    public void moveCharacters()
    {
        ListIterator<MovingCharacter> vIt = this.aMovingCharacters.listIterator();
            while(vIt.hasNext()){
                vIt.next().move();
            }
    }
    
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
     * 
     * @return true si le jeu est en mode test, false sinon
     */
    public boolean getTestMode()
    {
        return this.aTestMode;
    }

    /**
     * Permet d'indiquer si le jeu est en mode test ou non.
     * 
     * @param True or False pour activer ou non le TestMode
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
     * @return Les pièces du jeu.
     */
    public HashMap<String,Room> getRooms()
    {
        return this.aRooms;
    }
    
    /**
     * Retourne une pièce du jeu.
     * @return Une pièce du jeu.
     * @param Le nom de la pièce.
     */
    public Room getRoom(final String pName)
    {
        return this.aRooms.get(pName);
    }
    
    /**
     * Retourne les Doors du jeu
     */
    public HashMap<String, Door> getDoors()
    {
        return this.aDoors;
    }
    //HISTOIRE
    
    /**
     * Fonction Histoire : Fait apparaitre la bombe au Weapon Market
     */
    public void summonBombInWM()
    {
        if (this.aIsBombInGame == false)
        {
            this.aIsBombInGame = true;
            this.getRoom("WeaponMarket").addItem((Item)new Bomb("bombe", "Une bombe artisanale.", 5, this));
        }
    }
    
    /**
     * Fonction Histoire : Ouvre le vaisseau de l'Union
     */
    public void explosionOldFactory()
    {
        this.aDoors.get("Dock1").setOpen();
        this.aRooms.get("OldBuilding").removePNJ("Ragnar");
        this.aRooms.get("MilitaryTower").removePNJ("Commandant");
        this.aRooms.get("UnionShip").addPNJ(new Character("Commandant", "Toutes mes félicitations. Vous avez vaincu la plupart des troupes rebelles de Saand. \nJ’ai encore quelque chose à vous demander. \nNous avons entendu parler d’un ancien temple datant d’avant la colonisation de la planète.\nIl abriterait une arme très puissante. \nPrenez cette clé, amenez-nous cette arme afin que nous puissions vaincre les rebelles, et vous pourrez rentrer sur Terre. ",
        "La clé, le temple, l'arme, le vaisseau, la Terre."));
    }
    
    /**
     * Fonction Histoire : Ouvre le vaisseau des rebelles
     */
    public void explosionGovTower()
    {
        this.aDoors.get("Dock2").setOpen();
        this.aRooms.get("OldBuilding").removePNJ("Ragnar");
        this.aRooms.get("MilitaryTower").removePNJ("Commandant");
        
    }
    
    /**
     * Fonction Histoire : La fin de l'Histoire avec les rebelles.
     */
    public void endWithRebels()
    {
        this.aGui.println("Vous avez donné des Nanites aux rebelles.\nGrâce à cette nouvelle arme, ils ont facilement pu détruire la Grande Flotte de l'Union,\net prendre le contrôle de la galaxie.\nTous les dirigeants de l'Union ont été jugés et exécutés.\nIls vous ont ramené sur Terre, et vous ont promu Capitaine.");
        this.endGame();
    }
    
    /**
     * Fonction Histoire : La fin de l'Histoire avec l'Union.
     */
    public void endWithUnion()
    {
        this.aGui.println("Vous avez donné des Nanites aux forces de l'Union.\nGrâce à cette nouvelle arme, ils ont facilement pu détruire la flotte rebelle.\nTous les leaders rebelles ont été jugés et exécutés.\nVous avez été ramené sur Terre, et avez été promu Capitaine.");
        this.endGame();
    }
} // Game
