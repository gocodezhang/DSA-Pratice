/*
Given a string s, find the length of the longest substring without repeating characters.

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

// I: a string with characters
// O: a number represent the max length of substring without repeating characters
// E: 1) empty str, return 0
// C: none

function lengthOfLongestSubtring(s) {
  if (s.length === 0) {
    return 0;
  }
  // 1. Create left pointer
  let left = 0;
  // 2. Create currWindow = s[left]; currLength = 1; maxLength = 0;
  let currWindow = new Set();
  currWindow.add(s[left]);
  let currLength = currWindow.size;
  let maxLength = 1;
  // 3. Iterate through str (create right pointer = 1)
  for (let right = 1; right < s.length; right++) {
    const currLetter = s[right];
    // check if curr letter exists in currWindow
    if (!currWindow.has(currLetter)) {
      // if no, add curr letter into currWindow
      currWindow.add(currLetter);
      // increment currLength by 1
      currLength = currWindow.size;
      // check if maxLength < currLength
      if (currLength > maxLength) {
        // reassign
        maxLength = currLength;
      }
    } else {
      // if yes,
      // while currLetter is in currWindow
      while (currWindow.has(currLetter)) {
        // update currWindow
        currWindow.delete(s[left])
        // increment left by 1
        left = left + 1;
      }
      currWindow.add(currLetter);
      currLength = currWindow.size;
      // check if maxLength < currLength
      if (currLength > maxLength) {
        // reassign
        maxLength = currLength
      }
    }
  }
  // 4. return maxLength
  return maxLength;
}