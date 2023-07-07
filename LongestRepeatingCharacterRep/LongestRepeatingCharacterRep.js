/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
You can perform this operation at most k times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achive this answer too.


Constraints:

1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

// I: a string with all uppercase letters, an integer k
// O: length of the longest substring with the same letter after at most k times operations
// E: none
// C: none

function characterReplacement(s, k) {
  // frequencyObj {}
  // iterate through the input string and find unique characters
    // check if the current letter exist in the uniqueChar
      // if yes, increment the current value by 1
      // if no, inital the key and assign the value = 1

  // find the letter with highest frequcny
  // find the potential positions that we can make change to (find letters other than the letter with highest frequency) (M)
  // exhaust K / M combination and check if that give us the longest substring

  // return the length of the longest substring
}