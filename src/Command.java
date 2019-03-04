package src;

public enum Command {
    GO("go"),
    QUIT("quit"),
    LOOK("look"),
    HELP("help"),
    INVENTORY("inventory"),
    UNKNOWN("?");

    public String commandString;

    private Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return this.commandString;
    }
}