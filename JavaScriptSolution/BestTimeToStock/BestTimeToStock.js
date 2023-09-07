/*
You are given an array prices where prices[i] is the price of a given stock on the ith day.
You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

Example 1:
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Example 2:
Input: prices = [7,6,4,3,1]
Output: 0
Explanation: In this case, no transactions are done and the max profit = 0.


Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
*/

// I: an array where each element represent stock price and index represent the time
// O: a number representing the max profit
// C: none
// E: 1) cannot make any profit 2) array length is 0 or 1

function maxProfit(prices) {
  let maxDiff = 0;
  // iterate through all elements in prices using a loop
  for (let i = 0; i < prices.length; i++) {
    // iterate through all elements to the right of the current element
    for (let j = i + 1; j < prices.length; j++) {
      // compute the difference between two numbers (currentDiscrepancy)
      const currentDiff = prices[j] - prices[i]
      // if it is larger than the max difference, then reassign current to the max
      if (currentDiff > maxDiff) {
        maxDiff = currentDiff
      }
    }
  }

  // return the max
  return maxDiff;
}

function maxProfitLinear(prices) {
  let left = 0;
  let right = 1;
  let max = 0;

  for (let i = 0; i < prices.length; i++) {
    const currDiff = prices[right] - prices[left]
    if (currDiff < 0) {
      left++;
      right++;
    } else {
      max = currDiff > max ? currDiff : max;
      right++;
    }
  }

  return max;
}