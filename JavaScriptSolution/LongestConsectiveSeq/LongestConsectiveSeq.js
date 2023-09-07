/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.

Example 1:
Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.

Example 2:
Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9

Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
*/

// I: an array of integers
// O: length of the longest consective number sequence
// E: 1) when input array is empty, we return 0
// C: solution should be in linear

function longestConsective(nums) {
  let maxSeqLength = 0;
  // Convert the array into a set
  const numsSet = new Set(nums);
  // Iterate through the nums
  for (let num of numsSet) {
    // at curr num
    // check if curr num - 1 exist in the nums
    if (!numsSet.has(num - 1)) {
      // if no, then we initialize a sequence starting with curr num
      // create currSeqLength = 1
      let currSeqLength = 1;
      // then, we check its consecutive nums exists in nums arr
      // while loop will run as long as curr num + 1 exist
      while (numsSet.has(num + 1)) {
        // currSeqLength++
        currSeqLength++;
        // curr num = curr num + 1
        num = num + 1;
      }
      // if maxLength < currSeqLength, reassign maxLength
      if (maxSeqLength < currSeqLength) {
        maxSeqLength = currSeqLength;
      }
    }
  }
  // return maxLength
  return maxSeqLength;
}