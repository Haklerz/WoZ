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

    public void getCommand() {
    }

    public void close() {
        this.reader.close();
    }
}