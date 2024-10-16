import java.util.HashSet;

public class OpenTheLock {
    char[] options = new char[]{'0', '1', '2','3', '4', '5','6', '7', '8', '9'};
    public int openLock(String[] deadends, String target) {

        HashSet<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        return dfs("0000", deadendSet, target);

    }
    public int dfs(String start, HashSet<String> deadend, String target) {
        // base case
        if (start.equals(target)) {
            return 0;
        }
        if (deadend.contains(start)) {
            return -1;
        }

        // recursive case
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < start.length(); i++) {
            int currNum = start.charAt(i) - '0';
            char turnUp = options[((currNum + 1) + 10) % 10];
            char turnDown = options[((currNum - 1) + 10) % 10];
            int turnUpPath = dfs(start.substring(0, i) + turnUp + start.substring(i + 1), deadend, target);
            int turnDownPath = dfs(start.substring(0, i) + turnDown + start.substring(i + 1), deadend, target);
            if (turnUpPath > 0) {
                result = Math.min(result, turnUpPath + 1);
            }
            if (turnDownPath > 0) {
                result = Math.min(result, turnDownPath + 1);
            }

        }

        return result == Integer.MAX_VALUE ? -1 : result;
    }
    public static void main(String[] args) {
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        OpenTheLock openTheLock = new OpenTheLock();
        System.out.println(openTheLock.openLock(deadends, target));
    }
}
