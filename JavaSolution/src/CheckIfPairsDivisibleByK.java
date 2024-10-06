public class CheckIfPairsDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        int[] remainders = new int[k];
        for (int i = 0; i < arr.length; i++) {
            int remainder = (arr[i] % k + k) % k;
            remainders[remainder] = remainders[remainder] + 1;
        }

        for (int i = 0; i < remainders.length; i++) {
            int numberInBucket = remainders[i];
            if (i == 0 && numberInBucket % 2 != 0) {
                return false;
            }
            if (i != 0 && remainders[i] != remainders[k - i]) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        int[] nums = {-1,1,-2,2,-3,3,-4,4};
        CheckIfPairsDivisibleByK checkIfPairsDivisibleByK = new CheckIfPairsDivisibleByK();
        System.out.println(checkIfPairsDivisibleByK.canArrange(nums, 3));
    }
}
