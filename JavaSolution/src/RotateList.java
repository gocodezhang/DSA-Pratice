import java.util.HashMap;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        // go through list once
        ListNode currNode = head;
        int size = 0;
        HashMap<Integer, ListNode> indexMap = new HashMap<>();

        while (currNode != null) {
            indexMap.put(size, currNode);
            size += 1;
            currNode = currNode.next;
        }
        // size, indexMap, lastIndex = n - 1
        int lastIndex = size - 1;
        // update k = k % size
        k = k % size;

        // rotate k times
        while (k > 0) {
            // remove next pointer of lastSecond node
            ListNode lastSecond = indexMap.get(lastIndex - 1);
            ListNode last = indexMap.get(lastIndex);
            lastSecond.next = null;
            // update lastNode next pointer to curr Head
            last.next = head;
            // update curr head
            head = last;
            k--;
            lastIndex--;
        }

        // return head
        return head;
    }
    public ListNode rotateRightOptimal(ListNode head, int k) {
        if (head == null || k == 0) {
            return head;
        }
        int size = 1;
        ListNode currNode = head;
        while (currNode.next != null) {
            size += 1;
            currNode = currNode.next;
        }
        currNode.next = head;

        k = k % size;
        ListNode tail = head;
        for (int i = 0; i < size - 1 - k; i++) {
            tail = tail.next;
        }
        ListNode newHead = tail.next;
        tail.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        RotateList rotateList = new RotateList();
        rotateList.rotateRight(node1, 5);
    }

}
