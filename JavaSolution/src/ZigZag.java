public class ZigZag {
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        // define section length
        int sessionLength = (2 * numRows) - 2;
        StringBuilder builder = new StringBuilder();

        for (int row = 0; row < numRows; row++) {
            int startIndex = row;
            while (startIndex < s.length()) {
                builder.append(s.charAt(startIndex));
                if (row != 0 & row != (numRows - 1)) {
                    int increment = sessionLength - (2 * row);
                    int secondIndex = startIndex + increment;
                    if (secondIndex < s.length()) {
                        builder.append(s.charAt(secondIndex));
                    }
                }
                startIndex += sessionLength;
            }
        }
        return builder.toString();
    }
    public static void main(String[] args) {
        String s = "PAYPALISHIRING";
        ZigZag zigzag = new ZigZag();
        System.out.println(zigzag.convert(s, 4));
    }

}
