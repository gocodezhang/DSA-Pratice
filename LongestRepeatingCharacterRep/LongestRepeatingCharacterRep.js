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
  const frequencyObj = {};
  // iterate through the input string and find unique characters
  for (let i = 0; i < s.length; i++) {
    // check if the current letter exist in the uniqueChar
    const currentLetter = s[i]
    if (frequencyObj[currentLetter]) {
      frequencyObj[currentLetter] = frequencyObj[currentLetter] + 1;
    } else {
      frequencyObj[currentLetter] = 1;
    }
  }

  let maxFrequency = 0;
  let maxLetter = null;
  for (let key in frequencyObj) {
    if (frequencyObj[key] > maxFrequency) {
      maxLetter = key;
      maxFrequency = frequencyObj[key];
    }
  }

  // maxLength
  let maxLength = 0;
  // iterate through the letter with maxFrequency
  for (let j = 0; j < maxFrequency; j++) {
    // left pointer = the initial position
    const leftPointer = s.indexOf(maxLetter, j)
    // right pointer = the position next to the initial position
    let rightPointer = leftPointer + 1;
    // iterate through the right pointer
    let counter = 0;
    let currLength = 1;
    while (rightPointer < s.length && (counter < k || (counter === k && s[rightPointer] === maxLetter))) {
      const currentLetter = s[rightPointer]
      if (currentLetter !== maxLetter) {
        counter++
      }
      currLength++
      // compare the current length with the maxlength
      if (currLength > maxLength) {
        maxLength = currLength;
      }
      rightPointer++;
    }
  }

  // return maxLength
  return maxLength;
}

function characterReplacementLinear(s, k) {
  const frequencyMap = new Map();
  let [left, maxLength] = [0, 0];

  for (let right = 0; right < s.length; right++) {
    const frequency = frequencyMap.get(s[right]) ? frequencyMap.get(s[right]) + 1 : 1;
    frequencyMap.set(s[right], frequency);

    const maxFrequency = Math.max(...frequencyMap.values());

    let windowLength = right - left + 1;
    if (windowLength - maxFrequency > k) {
      const subtract = frequencyMap.get(s[left]) - 1;
      frequencyMap.set(s[left], subtract);
      left++;
      windowLength = right - left + 1;
    }

    if (windowLength > maxLength) {
      maxLength = windowLength;
    }
  }

  return maxLength;
}