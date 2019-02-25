package src;

import java.util.Scanner;

/**
 * Represents a parser.
 */
public class Parser {
    private Scanner reader;

    public Parser() {
        this.reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String commandStrings[] = this.reader.next().split(" ");
        String operation = commandStrings[0];
        String firstOperand = commandStrings[1];
        String secondOperand = commandStrings[2];
        return new Command(operation, firstOperand, secondOperand);
    }

    public void quit() {
        this.reader.close();
    }
}