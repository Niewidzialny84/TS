package ts.server.data;

//Enum for the first to bits as operation
public enum Operation {
    ADD((byte)2), // 10
    SUB((byte)0), // 00
    DIV((byte)1), // 01
    MUL((byte)3), // 11
    ERR((byte)127); //Error only for internal use and validation
    private byte Byte;
    Operation(byte Byte) {
        this.Byte = Byte;
    }

    public byte getByte() {
        return Byte;
    }
    public void setByte(byte Byte) { this.Byte = Byte; }

    //Check layer for Operation
    public static Operation getOperation(byte Byte) {
        switch (Byte) {
            case 0:
                return Operation.SUB;
            case 1:
                return Operation.DIV;
            case 2:
                return Operation.ADD;
            case 3:
                return Operation.MUL;
            default:
                return Operation.ERR;
        }
    }
}
