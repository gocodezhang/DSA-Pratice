/*
You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000
*/

// I: head of a linked list
// O: return head of a linked list in a specific order
// C: none
// E: none

function reorderList(head) {
  // 1. Split the link list into half
  // Create two pointer 1. slow pointer (one step) 2. fast pointer (two steps)
  let slowPointer = head;
  let fastPointer = head;
  // two pointer traverse at the starting position
  while (fastPointer !== null) {
    slowPointer = slowPointer.next;
    fastPointer = fastPointer.next;
    if (fastPointer !== null) {
      fastPointer = fastPointer.next;
    }
  }
  // when fast pointer reach the end (reach null), slow pointer should reach the mid point


  // 2. Reverse the second half of the link list
  function reverseList(head) {
    // Create prev, curr, next
    let prev = null;
    let curr = head;
    let next = null;
    // iterate through the second half
    while (curr !== null) {
      next = curr.next;
      // point curr.next to prev
      curr.next = prev

      prev = curr;
      curr = next;
    }

    // return the reverse list
    return prev;
  }

  let reverseSecondHalf = reverseList(slowPointer);

  // 3. Merge the first half with the second half
  let firstHalf = head;
  // iterate through both half
  while (firstHalf !== null && reverseSecondHalf !==null) {
    const nextNodeInFirst = firstHalf.next;
    // point curr node in 1st half to curr node in 2nd half
    firstHalf.next = reverseSecondHalf;
    // point curr node in 2nd half to the next node in 1st half
    const nextNodeInSecond = reverseSecondHalf.next;
    reverseSecondHalf.next = nextNodeInFirst;

    firstHalf = nextNodeInFirst;
    reverseSecondHalf = nextNodeInSecond;
  }
  if (firstHalf !== null) {
    firstHalf.next = null;
  }

  return head;
}