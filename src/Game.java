package src;

import java.util.Iterator;

/**
 * @author Håkon "Haklerz" Lervik
 * @version 0.1
 */
public class Game {
    private Player player;
    private Parser parser;
    private boolean running;
    
    public Game() {
        this.parser = new Parser();
    }

    private void createWorld() {
        Room entrance   = new Room("in the Main Entrance", "The Main Entrance of the house is small but welcoming.");
        Room hallway    = new Room("in the Hallway",       "The Hallway is long with a door in each end and on eather side.");
        Room bedroom    = new Room("in the Bedroom",       "The Bedroom is large with a massive bed.");
        Room livingroom = new Room("in the Livingroom",    "The Livingroom has a comfy couch and a big tube-TV.");
        Room kitchen    = new Room("in the Kitchen",       "The Kitchen is clean and sleek.");

        hallway.addExit("east" , kitchen);
        hallway.addExit("north", livingroom);
        hallway.addExit("west" , bedroom);
        hallway.addExit("south", entrance);

        kitchen.addExit(   "west" , hallway);
        livingroom.addExit("south", hallway);
        bedroom.addExit(   "east" , hallway);
        entrance.addExit(  "north", hallway);

        player = new Player(getPlayerName(), entrance);
    }

    public void run() {
        this.running = true;
        this.printWelcome();
        this.createWorld();
        while(this.running) {
            this.printLocationName();
            this.printExitDirections();
            System.out.print(">");
            Instruction instruction = this.parser.getInstruction();
            this.executeInstruction(instruction);
        }
        this.printFarewell();
    }

    private void executeInstruction(Instruction instruction) {
        Command command = instruction.getCommand();
        String arguments = instruction.getArguments();
        Room currentRoom = player.getCurrentRoom();
        switch (command) {
            case QUIT:
                this.quit();
                break;
            
            case GO:
                try {
                    if (arguments.equals("back")) {
                        this.player.go(this.player.getPreviousRoom());
                    }
                    else {
                        this.player.go(currentRoom.getExit(arguments));
                    }
                }
                catch(NullPointerException e) {
                    this.printNoRoom();
                }
                break;
            
            case LOOK:
                this.printLocationInfo();
                this.printItems();
                break;
            
            case HELP:
                this.printHelpInfo();
                break;
            
            case INVENTORY:
                this.printPlayerInventory();
                break;
        
            case UNKNOWN:
                this.printUnknownCommand();
                break;
        }
    }

    private void printNoRoom() {
        System.out.println("\nNo room in that direction.");
    }

    private void printHelpInfo() {
        String commandsString = "\nCommands:";
        for (Command testCommand : Command.values()) {
            if (!testCommand.getCommandString().equals("?")) {
                commandsString += " " + testCommand.getCommandString();
            }
        }
        System.out.println(commandsString);
    }

    private void printLocationName() {
        Room currenRoom = this.player.getCurrentRoom();
        System.out.println("\nYou are " + currenRoom.getName() + ".");
    }

    private void printUnknownCommand() {
        System.out.println("\nI don't know what you mean.");
        System.out.println("Type help for valid commands.");
    }

    private void printWelcome() {
        System.out.println("\nWelcome to the World of Zuul!");
        System.out.println("This game is very bad.");
        System.out.println("But it is under developemt so it's ok.");
    }

    private void printFarewell() {
        System.out.println("\nThank you for playing, " + player.getName() + ".");
    }    

    private String getPlayerName() {
        System.out.println("\nTo start your adventure I need to know your name.");
        System.out.println("What do you wish to be called?");
        return parser.getInput();
    }

    private void printLocationInfo() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("\n" + currentRoom.getDescription());
    }

    private void printExitDirections() {
        Room currentRoom = player.getCurrentRoom();
        Iterator<String> directions = currentRoom.getExitIterator();
        String exitsString = "Exits:";
        while(directions.hasNext()) {
            exitsString += " " + directions.next();
        }
        System.out.println(exitsString);
    }

    private void printPlayerInventory() {
        Iterator<String> inventory = player.getItemIterator();
        String itemNames = "\nInventory:";
        while(inventory.hasNext()) {
            itemNames += " " + inventory.next();
        }
        System.out.println(itemNames);
    }

    private void printItems() {
        Room currentRoom = this.player.getCurrentRoom();
        Iterator<String> items = currentRoom.getItemIterator();
        String itemNames = "Items in the room:";
        while(items.hasNext()) {
            itemNames += " " + items.next();
        }
        System.out.println(itemNames);
    }

    private void quit() {
        this.parser.close();
        this.running = false;
    }
}