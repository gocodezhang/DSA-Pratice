import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class ExclusiveTimeFunctions {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] result = new int[n];

        Stack<String> stack = new Stack<>();

        // go through logs
        for (int i = 0; i < logs.size(); i++) {
            String log = logs.get(i);

            int[] parsedLog = parseLog(log);
            if (parsedLog[1] == 0) {
                stack.push(log);
            } else {
                int[] parsedLogFromStack = parseLog(stack.pop());
                int funcId = parsedLog[0];
                int time = parsedLog[2] - parsedLogFromStack[2] + 1;

                result[funcId] = result[funcId] + time;

                // if the stack is not empty, tell previous func the time it took
                if (!stack.isEmpty()) {
                    int[] parsed = parseLog(stack.peek());
                    result[parsed[0]] = result[parsed[0]] - time;
                }


            }

        }

        return result;

    }
    // id, start/end, time
    public int[] parseLog(String log) {
        String[] tripletA = log.split(":");

        int funcId = Integer.parseInt(tripletA[0]);
        int status = tripletA[1].equals("start") ? 0 : 1;
        int time = Integer.parseInt(tripletA[2]);

        return new int[]{funcId, status, time};
    }
    public static void main(String[] args) {
        int n = 1;
        List<String> logs = List.of("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7");
        ExclusiveTimeFunctions exclusiveTimeFunctions = new ExclusiveTimeFunctions();
        int[] result = exclusiveTimeFunctions.exclusiveTime(n, logs);
        System.out.println(Arrays.toString(result));
    }
}
