public class IsSubsequence {
    public boolean check(String s, String t) {
        // secondPointer = 0
        int j = 0;
        // for (i < s.length; i++)
        for (int i = 0; i < s.length(); i++) {
            // currLetter = s.charAt(i)
            char currLetter = s.charAt(i);
            // find = false
            boolean find = false;
            // while (!find && secondPointer < t.length)
            while (!find && j < t.length()) {
                find = t.charAt(j) == currLetter;
                j++;
            }
            // if (secondPointer >= t.length)
            if (!find && j >= t.length()) {
                return false;
            }
        }


        return true;
    }
}
