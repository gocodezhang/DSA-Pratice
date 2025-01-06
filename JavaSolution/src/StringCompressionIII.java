public class StringCompressionIII {
    public String compressedString(String word) {
        int currIndex = 0;
        StringBuilder builder = new StringBuilder();
        // go through the word
        while (currIndex < word.length()) {
            char currChar = word.charAt(currIndex);
            int count = 1;
            // find prefix given currIndex
            while (currIndex + 1 < word.length() && word.charAt(currIndex + 1) == currChar && count < 9) {
                currIndex++;
                count++;
            }

            // append to comp
            builder.append(count);
            builder.append(currChar);

            currIndex++;
        }

        // return
        return builder.toString();
    }
    public static void main(String[] args) {
        StringCompressionIII sc = new StringCompressionIII();
        System.out.println(sc.compressedString("aaaaaaaaaa"));
    }
}
