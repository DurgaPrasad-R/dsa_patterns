class Solution {
    public static boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> operands = new Stack<>();
        
        for (String str : tokens) {
            if (isOperator(str)) {
                int op2 = operands.pop();
                int op1 = operands.pop();

                if (str.equals("+")) {
                    operands.push(op1 + op2);
                } else if (str.equals("-")) {
                    operands.push(op1 - op2);
                } else if (str.equals("*")) {
                    operands.push(op1 * op2);
                } else {
                    operands.push(op1 / op2);
                }
            } else {
                operands.push(Integer.valueOf(str));
            }
        }
        int result = operands.pop();

        if (operands.size() == 0) {
            return result;
        }
        return -1;
    }
}