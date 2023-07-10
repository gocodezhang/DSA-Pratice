/*
Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.

Machine 1 (sender) has the function:

string encode(vector<string> strs) {
  // ... your code
  return encoded_string;
}
Machine 2 (receiver) has the function:
vector<string> decode(string s) {
  //... your code
  return strs;
}
So Machine 1 does:

string encoded_string = encode(strs);
and Machine 2 does:

vector<string> strs2 = decode(encoded_string);
strs2 in Machine 2 should be the same as strs in Machine 1.

Implement the encode and decode methods.

You are not allowed to solve the problem using any serialize methods (such as eval).


Example 1:

Input: dummy_input = ["Hello","World"]
Output: ["Hello","World"]

Explanation:
Machine 1:
Codec encoder = new Codec();
String msg = encoder.encode(strs);
Machine 1 ---msg---> Machine 2

Machine 2:
Codec decoder = new Codec();
String[] strs = decoder.decode(msg);
Example 2:

Input: dummy_input = [""]
Output: [""]


Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] contains any possible characters out of 256 valid ASCII characters.


Follow up: Could you write a generalized algorithm to work on any possible set of characters?
*/

// I: an array of strings
// O: a single string (delimiter: "," escape: "/")
// E: none
// C: none

function encode(strs) {
  // 1. create an empty str
  let resultStr = '';
  // 2. iterate over the array
  for (let i = 0; i < strs.length; i++) {
    let currStr = strs[i];
    // check if the curr str contains "/"
    if (currStr.indexOf('/') !== -1) {
      // add "/" in front to escape
      currStr = currStr.replaceAll('/','//');
    }
    // add the curr str into resultStr
    resultStr = resultStr + currStr + '/,';
  }
  return resultStr;
}

function decode(s) {
  const resArr = [];
  let escapeMode = false;
  let currStr = '';
  // iterate over the string
  for (let i = 0; i < s.length; i++) {
    const currLetter = s[i];
    // if escapeMode === true
    if (escapeMode) {
      // add curr letter into curr str
      currStr = currStr + currLetter;
      // set escapeMode = false
      escapeMode = false;
    } else {
      // if we are not in escapeMode
        if (currLetter === '/') {
          // check the next letter - if next letter is "/"
          if (s[i + 1] === '/') {
            // we escape curr letter and move to next
            // set escapeMode = true
            escapeMode = true;
          } else {
            // add curr str into the resArr and move to the next two posistion
            resArr.push(currStr);
            i++
            // reset curr str
            currStr = '';
          }
        } else {
          currStr = currStr + currLetter;
        }
    }
  }
  // return resArr
  return resArr;
}