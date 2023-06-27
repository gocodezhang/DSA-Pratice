const TwoSum = require('./TwoSum').TwoSum;
const TwoSumLinear = require('./TwoSum').TwoSumLinear;

describe('Test cases for Native solution', () => {
  it('case 1', () => {
    const nums = [2,7,11,15]
    const target = 9
    expect(TwoSum(nums, target)).toEqual([0,1])
  });

  it('case 2', () => {
    const nums = [3,2,4]
    const target = 6
    expect(TwoSum(nums, target)).toEqual([1,2])
  });

  it('case 3', () => {
    const nums = [3,2,3]
    const target = 6
    expect(TwoSum(nums, target)).toEqual([0,2])
  });
})

describe('Test cases for Linear solution', () => {
  it('case 1', () => {
    const nums = [2,7,11,15]
    const target = 9
    expect(TwoSumLinear(nums, target)).toEqual([0,1])
  });

  it('case 2', () => {
    const nums = [3,2,4]
    const target = 6
    expect(TwoSumLinear(nums, target)).toEqual([1,2])
  });

  it('case 3', () => {
    const nums = [3,2,3]
    const target = 6
    expect(TwoSumLinear(nums, target)).toEqual([0,2])
  });
})