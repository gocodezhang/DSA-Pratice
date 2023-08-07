/*
Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.

In other words, return true if one of s1's permutations is the substring of s2.



Example 1:

Input: s1 = "ab", s2 = "eidbaooo"
Output: true
Explanation: s2 contains one permutation of s1 ("ba").
Example 2:

Input: s1 = "ab", s2 = "eidboaoo"
Output: false


Constraints:

1 <= s1.length, s2.length <= 104
s1 and s2 consist of lowercase English letters.
*/

var checkInclusion = function(s1, s2) {
  const s1Map = new Map();
  for (const letter of s1) {
      let frequency = s1Map.get(letter) || 0;
      s1Map.set(letter, frequency + 1);
  }
  // Iterate through s2
  for (let i = 0; i < s2.length; i++) {
      // check if curr letter exists in s1
      if (s1.includes(s2[i])) {
          // create allMatch = true
          const s2Map = new Map();
          s2Map.set(s2[i], 1);
          let steps = 1;
          // iterate m - 1 letters after curr letter
          while (steps <= s1.length - 1) {
              // check if each letter also exists in s1
              const currLetter = s2[i + steps];
              let frequency = s2Map.get(currLetter) || 0
              s2Map.set(currLetter, frequency + 1);
              steps = steps + 1;
          }
          // if every letter in this window exists in s1
          let allMatch = true;
          s1Map.forEach((value, key) => {
              if (!s2Map.has(key)) {
                  allMatch = false
              } else if (s2Map.get(key) !== value) {
                  allMatch = false
              }
          })
          if (allMatch) {
              return true;
          }
      }
  }

  // return false
  return false;
};