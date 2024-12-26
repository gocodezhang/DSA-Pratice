import java.util.Arrays;
import java.util.PriorityQueue;

public class LongestHappyString {
    public String longDiverseString(int a, int b, int c) {
        char[] map = new char[]{'a', 'b', 'c'};
        // maintain a heap
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (y[1] - x[1]));
        if (a > 0) {
            pq.add(new int[]{0, a});
        }
        if (b > 0) {
            pq.add(new int[]{1, b});
        }
        if (c > 0) {
            pq.add(new int[]{2, c});
        }
        // build string
        StringBuilder builder = new StringBuilder();
        int prev = -1;
        int charCount = 0;
        while (!pq.isEmpty() && (prev != pq.peek()[0] || charCount <= 1 || pq.size() > 1)) {
            if (prev != pq.peek()[0] || charCount <= 1) {
                int[] pair = pq.poll();
                builder.append(map[pair[0]]);

                charCount = prev == pair[0] ? charCount + 1 : 1;
                prev = pair[0];
                pair[1] = pair[1] - 1;
                if (pair[1] > 0) {
                    pq.add(pair);
                }
            } else {
                // check if count == 2 && char is same
                // pop second one
                int[] first = pq.poll();
                int[] second = pq.poll();
                // add it
                builder.append(map[second[0]]);

                prev = second[0];
                charCount = 1;
                second[1] = second[1] - 1;
                if (second[1] > 0) {
                    pq.add(second);
                }
                pq.add(first);
                // add the top of heap
            }
        }
        // return string
        return builder.toString();
    }
    public static void main(String[] args) {
        LongestHappyString longestHappyString = new LongestHappyString();
        System.out.println(longestHappyString.longDiverseString(3,0,0));
    }
}
