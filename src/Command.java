package src;

public class Command {
    private Operation operation;
    private String operand;

    public Command(Operation operation, String operand) {
        this.operation = operation;
        this.operand = operand;
    }
}