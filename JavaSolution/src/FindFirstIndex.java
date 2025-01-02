public class FindFirstIndex {
    public int strStr(String haystack, String needle) {
        return haystack.indexOf(needle);
    }
    public int strStrWOBuiltIn(String haystack, String needle) {
        int length = needle.length();
        char starting = needle.charAt(0);

        for (int i = 0; i < haystack.length(); i++) {
            if (starting == haystack.charAt(i)) {
                int count = 1;
                boolean match = true;

                while (match && count < length && i + count < haystack.length()) {
                    if (needle.charAt(count) != haystack.charAt(count + i)) {
                        match = false;
                    } else {
                        count++;
                    }
                }
                if (match && count == length) {
                    return i;
                }
            }
        }

        return -1;
    }
}
