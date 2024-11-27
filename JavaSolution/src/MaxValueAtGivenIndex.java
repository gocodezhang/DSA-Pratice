public class MaxValueAtGivenIndex {
    public int maxValue(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum - n + 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (check(n, index, mid, maxSum - n)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }
    private boolean check(int n, int index, int indexValue, int maxValue) {
        int leftNum = Math.min(index, indexValue - 1);
        long leftSum = (long) (indexValue - 1) * leftNum - leftNum * (leftNum - 1) / 2;

        int numberOnRight = Math.min(n - index, indexValue);
        long rightSum = (long) (indexValue) * numberOnRight - numberOnRight * (numberOnRight - 1) / 2;

        return leftSum + rightSum <= maxValue;
    }
    public int maxValueAltBinarySearch(int n, int index, int maxSum) {
        int left = 0;
        int right = maxSum - n;

        while (left < right) {
            int mid = (left + right + 1) / 2;
            if (check(n, index, mid, maxSum - n)) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }

        return left + 1;
    }
    private boolean checkAltBinarySearch(int n, int index, int indexValue, int maxValue) {
        int leftNum = Math.min(index, indexValue - 1);
        long leftSum = (long) (indexValue - 1) * leftNum - leftNum * (leftNum - 1) / 2;

        int numberOnRight = Math.min(n - index, indexValue);
        long rightSum = (long) (indexValue) * numberOnRight - numberOnRight * (numberOnRight - 1) / 2;

        return leftSum + rightSum <= maxValue;
    }
    public static void main(String[] args) {
        MaxValueAtGivenIndex maxValueAtGivenIndex = new MaxValueAtGivenIndex();
        System.out.println(maxValueAtGivenIndex.maxValue(6, 1, 10));
    }
}
