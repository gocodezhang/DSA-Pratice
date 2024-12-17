import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * A special string s of length n consists of characters 0-9 only.
 * Its characters can only be accessed sequentially i.e the first
 * '1' chosen is the leftmost '1' in s.
 *
 * There is an array arr of m strings, also consisting of characters 0-9.
 * Calculate the minimum number of characters needed from s to construct a permutation of each of the strings in arr.
 *
 * Return an array of integers where the ith element denotes the minimum length of a substring that contains a permutation of the ith string in arr.
 * If a string cannot be constructed, return -1 at that index.
 *
 * Example
 * Consider n = 12, s= "064819848398", m = 3, arr = ["088", "364", "07"]
 * • To construct "088", the first 7 characters ("064819848398") of the special string include '0', '8', and '8'. Since the characters can be rearranged, the results for '088', '808', and '880' are all 7.
 * • To construct "364", access the first 10 characters ("064819848398") of the special string and use only '6', '4', and '3'. Rearrange to match "364".
 * • String "07" cannot be constructed from the special string. No '7' is available.
 * The return array is [7, 10, - 1]. Note that only bolded characters are used to construct the strings.
 */
public class SequentialString {
    public int[] findMinimumSubstringIndex(String s, String[] arr) {
        // go through s and build a map (Character, List)
        HashMap<Character, List<Integer>> sMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (!sMap.containsKey(currChar)) {
                sMap.put(currChar, new ArrayList<>());
            }
            List<Integer> list = sMap.get(currChar);
            list.add(i);
        }

        int[] result = new int[arr.length];
        // go through the arr
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            HashMap<Character, Integer> strMap = new HashMap<>();
            // find out its letter and corresponding fre
            for (int j = 0; j < str.length(); j++) {
                char letter = str.charAt(j);
                int currFrequency = strMap.getOrDefault(letter, 0);
                strMap.put(letter, currFrequency + 1);
            }
            // get their index and add max into array

            int target = -2;
            for (char digit : strMap.keySet()) {
                int frequency = strMap.get(digit);
                if (sMap.containsKey(digit) && sMap.get(digit).size() >= frequency) {
                    target = Math.max(target, sMap.get(digit).get(frequency - 1));
                } else {
                    target = -2;
                }
            }
            result[i] = target + 1;

        }

        // return resultt
        return result;
    }
    public static void main(String[] args) {
        String s = "064819848398";
        String[] arr = {"088", "364", "07"};
        SequentialString sequentialString = new SequentialString();
        System.out.println(Arrays.toString(sequentialString.findMinimumSubstringIndex(s, arr)));
    }
}
