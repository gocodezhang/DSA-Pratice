import java.util.Arrays;

public class EnforcePasswordPolicy {
    public String[] findSimilarities(String[] newPasswords, String[] oldPasswords) {
        int n = newPasswords.length;
        String[] result = new String[n];
        Arrays.fill(result, "NO");
        // go through each new and old pair
        for (int i = 0; i < n; i++) {
            String newPw = newPasswords[i];
            String oldPw = oldPasswords[i];
            // iterate through the new password
            for (int start = 0; start < newPw.length(); start++) {
                if (check(start, newPw, oldPw)) {
                    result[i] = "YES";
                }
            }

        }

        // return result
        return result;
    }
    public boolean check(int startIndex, String newPw, String oldPw) {
        if (newPw.length() - startIndex < oldPw.length()) {
            return false;
        }
        int newPointer = startIndex;
        int oldPointer = 0;
        while (newPointer < newPw.length() && oldPointer < oldPw.length()) {
            int diff = oldPw.charAt(oldPointer) - newPw.charAt(newPointer);
            //System.out.println();
            if (diff == 0 || diff == 1 || diff == -25) {

                oldPointer++;
            }
            newPointer++;

        }

        return oldPointer == oldPw.length();
    }
    public static void main(String[] args) {
        String[] newPw = {"aaaa", "bzz"};
        String[] oldPw = {"bcd", "az"};
        EnforcePasswordPolicy enforcePasswordPolicy = new EnforcePasswordPolicy();
        System.out.println(Arrays.toString(enforcePasswordPolicy.findSimilarities(newPw, oldPw)));
    }
}
