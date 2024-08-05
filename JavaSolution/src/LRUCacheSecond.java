import java.util.HashMap;

public class LRUCacheSecond {
    int capacity;
    DoublyListNode head;
    DoublyListNode tail;
    HashMap<Integer, DoublyListNode> map;
    public LRUCacheSecond(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = new DoublyListNode(-1, -1);
        this.tail = new DoublyListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    private void add(DoublyListNode node) {
        DoublyListNode prevNode = tail.prev;
        prevNode.next = node;
        node.prev = prevNode;
        node.next = tail;
        tail.prev = node;
    }
    private void remove(DoublyListNode node) {
        DoublyListNode prevNode = node.prev;
        DoublyListNode nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }
    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        DoublyListNode currNode = map.get(key);
        int value = currNode.val;
        remove(currNode);
        add(currNode);
        return value;
    }
    public void put(int key, int value) {
        if (map.containsKey(key)) {
            DoublyListNode currNode = map.get(key);
            currNode.val = value;
            remove(currNode);
            add(currNode);
        } else {
            DoublyListNode newNode = new DoublyListNode(key, value);
            add(newNode);
            map.put(key, newNode);
            if (map.size() > capacity) {
                int tempKey = head.next.key;
                remove(head.next);
                map.remove(tempKey);
            }
        }

    }
    public static void main(String[] args) {
        LRUCacheSecond lruCacheSecond = new LRUCacheSecond(2);
        lruCacheSecond.put(1, 1); // cache is {1=1}
        lruCacheSecond.put(2, 2); // cache is {1=1, 2=2}
        lruCacheSecond.get(1);    // return 1
        lruCacheSecond.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        lruCacheSecond.get(2);    // returns -1 (not found)
        lruCacheSecond.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        lruCacheSecond.get(1);    // return -1 (not found)
        lruCacheSecond.get(3);    // return 3
        lruCacheSecond.get(4);    // return 4
    }
}
