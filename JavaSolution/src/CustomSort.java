import java.util.Arrays;
import java.util.HashMap;

public class CustomSort {
    public String[] customSortString(String order, String[] arr) {
        HashMap<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }

        Arrays.sort(arr, (a, b) -> customCompare(a, b, orderMap));

        return arr;

    }
    private int customCompare(String a, String b, HashMap<Character,Integer> orderMap) {
        int i = 0;

        while (i < a.length() && i < b.length()) {
            if (a.charAt(i) != b.charAt(i)) {
                int rankA = orderMap.get(a.charAt(i));
                int rankB = orderMap.get(b.charAt(i));

                return rankA < rankB ? -1 : 1;
            }
            i++;
        }
        if (a.length() < b.length()) {
            return -1;
        } else if (a.length() > b.length()) {
            return 1;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        String order = "yYaAbB1";
        String[] arr = {"Yay", "yaY", "1yaB", "1yab", "b", "bay"};
        CustomSort customSort = new CustomSort();
        System.out.println(Arrays.toString(customSort.customSortString(order, arr)));
    }
}
