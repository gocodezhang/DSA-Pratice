/**
 * Given a string s, we need to the maximum number of delete operation that we can perform
 * such that after delete operation, the first and last letter is still the same as original string
 *
 * The delete operation can only be performed at the start or end of a string
 *
 * Example:
 * s = "babdcaac" (the string start with "b" and end with "c")
 * findMaximumDeleteOperations(s) -> 5 (delete first two letters and last three letters)
 */
public class AmazonFindMaxDeleteOperation {
    public int findMaximumDeleteOps(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        char startChar = s.charAt(0);
        char endChar = s.charAt(n - 1);

        // use sliding window to find the smallest window that start and end with the letters
        int left = 0;
        int right = 0;

        int min = Integer.MAX_VALUE;

        while (left < n) {
            while (left < n && s.charAt(left) != startChar) {
                left++;
            }
            // reset right if it is less than left
            if (right < left) {
                right = left;
            }
            while (right < n && s.charAt(right) != endChar) {
                right++;
            }

            // check if it is a valid window before updating it
            if (left < n && right < n) {
                min = Math.min(min, right - left + 1);
            }
            left++;
        }

        // max delete operations = string length - the smallest window found
        return n - min;
    }
    public static void main(String[] args) {
        String s = "babdcaac"; // 5
        String s1 = ""; // 0
        String s2 = "bb"; // 1
        String s3 = "babdcaabc"; // 7
        String s4 = "babdb"; // 4
        AmazonFindMaxDeleteOperation amazonFindMaxDeleteOperation = new AmazonFindMaxDeleteOperation();
        System.out.println(amazonFindMaxDeleteOperation.findMaximumDeleteOps(s));
        System.out.println(amazonFindMaxDeleteOperation.findMaximumDeleteOps(s1));
        System.out.println(amazonFindMaxDeleteOperation.findMaximumDeleteOps(s2));
        System.out.println(amazonFindMaxDeleteOperation.findMaximumDeleteOps(s3));
        System.out.println(amazonFindMaxDeleteOperation.findMaximumDeleteOps(s4));
    }
}
