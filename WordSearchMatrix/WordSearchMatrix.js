/*
Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.



Example 1:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true
Example 2:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true
Example 3:


Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false


Constraints:

m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board and word consists of only lowercase and uppercase English letters.
*/

// var exist = function(board, word) {
//   // create firstLetter (str); possiblePos = [];
//   const firstLetter = word[0];
//   const possiblePos = [];
//   // Iterate through board
//   board.forEach((row, vertIndex) => {
//       // curr arr represent a row
//       // find the index of the firstLetter in curr row
//       const horIndice = row.reduce((accum, curr, index) => {
//           if (curr === firstLetter) {
//               return accum.concat(index);
//           }
//           return accum;
//       },[])
//       if (horIndice.length > 0) {
//           // if exist, [index, i] push into possible Pos
//           horIndice.forEach((horIndex) => {
//               possiblePos.push([horIndex, vertIndex]);
//           })
//       }
//   })

//   // Create a helper to traverse the board
//   // boardTraversal(currPos, word); return a boolean
//   function boardTraversal(currPos, word) {
//       // base case - word.lenght === 0, return true
//       if (word.length === 0) {
//           return true;
//       }
//       const [horIndex, vertIndex] = currPos;
//       if (horIndex < 0 || horIndex > board[0].length - 1) {
//         return false;
//       }
//       if (vertIndex < 0 || vertIndex > board.length - 1) {
//         return false;
//       }
//       if (board[vertIndex][horIndex] !== word[0]) {
//         return false;
//       }

//       board[vertIndex][horIndex] = '*';
//       const options = {
//         up: [horIndex, vertIndex + 1],
//         down: [horIndex, vertIndex - 1],
//         left: [horIndex - 1, vertIndex],
//         right: [horIndex + 1, vertIndex],
//       }

//       for (let dir in options) {
//         if (boardTraversal(options[dir], word.slice(1))) {
//           return true;
//         }
//       }

//       board[vertIndex][horIndex] = word[0];

//       return false;
//   }

//   // Iterate through possible pos
//   for (let i = 0; i < possiblePos.length; i++) {
//       // call boardTraversal with curr posistion
//       if (boardTraversal(possiblePos[i], word.slice(1))) {
//           return true;
//       }
//   }


//   // return false;
//   return false;

// };

var exist = function(board, word) {
  // create firstLetter (str); possiblePos = [];
  const firstLetter = word[0];
  const possiblePos = [];
  // Iterate through board
  board.forEach((row, vertIndex) => {
      // curr arr represent a row
      // find the index of the firstLetter in curr row
      const horIndice = row.reduce((accum, curr, index) => {
          if (curr === firstLetter) {
              return accum.concat(index);
          }
          return accum;
      },[])
      if (horIndice.length > 0) {
          // if exist, [index, i] push into possible Pos
          horIndice.forEach((horIndex) => {
              possiblePos.push([horIndex, vertIndex]);
          })
      }
  })

  // Create a helper to traverse the board
  // boardTraversal(currPos, word); return a boolean
  function boardTraversal(currPos, word) {
      // base case - word.lenght === 0, return true
      if (word.length === 0) {
          return true;
      }
      const [horIndex, vertIndex] = currPos;
      if (horIndex < 0 || horIndex > board[0].length - 1) {
        return false;
      }
      if (vertIndex < 0 || vertIndex > board.length - 1) {
        return false;
      }
      if (board[vertIndex][horIndex] !== word[0]) {
        return false;
      }

      board[vertIndex][horIndex] = '*';
      const options = {
        up: [horIndex, vertIndex + 1],
        down: [horIndex, vertIndex - 1],
        left: [horIndex - 1, vertIndex],
        right: [horIndex + 1, vertIndex],
      }

      for (let dir in options) {
        if (boardTraversal(options[dir], word.slice(1))) {
          return true;
        }
      }

      board[vertIndex][horIndex] = word[0];

      return false;
  }

  // Iterate through possible pos
  for (let i = 0; i < possiblePos.length; i++) {
      // call boardTraversal with curr posistion
      if (boardTraversal(possiblePos[i], word)) {
          return true;
      }
  }


  // return false;
  return false;

};