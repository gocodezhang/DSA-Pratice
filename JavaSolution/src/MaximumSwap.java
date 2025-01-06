import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class MaximumSwap {
    public int maximumSwapStack(int num) {
        String str = Integer.toString(num);

        Stack<int[]> candidates = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int curr = str.charAt(i) - '0';

            while (!candidates.isEmpty() && candidates.peek()[1] < curr) {
                candidates.pop();
            }
            candidates.add(new int[]{i, curr});
        }

        List<int[]> candidatesArr = new ArrayList<>();
        for (int[] candidate : candidates) {
            candidatesArr.add(candidate);
        }

        StringBuilder builder = new StringBuilder(str);

        int index = 0;
        while (index < builder.length() && index < candidatesArr.size() && (builder.charAt(index) - '0') == candidatesArr.get(index)[1]){
            index++;
        }

        if (index < candidatesArr.size()){
            int sourceIndex = index;
            char source = builder.charAt(sourceIndex);

            while (index + 1 < candidatesArr.size() && candidatesArr.get(index)[1] == candidatesArr.get(index + 1)[1]) {
                index++;
            }
            int[] candidate = candidatesArr.get(index);
            builder.setCharAt(candidate[0], source);
            builder.setCharAt(sourceIndex, Character.forDigit(candidate[1], 10));
        }

        return Integer.parseInt(builder.toString());

    }
    public int maximumSwapSuffix(int num) {
        String numInStr = Integer.toString(num);
        // build array containing maximum suffix
        int[] suffix = new int[numInStr.length()];
        suffix[suffix.length - 1] = suffix.length - 1;
        for (int i = suffix.length - 2; i >= 0; i--) {
            char curr = numInStr.charAt(i);
            char maxSoFar = numInStr.charAt(suffix[i + 1]);
            if (curr > maxSoFar) {
                suffix[i] = i;
            } else {
                suffix[i] = suffix[i + 1];
            }
        }
        // go through num
        StringBuilder builder = new StringBuilder(numInStr);
        for (int i = 0; i < numInStr.length(); i++) {
            if (builder.charAt(i) < builder.charAt(suffix[i])) {
                // if suffix is larger the curr
                // update and return
                char originChar = builder.charAt(i);
                builder.setCharAt(i, builder.charAt(suffix[i]));
                builder.setCharAt(suffix[i], originChar);
                return Integer.parseInt(builder.toString());
            }
        }
        // return original num
        return num;
    }
    public static void main(String[] args) {
        MaximumSwap ms = new MaximumSwap();
        System.out.println(ms.maximumSwapSuffix(1992));
    }
}
