import java.util.ArrayList;
import java.util.List;

public class EncodeDecodeStrings {
    char delimiter = ',';
    char escape = '#';

    public String encode(List<String> strs) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            String currStr = strs.get(i);
            for (int j = 0; j < currStr.length(); j++) {
                char currChar = currStr.charAt(j);
                if (currChar == delimiter || currChar == escape) {
                    builder.append(escape);
                }
                builder.append(currChar);
            }
            if (i != strs.size() - 1) {
                builder.append(delimiter);
            }
        }
        return builder.toString();
    }
    public List<String> decode(String s) {
        List<String> result = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        boolean escapeFlag = false;
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (escapeFlag) {
                builder.append(currChar);
                escapeFlag = false;
                continue;
            }

            if (currChar == escape) {
                escapeFlag = true;
            } else if (currChar == delimiter) {
                result.add(builder.toString());
                builder = new StringBuilder();
            } else {
                builder.append(currChar);
            }

        }

        result.add(builder.toString());

        return result;
    }
    public String encodeChunkTransfer(List<String> strs) {
        StringBuilder builder = new StringBuilder();

        for (String str : strs) {
            int size = str.length();
            builder.append(size + "" + delimiter + str);
        }

        return builder.toString();
    }
    public List<String> decodeChunkTransfer(String s) {
        List<String> result = new ArrayList<>();

        int index = 0;
        while (index < s.length()) {
            int delimiterIndex = s.indexOf(delimiter, index);
            int size = Integer.parseInt(s.substring(index, delimiterIndex));
            int startIndex = delimiterIndex + 1;

            String str = s.substring(startIndex, startIndex + size);
            result.add(str);

            index = startIndex + size;
        }

        return result;
    }
    public static void main(String[] args) {
        EncodeDecodeStrings encodeDecodeStrings = new EncodeDecodeStrings();
        List<String> test = List.of("jay","z");
        String result = encodeDecodeStrings.encodeChunkTransfer(test);
        System.out.println(result);
        System.out.println(encodeDecodeStrings.decodeChunkTransfer(result));
    }
}
