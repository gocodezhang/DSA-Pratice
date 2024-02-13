public class AddTwoNumbers {
    public static ListNode add(ListNode l1, ListNode l2) {
        // create dummyNode
        ListNode dummyNode = new ListNode(-1);
        // prev = dummyNode
        ListNode prev = dummyNode;
        // carry = 0
        int carry = 0;
        // while (list1 != null && list2 != null)
        while (l1 != null && l2 != null) {
            // sum = list1.val + list2.val + carry
            int sum = l1.val + l2.val + carry;
            // currDigit = sum >= 10 ? sum - 10 : sum
            int currDigit = sum >= 10 ? sum - 10 : sum;
            // carry = sum >= 10 ? 1 : 0
            carry = sum >= 10 ? 1 : 0;
            // currNode = new ListNode(currDigit)
            ListNode currNode = new ListNode(currDigit);
            // prev.next = currNode
            prev.next = currNode;
            // prev = currNode
            prev = currNode;
            // list1 = list1.next
            l1 = l1.next;
            // list2 = list2.next
            l2 = l2.next;
        }

        // while (list1.val != null)
        while (l1 != null) {
            int sum = l1.val + carry;
            int currDigit = sum >= 10 ? sum - 10 : sum;
            carry = sum >= 10 ? 1 : 0;
            ListNode currNode = new ListNode(currDigit);
            // prev.next = currNode
            prev.next = currNode;
            // prev = currNode
            prev = currNode;
            // list1 = list1.next
            l1 = l1.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;
            int currDigit = sum >= 10 ? sum - 10 : sum;
            carry = sum >= 10 ? 1 : 0;
            ListNode currNode = new ListNode(currDigit);
            // prev.next = currNode
            prev.next = currNode;
            // prev = currNode
            prev = currNode;
            // list1 = list1.next
            l2 = l2.next;
        }

        if (carry == 1) {
            prev.next = new ListNode(carry);
        }

        // return dummyNode.next
        return dummyNode.next;
    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(add(l1, l2));
    }
}
