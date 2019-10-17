package ts.server;

import ts.server.data.Operation;

public class Calculate {
    public static int calculate(Operation operation,int[] numbers) throws ArithmeticException {
        int ret = 0;
        try {
            switch (operation) {
                case ADD:
                    //ret = numbers[0]+numbers[1]+numbers[2];
                    ret = Math.addExact(numbers[0], numbers[1]);
                    ret = Math.addExact(ret, numbers[2]);
                    break;
                case DIV:
                    if (numbers[0] == 0 || numbers[1] == 0 || numbers[2] == 0) {
                        throw new ArithmeticException("DIV");
                    } else {
                        //ret = numbers[0]/numbers[1]/numbers[2];
                        ret = Math.floorDiv(numbers[0], numbers[1]);
                        ret = Math.floorDiv(ret, numbers[2]);
                    }
                    break;
                case MUL:
                    //ret = numbers[0]*numbers[1]*numbers[2];
                    ret = Math.multiplyExact(numbers[0], numbers[1]);
                    ret = Math.multiplyExact(ret, numbers[2]);
                    break;
                case SUB:
                    //  ret = numbers[0]-numbers[1]-numbers[2];
                    ret = Math.subtractExact(numbers[0], numbers[1]);
                    ret = Math.subtractExact(ret, numbers[2]);
                    break;
            }
            return ret;
        } catch (ArithmeticException ex) {
            if(ex.getMessage().equalsIgnoreCase("DIV")) {
                throw ex;
            } else {
                throw new ArithmeticException("INF");
            }
        }
      /*  if(Float.isInfinite(ret)) {
            throw new ArithmeticException("INF");
        } else if(Float.isNaN(ret)) {
            throw new ArithmeticException("NAN");
        } else {
            return ret;
        }

       */
    }
}
