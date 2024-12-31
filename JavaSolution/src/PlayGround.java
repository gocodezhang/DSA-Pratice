import javax.swing.*;
import java.util.*;

public class PlayGround {

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<List<Character>> rows = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int range = numRows * 2 - 2;
        int currIndex = 0;

        while (currIndex < s.length()) {
            int step = 0;
            while (step < range && currIndex + step < s.length()) {
                char curr = s.charAt(currIndex + step);
                int currRow = step < numRows ? step : (range - step);
                List<Character> row = rows.get(currRow);
                row.add(curr);
                step++;
            }
            currIndex += range;
        }
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < rows.size(); i++) {
            List<Character> row = rows.get(i);
            for (int j = 0; j < row.size(); j++) {
                builder.append(row.get(j));
            }
        }

        return builder.toString();
    }
    public String convertConstantMemory(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        int sessionLength = 2 * numRows - 2;

        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int firstIndex = row;
            while (firstIndex < s.length()) {
//                System.out.println("row: " + row);
//                System.out.println("char: " + s.charAt(firstIndex));
                builder.append(s.charAt(firstIndex));
                int secondIndex = firstIndex + (sessionLength - 2 * row);
                if (row != 0 && row != numRows - 1 && secondIndex < s.length()) {
                    builder.append(s.charAt(secondIndex));
                }

                firstIndex += sessionLength;
            }
        }

        return builder.toString();
    }



    public static void main(String[] args) {
        PlayGround playground = new PlayGround();
        System.out.println(playground.convertConstantMemory("PAYPALISHIRING",3));
    }
}
