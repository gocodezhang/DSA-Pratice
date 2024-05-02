import java.util.HashMap;

public class RemoveDuplicatesFromSortedListII {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // dummy Node
        ListNode dummyNode = new ListNode(0);
        // dummy.next = head
        dummyNode.next = head;
        // frequencyMap
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        // while (head.next != null)
        while (head != null) {
            // currFre = frequencyMap.get(head.val, 0)
            int currFrequency = frequencyMap.getOrDefault(head.val, 0);
            // frequenctMap.put(head.val, currFre + 1)
            frequencyMap.put(head.val, currFrequency + 1);
            // head = head.next
            head = head.next;
        }

        // currNode = dummy.next
        ListNode currNode = dummyNode;
        // while (currNode.next != null)
        while (currNode != null && currNode.next != null) {
            // nextValue = currNode.next.val
            int nextVal = currNode.next.val;
            // if (frequencyMap(nextValue) > 1)
            if (frequencyMap.get(nextVal) > 1) {
                // notDuplicatedNode = currNode.next
                ListNode notDuplicated = currNode.next;
                // While (frequencyMap(notDuplicatedNode.val) > 1)
                while (notDuplicated != null && frequencyMap.get(notDuplicated.val) > 1) {
                    // notDuplicatedNode = notDuplicatedNode.next
                    notDuplicated = notDuplicated.next;
                }
                // currNode.next = notDuplicatedNode
                currNode.next = notDuplicated;
            }

            // currNode = currNode.next
            currNode = currNode.next;
        }
        return dummyNode.next;
    }
    public ListNode deleteDuplicatesOnePass(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode prev = sentinel;

        while (head != null) {
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return sentinel.next;
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        node1.next = node2;
        node2.next = node3;
        RemoveDuplicatesFromSortedListII removeDuplicatesFromSortedListII = new RemoveDuplicatesFromSortedListII();
        System.out.println(removeDuplicatesFromSortedListII.deleteDuplicates(node1));
    }
}
