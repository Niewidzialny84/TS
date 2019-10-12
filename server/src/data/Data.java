package data;

public class Data {
    private operation operation;
    private float[] numbers;
    private byte status;
    private byte session;

    public Data(operation operation, float[] numbers, byte status, byte session) {
        this.operation = operation;
        this.numbers = numbers;
        this.status = status;
        this.session = session;
    }

    public Data() {
        this.numbers = new float[3];
    }

    public operation getOperation() {
        return operation;
    }

    public void setOperation(operation operation) {
        this.operation = operation;
    }

    public float[] getNumbers() {
        return numbers;
    }

    public void setNumbers(float[] numbers) {
        this.numbers = numbers;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    public byte getSession() {
        return session;
    }

    public void setSession(byte session) {
        this.session = session;
    }
}
