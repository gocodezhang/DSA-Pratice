public class LengthOfLastWord {
    public static int lenOfLastWord(String s) {
        int strLen = s.length();
        // create lastLetter = -1; afterSpace = -1;
        int lastLetter = -1;
        int afterSpace = -1;
        // for (int i = s.length - 1; i >= 0; i--)
        for (int i = strLen - 1; i >= 0; i--) {
            char currChar = s.charAt(i);
            // if (lastLetter == -1 && currLetter == character)
            if (lastLetter == -1 && Character.isLetter(currChar)) {
                lastLetter = i;
            }
            // if (lastLetter != -1 && currLetter == space)
            if (lastLetter != -1 && currChar == ' ') {
                afterSpace = i;
            }
            // if (lastLetter != -1 && afterSpace != -1)
            if (lastLetter != -1 && afterSpace != -1) {
                break;
            }
        }

        // return lastLetter - afterSpace
        return lastLetter - afterSpace;
    }
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lenOfLastWord(s));
    }
}
