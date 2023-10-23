import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static int[] productExceptSelf(int[] nums) {
        //1. create totalProduct = 1, totalProductExclude = 1, index = -1
        int totalProduct = 1;
        int totalProductExclude = 1;
        int index = -1;
        //2. Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // currElement
            int currElement = nums[i];
            // if (currElement != 0)
            if (currElement != 0) {
                totalProduct *= currElement;
                totalProductExclude *= currElement;
            } else {
                // if (index >=0)
                if (index >= 0) {
                    return new int[nums.length];
                }
                // index = i
                index = i;
                // update totalProduct
                totalProduct *= currElement;
            }
        }
        //3. create new array - resultArr
        int[] resultArr = new int[nums.length];
        //4. Iterate through resultArr and assign values
        for (int i = 0; i < nums.length; i++) {
            int currElement = nums[i];
            if (currElement != 0) {
                resultArr[i] = totalProduct / currElement;
            } else {
                resultArr[i] = totalProductExclude;
            }
        }
        return resultArr;
    }
    public static int[] productExceptSelfWithoutDivision(int[] nums) {
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
    public static int[] productExceptSelfWithoutDivisionOptimal(int[] nums) {
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
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelfWithoutDivisionOptimal(nums)));
    }
}
