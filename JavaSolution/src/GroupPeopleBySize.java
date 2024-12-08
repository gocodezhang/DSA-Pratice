import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GroupPeopleBySize {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        // create a map
        HashMap<Integer, List<List<Integer>>> groupMap = new HashMap<>();
        // go through the array
        for (int i = 0; i < groupSizes.length; i++) {
            // append person into corresponding group size
            int size = groupSizes[i];
            if (!groupMap.containsKey(size)) {
                groupMap.put(size, new ArrayList<>());
            }
            List<List<Integer>> groupsWithSize = groupMap.get(size);
            if (groupsWithSize.size() == 0 || groupsWithSize.get(groupsWithSize.size() - 1).size() == size) {
                groupsWithSize.add(new ArrayList<>());
            }
            List<Integer> lastGroup = groupsWithSize.get(groupsWithSize.size() - 1);
            lastGroup.add(i);
        }

        // go through the map
        List<List<Integer>> result = new ArrayList<>();
        for (int key : groupMap.keySet()) {
            List<List<Integer>> currList = groupMap.get(key);

            for (int i = 0; i < currList.size(); i++) {
                result.add(currList.get(i));
            }
        }
        // return result list

        return result;
    }
    public static void main(String[] args) {
        int[] groupSizes = {3,3,3,3,3,1,3};
        GroupPeopleBySize groupPeopleBySize = new GroupPeopleBySize();
        System.out.println(groupPeopleBySize.groupThePeople(groupSizes));
    }

}
