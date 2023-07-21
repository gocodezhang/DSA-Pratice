/*
Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
You may assume all four edges of the grid are all surrounded by water.

Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3


Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] is '0' or '1'.
*/

var numIslands = function(grid) {
  // adjacantSearch(currPosition)
  const m = grid.length;
  const n = grid[0].length;
  function adjacantSearch(currPosition) {
      const [x, y] = currPosition;

      // try four directions (up, down, left, right)
      const options = {
          up: [x, y - 1],
          down: [x, y + 1],
          left: [x - 1, y],
          right: [x + 1, y],
      }
      for (let dir in options) {
          // check if position in the direction === 1
          const [horIndex, vertIndex] = options[dir];
          if (grid[vertIndex] && grid[vertIndex][horIndex] === '1') {
              grid[vertIndex][horIndex] = '0';
              adjacantSearch([horIndex, vertIndex])
          }
      }

      // return;
      return;
  }
  let counter = 0;
  // create two for loops to iterate through the matrix
  for (let vIndex = 0; vIndex < m; vIndex++) {
      for (let hIndex = 0; hIndex < n; hIndex++) {
          // check if curr position === "1"
          if (grid[vIndex][hIndex] === '1') {
              counter++
              grid[vIndex][hIndex] = '0';
              // create a helper function to search adj "1"
              adjacantSearch([hIndex, vIndex])
          }
      }
  }

  return counter;

};