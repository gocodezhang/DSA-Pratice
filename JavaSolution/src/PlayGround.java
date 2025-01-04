import javax.swing.*;
import java.util.*;

public class PlayGround {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        List<String> currLine = new ArrayList<>();
        int currLineLen = words[0].length() + 1;
        currLine.add(words[0]);
        // go through words
        for (int i = 1; i < words.length; i++) {
            // track currLineLength
            String word = words[i];
            if (currLineLen + word.length() <= maxWidth) {
                // if currLine can fit curr word, add
                currLine.add(word);
                currLineLen += word.length() + 1;
//                System.out.println(currLineLen);
//                System.out.println(currLine);
            } else {
                // if no, format and add into result
                result.add(formatLine(currLine, maxWidth, false));

                currLine.clear();
                currLine.add(word);
                currLineLen = word.length() + 1;
            }
        }

        // address last line
        String lastLine = formatLine(currLine, maxWidth, true);

        result.add(lastLine);

        // return
        return result;
    }
    public String formatLine(List<String> wordsInLine, int maxWidth, boolean last) {
        // find out the remaining spaces and slots
        // System.out.println(wordsInLine);
        int wordsLen = 0;

        for (int i = 0; i < wordsInLine.size(); i++) {
            wordsLen += wordsInLine.get(i).length();
        }

        // case 1 - one word or last line
        if (wordsInLine.size() == 1 || last) {
            String text = String.join(" ", wordsInLine);

            // add space padding
            return text + " ".repeat(maxWidth - text.length());
        }

        // case 2 - 2 or more words in the line
        int slots = wordsInLine.size() - 1;
        // find out base + extra
        int base = (maxWidth - wordsLen) / slots;
        int extra = (maxWidth - wordsLen) - base * slots;
        // System.out.println(extra);
        // build the line and assign extra 1 by 1 from left
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < wordsInLine.size(); i++) {
            String word = wordsInLine.get(i);
            builder.append(word);

            if (i != wordsInLine.size() - 1) {
                builder.append(" ".repeat(base));

                if (extra > 0) {
                    builder.append(" ");
                    extra--;
                }
            }
        }

        return builder.toString();
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        System.out.println(playground.fullJustify(words, 20));
    }

}
