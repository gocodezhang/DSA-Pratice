const { containsDuplicate, containsDuplicateLinear } = require('./ContainsDuplicate');

describe('Test cases for containsDuplicate', () => {

  it('case 1', () => {
    const nums = [1,2,3,4];
    expect(containsDuplicate(nums)).toBe(false);
  });

  it('case 2', () => {
    const nums = [1,2,3,1];
    expect(containsDuplicate(nums)).toBe(true);
  });

  it('case 3', () => {
    const nums = [1,2,3,4,5,6,7,9,2];
    expect(containsDuplicate(nums)).toBe(true);
  })
})

describe('Test cases for containsDuplicateLinear', () => {

  it('case 1', () => {
    const nums = [1,2,3,4];
    expect(containsDuplicateLinear(nums)).toBe(false);
  });

  it('case 2', () => {
    const nums = [1,2,3,1];
    expect(containsDuplicateLinear(nums)).toBe(true);
  });

  it('case 3', () => {
    const nums = [1,2,3,4,5,6,7,9,2];
    expect(containsDuplicateLinear(nums)).toBe(true);
  })
})