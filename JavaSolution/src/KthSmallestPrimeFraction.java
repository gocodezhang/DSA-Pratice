public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        double left = 0;
        double right = 1;
        int n = arr.length;

        while (left < right) {
            double mid = (left + right) / 2;
            int smallerFractionCount = 0;
            double maxFraction = 0;
            int firstIndex = 0;
            int secondIndex = 0;
            int j = 1;

            for (int i = 0; i < n - 1; i++) {
                while (j < n && ((double) arr[i] / arr[j]) >= mid) {
                    j++;
                }
                smallerFractionCount += n - j;

                if (j == n) {
                    break;
                }

                double currFraction = (double) arr[i] / arr[j];
                if (currFraction > maxFraction) {
                    firstIndex = i;
                    secondIndex = j;
                    maxFraction = currFraction;
                }
            }

            if (smallerFractionCount == k) {
                return new int[]{arr[firstIndex], arr[secondIndex]};
            } else if (smallerFractionCount > k) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return new int[2];
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,5,7};
        KthSmallestPrimeFraction kthSmallestPrimeFraction = new KthSmallestPrimeFraction();
        System.out.println(kthSmallestPrimeFraction.kthSmallestPrimeFraction(arr, 3));
    }
}
