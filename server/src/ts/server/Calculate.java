package ts.server;

import ts.server.data.Operation;

public class Calculate {
    public static float calculate(Operation operation,float[] numbers) throws ArithmeticException {
        float ret = Float.NEGATIVE_INFINITY;
        switch (operation) {
            case ADD:
                ret = numbers[0]+numbers[1]+numbers[2];
                break;
            case DIV:
                if(numbers[0] == 0 || numbers[1] == 0 || numbers [2] == 0) {
                    throw new ArithmeticException("DIV");
                } else {
                    ret = numbers[0]/numbers[1]/numbers[2];
                }
                break;
            case MUL:
                ret = numbers[0]*numbers[1]*numbers[2];
                break;
            case SUB:
                ret = numbers[0]-numbers[1]-numbers[2];
                break;
        }

        if(Float.isInfinite(ret)) {
            throw new ArithmeticException("INF");
        } else if(Float.isNaN(ret)) {
            throw new ArithmeticException("NAN");
        } else {
            return ret;
        }
    }
}
