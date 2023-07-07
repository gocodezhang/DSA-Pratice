const mergeTwoLists = require('./MergeTwoLinkedList.js');

describe('debugging', () => {

  function ListNode(val, next) {
    this.val = (val===undefined ? 0 : val)
    this.next = (next===undefined ? null : next)
  }
  it('debug 1', () => {
    const list1 = new ListNode(1, new ListNode(2, new ListNode(4)));
    const list2 = new ListNode(1, new ListNode(3, new ListNode(4)));
    console.log(mergeTwoLists(list1, list2))
  })
})