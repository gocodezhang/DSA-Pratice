/*
Given the head of a singly linked list, reverse the list, and return the reversed list.

Constraints:

The number of nodes in the list is the range [0, 5000].
-5000 <= Node.val <= 5000


Follow up: A linked list can be reversed either iteratively or recursively. Could you implement both?
*/

// I: a singly linked list
// O: a reversed single linked list
// C: none
// E: 1. empty list 2. linked list with length = 1

function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}

function reverseList(head) {
  if (!head) {
    return null;
  }
  let currentNode = head
  let prevNode = null;
  let nextNode = currentNode.next;
  // Iterate through the input linked list by using a while loop (stop when next is null)
  while (currentNode.next) {
    // remove the pointer and point the pointer to the prev node
    currentNode.next = prevNode

    prevNode = currentNode;
    currentNode = nextNode;
    nextNode = currentNode.next;
  }
  currentNode.next = prevNode;

  // return the head
  return currentNode
};

function reverseListRecusion(head) {
  if (!head) {
    return null;
  }

  if (!head.next) {
    return head
  }

  let prev = reverseListRecusion(head.next);
  head.next.next = head;
  head.next = null;

  return prev;
}