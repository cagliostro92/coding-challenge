package edoardo.patti.leetcode;

/**
 * <a href="https://leetcode.com/problems/add-two-numbers/description/">Add Two numbers</a>
 */
public class AddTwoNumbers {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

    ListNode result = null;
    ListNode next = null;
    byte rem = -1;
    while(!(l1 == null && l2 == null && rem == 0)) {
      var sum =
          (l1 != null ? l1.val : 0)
          + (l2 != null ? l2.val : 0)
          + (rem > 0 ? 1 : 0);
      if(sum > 9) {
        sum = sum % 10;
        rem = 1;
      } else {
        rem = 0;
      }
      l1 = l1 != null ? l1.next : null;
      l2 = l2 != null ? l2.next : null;
      if(result == null) {
        result = new ListNode(sum);
        next = result;
      } else {
        next.next = new ListNode(sum);
        next = next.next;
      }
    }

    return result;
  }

  public static class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
