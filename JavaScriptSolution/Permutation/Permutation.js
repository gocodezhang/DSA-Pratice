/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
*/

var permute = function(nums) {
  // Create resArr [];
  const resArr = [];
  // dfs(currSelection)
  function dfs(currSelection) {
      // base case
      // check if currSelection length === 3
      if (currSelection.length === nums.length) {
          // add currSlection into resArr
          resArr.push(currSelection.slice());
          // return;
          return;
      }

      // recursive case
      // iterate through nums
      for (let i = 0; i < nums.length; i++) {
          // check if curr element exist in selection
          if (!currSelection.includes(nums[i])) {
              // dfs(currSelection.concat(curr element)
              currSelection.push(nums[i])
              dfs(currSelection)
              currSelection.pop();
          }

      }
  }

  // dfs([])
  dfs([]);

  // return resArr;
  return resArr;
};