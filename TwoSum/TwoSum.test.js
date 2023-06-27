const TwoSum = require('./TwoSum');

describe('Test cases for TwoSum', () => {
  it('case 1', () => {
    const nums = [2,7,11,15]
    const target = 9
    expect(TwoSum(nums, target)).toEqual([0,1])
  });

  it('case 2', () => {
    const nums = [3,2,4]
    const target = 6
    expect(TwoSum(nums, target)).toEqual([1,2])
  })
})