import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();
        // base case
        if (expression.length() == 0) {
            return result;
        }

        boolean onlyNumber = true;

        for (int i = 0; i < expression.length(); i++) {
            char currChar = expression.charAt(i);
            if (Character.isDigit(currChar)) {
                continue;
            }
            onlyNumber = false;
            List<Integer> leftResults = diffWaysToCompute(expression.substring(0, i));
            List<Integer> rightResults = diffWaysToCompute(expression.substring(i + 1));

            for (int left : leftResults) {
                for (int right : rightResults) {
                    if (currChar == '+') {
                        result.add(left + right);
                    } else if (currChar == '*') {
                        result.add(left * right);
                    } else {
                        result.add(left - right);
                    }
                }
            }
        }

        if (onlyNumber) {
            result.add(Integer.parseInt(expression));
        }

        return result;

    }
    public List<Integer> diffWaysToComputeWithMemo(String expression) {
        int n = expression.length();
        List<Integer>[][] memo = new List[n][n];

        return diffWaysToComputeWithMemoHelper(0, n - 1, expression, memo);
    }
    private List<Integer> diffWaysToComputeWithMemoHelper(int left, int right, String expression, List<Integer>[][] memo) {
        List<Integer> result = new ArrayList<>();
        // base case
        if (left < 0 || right >= expression.length() || left > right) {
            return result;
        }

        if (memo[left][right] != null) {
            return memo[left][right];
        }

        boolean onlyDigit = true;

        // recursive case
        for (int i = left; i <= right; i++) {
            char currChar = expression.charAt(i);
            if (Character.isDigit(currChar)) {
                continue;
            }
            onlyDigit = false;
            List<Integer> leftResults = diffWaysToComputeWithMemoHelper(left, i - 1, expression, memo);
            List<Integer> rightResults = diffWaysToComputeWithMemoHelper(i + 1, right, expression, memo);

            for (int l : leftResults) {
                for (int r : rightResults) {
                    if (currChar == '+') {
                        result.add(l + r);
                    } else if (currChar == '*') {
                        result.add(l * r);
                    } else {
                        result.add(l - r);
                    }
                }
            }
        }

        if (onlyDigit) {
            result.add(Integer.parseInt(expression.substring(left, right + 1)));
        }


        memo[left][right] = result;

        return result;
    }
    public List<Integer> diffWaysToComputeDp(String expression) {
        int n = expression.length();
        List<Integer>[][] dp = new ArrayList[n][n];

        int currNumberIndex = findNumber(expression, 0);
        List<Integer> first = new ArrayList<>();

        first.add(Integer.parseInt(expression.substring(0, currNumberIndex + 1)));
        dp[0][currNumberIndex] = first;

        int nextNumberIndex = findNumber(expression, currNumberIndex + 2);
        while (nextNumberIndex != -1) {
            char currOperator = expression.charAt(currNumberIndex + 1);
            int right = Integer.parseInt(expression.substring(currNumberIndex + 2, nextNumberIndex + 1));
            List<Integer> result = new ArrayList<>();
            for (int left : dp[0][currNumberIndex]) {
                if (currOperator == '+') {
                    result.add(left + right);
                } else if (currOperator == '*') {
                    result.add(left * right);
                } else {
                    result.add(left - right);
                }
            }
            dp[0][nextNumberIndex] = result;
            currNumberIndex = nextNumberIndex;
            nextNumberIndex = findNumber(expression, currNumberIndex + 2);
        }

        return dp[0][n - 1];
    }

    private int findNumber(String s, int startIndex) {
        for (int i = startIndex; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == '+' || currChar == '-' || currChar == '*') {
                return i - 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        String expression = "2*3-4*5";
        DifferentWaysToAddParentheses differentWaysToAddParentheses = new DifferentWaysToAddParentheses();
        System.out.println(differentWaysToAddParentheses.diffWaysToComputeDp(expression));
    }
}
