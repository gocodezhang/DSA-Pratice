/*
You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.



Example 1:

Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 105

*/
var canJump = function(nums) {
  // create array with length of nums, fill with -1
  const memo = new Array(nums.length).fill(-1);
  //dp(i); return boolean
  function dp(i) {
      // base case
      // if (i === nums.length - 1)
      if (i >= nums.length - 1) {
          // return true
          return true;
      }
      // if (nums[i] === 0)
      if (nums[i] === 0) {
          // return false
          return false;
      }
      // if memo[i] !== -1
      if (memo[i] !== -1) {
          return memo[i]
      }

      // recursive case
      // for every j between 1 and nums[i],
      for (let j = 1; j <= nums[i]; j++) {
          // if dp(i + j)
          if (dp(i + j)) {
              // memo[i] = true;
              memo[i] = true;
              // return true
              return true;
          }
      }
      // memo[i] = false;
      memo[i] = false;
      // return false;
      return false;
  }

  return dp(0);
};