package src;

import java.util.Iterator;
import java.util.Scanner;

public class Game {
    private Player player;
    private boolean running;
    
    public Game() {}

    public void run() {
        //Map definition
        Room outside = new Room("forrest outside a house");
        Room entrance = new Room("main entrace of the house");
        Room cupboard = new Room("cupboard in the main entrance");
        Room hallway = new Room("hallway");
        Room mainBedroom = new Room("bedroom");
        Room library = new Room("library");
        Room kitchen = new Room("kitchen");
        Room freezer = new Room("freezer");
        Room stairwell = new Room("stairwell");
        Room livingroom = new Room("livingroom");
        Room mainBathroom = new Room("bathroom");
        Room upstairs = new Room("upstairs of the house");
        Room secondBedroom = new Room("bedroom");
        Room secondBathroom = new Room("bathroom");
        Room balcony = new Room("balcony");
        Room loft = new Room("loft");

        outside.addExit("north", entrance);

        entrance.addExit("north", hallway);
        entrance.addExit("west", cupboard);
        entrance.addExit("south", outside);

        cupboard.addExit("east", entrance);

        hallway.addExit("southeast", stairwell);
        hallway.addExit("northeast", kitchen);
        hallway.addExit("north", livingroom);
        hallway.addExit("northwest", library);
        hallway.addExit("southwest", mainBedroom);
        hallway.addExit("south", entrance);

        mainBedroom.addExit("east", hallway);

        library.addExit("east", hallway);
        library.addExit("north", livingroom);

        kitchen.addExit("west", hallway);
        kitchen.addExit("south", freezer);

        freezer.addExit("north", kitchen);

        stairwell.addExit("west", hallway);
        stairwell.addExit("up", upstairs);

        livingroom.addExit("east", mainBathroom);
        livingroom.addExit("southeast", hallway);
        livingroom.addExit("southwest", library);

        mainBathroom.addExit("west", livingroom);

        upstairs.addExit("southeast", secondBedroom);
        upstairs.addExit("northeast", secondBathroom);
        upstairs.addExit("north", loft);
        upstairs.addExit("west", balcony);
        upstairs.addExit("down", stairwell);

        secondBedroom.addExit("west", upstairs);

        secondBathroom.addExit("west", upstairs);

        balcony.addExit("east", upstairs);

        loft.addExit("south", upstairs);



        //Init player
        player = new Player(getPlayerName(), outside);

        while(running) {
            //game loop
        }
    }

    public String getPlayerName() {
        System.out.println("What is your name?\n: ");
        Scanner input = new Scanner(System.in);
        String playerName = input.next();
        input.close();
        return playerName;
    }

    public String getLocationInfo() {
        Room currentRoom = player.getCurrentRoom();
        String location = "You are in the " + currentRoom.getDescription();
        location += ".\nWhere do you want to go next?\n";
        return location;
    }

    public String getExitDirections() {
        Room currentRoom = player.getCurrentRoom();
        Iterator<String> directions = currentRoom.getExitDirections();
        String exitsString = "Exits:";
        while(directions.hasNext()) {
            exitsString += " " + directions.next();
        }
        return exitsString;
    }
}