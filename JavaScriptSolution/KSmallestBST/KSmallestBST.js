/*
Given the root of a binary search tree, and an integer k, return the kth smallest value (1-indexed) of all the values of the nodes in the tree.

Example 1:
Input: root = [3,1,4,null,2], k = 1
Output: 1

Example 2:
Input: root = [5,3,6,2,4,null,null,1], k = 3
Output: 3


Constraints:

The number of nodes in the tree is n.
1 <= k <= n <= 104
0 <= Node.val <= 104
*/

var kthSmallest = function(root, k) {
  // create resArr with length of K
  const resArr = [];
  // Create a helper function to perform inOrder traversal
  // inOrderTraverse(root)
  function inOrderTraverse(root) {
      // base case - check if resArr contains k elements
      if (root === null) {
          return;
      }
      // recursive cases
      // inOrderTraverse(root.left)
      inOrderTraverse(root.left);
      // push currNode into resArr
      resArr.push(root.val);
      inOrderTraverse(root.right);
  }

  inOrderTraverse(root);
  // return last element in resArr
  return resArr[k - 1];
};