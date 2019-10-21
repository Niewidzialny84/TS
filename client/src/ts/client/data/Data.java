package ts.client.data;

//Data class for storage all of message data
public class Data {
    private Operation operation;
    private int[] numbers;
    private Status status;
    private byte session;

    public Data(Operation operation, int[] numbers, Status status, byte session) {
        this.operation = operation;
        this.numbers = numbers;
        this.status = status;
        this.session = session;
    }

    public Data() {
        this.numbers = new int[3];
    }

    //Getters and Setters
    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int[] getNumbers() {
        return numbers;
    }

    public void setNumbers(int[] numbers) {
        this.numbers = numbers;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public byte getSession() {
        return session;
    }

    public void setSession(byte session) {
        this.session = session;
    }
}
