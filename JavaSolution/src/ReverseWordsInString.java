public class ReverseWordsInString {
    public String reverseWords(String s) {
        // wordsWithSpaces = s.split(' ')
        String[] wordsWithSpaces = s.split(" ");
        // result = ""
        String result = "";
        // for (i = size - 1; i >= 0; i--)
        for (int i = wordsWithSpaces.length - 1; i >= 0; i--) {
            // trim(word)
            String wordWithSpace = wordsWithSpaces[i];
            if (wordWithSpace.length() == 0) {
                continue;
            }
            result += wordWithSpace.trim() + " ";
        }


        // return result
        return result.trim();
    }
    public static void main(String[] args) {
        String s = "  hello world  ";
        ReverseWordsInString reverseWordsInString = new ReverseWordsInString();
        System.out.println(reverseWordsInString.reverseWords(s));
    }
}
