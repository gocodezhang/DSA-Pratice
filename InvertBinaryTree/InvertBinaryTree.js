/*
Given the root of a binary tree, invert the tree, and return its root.
aka - by inverting, we should transform the binary tree (left small; right large) into another binary tree (left large; right small)
*/

// I: a binary tree (left small; right large)
// O: another binary tree (left large; right small)
// C: none
// E: 1) empty tree 2) tree with only root node


function TreeNode(val, left, right) {
  this.val = (val===undefined ? 0 : val)
  this.left = (left===undefined ? null : left)
  this.right = (right===undefined ? null : right)
}

function invertTree(root) {
  // base case - if value of the node is null, return null
  if (!root) {
    return null;
  }
  // create a new tree with the same root value
  const newNode = new TreeNode(root.val);

  // iterate through the input tree
  // add the left child in input tree as the right child in the new tree
  newNode.right = invertTree(root.left)
  // add the right child in input tree as the left child in the new tree
  newNode.left = invertTree(root.right)
  // return the new tree
  return newNode;
}

