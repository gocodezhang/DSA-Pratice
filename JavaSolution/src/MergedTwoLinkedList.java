public class MergedTwoLinkedList {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // create dummyNode = listNode(0)
        ListNode dummyNode = new ListNode(0);
        // currNode = dummyNode
        ListNode currNode = dummyNode;
        // while (curr1 != null && curr2 != null)
        while (list1 != null && list2 != null) {
            // if (curr1.val <= curr2.val)
            if (list1.val <= list2.val) {
                // currNode.next = curr1
                currNode.next = list1;
                // currNode = curr1
                currNode = list1;
                // curr1 = curr1.next
                list1 = list1.next;
            } else {
                // currNode.next = curr2
                currNode.next = list2;
                // currNode = curr2
                currNode = list2;
                // curr2 = curr2.next
                list2 = list2.next;
            }
        }

        // if (curr1 != null)
        if (list1 != null) {
            // currNode.next = curr1
            currNode.next = list1;
        }
        // if (curr2 != null)
        if (list2 != null) {
            // currNode.next = curr2
            currNode.next = list2;
        }

        // return dummyNode.next
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        System.out.println(mergeTwoLists(list1, list2));
    }
}
