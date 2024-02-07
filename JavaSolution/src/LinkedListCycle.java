import java.util.List;

public class LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode reg = head;
        ListNode fast = head;
        while (reg != null && fast != null) {
            reg = reg.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
            if (reg != null && fast != null && reg == fast) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node4 = new ListNode(4);
        head.next = node2;
        node2.next = node0;
        node0.next = node4;
//        node4.next = node2;
        System.out.println(hasCycle(head));

    }
}
