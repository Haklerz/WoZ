package src;

import java.util.Scanner;

public class Parser {
    private Scanner scanner;

    public Parser() {
        scanner = new Scanner(System.in);
    }

    public Instruction getInstruction() {
        return new Instruction(scanner.nextLine());
    }

	public void close() {
        this.scanner.close();
	}
}