import java.util.ArrayList;
import java.util.List;

public class TextJustification {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int currLineLength = 0;
        List<String> currLine = new ArrayList<>();
        List<List<String>> allLines = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String currWord = words[i];
            int currWordLength = currLine.size() == 0 ? currWord.length() : currWord.length() + 1;
            if (currLineLength + currWordLength > maxWidth) {
                allLines.add(new ArrayList<>(currLine));
                currLine = new ArrayList<>();
                currLineLength = 0;
                currWordLength--;
            }
            currLine.add(currWord);
            currLineLength += currWordLength;
        }
        if (currLine.size() > 0) {
            allLines.add(currLine);
        }
        List<String> result = new ArrayList<>();
        for (int i = 0; i < allLines.size(); i++) {
            List<String> line = allLines.get(i);
            if (i == allLines.size() - 1 || line.size() == 1) {
                result.add(leftJustifyLine(line, maxWidth));
            } else {
                result.add(fullJustifyLine(line, maxWidth));
            }
        }
        return result;

    }
    private String fullJustifyLine(List<String> currLine, int maxWidth) {
        int numberOfSlot = currLine.size() - 1;
        int totalLength = 0;
        for (int i = 0; i < currLine.size(); i++) {
            totalLength += currLine.get(i).length();
        }
        int numberOfSpace = (maxWidth - totalLength) / numberOfSlot;
        int remainder = (maxWidth - totalLength) % numberOfSlot;
        String result = "";
        for (int i = 0; i < currLine.size(); i++) {
            if (i == 0) {
                result += currLine.get(i);
                continue;
            }
            String space = "";
            int count = 0;
            while (count < numberOfSpace) {
                space += " ";
                count++;
            }
            if (remainder > 0) {
                space += " ";
                remainder--;
            }
            result += space + currLine.get(i);
        }
        return result;
    }
    private String leftJustifyLine(List<String> lastLine, int maxWidth) {
        int length = 0;
        String result = "";
        for (int i = 0; i < lastLine.size(); i++) {
            String currWord = lastLine.get(i);
            if (i == 0) {
                result += currWord;
                length += currWord.length();
                continue;
            }
            result += " " + currWord;
            length += currWord.length() + 1;
        }
        int numberSpaceNeeded = maxWidth - length;
        String space = "";
        while (numberSpaceNeeded > 0) {
            space += " ";
            numberSpaceNeeded--;
        }
        return result + space;
    }
    public List<String> fullJustifySecondSolution(String[] words, int maxWidth) {
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
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.fullJustify(words, 20));
    }

}
