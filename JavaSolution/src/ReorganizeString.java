import java.lang.management.ManagementPermission;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static String reorganize(String s) {
        // account for the only letter case
        if (s.length() == 1) {
            return s;
        }
        // create builder
        StringBuilder builder = new StringBuilder(s.length());
        // create Heap
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int key = s.charAt(i) - 'a';
            int currFrequency = frequencyMap.getOrDefault(key, 0);
            frequencyMap.put(key, currFrequency + 1);
        }
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> (b[1] - a[1]));
        frequencyMap.forEach((k, v) -> maxPQ.add(new int[]{k, v}));

        // while the heap is not empty
        while (maxPQ.size() > 0) {
            // currLetter and currFrequey
            int[] curr = maxPQ.poll();
            char currLetter = (char) (curr[0] + 'a');
            int currFrequency = curr[1];
            // if currLetter != lastLetter || empty builder
            if (builder.length() == 0 || currLetter != builder.charAt(builder.length() - 1)) {
                // add currLetter
                builder.append(currLetter);
                // update the tuple
                currFrequency--;
                if (currFrequency > 0) {
                    maxPQ.add(new int[]{curr[0], currFrequency});
                }
            } else {
                if (maxPQ.size() == 0) {
                    return "";
                }
                int[] next = maxPQ.poll();
                char nextLetter = (char) (next[0] + 'a');
                int nextFrequency = next[1];
                builder.append(nextLetter);
                maxPQ.add(curr);
                nextFrequency--;
                if (nextFrequency > 0) {
                    maxPQ.add(new int[]{next[0], nextFrequency});
                }
            }
        }

        // return string
        return builder.toString();
    }
    public static String reorganizeAlt(String s) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        char maxLetter = s.charAt(0);
        int maxFrequency = 0;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            int currFrequency = frequencyMap.getOrDefault(currChar, 0);
            currFrequency++;
            frequencyMap.put(currChar, currFrequency);
            if (currFrequency > maxFrequency) {
                maxFrequency = currFrequency;
                maxLetter = currChar;
            }
        }
        if ((s.length() + 1) / 2 < maxFrequency) {
            return "";
        }
        char[] charArr = new char[s.length()];
        int index = 0;
        while (frequencyMap.get(maxLetter) > 0) {
            charArr[index] = maxLetter;
            index += 2;
            frequencyMap.put(maxLetter, frequencyMap.get(maxLetter) - 1);
        }

        for (char currChar : frequencyMap.keySet()) {
            while (frequencyMap.get(currChar) > 0) {
                if (index > s.length() - 1) {
                    index = 1;
                }
                charArr[index] = currChar;
                index += 2;
                frequencyMap.put(currChar, frequencyMap.get(currChar) - 1);
            }
        }

        return String.valueOf(charArr);

    }
    public static void main(String[] args) {
        String s = "aaab";
        System.out.println(reorganizeAlt(s));
    }

}
