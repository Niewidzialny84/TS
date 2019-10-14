package ts.server.data;

public enum Status {
    CORRECT((byte) 0b0000),
    ERROR((byte)0b0001),
    INVALID_SESSION((byte)0b0010),
    SESSION_KEY((byte)0b0011),
    RESPONSE((byte)0b0100),
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
            case 2:
                return Status.INVALID_SESSION;
            case 3:
                return Status.SESSION_KEY;
            case 4:
                return Status.RESPONSE;
            case 7:
                return Status.CLOSING;
            case 1:
            default:
                return Status.ERROR;
        }
    }
}
