/*
Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Constraints:

The number of nodes in the tree is in the range [0, 104].
-100 <= Node.val <= 100
*/

// I: a binary tree
// O: a number
// E: none
// C: none

function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}

function maxDepth(root) {
  // base case - when the root is null, return 0;
  if (root === null) {
    return 0;
  }
  // recusion case - call maxDepth on left and right child
  const leftDepth = 1 + maxDepth(root.left)
  const rightDepth = 1 + maxDepth(root.right)
  // find the max between left and right child
  const max = leftDepth >= rightDepth ? leftDepth : rightDepth;
  // return the max
  return max;
}