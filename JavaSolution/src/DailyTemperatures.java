import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans = new int[temperatures.length];
        Stack<Integer> nonDecreasingStack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!nonDecreasingStack.isEmpty() && temperatures[nonDecreasingStack.peek()] < temperatures[i]) {
                int updateIndex = nonDecreasingStack.pop();
                ans[updateIndex] = i - updateIndex;
            }
            nonDecreasingStack.push(i);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] temps = {73,74,75,71,69,72,76,73};
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] result = dailyTemperatures.dailyTemperatures(temps);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            builder.append(result[i]);
            builder.append(',');
        }
        System.out.println(builder.toString());
    }
}
