const ValidAnagram = require('./ValidAnagram');

describe('Test cases for Anagram', () => {

  it('case 1', () => {
    const s = 'abc';
    const t = 'cde';
    expect(ValidAnagram(s, t)).toBe(false);
  });

  it('case 2', () => {
    const s = 'abc';
    const t = 'cba';
    expect(ValidAnagram(s, t)).toBe(true);
  });
})