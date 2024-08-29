import java.util.List;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        // create two heads (left, right)
        ListNode dummyLeft = new ListNode(-1);
        ListNode dummyRight = new ListNode(-1);
        ListNode currLeft = dummyLeft;
        ListNode currRight = dummyRight;

        // go through the list
        ListNode currNode = head;
        while (currNode != null) {
            // if currNode < x
            if (currNode.val < x) {
                // add it in left
                currLeft.next = currNode;
                currLeft = currLeft.next;
            } else {
                currRight.next = currNode;
                currRight = currRight.next;
            }
            currNode = currNode.next;
        }
        // link left and right

        currLeft.next = dummyRight.next;

        // update last node pointer
        currRight.next = null;
        // return
        return dummyLeft.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node4 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node22 = new ListNode(2);
        node1.next = node4;
        node4.next = node3;
        node3.next = node2;
        node2.next = node5;
        node5.next = node22;
        PartitionList partitionList = new PartitionList();
        System.out.println(partitionList.partition(node1, 3));
    }
}
