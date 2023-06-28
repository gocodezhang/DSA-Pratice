/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.
An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false


Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case? */

// I: two strings with only lowercase letters
// O: a boolean
// C: none
// E: two empty strings

function isAnagram(s, t) {

  function LetterObj(str) {
    // Create a obj to store letters and number of time each letter appear
    const obj = {}
    // iterate through a string
    for (let i = 0; i < str.length; i++) {
      // Check if the letter exist
      const currentLetter = str[i];
      if (!obj[currentLetter]) {
        // If no, initial the key-value pair
        obj[currentLetter] = 1;
      } else {
        // otherwise, increase the count the letter appears
        obj[currentLetter] = obj[currentLetter] + 1;
      }
    }
    return obj;
  }

  const objS = LetterObj(s);
  const objT = LetterObj(t);

  // Compare obj1 with obj2 to see
  for (let key in objS) {
    // 1) if they have the same keys 2)
    if (!objT[key]) {
      return false;
    } else {
      // 2) if the values of the same key are equal
      if (objS[key] !== objT[key]) {
        return false;
      }
    }
  }

  return true;
}

module.exports = isAnagram;