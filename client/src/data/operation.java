package data;

public enum operation {
    ADD((byte)0),
    SUB((byte)1),
    DIV((byte)2),
    MUL((byte)3),
    ERR((byte)127);
    private byte Byte;
    operation(byte Byte) {
        this.Byte = Byte;
    }

    public byte getByte() {
        return Byte;
    }
    public void setByte(byte Byte) { this.Byte = Byte; }

    public static operation getOperation(byte Byte) {
        switch (Byte) {
            case 0:
                return operation.ADD;
            case 1:
                return operation.SUB;
            case 2:
                return operation.DIV;
            case 3:
                return operation.MUL;
            default:
                return operation.ERR;
        }
    }
}
