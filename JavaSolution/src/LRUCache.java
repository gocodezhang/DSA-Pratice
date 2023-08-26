import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Map<Integer, DoublyListNode> map;
    private DoublyListNode head;
    private DoublyListNode tail;
    private void add(DoublyListNode node) {
        DoublyListNode originalLastNode = tail.prev;
        originalLastNode.next = node;
        node.prev = originalLastNode;
        node.next = tail;
        tail.prev = node;
    }
    private void remove(DoublyListNode node) {
        DoublyListNode prevNode = node.prev;
        prevNode.next = node.next;
        node.next.prev = prevNode;
    }
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoublyListNode(0, 0);
        this.tail = new DoublyListNode(1, 1);
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoublyListNode node = map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            remove(map.get(key));
        }
        DoublyListNode newNode = new DoublyListNode(key, value);
        add(newNode);
        map.put(key, newNode);
        if (map.size() > capacity) {
            int keyToRemove = head.next.key;
            remove(head.next);
            map.remove(keyToRemove);
        }
    }
    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lRUCache.get(1);    // return -1 (not found)
        System.out.println(lRUCache.get(4)); // return 4
    }
}
