package data;

public class Package {
    public static byte[] pack(Data data) {
        byte[] tab = new byte[14];

        float[] n = data.getNumbers();
        int [] numbers = new int[3];
        for(int i =0;i<3;i++) {
            numbers[i] = Float.floatToIntBits(n[i]);
        }

        tab[0] = (byte)((data.getOperation().getByte()) << 6);
        tab[0] = (byte)(tab[0]|(numbers[0] >>> 26 ));
        tab[1] = (byte)(numbers[0] >>> 18);
        tab[2] = (byte)(numbers[0] >>> 10);
        tab[3] = (byte)(numbers[0] >>> 2 );
        tab[4] = (byte)(numbers[0] << 6);
        tab[4] = (byte)(tab[4]|(numbers[1] >>> 26 ));
        tab[5] = (byte)(numbers[1] >>> 18);
        tab[6] = (byte)(numbers[1] >>> 10);
        tab[7] = (byte)(numbers[1] >>> 2 );
        tab[8] = (byte)(numbers[1] << 6);
        tab[8] = (byte)(tab[8]|(numbers[2] >>> 26 ));
        tab[9] = (byte)(numbers[2] >>> 18);
        tab[10] = (byte)(numbers[2] >>> 10);
        tab[11] = (byte)(numbers[2] >>> 2 );
        tab[12] = (byte)(numbers[2] << 6 );
        tab[12] = (byte)(tab[12]|(data.getStatus().getByte() << 2)|data.getSession() >>> 2);
        tab[13] = (byte)(data.getSession() << 4);

        return tab;
    }

    public static Data unpack(byte[] data) {
        Data tmp = new Data();
        int[] numbers = new int[3];

        tmp.setOperation(Operation.getOperation((byte)((data[0] >>> 6) & 0x3)));
        numbers[0] = (data[0] << 26) | (data[1] << 18) | (data[2] << 10) | (data[3] << 2) | ((data[4] >>> 6) & 0x3);
        numbers[1] = (data[4] << 26) | (data[5] << 18) | (data[6] << 10) | (data[7] << 2) | ((data[8] >>> 6) & 0x3);
        numbers[2] = (data[8] << 26) | (data[9] << 18) | (data[10] << 10) | (data[11] << 2) | ((data[12] >>> 6) & 0x3);

        float[] n = new float[3];
        for(int i =0;i<3;i++) {
            n[i] = Float.intBitsToFloat(numbers[i]);
        }
        tmp.setNumbers(n);

        tmp.setStatus(Status.getStatus ((byte)((data[12] >>> 2) & 0xf)));
        tmp.setSession((byte)(((data[12] << 4) & 0x30 ) | (data[13] >>> 4)));
        return tmp;
    }

}