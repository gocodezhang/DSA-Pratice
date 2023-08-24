import java.util.*;

public class DetectSquares {
    private Map<String, Integer> frequencyMap;
    private List<int[]> storage;
    public DetectSquares() {
        this.frequencyMap = new HashMap<String, Integer>();
        this.storage = new ArrayList<>();
    }
    public void add(int[] point) {
        storage.add(point);
        String key = point[0] + "-" + point[1];
        if (frequencyMap.containsKey(key)) {
            frequencyMap.put(key, frequencyMap.get(key) + 1);
        } else {
            frequencyMap.put(key, 1);
        }
    }
    public int count(int[] point) {
        int ways = 0;
        int px = point[0], py = point[1];
        for (int i = 0; i < storage.size(); i++) {
            int[] currPoint = storage.get(i);
            if (currPoint[0] != px && currPoint[1] != py && Math.abs(px - currPoint[0]) == Math.abs( py - currPoint[1])) {
                int numberOfpoint1 = frequencyMap.getOrDefault(currPoint[0] + "-" + py, 0);
                int numberOfpoint2 = frequencyMap.getOrDefault(px + "-" + currPoint[1], 0);
                ways = ways + numberOfpoint1 * numberOfpoint2;
            }
        }
        return ways;
    }

    public static void main(String[] args) {
        DetectSquares test = new DetectSquares();
        test.add(new int[]{3, 10});
        test.add(new int[]{11, 2});
        test.add(new int[]{3, 2});
        System.out.println(test.count(new int[]{11, 10}));
    }
}
