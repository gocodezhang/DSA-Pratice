/*
Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.



Example 1:

Input: n = 3
Output: ["((()))","(()())","(())()","()(())","()()()"]
Example 2:

Input: n = 1
Output: ["()"]


Constraints:

1 <= n <= 8
*/

var generateParenthesis = function(n) {
  // resArr = []
  const resArr = [];
  const currStack = [')'];

  // DFS(currStr, currStack, n)
  function dfs(currStr, currStack, numberOfLeft) {
      // base case
      // check if (n === 3)
      if (numberOfLeft === n) {
          // pop things in the stack
          const copyStack = currStack.slice()
          while (copyStack.length !== 0) {
              // add into currStr
              currStr = currStr + copyStack.pop()
          }
          // add currStr into resArr
          resArr.push(currStr)
          return;
      }

      // recursive base
      // dfs(currStr + '(', currStack.concat(')'), n + 1)
      currStack.push(')');
      dfs(currStr + '(', currStack, numberOfLeft + 1)
      currStack.pop();
      // if currStack is not empty
      if (currStack.length !== 0) {
          const right = currStack.pop()
          dfs(currStr + right, currStack, numberOfLeft)
          currStack.push(right);
      }
  }

  dfs('(', currStack, 1)
  // return resArr
  return resArr;
};