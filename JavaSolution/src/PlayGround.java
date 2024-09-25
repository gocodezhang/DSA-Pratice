import java.util.*;

public class PlayGround {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currNode = head;

        int index = 1;
        while (left > index) {
            prevNode = currNode;
            currNode = currNode.next;
            index++;
        }
        ListNode beforeStart = prevNode;
        ListNode start = currNode;
        while (right + 1 > index) {
            ListNode nextNode = currNode.next;
            currNode.next = prevNode;

            prevNode = currNode;
            currNode = nextNode;
            index++;
        }
        start.next = currNode;
        beforeStart.next = prevNode;

        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        PlayGround playground = new PlayGround();
        int intNum = 1000;
        long longNum = 10000000000L;
        String longStr = "/\\";
        for (int i = 0; i < longStr.length(); i++) {
            System.out.println(longStr.charAt(i));
        }
        System.out.println(longStr.length());
    }
}
