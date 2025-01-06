import javax.swing.*;
import java.util.*;

public class PlayGround {
    public String mergeAlternately(String word1, String word2) {
        // find out # merge operations
        int mergeOps = Math.min(word1.length(), word2.length());
        // perform merging
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < mergeOps; i++) {
            builder.append(word1.charAt(i));
            builder.append(word2.charAt(i));
        }
        // pad remaining letters
        String remainingWord = word1.length() > word2.length() ? word1 : word2;

        for (int i = mergeOps; i < remainingWord.length(); i++) {
            builder.append(remainingWord.charAt(i));
        }

        return builder.toString();
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        System.out.println(playground.mergeAlternately("a", "p"));
    }

}
