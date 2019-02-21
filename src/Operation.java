package src;

public enum Operation {
    GO("go"),
    LOOK("look"),
    TAKE("take"),
    USE("use"),
    QUIT("quit"),
    UNKNOWN("?");

    private String operationString;

    private Operation(String operationString) {
        this.operationString = operationString;
    }

    public String toString() {
        return this.operationString;
    }
}