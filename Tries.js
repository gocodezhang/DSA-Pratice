/*
A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings.
There are various applications of this data structure, such as autocomplete and spellchecker.

Implement the Trie class:

Trie() Initializes the trie object.
void insert(String word) Inserts the string word into the trie.
boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.


Example 1:

Input
["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
Output
[null, null, true, false, true, null, true]

Explanation
Trie trie = new Trie();
trie.insert("apple");
trie.search("apple");   // return True
trie.search("app");     // return False
trie.startsWith("app"); // return True
trie.insert("app");
trie.search("app");     // return True


Constraints:

1 <= word.length, prefix.length <= 2000
word and prefix consist only of lowercase English letters.
At most 3 * 104 calls in total will be made to insert, search, and startsWith.
*/

/* standard implementation */

function Trie() {
  this.root = new TrieNode();
}

function TrieNode() {
  this.children = {};
  this.isEnd = false;
}

Trie.prototype.insert = function(word) {
  let currNode = this.root;
  for (let i = 0; i < word.length; i++) {
    const currLetter = word[i];
    if (!currNode[currLetter]) {
      currNode[currLetter] = new TrieNode();
    }
    currNode = currNode[currLetter];
  }
  currNode.isEnd = true;
}

Trie.prototype.search = function(word) {
  let currNode = this.root;
  for (let i = 0; i < word.length; i++) {
    const currLetter = word[i];
    if (!currNode[currLetter]) {
      return false
    }
    currNode = currNode[currLetter];
  }

  return currNode.isEnd;
}

Trie.prototype.startsWith = function(prefix) {
  let currNode = this.root;
  for (let i = 0; i < prefix.length; i++) {
    const currLetter = prefix[i];
    if (!currNode[currLetter]) {
      return false
    }
    currNode = currNode[currLetter];
  }

  return true;
}



/* my implementation */

// var Trie = function(val) {
//   this.val = val;
//   this.children = [];
//   this.isEnd = false;
// };

// Trie.prototype.insert = function(word) {
//   // Create currletter (first letter in word)
//   const currLetter = word[0];
//   // Create nextNode;
//   let nextNode = null;
//   // Iterate through the children
//   for (let i = 0; i < this.children.length; i++) {
//       // check if val of child === currletter
//       if (this.children[i].val === currLetter) {
//           // if true, assign to nextNode
//           nextNode = this.children[i]
//       }
//   }
//   // Check if nextNode is null
//   if (nextNode === null) {
//       // create a node with val = currLetter
//       nextNode = new Trie(currLetter);
//       // Add the node into the children
//       this.children.push(nextNode)
//   }
//   // if word.length === 1
//   if (word.length === 1) {
//     nextNode.isEnd = true;
//     return;
//   }

//   // call insert on the node with word.slice(1)
//   nextNode.insert(word.slice(1));
// };

// Trie.prototype.search = function(word) {
//   const currLetter = word[0];
//   // Iterate through the children
//   for (let i = 0; i < this.children.length; i++) {
//     // Check if child.val === currLetter
//     if (this.children[i].val === currLetter)
//         // if true, check if word.length === 1
//         if (word.length === 1) {
//           // if true, return child.isend
//           return this.children[i].isEnd;
//         } else {
//           // if true, return child.isend
//           // else call search on the node with word.slice(1)
//           return this.children[i].search(word.slice(1))
//         }
//   }
//   // return false
//   return false;
// };


// Trie.prototype.startsWith = function(prefix) {
//   const currLetter = prefix[0];
//   for (let i = 0; i < this.children.length; i++) {
//     if (this.children[i].val === currLetter) {
//       if (prefix.length === 1) {
//         return true;
//       }
//       return this.children[i].startsWith(prefix.slice(1));
//     }
//   }
//   return false;
// };