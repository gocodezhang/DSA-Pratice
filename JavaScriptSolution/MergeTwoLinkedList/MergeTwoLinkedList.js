/*
You are given the heads of two sorted linked lists list1 and list2.
Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
Return the head of the merged linked list.

Example 1:
Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:
Input: list1 = [], list2 = []
Output: []

Example 3:
Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
-100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.
*/

// singly linked list
// I: two sorted linked lists
// O: one sorted linked list combining the two input (sort: smallest -> largest; keep all elements in lists even if they are the same)
// C: none
// E: 1) two empty linked list - return empty linked list as the output

function ListNode(val, next) {
  this.val = (val===undefined ? 0 : val)
  this.next = (next===undefined ? null : next)
}

function mergeTwoLists(list1, list2) {
  let head = new ListNode(1);
  let tail = new ListNode(2);
  head.next = tail;
  // iterate through both lists
  while (list1 && list2) {
    // compare node1 from list1 with node2 from list2
    if (list1.val < list2.val) {
      // if node1 < node2
      //add node1 into the result list and move forward for list1
      tail.next = list1;
      tail = tail.next;
      list1 = list1.next
    } else if (list1.val > list2.val) {
      // if node1 > node2
      // add node2 into the result list and move forward for list2
      tail.next = list2;
      tail = tail.next;
      list2 = list2.next
    } else {
      // node1 = node2, add both nodes into the result list and move forward on both lists
      tail.next = list1;
      list1 = list1.next
      tail.next.next = list2;
      tail = tail.next.next;
      list2 = list2.next
    }
  }

  // check if either list1 or list2 has remaing nodes
  if (list1) {
    // if yes, continue to iterate through the remaing nodes
    while (list1) {
      // add the nodes directly into the result list
      tail.next = list1;
      tail = tail.next;
      list1 = list1.next;
    }
  }

  // check if either list1 or list2 has remaing nodes
  if (list2) {
    // if yes, continue to iterate through the remaing nodes
    while (list2) {
      // add the nodes directly into the result list
      tail.next = list2;
      tail = tail.next;
      list2 = list2.next;
    }
  }

  // return the result list
  head = head.next.next
  return head;
}

module.exports = mergeTwoLists;