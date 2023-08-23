public class myPow {
    private static double binaryExp(double x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        // recursive case
        if (n < 0) {
            return 1.0 / binaryExp(x, -1 * n);
        }
        if (n % 2 == 0) {
            return binaryExp(x * x, n / 2);
        } else {
            return x * binaryExp(x * x, (n - 1) / 2);
        }
    }
    public static double myPow(double x, int n) {
        return binaryExp(x, (long) n);
    }
    public static double myPow2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        long exponent = Math.abs((long) n);
        double result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = result * x;
                exponent--;
            }
            x = x * x;
            exponent = exponent / 2;
        }

        return n > 0 ? result : 1 / result;
    }
    public static void main(String[] args) {
        System.out.println(myPow2(2, -2147483648));
    }
}
