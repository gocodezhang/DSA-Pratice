import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    private PriorityQueue<Integer> storage;
    private Integer k;
    public KthLargest(int k, int[] nums) {
        storage = new PriorityQueue<>();
        this.k = k;
        for (int num : nums) {
            this.storage.add(num);
            if (this.storage.size() > this.k) {
                this.storage.poll();
            }
        }
    }
    public int add(int val) {
        storage.add(val);
        if (this.storage.size() > k) {
            this.storage.poll();
        }
        return this.storage.peek();
    }
    public static void main(String[] args) {
        KthLargest Kl = new KthLargest(3, new int[]{4,5,8,2});
        System.out.println(Kl.add(3));
        System.out.println(Kl.add(5));
        System.out.println(Kl.add(10));
    }
}
