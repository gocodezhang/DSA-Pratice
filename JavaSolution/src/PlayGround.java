import java.util.*;

public class PlayGround {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(a) - frequencyMap.get(b));

        for (int key : frequencyMap.keySet()) {
            minHeap.add(key);

            while (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        int[] result = new int[k];
        int index = 0;

        while (!minHeap.isEmpty()) {
            result[index] = minHeap.poll();
            index++;
        }

        return result;
    }

    public static void main(String[] args) {

        String longStr = "/\\,";
        for (int i = 0; i < longStr.length(); i++) {
            System.out.println(longStr.charAt(i));
        }
        System.out.println(longStr.length());
    }
}
