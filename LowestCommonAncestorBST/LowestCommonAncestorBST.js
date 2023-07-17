/*
Given a binary search tree (BST), find the lowest common ancestor (LCA) node of two given nodes in the BST.
According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as
the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

Example 1:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
Output: 6
Explanation: The LCA of nodes 2 and 8 is 6.

Example 2:
Input: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
Output: 2
Explanation: The LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

Example 3:
Input: root = [2,1], p = 2, q = 1
Output: 2

Constraints:

The number of nodes in the tree is in the range [2, 105].
-109 <= Node.val <= 109
All Node.val are unique.
p != q
p and q will exist in the BST.
*/

function TreeNode(val) {
  this.val = val;
  this.left = this.right = null;
}

function lowestCommonAncestor(root, p, q) {
  // Create findPath function (root, node); return the path from root to the node
  function findPath(root, node) {
    // creat a set called Path
    const path = new Set();
    path.add(root);
    // check if curr node val === node.val
    if (root.val === node.val) {
      // return path;
      return path;
    }
    // compare curr node val with node.val
    if (root.val > node.val) {
      // if curr node val > node val
      // findPath on left branch and then concatenate the path with curr Node
      const leftPath = findPath(root.left, node)
      leftPath.forEach((currNode) => {
        path.add(currNode);
      })
    } else {
      // else, findPath on right branch and then concatenate the path with curr Node
      const rightPath = findPath(root.right, node)
      rightPath.forEach((currNode) => {
        path.add(currNode);
      })
    }

    return path;

  }

  // Call findPath(root, q) and findPath(root, p)
  const pathQ = findPath(root, q);
  const pathP = findPath(root, p);

  // Create a variable called LCA
  let LCA;
  // Iterate through pathP
  for (const node of pathQ) {
    // check if curr element exist in pathQ
    if (pathP.has(node)) {
      // if yes, reassign LCA = curr element
      LCA = node;
    }
  }
  // return LCA
  return LCA;
}