public class ReverseWordsInStrIII {
    public static String reverseWords(String s) {
        String[] words = s.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversed = "";
            for (int j = word.length() - 1; j >= 0; j--) {
                reversed += word.charAt(j);
            }
            words[i] = reversed;
        }
        String reversedStr = "";
        for (int i = 0; i < words.length; i++) {
            reversedStr += words[i];
            if (i != words.length - 1) {
                reversedStr += " ";
            }
        }
        return reversedStr;
    }
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(reverseWords(s));
    }
}
