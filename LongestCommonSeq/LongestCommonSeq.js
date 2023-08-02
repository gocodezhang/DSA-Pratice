/*
Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.

A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

For example, "ace" is a subsequence of "abcde".
A common subsequence of two strings is a subsequence that is common to both strings.



Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.


Constraints:

1 <= text1.length, text2.length <= 1000
text1 and text2 consist of only lowercase English characters.
*/

var longestCommonSubsequence = function(text1, text2) {
  // create memo - an array with length S1, each element will be an array with S2
  const memo = [];
  for (let i = 0; i < text1.length; i++) {
      const arr = new Array(text2.length).fill(-1);
      memo.push(arr);
  }
  // dp(i, j); return length of longest common subseq starting from i, j
  function dp(i, j) {
      // base case
      // check if (i === s1 - 1 && j === s2 - 1)
      if (i > text1.length - 1 || j > text2.length - 1) {
          return 0;
      }
      if (i === text1.length - 1 && j === text2.length - 1) {
          // when true, check if i element === j element
          if (text1[i] === text2[j]) {
              // when ture, return 1
              return 1
          } else {
              // otherwise, return 0
              return 0
          }
      }
      // check if memo contains result
      if (memo[i][j] !== -1) {
          // when true, return result from memo
          return memo[i][j]
      }

      // recursive case
      // check if i element === j element
      let result;
      if (text1[i] === text2[j]) {
          result = 1 + dp(i + 1, j + 1)
      } else {
          result = Math.max(dp(i, j + 1), dp(i + 1, j))
      }
      // cache result into memo
      memo[i][j] = result;
      // return result
      return result;
  }

  // dp(0, 0)
  return dp(0, 0)
};