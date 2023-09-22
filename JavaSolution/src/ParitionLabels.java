import java.util.ArrayList;
import java.util.List;

public class ParitionLabels {
    public static List<Integer> partitionLabels(String s) {
        // create result (list of integer)
        List<Integer> result = new ArrayList<>();
        // create startIndex, endIndex
        int startIndex = 0, endIndex = -1;
        // Iterate through string
        for (int i = 0; i < s.length(); i++) {
            // currLetter
            char currLetter = s.charAt(i);
            // endIndex = Math.max(endIndex, string.lastIndexof(currLetter))
            endIndex = Math.max(endIndex, s.lastIndexOf(currLetter));
            // if i == endIndex
            if (i == endIndex) {
                result.add(endIndex - startIndex + 1);
                startIndex = i + 1;
            }
        }
        // if (startIndex > endIndex)
        if (startIndex < endIndex) {
            // result.add(length - startIndex)
            result.add(s.length() - startIndex);
        }
        // return result
        return result;
    }
    public static List<Integer> partitionLabelsOptimal(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int startIndex = 0;
        int endIndex = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            endIndex = Math.max(endIndex, last[s.charAt(i) - 'a']);
            if (i == endIndex) {
                result.add(endIndex - startIndex + 1);
                startIndex = i + 1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
