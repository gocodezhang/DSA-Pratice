import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        // iterate through strings
        for (int i = 0; i < strs.length; i++) {
            // currStr
            String currStr = strs[i];
            // build key for currStr
            int[] frequency = new int[26];
            for (int j = 0; j < currStr.length(); j++) {
                char currChar = currStr.charAt(j);
                frequency[currChar - 'a'] = frequency[currChar - 'a'] + 1;
            }
            String key = "";
            for (int charIndex = 0; charIndex < frequency.length; charIndex++) {
                if (frequency[charIndex] > 0) {
                    key += charIndex + "-" + frequency[charIndex] + "#";
                }
            }
            // check if key exist
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            // if yes, add to the list
            // if no, create a empty list and add
            list.add(currStr);
            map.put(key, list);
        }
        // add all list into the resultList
        List<List<String>> resultList = new ArrayList<>();
        for (String key : map.keySet()) {
            resultList.add(map.get(key));
        }
        return resultList;
    }
    public static void main(String[] args) {
        String[] strs = new String[]{"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
}
