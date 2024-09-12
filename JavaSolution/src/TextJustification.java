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
    public static void main(String[] args) {
        String[] words = {"Science","is","what","we","understand","well","enough","to","explain","to","a","computer.","Art","is","everything","else","we","do"};
        TextJustification textJustification = new TextJustification();
        System.out.println(textJustification.fullJustify(words, 20));
    }

}
