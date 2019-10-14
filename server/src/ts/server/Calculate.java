package ts.server;

import ts.server.data.Operation;

public class Calculate {
    public static float calculate(Operation operation,float[] numbers) {
        switch (operation) {
            case ADD:
                return numbers[0]+numbers[1]+numbers[2];
            case DIV:
                if(numbers[0] == 0 || numbers[1] == 0 || numbers [2] == 0) {
                    return 0;
                } else {
                    return numbers[0]/numbers[1]/numbers[2];
                }
            case MUL:
                return numbers[0]*numbers[1]*numbers[2];
            case SUB:
                return numbers[0]-numbers[1]-numbers[2];
            default:
                return Float.NEGATIVE_INFINITY;
        }
    }
}
