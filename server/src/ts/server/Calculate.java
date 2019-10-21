package ts.server;

import ts.server.data.Operation;

//Class for operations and handling error when calculating the answer
//Using Math class because it handles overflow
public class Calculate {
    public static int calculate(Operation operation,int[] numbers) throws ArithmeticException {
        int ret = 0;
        try {
            switch (operation) {
                case ADD: //Adding
                    ret = Math.addExact(numbers[0], numbers[1]);
                    ret = Math.addExact(ret, numbers[2]);
                    break;
                case DIV: //Dividing - wrong if there should be no number[0] - 0 can be divided
                    if (numbers[0] == 0 || numbers[1] == 0 || numbers[2] == 0) {
                        throw new ArithmeticException("DIV");
                    } else {
                        ret = Math.floorDiv(numbers[0], numbers[1]);
                        ret = Math.floorDiv(ret, numbers[2]);
                    }
                    break;
                case MUL: //Multiply
                    ret = Math.multiplyExact(numbers[0], numbers[1]);
                    ret = Math.multiplyExact(ret, numbers[2]);
                    break;
                case SUB: //Subtract
                    ret = Math.subtractExact(numbers[0], numbers[1]);
                    ret = Math.subtractExact(ret, numbers[2]);
                    break;
            }
            return ret;
        } catch (ArithmeticException ex) {
            if(ex.getMessage().equalsIgnoreCase("DIV")) { //throwing division by 0
                throw ex;
            } else {
                throw new ArithmeticException("INF"); //throwing overflow
            }
        }
    }
}
