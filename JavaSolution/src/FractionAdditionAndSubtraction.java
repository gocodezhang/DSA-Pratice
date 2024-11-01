import java.util.ArrayList;
import java.util.List;

public class FractionAdditionAndSubtraction {
    public String fractionAddition(String expression) {
        // parse string
        // find all operator
        if (expression.charAt(0) != '-') {
            expression = '+' + expression;
        }
        List<Integer> operatorIndices = new ArrayList<>();
        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (currChar == '-' || currChar == '+') {
                operatorIndices.add(i);
            }
        }

        // process one operator at a time
        String leftOperand = "0/1";
        for (int i = 0; i < operatorIndices.size(); i++) {
            int operandIndex = operatorIndices.get(i);

            String rightOperand = i + 1 < operatorIndices.size() ? expression.substring(operandIndex + 1, operatorIndices.get(i + 1)) : expression.substring(operandIndex + 1);
            leftOperand = compute(leftOperand, rightOperand, expression.charAt(operandIndex));
        }

        String[] pair = leftOperand.split("/");
        int num = Integer.parseInt(pair[0]);
        int dem = Integer.parseInt(pair[1]);
        int gcd = Math.abs(gcd(num, dem));
        int finalNum = num / gcd;
        int finalDem = dem / gcd;

        return finalNum + "/" + finalDem;
    }
    public String fractionAdditionConstantMem(String expression) {
        // set up initial num and denom
        int num = 0;
        int denom = 1;
        // go through expression
        int index = 0;
        while (index < expression.length()) {
            // find sign
            boolean positive = true;
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                if (expression.charAt(index) == '-') {
                    positive = false;
                }
                index++;
            }
            // find num
            int currNum = 0;
            while (Character.isDigit(expression.charAt(index))) {
                int digit = expression.charAt(index) - '0';
                currNum = currNum * 10 + digit;
                index++;
            }

            if (!positive) {
                currNum = - currNum;
            }

            index++;
            // find denom
            int currDenom = 0;
            while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                int digit = expression.charAt(index) - '0';
                currDenom = currDenom * 10 + digit;
                index++;
            }

            num = num * currDenom + currNum * denom;
            denom = currDenom * denom;
        }

        int gcd = Math.abs(gcd(num, denom));
        int finalNum = num / gcd;
        int finalDenom = denom / gcd;

        return finalNum + "/" + finalDenom;
    }

    private String compute(String leftOperand, String rightOperand, char operator) {
        if (operator == '-') {
            rightOperand = '-' + rightOperand;
        }
        String[] leftPair = leftOperand.split("/");
        String[] rightPair = rightOperand.split("/");

        int leftNum = Integer.parseInt(leftPair[0]);
        int rightNum = Integer.parseInt(rightPair[0]);
        int leftDem = Integer.parseInt(leftPair[1]);
        int rightDem = Integer.parseInt(rightPair[1]);

        int num = leftNum * rightDem + rightNum * leftDem;

        return num + "/" + (leftDem * rightDem);
    }
    private int gcd(int a, int b) {
        if (b==0) return a;
        return gcd(b,a%b);
    }

    public static void main(String[] args) {
        String expression = "1/3-1/2";
        FractionAdditionAndSubtraction fractionAdditionAndSubtraction = new FractionAdditionAndSubtraction();
        System.out.println(fractionAdditionAndSubtraction.fractionAdditionConstantMem(expression));
    }
}
