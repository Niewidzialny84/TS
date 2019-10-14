package ts.server.data;

public class Data {
    private Operation operation;
    private float[] numbers;
    private Status status;
    private byte session;

    public Data(Operation operation, float[] numbers, Status status, byte session) {
        this.operation = operation;
        this.numbers = numbers;
        this.status = status;
        this.session = session;
    }

    public Data() {
        this.numbers = new float[3];
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public float[] getNumbers() {
        return numbers;
    }

    public void setNumbers(float[] numbers) {
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
