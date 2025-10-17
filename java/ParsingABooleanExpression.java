public class ParsingABooleanExpression {
    public boolean parseBoolExpr(String expression) {
        int[] idx = new int[1]; // acts as a pointer (since Java passes by value)
        return evaluate(expression, idx);
    }

    private boolean evaluate(String expr, int[] idx) {
        char ch = expr.charAt(idx[0]);

        // Base cases
        if (ch == 't') {
            idx[0]++;
            return true;
        }
        if (ch == 'f') {
            idx[0]++;
            return false;
        }

        // Operator cases: '!', '&', '|'
        if (ch == '!') {
            idx[0] += 2; // skip "!("
            boolean inner = evaluate(expr, idx);
            idx[0]++;     // skip ')'
            return !inner;
        }

        boolean isAnd = (ch == '&');
        idx[0] += 2; // skip "&(" or "|("
        boolean result = isAnd ? true : false;

        while (true) {
            boolean val = evaluate(expr, idx);

            if (isAnd)
                result &= val;
            else
                result |= val;

            if (expr.charAt(idx[0]) == ')') {
                idx[0]++; // skip ')'
                break;
            }
            idx[0]++; // skip ','
        }
        return result;
    }
}
