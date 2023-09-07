/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.
Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:

1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
*/

// I: a string
// O: boolean indicating whether the str is palindrome
// E: 1) return true when we have empty string
// C: none

function isPalindrome(s) {
  const regex = /^[a-zA-Z0-9]+$/;
  const regexChat = /^[a-zA-Z]+$/;
  let cleanupStr = '';
  // 1. Convert all uppcase letter (if any) to lowercase letter and Remove anything that is not letters or numbers
  // iterate through the input str
  for (let i = 0; i < s.length; i++) {
    let currLetter = s[i]
    // check if curr letter is character or numbers
    if (regex.test(currLetter)) {
      if (regexChat.test(currLetter)) {
         // convert curr letter to lowercase
        currLetter = currLetter.toLowerCase();
      }
      // add curr letter into cleanupStr
      cleanupStr = cleanupStr + currLetter;
    }
  }
  // 2. Iterate the updated str backward
  // create backStr = '';
  let backStr = '';
  for (let i = cleanupStr.length - 1; i >= 0; i--) {
    // add curr letter into backStr
    backStr = backStr + cleanupStr[i];
  }
  // 3. compare backStr with the updated str
  // check if updatedStr === backStr
  if (backStr === cleanupStr) {
    return true;
  } else {
    return false;
  }
}