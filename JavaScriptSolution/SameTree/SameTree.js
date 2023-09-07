/*
Given the roots of two binary trees p and q, write a function to check if they are the same or not.
Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.

Example 1:
Input: p = [1,2,3], q = [1,2,3]
Output: true

Example 2:
Input: p = [1,2], q = [1,null,2]
Output: false

Constraints:

The number of nodes in both trees is in the range [0, 100].
-104 <= Node.val <= 104
*/

// I: two roots fo two binary tree
// O: a boolean indicating whether two trees are the same
// E: 1) when two trees are empty, return true
// C: none

function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}

function isSameTree(p, q) {
  // base case - compare the curr node in p and q
  if (p === null || q === null) {
    return p === q;
  }
  if (p.val !== q.val) {
    // if diff, return false
    return false;
  }

  // recursion case - for every child of the curr node
  // call the function on left
  const isLeftSame = isSameTree(p.left, q.left);
  // call the function on right
  const isRightSame = isSameTree(p.right, q.right);


  // return left result && right result
  return isLeftSame && isRightSame;
}