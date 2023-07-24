/*
You have a graph of n nodes. You are given an integer n and an array edges where edges[i] = [ai, bi] indicates that there is an edge between ai and bi in the graph.

Return the number of connected components in the graph.



Example 1:


Input: n = 5, edges = [[0,1],[1,2],[3,4]]
Output: 2
Example 2:


Input: n = 5, edges = [[0,1],[1,2],[2,3],[3,4]]
Output: 1


Constraints:

1 <= n <= 2000
1 <= edges.length <= 5000
edges[i].length == 2
0 <= ai <= bi < n
ai != bi
There are no repeated edges.
*/

var countComponents = function(n, edges) {
  // DFS(node)
  function dfs(node) {
      const connection = adj.get(node);
      // base case - length of value in the map === 0
      if (connection.length === 0) {
          // when true, return
          return;
      }

      // base case - if the node is visited
      if (visited.has(node)) {
          return;
      }
      // recursion
      visited.add(node);
      // for every node that curr node is connected
      for (let i = 0; i < connection.length; i++) {
          dfs(connection[i])
      }
  }

  // create a map (key: val node, value: [])
  const adj = new Map();
  for (let i = 0; i < n; i++) {
      adj.set(i, []);
  }
  // Iterate through key in the map
  for (let i = 0; i < edges.length; i++) {
      const edge = edges[i];
      adj.get(edge[0]).push(edge[1])
      adj.get(edge[1]).push(edge[0])
  }


  // Create visited
  let count = 0;
  const visited = new Set();
  // iterate through key in the map
  for (let [node, conn] of adj) {
      // check if curr node is visited
      if (!visited.has(node)) {
          //if no, we perform DFS
          dfs(node)
          // increment # of component
          count = count + 1;
      }
  }

  // return # of component
  return count
};