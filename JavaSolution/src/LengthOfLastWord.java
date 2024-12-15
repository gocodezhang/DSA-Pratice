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
    public int lengthOfLastWord(String s) {
        // search from the back
        // seenWord
        boolean seenWord = false;
        int prevSpaceIndex = s.length();
        int index = s.length() - 1;

        while (index >= 0) {
            char currChar = s.charAt(index);
            if (currChar != ' ') {
                seenWord = true;
            } else {
                if (seenWord) {
                    break;
                }
                prevSpaceIndex = index;
            }
            index--;
        }

        return prevSpaceIndex - index - 1;

    }
    public static void main(String[] args) {
        String s = "   fly me   to   the moon  ";
        System.out.println(lenOfLastWord(s));
    }
}
