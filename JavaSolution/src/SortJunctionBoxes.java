import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortJunctionBoxes {
    public List<String> sortBoxes(List<String> boxList) {
        List<String> oldBoxes = new ArrayList<>();
        List<String> newBoxes = new ArrayList<>();
        // split the new and old
        for (int i = 0; i < boxList.size(); i++) {
            String box = boxList.get(i);
            String[] boxParsed = box.split(" ");
            if (Character.isDigit(boxParsed[1].charAt(0))) {
                newBoxes.add(box);
            } else {
                oldBoxes.add(box);
            }
        }
        // sort the old
        Collections.sort(oldBoxes, (a, b) -> {
            int firstSpaceIndexA = a.indexOf(' ');
            String flipedA = a.substring(firstSpaceIndexA + 1) + a.substring(0, firstSpaceIndexA + 1);
            int firstSpaceIndexB = a.indexOf(' ');
            String flipedB = b.substring(firstSpaceIndexB + 1) + b.substring(0, firstSpaceIndexB + 1);

            return flipedA.compareTo(flipedB);
        });
        // append new into sorted old
        for (int i = 0; i < newBoxes.size(); i++) {
            oldBoxes.add(newBoxes.get(i));
        }

        return oldBoxes;
    }
    public static void main(String[] args) {
        List<String> boxList = List.of("vkc 82 01", "eo first qpx", "09z cat hamster", "06f 12 25 6", "azO first qpx", "236 cat dog rabbit snake");
        SortJunctionBoxes sortJunctionBoxes = new SortJunctionBoxes();
        System.out.println(sortJunctionBoxes.sortBoxes(boxList));
    }
}
