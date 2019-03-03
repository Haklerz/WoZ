package src;

public enum Command {
    GO("go"),
    QUIT("quit"),
    UNKNOWN("?");

    public String commandString;

    private Command(String commandString) {
        this.commandString = commandString;
    }

    public String getCommandString() {
        return this.commandString;
    }
}