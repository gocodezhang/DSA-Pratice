public class PlayGround {
    public static String altPairs(String str) {
        int index = 0;
        int count = 0;
        String result = "";
        while (index < str.length()) {
            result += str.charAt(index);
            if (count % 2 == 0) {
                index += 1;
            } else {
                index += 3;
            }
            count += 1;

        }
        return result;
    }

    public static void main(String[] args) {
        String a = "kitten";
        System.out.println(altPairs(a));
    }
}
