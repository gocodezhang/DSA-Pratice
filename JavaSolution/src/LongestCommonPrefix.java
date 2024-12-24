public class LongestCommonPrefix {
    public String findLongestCommonPrefixHorizontalScanning(String[] strs) {
        // create LongestPossblePrefix
        String longestPossiblePrefix = strs[0];
        // create pointer
        int pointer = longestPossiblePrefix.length();

        // go through the input array
        for (int i = 1; i < strs.length; i++) {
            // currString
            String currString = strs[i];
            // currPointer
            int currPointer = 0;
            // go through each letter in currString
            while ((currPointer < currString.length() && currPointer < longestPossiblePrefix.length()) && (currString.charAt(currPointer) == longestPossiblePrefix.charAt(currPointer))) {
                currPointer++;
            }
            pointer = Math.min(currPointer, pointer);
        }

        // substring(0, pointer)
        return longestPossiblePrefix.substring(0, pointer);
    }
    public String findLongestCommonPrefixVerticalScanning(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String firstStr = strs[0];
        for (int i = 0; i < firstStr.length(); i++) {
            char currChar = firstStr.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || currChar != strs[j].charAt(i)) {
                    return firstStr.substring(0, i);
                }
            }
        }
        return firstStr;
    }
    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.findLongestCommonPrefixHorizontalScanning(strs));
    }

}
