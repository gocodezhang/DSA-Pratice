import java.util.Stack;

public class SimplifyPath {
    public static String translateSimplifyPath(String path) {
        String[] directories = path.split("/");
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < directories.length; i++) {
            String currDirectory = directories[i];
            if (currDirectory.equals(".") || currDirectory.equals("")) {
                continue;
            }
            if (currDirectory.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.add(currDirectory);
            }
        }

        if (stack.empty()) {
            return "/";
        }

        String resultPath = "";
        while (!stack.empty()) {
            String directory = stack.pop();
            resultPath = "/" + directory + resultPath;
        }

        return resultPath;
    }
    public static void main(String[] args) {
        String path = "/home/";
        System.out.println(translateSimplifyPath(path));
    }
}
