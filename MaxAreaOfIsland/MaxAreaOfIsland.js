/*
You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

The area of an island is the number of cells with a value 1 in the island.

Return the maximum area of an island in grid. If there is no island, return 0.
*/


var maxAreaOfIsland = function(grid) {
  const directions = {
      up: [ -1, 0],
      down: [1, 0],
      left: [0, -1],
      right: [0, 1],
  }
  // create visited = new Set()
  const visited = new Set();
  // create maxArea = 0
  let maxArea = 0;
  const m = grid.length;
  const n = grid[0].length;
  // for (let i = 0; i < n; i++)
  for (let i = 0; i < m; i++) {
      // for (let j = 0; j < m; j++)
      for (let j = 0; j < n; j++) {
          // check if grid[i][j] === 1
          if (grid[i][j] === 1) {
              //create currArea = 0;
              var currArea = 0;
              // perform DFS(i, j)
              dfs(i, j)
              // check if currArea > maxArea
              if (currArea > maxArea) {
                  // maxArea = currArea
                  maxArea = currArea;
              }

          }
      }
  }

  //dfs(i, j)
  function dfs(i, j) {
      // base case
      // 1. either i >= n or i < 0 || either j >=m or j < 0
      if ((i >= m || i < 0) || (j >= n || j < 0)) {
          // return
          return;
      }
      // grid[i][j] === 0
      if (grid[i][j] === 0) {
          return;
      }
      // visited.has
      if (visited.has(`${i}-${j}`)) {
          return;
      }

      // add curr pos in visited
      visited.add(`${i}-${j}`);
      // currArea++
      currArea++
      // recursive case
      // call dfs on four directions
      for (let dir in directions) {
          const [row, col] = directions[dir];
          dfs(i + row, j + col)
      }
  }

  // return maxArea
  return maxArea

};