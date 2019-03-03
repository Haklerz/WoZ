package src;

import java.util.Iterator;
import java.util.Scanner;

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
        Room entrance   = new Room("main entrance");
        Room hallway    = new Room("hallway");
        Room bedroom    = new Room("bedroom");
        Room livingroom = new Room("livingroom");
        Room kitchen    = new Room("kitchen");

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
            this.printLocationInfo();
            Instruction instruction = parser.getInstruction();
            this.executeInstruction(instruction);
        }
        this.printFarewell();
    }

    private void executeInstruction(Instruction instruction) {
        Command command = instruction.getCommand();
        String arguments = instruction.getArguments();
        switch (command) {
            case QUIT:
                this.quit();
                break;
            
            case GO:
                Room currentRoom = this.player.getCurrentRoom();
                this.player.go(currentRoom.getExit(arguments));
                break;
        
            default:
                this.printUnknownCommand();
                break;
        }
    }

    private void printUnknownCommand() {
        System.out.println("I don't know what you mean.");
        System.out.println("Type help for valid commands.");
    }

    private void printWelcome() {
        System.out.println("\nWelcome to the World of Zuul!");
        System.out.println("This game is very bad.");
        System.out.println("But it is under developemt so it's ok.\n");
        System.out.println("To start your adventure I need to know your name.");
    }

    private void printFarewell() {
        System.out.println("\nThank you for playing, " + player.getName() + ".");
    }    

    public String getPlayerName() {
        System.out.println("What do you wish to be called?");
        Scanner input = new Scanner(System.in);
        String playerName = input.nextLine();
        return playerName;
    }

    public void printLocationInfo() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("\nYou are in the " + currentRoom.getDescription());
    }

    public void printExitDirections() {
        Room currentRoom = player.getCurrentRoom();
        Iterator<String> directions = currentRoom.getExitIterator();
        String exitsString = "Exits:";
        while(directions.hasNext()) {
            exitsString += " " + directions.next();
        }
        System.out.println(exitsString);
    }

    public void printPlayerInventory() {
        Iterator<String> inventory = player.getItemIterator();
        String itemNames = "Inventory:";
        while(inventory.hasNext()) {
            itemNames += " " + inventory.next();
        }
        System.out.println(itemNames);
    }

    public void quit() {
        this.parser.close();
        this.running = false;
    }
}