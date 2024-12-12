public class SumOfSquareNums {
    public boolean judgeSquareSumTwoPointer(int c) {
        // take square root of c
        double result = Math.sqrt(c);
        int target = (int) result;
        // if not integer, return false
        if (result == target) {
            return true;
        }

        // perform binary search
        int left = 0;
        int right = target;

        while (left <= right) {
            long sum = left * left + (long) right * right;
            if (sum > c) {
                right--;
            } else if (sum < c) {
                left++;
            } else {
                return true;
            }
        }

        return false;
    }
    public boolean judgeSquareSumWithSqrt(int c) {
        for (int a = 0; a <= Math.sqrt(c); a++) {
            int b = c - a * a;
            double result = Math.sqrt(b);
            if (result == (int) result) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        SumOfSquareNums sumOfSquareNums = new SumOfSquareNums();
        System.out.println(sumOfSquareNums.judgeSquareSumWithSqrt(2147483646));
    }
}
