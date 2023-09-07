/*
You are climbing a staircase. It takes n steps to reach the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?



Example 1:

Input: n = 2
Output: 2
Explanation: There are two ways to climb to the top.
1. 1 step + 1 step
2. 2 steps
Example 2:

Input: n = 3
Output: 3
Explanation: There are three ways to climb to the top.
1. 1 step + 1 step + 1 step
2. 1 step + 2 steps
3. 2 steps + 1 step


Constraints:

1 <= n <= 45
*/

var climbStairs = function(n) {
  // create resArr = []
  const memo = new Map();
  // DFS(steps, distance)
  function dfs(currPosition, distance) {
      // base case - distance === 0
      if (currPosition === distance) {
          return 1
      }
      // base case - distance < 0
      if (currPosition > distance) {
          // return;
          return 0;
      }

      if (memo.has(currPosition)) {
          return memo.get(currPosition);
      }
      // iterate through options
      memo.set(currPosition, dfs(currPosition + 1, distance) + dfs(currPosition + 2, distance))
      return memo.get(currPosition)
  }

  // DFS([], n)
  return dfs(0, n);
};