/*
There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.


Constraints:

1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.
*/

var canFinish = function(numCourses, prerequisites) {

  // DFS(node); return boolean
  function dfs(node, visit) {
      // base case - preps of the node is empty
      if (hashMap.get(node).length === 0) {
          return true;
      }
      if (visit.has(node)) {
          return false;
      }
      // mark the node as visited
      visit.add(node);
      // iterate through every node in preps
      for (let i = 0; i < hashMap.get(node).length; i++) {
          //if DFS(node)
          if (!dfs(hashMap.get(node)[i], visit)) {
              return false;
          }

      }
      hashMap.set(node, []);
      return true;

  }

 // 0 - numcourse - 1
 const hashMap = new Map();
  // iterate from 0 to numcourse - 1
  for (let i = 0; i < numCourses; i++) {
      hashMap.set(i, []);
  }

  for (let i = 0; i < prerequisites.length; i++) {
      hashMap.get(prerequisites[i][0]).push(prerequisites[i][1]);
  }

  // iterate thourhg every node
  for (let [node, preps] of hashMap) {
      // curr node
      // DFS - check if we can a courese
      if (!dfs(node, new Set())) {
          return false;
      }
  }
  // return true
  return true;

};