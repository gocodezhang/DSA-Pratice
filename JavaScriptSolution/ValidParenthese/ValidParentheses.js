/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

Example 1:
Input: s = "()"
Output: true

Example 2:
Input: s = "()[]{}"
Output: true

Example 3:
Input: s = "(]"
Output: false


Constraints:

1 <= s.length <= 104
s consists of parentheses only '()[]{}'.
*/

function isValid(s) {
  const openBrackets = ['(', '[', '{'];
  const closingBrackets = [')', ']', '}']
  // create a stack
  const stack = [];
  // iterate through the input string
  for (let i = 0; i < s.length; i++) {
    const currLetter = s[i];
    const index = openBrackets.indexOf(currLetter);
    // check if curr character belongs to open bracket
    if (index !== -1) {
      // if yes, put into the stack
      stack.push(currLetter);
    } else {
      // otherwise, pop the last item from stack
      const openBracket = stack.pop();
      // check if last item with curr character the same type
      if (openBrackets.indexOf(openBracket) !== closingBrackets.indexOf(currLetter)) {
        // no, return false
        return false;
      }
    }
  }


  // return true
  return stack.length === 0;
}