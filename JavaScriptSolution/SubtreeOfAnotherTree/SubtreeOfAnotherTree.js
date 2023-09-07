/*
Given the roots of two binary trees root and subRoot, return true if there is a subtree of root with
the same structure and node values of subRoot and false otherwise.
A subtree of a binary tree tree is a tree that consists of a node in tree and all of this node's descendants.
The tree tree could also be considered as a subtree of itself.

Example 1:
Input: root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true

Example 2:
Input: root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false

Constraints:

The number of nodes in the root tree is in the range [1, 2000].
The number of nodes in the subRoot tree is in the range [1, 1000].
-104 <= root.val <= 104
-104 <= subRoot.val <= 104
*/

// I: two roots of tree
// O: a boolean value indicating whether the first tree contains the second tree
// E: 1) potential case - two tree are the same
// C: none

function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}

var isSubtree = function(root, subRoot) {
  // base case
  // check if either 1st curr node or 2nd curr node is null
  if (root === null || subRoot === null) {
    // if yes, return 1st curr node === 2nd curr node
    return root === subRoot;
  }

  function isSameTree(root1, root2) {
    if (root1 === null || root2 === null) {
      return root1 === root2;
    }

    if (root1.val !== root2.val) {
      return false;
    }

    return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
  }
  // recursion case
  // check if 1st curr node val === 2nd curr node val
  if (isSameTree(root, subRoot)) {
    return true;
  }
  // if no, check if left child in 1st or right child in 1st are the same as curr node in 2nd
  const isLeftSub = isSubtree(root.left, subRoot);
  const isRightSub = isSubtree(root.right, subRoot);
  return isLeftSub || isRightSub;
};