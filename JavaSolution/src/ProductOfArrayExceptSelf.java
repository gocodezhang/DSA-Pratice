import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelfWithoutDivision(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1;
        right[nums.length - 1] = 1;
        // build the left array (products of all element to the left of index i)
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        for (int i = nums.length - 2; i >=0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        int[] answer = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            answer[i] = left[i] * right[i];
        }
        return answer;
    }
    public int[] productExceptSelfWithoutDivisionOptimal(int[] nums) {
        int[] left = new int[nums.length];
        int[] answer = new int[nums.length];
        left[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            answer[i] = left[i] * right;
            right = right * nums[i];
        }
        return answer;
    }
    public int[] productExceptSelfWithVar(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            left[i] = product;
            product = product * nums[i];
        }
        int[] right = new int[n];
        product = 1;
        for (int i = n - 1; i >=0; i--) {
            right[i] = product;
            product = product * nums[i];
        }
        int[] answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = left[i] * right[i];
        }

        return answer;
    }
    public int[] produceExceptSelfConstantSpace(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int product = 1;
        for (int i = 0; i < n; i++) {
            answer[i] = product;
            product = product * nums[i];
        }
        product = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * product;
            product = product * nums[i];
        }
        return answer;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
        System.out.println(Arrays.toString(productOfArrayExceptSelf.produceExceptSelfConstantSpace(nums)));
    }
}
