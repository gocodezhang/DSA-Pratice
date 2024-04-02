import java.util.HashMap;

public class CopyListWithRandomPointer {
    public LinkedListNodeWithRandomPointer copyRandomList(LinkedListNodeWithRandomPointer head) {
        // dummyNode = new Node(0)
        LinkedListNodeWithRandomPointer dummyNode = new LinkedListNodeWithRandomPointer(0);
        LinkedListNodeWithRandomPointer prevNode = dummyNode;
        // mapping<originalNode, newNode>
        HashMap<LinkedListNodeWithRandomPointer, LinkedListNodeWithRandomPointer> mapping = new HashMap<>();

        // originalListHead = head
        LinkedListNodeWithRandomPointer originalListHead = head;
        // while (head != null)
        while (head != null) {
            // copyNode = new Node(head.val)
            LinkedListNodeWithRandomPointer copyNode = new LinkedListNodeWithRandomPointer(head.val);
            prevNode.next = copyNode;
            // mapping.put(head, copyNode)
            mapping.put(head, copyNode);
            // head = head.next
            head = head.next;
            prevNode = prevNode.next;
        }

        head = originalListHead;
        while (head != null) {
            // copyNode = mapping.get(head)
            if (head.random == null) {
                head = head.next;
                continue;
            }
            LinkedListNodeWithRandomPointer copyNode = mapping.get(head);
            // randomNode = mapping.get(head.random)
            LinkedListNodeWithRandomPointer copyRandomNode = mapping.get(head.random);
            // copyNode.random = randomNode
            copyNode.random = copyRandomNode;
            // head = head.next
            head = head.next;
        }
        return dummyNode.next;
    }
    public static void main(String[] args) {
        LinkedListNodeWithRandomPointer head = new LinkedListNodeWithRandomPointer(1);
        LinkedListNodeWithRandomPointer node2 = new LinkedListNodeWithRandomPointer(2);
        head.next = node2;
        head.random = node2;
        node2.random = node2;
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        System.out.println(copyListWithRandomPointer.copyRandomList(head));
    }
}
