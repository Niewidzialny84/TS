package ts.server.data;

public enum Status {
    CORRECT((byte) 0),
    ERROR((byte)1),
    INVALID_SESSION((byte)2),
    SESSION_KEY((byte)3),
    RESPONSE((byte)4);

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
            case 1:
            default:
                return Status.ERROR;
        }
    }
}
