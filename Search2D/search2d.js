/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.

You must write a solution in O(log(m * n)) time complexity.



Example 1:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
Example 2:


Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
Output: false


Constraints:

m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-104 <= matrix[i][j], target <= 104
*/

var searchMatrix = function(matrix, target) {
  const m = matrix.length;
  const n = matrix[0].length;
  // create left = 0, right = m x n - 1
  let left = 0;
  let right = m*n - 1
  // while (left <= right)
  while (left <= right) {
      // calculate the mid = round up (left + right) / 2
      const mid = Math.ceil((left + right) / 2)
      // call convert(mid); midValue = matrix[row][col]
      const [row, col] = convert(mid);
      // check if midValue === target
      if (matrix[row][col] === target) {
          // when true, return true
          return true;
      }
      // check if midValue > target
      if (matrix[row][col] > target) {
          // when true, update right = mid - 1
          right = mid - 1;
      } else {
          // when false, update left = mid + 1
          left = mid + 1;
      }

  }

  // return false
  return false;

  // create helper function - convert(interger); return [row, col]
  function convert(i) {
      // interger / n
      const quotient = Math.floor(i / n)
      const remainder = i % n;
      // return [quotient, remainder]
      return [quotient, remainder];
  }

};