import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class waysToBuildRooms {
    public int waysToBuildRooms(int[] prevRoom) {
        HashMap<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < prevRoom.length; i++) {
            if (!mapping.containsKey(prevRoom[i])) {
                mapping.put(prevRoom[i], new ArrayList<>());
            }
            List<Integer> roomList = mapping.get(prevRoom[i]);
            roomList.add(i);
        }
        List<Integer> built = new ArrayList<>();
        built.add(-1);

        return dfs(built, mapping, prevRoom.length);
    }
    public int dfs(List<Integer> built, HashMap<Integer, List<Integer>> mapping, int n) {
        // base case
        if (built.size() == n) {
            return 1;
        }

        // recursive case
        int result = 0;
        for (int i = 0; i < built.size(); i++) {
            int builtRoom = built.get(i);
            List<Integer> options = mapping.getOrDefault(builtRoom, new ArrayList<>());
            for (int room : options) {
                if (built.indexOf(room) == -1) {
                    built.add(room);
                    result += dfs(built, mapping, n);
                    built.remove(built.size() - 1);
                }
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] test = {-1,0,0,1,2};
        waysToBuildRooms wb = new waysToBuildRooms();
        System.out.println(wb.waysToBuildRooms(test));
    }
}
