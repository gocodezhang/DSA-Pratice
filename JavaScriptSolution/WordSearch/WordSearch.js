/*
Design a data structure that supports adding new words and finding if a string matches any previously added string.

Implement the WordDictionary class:

WordDictionary() Initializes the object.
void addWord(word) Adds word to the data structure, it can be matched later.
bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.


Example:

Input
["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
[[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
Output
[null,null,null,null,false,true,true,true]

Explanation
WordDictionary wordDictionary = new WordDictionary();
wordDictionary.addWord("bad");
wordDictionary.addWord("dad");
wordDictionary.addWord("mad");
wordDictionary.search("pad"); // return False
wordDictionary.search("bad"); // return True
wordDictionary.search(".ad"); // return True
wordDictionary.search("b.."); // return True


Constraints:

1 <= word.length <= 25
word in addWord consists of lowercase English letters.
word in search consist of '.' or lowercase English letters.
There will be at most 2 dots in word for search queries.
At most 104 calls will be made to addWord and search.
*/

function triesNode() {
  this.children = {};
  this.isEnd = false;
}

var WordDictionary = function() {
  this.root = new triesNode();
};

/**
* @param {string} word
* @return {void}
*/
WordDictionary.prototype.addWord = function(word) {
  let currNode = this.root;
  for (let i = 0; i < word.length; i++) {
      if (!currNode.children[word[i]]) {
          currNode.children[word[i]] = new triesNode();
      }
      currNode = currNode.children[word[i]]
  }
  currNode.isEnd = true;
};

/**
* @param {string} word
* @return {boolean}
*/
WordDictionary.prototype.search = function(word) {

  function searchInNode(word, node) {
      let currNode = node;
      for (let i = 0; i < word.length; i++) {
          const currLetter = word[i];
          if (currLetter !== '.') {
              if (!currNode.children[word[i]]) {
                  return false
              }
              currNode = currNode.children[word[i]]
          } else {
              for (let letter in currNode.children) {
                  if (searchInNode(word.slice(i + 1), currNode.children[letter])) {
                      return true;
                  }
              }
              return false;
          }
      }
      return currNode.isEnd;
  }
  return searchInNode(word, this.root);

};