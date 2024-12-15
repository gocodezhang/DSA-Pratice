import javax.swing.*;
import java.util.*;

public class PlayGround {

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
        PlayGround playground = new PlayGround();
        System.out.println(playground.lengthOfLastWord("   fly me   to   the moon  "));
    }
}
