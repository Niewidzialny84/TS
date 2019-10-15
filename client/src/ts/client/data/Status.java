package ts.client.data;

public enum Status {
    CORRECT((byte) 0b0000),
    SESSION_KEY((byte)0b0001),
    NUMBER_INFINITE((byte)0b0011),
    NUMBER_NAN((byte)0b0100),
    NUMBER_DIV((byte)0b0101),
    ERROR((byte)0b0110),
    CLOSING((byte)0b0111);

    private byte b;
    Status(byte b) {
        this.b = b;
    }

    public byte getByte() {
        return b;
    }
    public void setByte(byte Byte) { this.b = Byte; }

    public static Status getStatus(byte Byte) {
        switch (Byte) {
            case 0:
                return Status.CORRECT;
            case 1:
                return Status.SESSION_KEY;
            case 3:
                return Status.NUMBER_INFINITE;
            case 4:
                return Status.NUMBER_NAN;
            case 5:
                return Status.NUMBER_DIV;
            case 7:
                return Status.CLOSING;
            case 6:
            default:
                return Status.ERROR;
        }
    }
}
