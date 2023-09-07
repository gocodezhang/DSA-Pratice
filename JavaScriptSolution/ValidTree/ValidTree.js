/*
You have a graph of n nodes labeled from 0 to n - 1. You are given an integer n and a list of edges where edges[i] = [ai, bi] indicates that there is an undirected edge between nodes ai and bi in the graph.
Return true if the edges of the given graph make up a valid tree, and false otherwise.

Example 1:
Input: n = 5, edges = [[0,1],[0,2],[0,3],[1,4]]
Output: true

Example 2:
Input: n = 5, edges = [[0,1],[1,2],[2,3],[1,3],[1,4]]
Output: false


Constraints:

1 <= n <= 2000
0 <= edges.length <= 5000
edges[i].length == 2
0 <= ai, bi < n
ai != bi
There are no self-loops or repeated edges.
*/

var validTree = function(n, edges) {
  // DFS(currNode, prevNode)
  function dfs(currNode, prevNode) {
      const connected = adjList.get(currNode);
      // base case
      if (connected.length === 0) {
          return false;
      }
      if (visited.has(currNode)) {
          return false;
      }
      // check if connect of curr node contains only prevNode
      visited.add(currNode);
      // for every connected node
      for (let i = 0; i < connected.length; i++) {
          // check if DFS on the node (excepte for the prevNode) return flase
          if (connected[i] !== prevNode) {
              if (!dfs(connected[i], currNode)) {
                  return false;
              }
          }
      }
      // return true
      return true;
  }

  if (n === 1) {
      return true;
  }

  // create a map for the graph (key: node, val: [])
  const adjList = new Map();
  for (let i = 0; i < n; i++) {
      adjList.set(i, []);
  }
  // iterate through the edges
  for (let i = 0; i < edges.length; i++) {
      const edge = edges[i]
      // get the first node and add the second node in its list
      adjList.get(edge[0]).push(edge[1]);
      // get the second node and add the first node in its list
      adjList.get(edge[1]).push(edge[0]);
  }


  // Create visit []
  const visited = new Set();
  // DFS on node 0
  const dfsResult = dfs(0, null)
  // check if visit has all nodes (visit.size === n)
  if (!dfsResult) {
      return false;
  }

  return visited.size === n;

};