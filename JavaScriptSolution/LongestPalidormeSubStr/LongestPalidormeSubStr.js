/*
Given a string s, return the longest
palindromic

substring
 in s.



Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"


Constraints:

1 <= s.length <= 1000
s consist of only digits and English letters.
*/

var longestPalindrome = function(s) {

  function expand(c1, c2) {
      if (s[c1] !== s[c2]) {
          return;
      }
      while (c1 - 1 >= 0 && c2 + 1 <= s.length - 1 && s[c1 - 1] === s[c2 + 1]) {
          c1 = c1 - 1;
          c2 = c2 + 1;
      }

      if (length < (c2 - c1 + 1)) {
          length = c2 - c1 + 1;
          left = c1;
          right = c2;
      }
  }
  let length = 0;
  let left = 0;
  let right = 0;
  for (let i = 0; i < s.length; i++) {
      expand(i, i + 1)
      expand(i, i)
  }

  return s.substring(left, right + 1)
};