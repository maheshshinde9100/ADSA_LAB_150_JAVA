package DivideAndConquer;

public class PowerFunction_13 {
    public static double myPow(double x, int n) {
        if (n == 0) return 1;

        long N = n; // Use long to avoid overflow when negating Integer.MIN_VALUE
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }

        return fastPow(x, N);
    }

    private static double fastPow(double x, long n) {
        if (n == 0) return 1;

        double half = fastPow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }
    }

    public static void main(String[] args) {
        double base = 19.3;
        int exponent = 3;
        System.out.println("Result: " + myPow(base, exponent));  // Output: 19.3^3 = 7191.857
    }
}
