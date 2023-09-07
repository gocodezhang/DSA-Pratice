/*
You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].
*/

var jump = function(nums) {
  // let endPointer = n - 1;
  let endPointer = nums.length - 1;
  // let steps = 0;
  let steps = 0;
  // while (endPointer !== 0)
  while (endPointer !==0) {
      // furthestPos;
      let furthestPos
      //for (let i = endPointer - 1; i >=0; i--)
      for (let i = endPointer - 1; i >= 0; i--) {
          // check if i + nums[i] >= endPointer
          if (i + nums[i] >= endPointer) {
              // if yes, furthestPos = i
              furthestPos = i
          }

      }
      // endPointer = furthestPos
      endPointer = furthestPos
      // steps++
      steps++
  }

  // return steps
  return steps;
};

var jump = function(nums) {
  let steps = 0;
  let left = 0;
  let right = 0;
  while (right < nums.length - 1) {
      let furthestPos = 0;
      for (let i = left; i <= right; i++) {
          furthestPos = Math.max(furthestPos, i + nums[i])
      }
      left = right + 1;
      right = furthestPos;
      steps += 1;
  }
  return steps;
};