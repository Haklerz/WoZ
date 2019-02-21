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
        this.running = true;
    }

    public void run() {
        //Map definition
        Room entrance   = new Room("main entrance");
        Room hallway    = new Room("hallway");
        Room bedroom    = new Room("bedroom");
        Room livingroom = new Room("livingroom");
        Room kitchen    = new Room("kitchen");

        hallway.addExit("east" , kitchen);
        hallway.addExit("north", livingroom);
        hallway.addExit("west" , bedroom);
        hallway.addExit("south", entrance);

        kitchen.addExit   ("west" , hallway);
        livingroom.addExit("south", hallway);
        bedroom.addExit   ("east" , hallway);
        entrance.addExit  ("north", hallway);

        //Init player
        printWelcome();
        player = new Player(getPlayerName(), entrance);
        parser = new Parser();
        while(running) {
            printLocationInfo();
            Command command = parser.getCommand();
            executeCommand(command);
            //quit();
        }
        printFarewell();
    }

    private void executeCommand(Command command) {
        quit();
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
        String playerName = input.next();
        return playerName;
    }

    public void printLocationInfo() {
        Room currentRoom = player.getCurrentRoom();
        System.out.println("\nYou are in the " + currentRoom.getDescription() + ".\nWhat do you want to do next?");
    }

    public void printExitDirections() {
        Room currentRoom = player.getCurrentRoom();
        Iterator<String> directions = currentRoom.getExitDirections();
        String exitsString = "Exits:";
        while(directions.hasNext()) {
            exitsString += " " + directions.next();
        }
        System.out.println(exitsString);
    }

    public void printPlayerInventory() {
        Iterator<String> inventory = player.getItemNames();
        String itemNames = "Inventory:";
        while(inventory.hasNext()) {
            itemNames += " " + inventory.next();
        }
        System.out.println(itemNames);
    }

    public void quit() {
        this.parser.quit();
        this.running = false;
    }
}