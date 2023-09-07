/*
Given an integer array nums, return the length of the longest strictly increasing
subsequence
.



Example 1:

Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.
Example 2:

Input: nums = [0,1,0,3,2,3]
Output: 4
Example 3:

Input: nums = [7,7,7,7,7,7,7]
Output: 1


Constraints:

1 <= nums.length <= 2500
-104 <= nums[i] <= 104
*/
var lengthOfLIS = function(nums) {

  // memo with length the same as nums (-1)
  const memo = new Array(nums.length).fill(-1);
  //dp(i)
  function dp(i) {
      // base case
      // check if i === 0
      if (i === 0) {
          return 1;
      }
      // check if memo[i] !== -1
      if (memo[i] !== -1) {
          // return memo[i]
          return memo[i];
      }

      // recursive case
      let max = 1;
      // for every element before i
      for (let j = 0; j < i; j++) {
          // check if curr element < element i
          if (nums[j] < nums[i]) {
              // if 1 + dp(j) > max
              const temp = 1 + dp(j)
              if (temp > max) {
                  // reassign
                  max = temp;
              }
          }
      }
      // memo[i] = max
      memo[i] = max;
      // return max
      return max
  }

  let globalMax = 0;
  for (let i = 0; i < nums.length; i++) {
      if (dp(i) > globalMax) {
          globalMax = dp(i)
      }
  }
  return globalMax;
};