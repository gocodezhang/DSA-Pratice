import java.util.HashSet;

public class FindLengthOfLongestCPF {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        int longest = 0;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                longest = Math.max(longest, findPrefixLength(arr1[i], arr2[j]));
            }
        }
        return longest;
    }
    public int findPrefixLength(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);

        int index = 0;
        while (index < strA.length() && index < strB.length() && strA.charAt(index) == strB.charAt(index)) {
            index++;
        }
        return index;
    }
    public int longestCommonPrefixHashTable(int[] arr1, int[] arr2) {
        HashSet<Integer> prefixSet = new HashSet<>();

        for (int num : arr1) {

            while (num != 0) {
                prefixSet.add(num);
                num = num / 10;
            }
        }

        int result = 0;
        for (int num : arr2) {
            while (num != 0) {
                if (prefixSet.contains(num)) {
                    result = Math.max(result, (int) Math.log10(num) + 1);
                }
                num = num / 10;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] arr1 = {1,123, 123456};
        int[] arr2 = {234, 1234};
        FindLengthOfLongestCPF findLengthOfLongestCPF = new FindLengthOfLongestCPF();
        System.out.println(findLengthOfLongestCPF.longestCommonPrefixHashTable(arr1, arr2));
    }
}
