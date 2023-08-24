import java.util.PriorityQueue;

public class kthLargestElement {
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> storage = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            storage.add(nums[i]);
            if (storage.size() > k) {
                storage.poll();
            }
        }
        return storage.poll();
    }
    public static void main(String[] args) {
        int[] nums = {
                3,2,1,5,6,4
        };
        System.out.println(findKthLargest(nums, 2));
    }
}
