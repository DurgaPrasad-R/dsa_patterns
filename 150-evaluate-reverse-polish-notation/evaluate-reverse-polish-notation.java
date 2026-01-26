/**
 * This solution evaluates an arithmetic expression written
 * in Reverse Polish Notation (Postfix notation).
 *
 * The algorithm uses a stack to store operands.
 *
 * Each token from the input array is processed sequentially:
 * - If the token is an operand, it is pushed onto the stack.
 * - If the token is an operator, the top two operands are popped
 *   from the stack and the operation is applied.
 *
 * The first popped value represents the second operand,
 * and the second popped value represents the first operand.
 * This order is critical for non-commutative operations
 * like subtraction and division.
 *
 * The result of the operation is pushed back onto the stack.
 *
 * After processing all tokens, the stack should contain
 * exactly one value, which represents the final result.
 *
 * Time Complexity:
 * - O(n), where n is the number of tokens.
 *
 * Space Complexity:
 * - O(n), due to the stack storing operands.
 */

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