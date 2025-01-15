import java.util.HashMap;
import java.util.HashSet;

public class CountPairsOfSimilarStrings {
    public int similarPairs(String[] words) {
        int count = 0;
        // maintain set
        HashMap<String, Integer> map = new HashMap<>();
        // go through words
        for (int i = 0; i < words.length; i++) {
            // find out distinct character in curr word
            String word = words[i];
            boolean[] check = new boolean[26];
            for (int j = 0; j < word.length(); j++) {
                char curr = word.charAt(j);
                check[curr - 'a'] = true;
            }

            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < check.length; j++) {
                if (check[j]) {
                    builder.append(j);
                }
            }
            String code = builder.toString();
            // check if these characters exist in any previous words (using set)
            int prevCount = map.getOrDefault(code, 0);
            count += prevCount;
            map.put(code, prevCount + 1);
            // add curr distinct characters in set
        }

        // return count
        return count;
    }
    public static void main(String[] args) {
        String[] words = {"aabb","ab","ba"};
        CountPairsOfSimilarStrings cs = new CountPairsOfSimilarStrings();
        System.out.println(cs.similarPairs(words));
    }

}
