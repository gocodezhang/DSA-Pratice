import java.util.HashMap;

public class MinimumDeleteToBalanceStr {

    public int minimumDeletionsWindowCount(String s) {
        // build a map
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }
        // left, right
        int count = 0;
        int left = 0;
        int right = s.length() - 1;
        // while (left < right)
        while (left < right) {
            // find B for left
            while (left < s.length() && s.charAt(left) != 'b') {
                map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                left++;
            }
            // find A for right
            while (right >= 0 && s.charAt(right) != 'a') {
                map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                right--;
            }
            // decide which one to delete in given range
            if (left < right) {
                // delete ones with lower count
                if (map.get('b') >= map.get('a')) {
                    map.put(s.charAt(right), map.get(s.charAt(right)) - 1);
                    right--;
                } else {
                    map.put(s.charAt(left), map.get(s.charAt(left)) - 1);
                    left++;
                }
                count++;
            }
        }
        return count;
    }
    public int minimumDeletionsPivot(String s) {
        int n = s.length();
        int[] countA = new int[n];
        int[] countB = new int[n];

        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i + 1) == 'a') {
                countA[i] = countA[i + 1] + 1;
            } else {
                countA[i] = countA[i + 1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (s.charAt(i - 1) == 'b') {
                countB[i] = countB[i - 1] + 1;
            } else {
                countB[i] = countB[i - 1];
            }
        }

        int minDelete = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            // given index i as pivot, find out # Bs to the left of pivot + # As to the right of pivot
            minDelete = Math.min(minDelete, countA[i] + countB[i]);
        }
        return minDelete;
    }
    public int minimumDeletionsPivotConstant(String s) {
        int n = s.length();
        int countA = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA++;
            }
        }

        int minDelete = Integer.MAX_VALUE;
        int countB = 0;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                countA--;
            }
            minDelete = Math.min(minDelete, countA + countB);
            if (s.charAt(i) == 'b') {
                countB++;
            }
        }
        return minDelete;
    }

    public static void main(String[] args) {
        String s1 = "ababaaaabbbbbaaababbbbbbaaabbaababbabbbbaabbbbaabbabbabaabbbababaa";
        String s = "aabaabbab";
        MinimumDeleteToBalanceStr minimumDeleteToBalanceStr = new MinimumDeleteToBalanceStr();
        System.out.println(minimumDeleteToBalanceStr.minimumDeletionsPivot(s1));
    }
}
