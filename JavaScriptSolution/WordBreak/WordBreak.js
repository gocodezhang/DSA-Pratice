/*
Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.

Note that the same word in the dictionary may be reused multiple times in the segmentation.



Example 1:

Input: s = "leetcode", wordDict = ["leet","code"]
Output: true
Explanation: Return true because "leetcode" can be segmented as "leet code".
Example 2:

Input: s = "applepenapple", wordDict = ["apple","pen"]
Output: true
Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
Note that you are allowed to reuse a dictionary word.
Example 3:

Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
Output: false


Constraints:

1 <= s.length <= 300
1 <= wordDict.length <= 1000
1 <= wordDict[i].length <= 20
s and wordDict[i] consist of only lowercase English letters.
All the strings of wordDict are unique.
*/

var wordBreak = function(s, wordDict) {
  const memo = new Array(s.length).fill(-1)
  function dp(i) {
      if (i > s.length - 1) {
          return true
      }
      if (memo[i] !== -1) {
          return memo[i]
      }

      for (let index = 0; index < wordDict.length; index++) {
          const word = wordDict[index];
          if (s.substring(i, word.length + i) === word && dp(word.length + i)) {
              memo[i] = true;
              return true
          }
      }
      memo[i] = false;
      return false
  }

  return dp(0);

};