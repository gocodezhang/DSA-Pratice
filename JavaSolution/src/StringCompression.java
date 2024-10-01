public class StringCompression {
    public int compress(char[] chars) {
        char prevChar = chars[0];
        int countChar = 1;
        int updateIndex = 1;

        for (int i = 1; i < chars.length; i++) {
            char currChar = chars[i];
            if (prevChar == currChar) {
                countChar++;
            } else if (countChar == 1) {
                prevChar = currChar;
                chars[updateIndex] = currChar;
                updateIndex++;
            } else {
                String countStr = String.valueOf(countChar);
                for (int numIndex = 0; numIndex < countStr.length(); numIndex++) {
                    chars[updateIndex] = countStr.charAt(numIndex);
                    updateIndex++;
                }
                prevChar = currChar;
                countChar = 1;
                chars[updateIndex] = currChar;
                updateIndex++;
            }
        }
        if (countChar > 1) {
            String countStr = String.valueOf(countChar);
            for (int numIndex = 0; numIndex < countStr.length(); numIndex++) {
                chars[updateIndex] = countStr.charAt(numIndex);
                updateIndex++;
            }
        }

        return updateIndex;
    }
    public static void main(String[] args) {
        char[] chars = {'a','b','c','d','e','f','g','g','g','g','g','g','g','g','g','g','g','g','a','b','c'};
        StringCompression stringCompression = new StringCompression();
        System.out.println(stringCompression.compress(chars));
    }
}
