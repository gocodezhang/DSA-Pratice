/*
Given an integer array nums, find a
subarray
 that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.



Example 1:

Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
Example 2:

Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.


Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
Accepted
1M
Submissions
3M
Acceptance Rate
34.9%
*/

var maxProduct = function(nums) {
  if (nums.length === 1) {
      return nums[0];
  }

  let minSoFar = nums[0]
  let maxSoFar = nums[0]
  let result = maxSoFar

  for (let i = 1; i < nums.length; i++) {
      const tmp = minSoFar
      minSoFar = Math.min(minSoFar * nums[i], maxSoFar * nums[i], nums[i])
      maxSoFar = Math.max(tmp * nums[i], maxSoFar * nums[i], nums[i])

      result = Math.max(result, maxSoFar);
  }

  return result;
};