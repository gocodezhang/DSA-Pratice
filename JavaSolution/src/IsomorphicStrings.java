import java.util.HashMap;

public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> sToT = new HashMap<>();
        HashMap<Character, Character> tToS = new HashMap<>();
        // iterate over two strings at same time
        for (int i = 0; i < s.length(); i++) {
            //currLetterOne, currLetterTwo
            char currLetterOne = s.charAt(i);
            char currLetterTwo = t.charAt(i);
            // check if map has key currLetterOne
            if (sToT.containsKey(currLetterOne)) {
                // if true, we check if value !== currLetterTwo
                if (sToT.get(currLetterOne) != currLetterTwo) {
                    return false;
                }
            } else {
                // false, we add key value pair
                sToT.put(currLetterOne, currLetterTwo);
            }

            if (tToS.containsKey(currLetterTwo)) {
                // if true, we check if value !== currLetterTwo
                if (tToS.get(currLetterTwo) != currLetterOne) {
                    return false;
                }
            } else {
                // false, we add key value pair
                tToS.put(currLetterTwo, currLetterOne);
            }

        }

        // return true
        return true;
    }
    public static void main(String[] args) {
        String s = "egg";
        String t = "ada";
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        System.out.println(isomorphicStrings.isIsomorphic(s, t));
    }
}
