package ts.client.data;

public enum Operation {
    ADD((byte)0),
    SUB((byte)1),
    DIV((byte)2),
    MUL((byte)3),
    ERR((byte)127);
    private byte Byte;
    Operation(byte Byte) {
        this.Byte = Byte;
    }

    public byte getByte() {
        return Byte;
    }
    public void setByte(byte Byte) { this.Byte = Byte; }

    public static Operation getOperation(byte Byte) {
        switch (Byte) {
            case 0:
                return Operation.ADD;
            case 1:
                return Operation.SUB;
            case 2:
                return Operation.DIV;
            case 3:
                return Operation.MUL;
            default:
                return Operation.ERR;
        }
    }
}
