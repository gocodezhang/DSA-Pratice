import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class FindkPairsWithSmallestSums {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> a.get(0) + a.get(1) - b.get(0) - b.get(1));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(List.of(nums1[i], nums2[j]));
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while (k > 0) {
            List<Integer> pair = pq.poll();
            result.add(pair);
            k--;
        }
        return result;
    }
    public List<List<Integer>> kSmallestPairsOptimal(int[] nums1, int[] nums2, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        HashSet<String> visited = new HashSet<>();

        pq.add(new int[]{nums1[0] + nums2[0], 0,0});
        visited.add(0 + "-" + 0);

        List<List<Integer>> result = new ArrayList<>();

        while (k > 0 && !pq.isEmpty()) {
            int[] currPair = pq.poll();
            int i = currPair[1];
            int j = currPair[2];
            result.add(List.of(nums1[i], nums2[j]));
            k--;

            if (i + 1 < nums1.length && !visited.contains((i + 1) + "-" + j)) {
                pq.add(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
                visited.add((i + 1) + "-" + j);
            }
            if (j + 1 < nums2.length && !visited.contains(i + "-" + (j + 1))) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
                visited.add(i + "-" + (j + 1));
            }
        }

        return result;

    }
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,5,7,9};
        FindkPairsWithSmallestSums findkPairsWithSmallestSums = new FindkPairsWithSmallestSums();
        System.out.println(findkPairsWithSmallestSums.kSmallestPairsOptimal(nums1, nums2, 20));
    }
}
