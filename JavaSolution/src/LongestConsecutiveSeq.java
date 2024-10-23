import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSeq {
    public int longestConsecutive(int[] nums) {
        // build a hashmap by iterating the array
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, 1);
        }
        // largestSeq = 0;
        int largestSeq = 0;
        // iterate throught the array
        for (int num: nums) {
            // if currNum not exist in array
            if (!hashMap.containsKey(num)) {
                continue;
            }
            int currSeq = 1;
            // remove currNum in hashmap
            hashMap.remove(num);
            // while (currNum + 1 exist in hashmap)
            int increaseNum = num;
            while (hashMap.containsKey(increaseNum + 1)) {
                // remove currNum + 1
                hashMap.remove(increaseNum + 1);
                increaseNum++;
                // currSeq++
                currSeq++;
            }
            // while (currNum - 1 exist in hashmap)
            int decreaseNum = num;
            while (hashMap.containsKey(decreaseNum - 1)) {
                // remove currNum - 1
                hashMap.remove(decreaseNum - 1);
                decreaseNum--;
                // currSeq++
                currSeq++;
            }
            // if currSeq > largestSeq
            if (currSeq > largestSeq) {
                largestSeq = currSeq;
            }
        }
        // return largestSeq
        return largestSeq;

    }
    public int longConsecutiveWithStartDetection(int[] nums) {
        HashSet<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            if (!numSet.contains(num)) {
                numSet.add(num);
            }
        }

        int longestSeq = 0;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                int currSeq = 1;

                while (numSet.contains(num + 1)) {
                    currSeq++;
                    num++;
                }

                longestSeq = Math.max(longestSeq, currSeq);
            }
        }

        return longestSeq;
    }
    public static void main(String[] args) {
        int[] nums = {0,3,7,2,5,8,4,6,0,1};
        LongestConsecutiveSeq longestConsecutiveSeq = new LongestConsecutiveSeq();
        System.out.println(longestConsecutiveSeq.longestConsecutive(nums));
    }
}
