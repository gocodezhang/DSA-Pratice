/*

Given a string s, return the number of palindromic substrings in it.

A string is a palindrome when it reads the same backward as forward.

A substring is a contiguous sequence of characters within the string.



Example 1:

Input: s = "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".
Example 2:

Input: s = "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".


Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.
*/

var countSubstrings = function(s) {
  // Create a count to track # of PD
  let count = 0;
  // Create a helper function to mutate count
  // expand(left, right)
  function expand(left, right) {
      // check if s[left] !== s[right]
      if (s[left] !== s[right]) {
          // when true, return
          return;
      }
      // increment the count by 1
      count = count + 1;
      // while 1. left -1 and right + 1 are in bound
      while (left - 1 >= 0 && right + 1 <= s.length - 1 && s[left - 1] === s[right + 1]) {
          // increment the count by 1 again
          count = count + 1;
          left = left - 1;
          right = right + 1;
      }
  }

  // iterate through every position
  for (let i = 0; i < s.length; i++) {
      // call expand(i, i) + expand(i, i + 1)
      expand(i, i)
      expand(i, i + 1);
  }

  // return the count
  return count;
};