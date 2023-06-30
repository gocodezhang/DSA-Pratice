/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.

*/

// I: an array of strings
// 0: an array of arrays - where each array represent a group of anagrams
// C: none
// E: when empty string or single letter, we still consider them anagrams

function groupAnagramsQuadratic(strs) {

  function createWordObj(str) {
    const strObj = {};
    for (let i = 0; i < str.length; i++) {
      const currentLetter = str[i];
      if (!strObj[currentLetter]) {
        strObj[currentLetter] = 1;
      } else {
        strObj[currentLetter] = strObj[currentLetter] + 1;
      }
    }
    return strObj
  }

  function compareObj(obj1, obj2) {
    for (let key in obj1) {
      if (!obj2[key]) {
        return false
      } else {
        if (obj1[key] !== obj2[key]) {
          return false
        }
      }
    }
    return true;
  }

  const copyStrs = strs.slice();
  const resultArr = [];
  // Iterate through the strs array
  for (let i = 0; i < copyStrs.length; i++) {
    // Create obj store the set of letters and times the letter appear in each str
    const anagramArr = [copyStrs[i]];
    const currentWordObj = createWordObj(copyStrs[i])
    // Iterate through the rest of the elements in the array
    for (let j = i + 1; j < copyStrs.length; j++) {
      // Create obj store the set of letters and times the letter appear in each str
      const otherWordObj = createWordObj(copyStrs[j])
      // Compare two objs
      if (compareObj(currentWordObj, otherWordObj)) {
        // if they are the same, put the element into the anagram array; take out the element from strs array
        anagramArr.push(copyStrs[j])
        copyStrs.splice(j, 1)
      }
    }
    resultArr.push(anagramArr);
  }


  // return the result array
  return resultArr;
}

function groupAnagramsLinear(strs) {

  function createHash(str) {
    const tempArr = new Array(26).fill(0);
    for (let i = 0; i < str.length; i++) {
      const currLetter = str[i]
      const index = currLetter.charCodeAt() - 'a'.charCodeAt();
      tempArr[index]++
    }
    return tempArr.join('');
  }

  const storage = new Map();
  // iterate through the strs array
  for (let i = 0; i < strs.length; i++) {
    // for curr str, create a unique hashcode (same for all anagrams)
    const hashcode = createHash(strs[i]);
    // check if the hashcode exist as key in the map
    const value = storage.get(hashcode)
    if (value) {
      // if yes, push the curr str into the value of the key
      value.push(strs[i])
      storage.set(hashcode, value)
    } else {
      // if no, create empty array and push the curr str in there
      const arr = [];
      arr.push(strs[i])
      storage.set(hashcode, arr)
    }
  }
  // return all values in the map obj
  return [...storage.values()];
}

module.exports = {
  groupAnagramsQuadratic,
  groupAnagramsLinear,
}