import java.util.*;

public class RandomizedSet {
    LinkedList<Integer> list;
    HashMap<Integer, Integer> dict;

    public RandomizedSet() {
        this.list = new LinkedList<>();
        this.dict = new HashMap<>();
    }
    public boolean insert(int val) {
        // check if val exist in set
        if (dict.containsKey(val)) {
            return false;
        }

        // add val into both set and linkedList
        dict.put(val, list.size());
        list.add(val);

        // return true
        return true;

    }
    public boolean remove(int val) {
        // check if val exist in set
        if (!dict.containsKey(val)) {
            return false;
        }
        // else
        // remove the val in both set and list
        int lastElement = list.get(list.size() - 1);
        int index = dict.get(val);
        list.set(index, lastElement);
        dict.put(lastElement, index);
        list.remove(list.size() - 1);
        dict.remove(val);

        // return true
        return true;

    }
    public int getRandom() {
        Random random = new Random();
        int pointer = random.nextInt(list.size());
        return list.get(pointer);
    }
    public static void main(String[] main) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(1);
        randomizedSet.remove(2);
        randomizedSet.insert(2);
        randomizedSet.remove(1);
        randomizedSet.insert(2);

    }
}
