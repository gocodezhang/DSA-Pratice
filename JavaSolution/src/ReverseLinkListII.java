import java.util.ArrayList;
import java.util.List;

public class ReverseLinkListII {
    static ListNode leftNode;
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }
        // create referList
        List<ListNode> referList = new ArrayList<>();
        ListNode dummyHead = new ListNode(0);
        referList.add(dummyHead);
        // start = head
        dummyHead.next = head;
        ListNode start = dummyHead.next;
        // while (start is not null)
        while (start != null) {
            // referArray[index] = start
            referList.add(start);
            // start = start.next;
            start = start.next;
        }

        // startNode = referArray[left]
        ListNode firstNode = referList.get(left);
        // endNode = referArray[right]
        ListNode endNode = referList.get(right);
        // prevNode = referArray[left - 1]
        ListNode prevNode = referList.get(left - 1);
        // prevNode.next = endNode
        prevNode.next = endNode;
        // startNode.next = endNode.next
        firstNode.next = endNode.next;
        // for (i = left, i < right, i++)
        for (int i = left + 1; i <= right; i++) {
            ListNode currNode = referList.get(i);
            currNode.next = referList.get(i - 1);
        }
        return dummyHead.next;
    }
    public static ListNode reverseBetweenIterative(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode prevNode = null;
        ListNode currNode = head;

        while (left > 1) {
            prevNode = currNode;
            currNode = currNode.next;
            left--;
            right--;
        }
        ListNode beforeFirst = prevNode;
        ListNode startNode = currNode;
        while (right > 0) {
            ListNode temp = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = temp;
            right--;
        }
        if (beforeFirst == null) {
            head = prevNode;
        } else {
            beforeFirst.next = prevNode;
        }
        startNode.next = currNode;

        return head;
    }
    public static ListNode reverseBetweenRecursive(ListNode head, int left, int right) {
        leftNode = head;
        recurseAndReverse(head, left, right, false);
        return head;
    }
    public static void recurseAndReverse(ListNode rightNode, int left, int right, boolean stop) {
        if (right == 1) {
            return;
        }
        rightNode = rightNode.next;

        if (left > 1) {
            leftNode = leftNode.next;
        }
        recurseAndReverse(rightNode, left - 1, right - 1, stop);

        if (leftNode == rightNode || rightNode.next == leftNode) {
            stop = true;
        }
        if (!stop) {
            int t = leftNode.val;
            leftNode.val = rightNode.val;
            rightNode.val = t;
            leftNode = leftNode.next;
        }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3)));
        System.out.println(reverseBetweenRecursive(head, 1, 3));
    }
}
