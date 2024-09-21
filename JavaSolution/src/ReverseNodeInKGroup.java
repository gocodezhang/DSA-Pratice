public class ReverseNodeInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode prevNode = dummyNode;
        ListNode currNode = head;
      // while we are not getting the end
        int session = 0;
        while (currNode != null) {
            // reverseInCurrSession
            ListNode[] result = reverseInCurrSession(prevNode, currNode, k);
            if (session == 0) {
                head = prevNode.next;
            }
            currNode = result[1];
            prevNode = result[0];
            session++;
        }

        // return head
        return head;
    }
    public ListNode[] reverseInCurrSession(ListNode beforeStart, ListNode start, int k) {
        if (start == null) {
            return new ListNode[]{null, null};
        }

        ListNode prev = beforeStart;
        ListNode curr = start;

        int length = 1;
        while (curr.next != null && length < k) {
            curr = curr.next;
            length++;
        }

        if (length < k) {
            return new ListNode[]{null, null};
        }

        // perform switching
        curr = start;
        int index = 0;
        while (index < k) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
            index++;
        }
        start.next = curr;
        beforeStart.next = prev;

        return new ListNode[]{start, curr};
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
        ReverseNodeInKGroup reverseNodeInKGroup = new ReverseNodeInKGroup();
        System.out.println(reverseNodeInKGroup.reverseKGroup(node1, 2));
    }



}
