import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(a) - map.get(b)));
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        int index = 0;
        while (index < k) {
            result[index] = pq.poll();
            index++;
        }
        return result;
    }
    public int[] topKFrequentCountingSort(int[] nums, int k) {
        int maxFrequency = 0;
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int frequency = frequencyMap.getOrDefault(num, 0);
            frequencyMap.put(num, frequency + 1);
            maxFrequency = Math.max(maxFrequency, frequency + 1);
        }

        int[] result = new int[k];
        List<Integer>[] buckets = new List[maxFrequency + 1];

        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int frequency = entry.getValue();
            int num = entry.getKey();
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(num);
        }

        int count = 0;
        int index = buckets.length - 1;
        while (count < k && index >= 0) {
            List<Integer> bucket = buckets[index];
            if (bucket == null) {
                index--;
                continue;
            }
            for (int i = 0; i < bucket.size() && count < k; i++) {
                result[count] = bucket.get(i);
                count++;
            }
            index--;
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {5,3,1,1,1,3,73,1};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        System.out.println(topKFrequentElements.topKFrequentCountingSort(nums, 2));
    }
}
