package src;

public class Instruction {
    private Command command;
    private String arguments;

    public Instruction(Command command, String arguments) {
        this.command = command;
        this.arguments = arguments;
    }

    public Command getCommand() {
        return this.command;
    }

    public String getArguments() {
        return this.arguments;
    }
}