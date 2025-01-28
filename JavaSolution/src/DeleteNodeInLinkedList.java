public class DeleteNodeInLinkedList {
    public void deleteNode(ListNode node) {
        // curr next
        ListNode curr = node;
        ListNode next = node.next;
        // while (next is not null)
        while (next != null) {
            // swap their values
            ListNode temp = next.next;
            int valueTemp = curr.val;
            curr.val = next.val;
            next.val = valueTemp;
            // if next.next is null
            // curr.next = null
            if (temp == null) {
                curr.next = null;
            }
            curr = next;
            next = temp;
        }
    }
}
