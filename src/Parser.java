package src;

import java.util.Scanner;

public class Parser {
    private Scanner reader;

    public Parser() {
        this.reader = new Scanner(System.in);
    }

    public void getCommand() {
    }

    public void quit() {
        this.reader.close();
    }
}