package src;

import java.util.Scanner;

public class Parser {
    private Scanner scanner;

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public Instruction getInstruction() {
        String instructionString = this.getInput();
        Command command = Command.UNKNOWN;
        String arguments = "";
        String[] instructionComponents = instructionString.split(" ", 2);
        for (Command testCommand : Command.values()) {
            if (instructionComponents[0].equals(testCommand.getCommandString())) {
                command = testCommand;
            }
        }
        if (instructionComponents.length > 1) {
            arguments = instructionComponents[1];
        }
        return new Instruction(command, arguments);
    }

	public void close() {
        this.scanner.close();
	}

	public String getInput() {
		return this.scanner.nextLine();
	}
}