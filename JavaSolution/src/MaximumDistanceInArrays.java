import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumDistanceInArrays {
    public int maxDistance(List<List<Integer>> arrays) {
        int[][] smallest = new int[arrays.size()][2];
        int[][] largest = new int[arrays.size()][2];
        // find the smallest and largest
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int size = curr.size();
            smallest[i] = new int[]{curr.get(0), i};
            largest[i] = new int[]{curr.get(size - 1), i};
         }
        // then sort them
        Arrays.sort(smallest, (a, b) -> a[0] - b[0]);
        Arrays.sort(largest, (a, b) -> b[0] - a[0]);
        // compare the first two
        int[] smallestNum = smallest[0];
        int[] largestNum = largest[0];
        int[] secSmallestNum = smallest[1];
        int[] secLargestNum = largest[1];
        if (smallestNum[1] != largestNum[1]) {
            return largestNum[0] - smallestNum[0];
        }

        return Math.max(secLargestNum[0] - smallestNum[0], largestNum[0] - secSmallestNum[0]);
    }
    public int maxDistanceHeap(List<List<Integer>> arrays) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> curr = arrays.get(i);
            int size = curr.size();
            int[] smallPair = new int[]{curr.get(0), i};
            int[] largePair = new int[]{curr.get(size - 1), i};

            maxHeap.add(smallPair);
            minHeap.add(largePair);

            while (maxHeap.size() > 2) {
                maxHeap.poll();
            }
            while (minHeap.size() > 2) {
                minHeap.poll();
            }
        }

        int[] secSmallestNum = maxHeap.poll();
        int[] smallestNum = maxHeap.poll();
        int[] secLargestNum = minHeap.poll();
        int[] largestNum = minHeap.poll();

        if (smallestNum[1] != largestNum[1]) {
            return largestNum[0] - smallestNum[0];
        }

        return Math.max(secLargestNum[0] - smallestNum[0], largestNum[0] - secSmallestNum[0]);
    }
}
