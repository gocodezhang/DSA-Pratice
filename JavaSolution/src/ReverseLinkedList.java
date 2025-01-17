public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        // prev, curr pointer
        // go through the list
        while (curr != null) {
            // point curr.next = prev
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // return head
        return prev;
    }
}
