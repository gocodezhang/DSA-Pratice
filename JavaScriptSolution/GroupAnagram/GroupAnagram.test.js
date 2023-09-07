const { groupAnagramsQuadratic, groupAnagramsLinear } = require('./GroupAnagram');

function compareArr(arr1, arr2) {
  if (arr1.length !== arr2.length) {
    return false
  }

  for (let i = 0; i < arr1.length; i++) {
    const currElement = arr1[i]
    const corresponding = arr2.filter((element) => (element.length === currElement.length))[0];
    for (let j = 0; j < currElement.length; j++) {
      if (!corresponding.includes(currElement[j])) {
        return false
      }
    }
  }
  return true;
}

describe('Test cases for GroupAnagramQuadratic', () => {

  it('case 1', () => {
    const strs = ["eat","tea","tan","ate","nat","bat"]
    const output = [["bat"],["nat","tan"],["ate","eat","tea"]]
    const actual = groupAnagramsQuadratic(strs);
    console.log(actual);
    expect(compareArr(actual,output)).toBe(true);
  })
})

describe('Test cases for GroupAnagramLinear', () => {

  it('case 1', () => {
    const strs = ["eat","tea","tan","ate","nat","bat"]
    const output = [["bat"],["nat","tan"],["ate","eat","tea"]]
    const actual = groupAnagramsLinear(strs);
    console.log(actual);
    expect(compareArr(actual,output)).toBe(true);
  })
})