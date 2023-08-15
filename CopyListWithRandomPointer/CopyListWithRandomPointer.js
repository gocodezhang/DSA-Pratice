/*

A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.

Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.

For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.

Return the head of the copied linked list.

The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:

val: an integer representing Node.val
random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
Your code will only be given the head of the original linked list.
*/



var copyRandomList = function(head) {
  if (!head) {
      return
  }
  const indexLinkedList = [];
  let currNode = head
  while (currNode !== null) {
      indexLinkedList.push(currNode)
      currNode = currNode.next;
  }

  const copyIndexLinkedList = new Array(indexLinkedList.length).fill(0);
  for (let i = 0; i < indexLinkedList.length; i++) {
      let copyNode;
      const node = indexLinkedList[i];
      const randomNode = node.random;
      if (copyIndexLinkedList[i] === 0) {
          copyNode = new Node(node.val, null, null);
      } else {
          copyNode = copyIndexLinkedList[i];
      }
      copyIndexLinkedList[i] = copyNode

      if (randomNode) {
          const randomIndex = indexLinkedList.indexOf(randomNode);
          const copyRandomNode = copyIndexLinkedList[randomIndex] !== 0 ?
          copyIndexLinkedList[randomIndex] : new Node(randomNode.val, null, null);
          copyNode.random = copyRandomNode;
          copyIndexLinkedList[randomIndex] = copyRandomNode;
      }



      if (i > 0) {
          copyIndexLinkedList[i - 1].next = copyIndexLinkedList[i];
      }
  }

  return copyIndexLinkedList[0];
};

var copyRandomList = function(head) {
  let currNode = head;
  const map = new Map();

  function cloneNode(node) {
      if (node === null) {
          return null;
      }
      if (map.has(node)) {
          return map.get(node);
      }
      const copyNode = new Node(node.val, null, null);
      map.set(node, copyNode);
      return copyNode;
  }
  while (currNode) {
      copyCurrNode = cloneNode(currNode);
      copyCurrNode.next = cloneNode(currNode.next);
      copyCurrNode.random = cloneNode(currNode.random);

      currNode = currNode.next;
  }

  return map.get(head);
};