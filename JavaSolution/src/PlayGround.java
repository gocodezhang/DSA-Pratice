import javax.swing.*;
import java.util.*;

public class PlayGround {

    public String reverseWords(String s) {
        List<String> words = new ArrayList<>();
        // lastIndex
        int lastIndexOfWord = -1;
        // go through string from the back
        for (int i = s.length() - 1; i >= -1; i--) {
            char curr = i == -1 ? ' ' : s.charAt(i);
            if (curr == ' ') {
                // when it is a space - check lastIndex is valid, add string from i + 1, lastIndex
                if (lastIndexOfWord != -1) {
                    words.add(s.substring(i + 1, lastIndexOfWord + 1));
                    lastIndexOfWord = -1;
                }
            } else {
                // when it is not a space - update lastIndex if lastIndex is not valid
                if (lastIndexOfWord == -1) {
                    lastIndexOfWord = i;
                }
            }
        }

        return String.join(" ", words);
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        System.out.println(playground.reverseWords("the sky is blue"));
    }
}
