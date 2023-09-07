/*
You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.



Example 1:

Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Example 3:

Input: coins = [1], amount = 0
Output: 0


Constraints:

1 <= coins.length <= 12
1 <= coins[i] <= 231 - 1
0 <= amount <= 104
*/

var coinChange = function(coins, amount) {
  // const hashMap = new Map()
  const hashMap = new Map();
  // FindMinCombo(target); return the number of coins in the minimum combo
  function findMinCombo(target) {
      // base case
      // check if target exist in the hashmap
      if (hashMap.has(target)) {
          // when true, return the corresponding value
          return hashMap.get(target);
      }
      // check if (target === 0)
      if (target === 0) {
          // when true, return 0
          return 0;
      }
      // check if (target < 0)
      if (target < 0) {
          // when true, return very large number
          return -1;
      }

      // recursive case
      let min = Infinity;
      // iterate through every elements in coins
      for (let i = 0; i < coins.length; i++) {
          // call FindCombo(target - curr element)
          const temp = findMinCombo(target - coins[i])
          if (temp >= 0 && temp < min) {
              min = temp;
          }
      }
      // return 1 + Min (min)
      hashMap.set(target, 1 + min);
      return hashMap.get(target);
  }

  // return FindMinCombo(amount)
  return findMinCombo(amount) === Infinity ? -1 : findMinCombo(amount);
};