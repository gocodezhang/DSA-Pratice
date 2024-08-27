import java.util.ArrayList;
import java.util.List;

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // turn the list into an array
        ListNode currNode = head;
        List<ListNode> nodes = new ArrayList<>();
        while (currNode != null) {
            nodes.add(currNode);
            ListNode prevNode = currNode;
            currNode = currNode.next;
            prevNode.next = null;
        }
        // perform merge sort in the array
        mergeSort(nodes, 0, nodes.size() - 1);
        // re-link the linklist
        ListNode newHead = nodes.get(0);
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        return newHead;
    }
    private void mergeSort(List<ListNode> nodes, int left, int right) {
        // base case
        if (left == right) {
            return;
        }
        if (left - right == 1) {
            if (nodes.get(left).val > nodes.get(right).val) {
                ListNode temp = nodes.get(left);
                nodes.set(left, nodes.get(right));
                nodes.set(right, temp);
            }
            return;
        }
        // recursive case
        int mid = (left + right) / 2;
        mergeSort(nodes, left, mid);
        mergeSort(nodes, mid + 1, right);

        ListNode[] tempNodes = new ListNode[right - left + 1];
        int leftPointer = left;
        int rightPointer = mid + 1;
        int index = 0;
        while (leftPointer <= mid && rightPointer <= right) {
            if (nodes.get(leftPointer).val < nodes.get(rightPointer).val) {
                tempNodes[index] = nodes.get(leftPointer);
                leftPointer++;
            } else {
                tempNodes[index] = nodes.get(rightPointer);
                rightPointer++;
            }
            index++;
        }
        while (leftPointer <= mid) {
            tempNodes[index] = nodes.get(leftPointer);
            leftPointer++;
            index++;
        }
        while (rightPointer <= right) {
            tempNodes[index] = nodes.get(rightPointer);
            rightPointer++;
            index++;
        }
        for (int i = 0; i < tempNodes.length; i++) {
            nodes.set(i + left, tempNodes[i]);
        }
    }
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node4.next = node2;
        node2.next = node1;
        node1.next = node3;
        SortList sortList = new SortList();
        ListNode head = sortList.sortList(node4);
        System.out.println(head);
    }
}
