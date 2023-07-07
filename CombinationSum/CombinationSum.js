/*
Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates
where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []

Constraints:

1 <= candidates.length <= 30
2 <= candidates[i] <= 40
All elements of candidates are distinct.
1 <= target <= 40
*/

// I: an array of numbers, a target
// O: an array of arrays where each array represent a combination that sum up to the target
// C: none
// E: 1) when no solutions, return [];

function combinationSum(candidates, target) {
  // create resultArr
  const resultArr = [];
  // create codeArr
  const codeArr = [];
  // create helper function to try all combo
  // comboSum (currSum, currCombo)
  function comboSum(currSum, currCombo) {
    // compare currSum with target
    // if equal, then we push currCombo into resultArr and return
    if (currSum === target) {
      const code = new Array(candidates.length).fill(0);
      currCombo.forEach((element) => {
        code[candidates.indexOf(element)] = code[candidates.indexOf(element)] + 1
      })
      const codeStr = code.join('');
      if (!codeArr.includes(codeStr)) {
        codeArr.push(codeStr);
        resultArr.push(currCombo);
      }
      return;
    }
    // if larger than target, return
    if (currSum > target) {
      return;
    }
    // pick all options from candidates arr and construct new currCombo and currSum
    candidates.forEach((element) => {
      // recusively call comboSum
      comboSum(currSum + element, currCombo.concat(element))
    })
  }

  comboSum(0, []);

  // return resultArr
  return resultArr;
}