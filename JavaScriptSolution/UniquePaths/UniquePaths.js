/*
There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.



Example 1:


Input: m = 3, n = 7
Output: 28
Example 2:

Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down


Constraints:

1 <= m, n <= 100
*/
var uniquePaths = function(m, n) {
  // memo - an array with m elements, each element is an array of n
  const memo = [];
  for (let i = 0; i < m; i++) {
      const arr = new Array(n).fill(-1);
      memo.push(arr);
  }
  // create dp(i, j) = dp(i + 1, j) + dp(i, j + 1)
  // input: i, j, output: # of unique path from (i, j) to destination
  function dp(i, j) {
      // base case
      // check if i >= m
      if (i >= m) {
          // if yes, return 0
          return 0;
      }
      // check if j >= n
      if (j >= n) {
          // if yes, return 0
          return 0;
      }
      // check if i = m - 1 and j = n - 1
      if (i === m - 1 && j === n - 1) {
          // if yes, return 1
          return 1
      }
      // check if memo[i][j] exists
      if (memo[i][j] !== -1) {
          // return memo[i][j]
          return memo[i][j]
      }

      // recursive case
      // return dp(i + 1, j) + dp(i, j + 1)
      const result = dp(i + 1, j) + dp(i, j + 1);
      memo[i][j] = result;
      return result;
  }


  // dp(0,0)
  return dp(0, 0);

};