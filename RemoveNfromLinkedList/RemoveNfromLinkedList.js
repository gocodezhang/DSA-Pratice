/*
Given the head of a linked list, remove the nth node from the end of the list and return its head.

Example 1:
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]

Example 2:
Input: head = [1], n = 1
Output: []

Example 3:
Input: head = [1,2], n = 1
Output: [1]

Constraints:

The number of nodes in the list is sz.
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz


Follow up: Could you do this in one pass?
*/

function removeNthFromEnd(head) {
    // Helper function to iterate the linked list and return the length
    // listLength(head); return the length
    function listLength(head) {
      // base case - check if head is null
      if (head === null) {
          // return 0
          return 0;
      }
      // recursive case - return 1 + listLength(head.next)
      return 1 + listLength(head.next);
  }
  // call listLength on the input linked list; then use the result - n;
  const length = listLength(head);
  const desiredPos = length - n;

  if (desiredPos === 0) {
      return head.next;
  }
  // create counter = 1; currNode = head;
  let counter = 1;
  let currNode = head;
  // while (counter < desired position)
  while (counter < desiredPos) {
      // currnode = currnode.next
      currNode = currNode.next;
      // counter++
      counter = counter + 1;
  }
  // create nextNode = currnode.next
  const nextNode = currNode.next;
  // currnode.next = nextnode.next
  if (nextNode.next === null) {
      currNode.next = null;
  } else {
      currNode.next = nextNode.next;
      // nextnode.next = null;
      nextNode.next = null;
  }

  // return head
  return head;
}
