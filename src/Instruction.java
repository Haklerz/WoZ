package src;

public class Instruction {
    private Command command;
    private String arguments;

    public Instruction(String instructionString) {
        String[] instructionComponents = instructionString.split(" ", 2);
        this.command = Command.UNKNOWN;
        for (Command testCommand : Command.values()) {
            if (instructionComponents[0].equals(testCommand.getCommandString())) {
                this.command = testCommand;
            }
        }
        this.arguments = (instructionComponents.length > 1) ? instructionComponents[1] : "";
    }

    public Command getCommand() {
        return this.command;
    }

    public String getArguments() {
        return this.arguments;
    }
}