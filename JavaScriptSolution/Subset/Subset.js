/*
Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]


Constraints:

1 <= nums.length <= 10
-10 <= nums[i] <= 10
All the numbers of nums are unique.
*/

var subsets = function(nums) {
  // create resArr [[]]
  const resArr = [[]];
  // dfs(currIndex, currSet)
  function dfs(currIndex, currSet) {
      // base case
      // check if currIndex === nums.length - 1
      if (currIndex === nums.length - 1) {
          // if yes, add currSet into resArr
          resArr.push(currSet.slice());
          // return;
          return;
      }

      // add the currSet into resArr
      resArr.push(currSet.slice());
      // recursive case
      // iterate through elements after currIndex
      for (let j = currIndex + 1; j < nums.length; j++) {
          dfs(j, currSet.concat(nums[j]))
      };
  };

  // call every possible index, add corresponding element in currSet
  for (let i = 0; i < nums.length; i++) {
      //dfs(i, [nums[i]])
      dfs(i, [[nums[i]]])
  }


  // return resArr
  return resArr;
};