public class Solution {
    /*
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)  return null;
        ListNode list = new ListNode(0);
        ListNode cur = list;
        int carry = 0;
        while(l1!=null || l2!=null){
            int x = (l1!=null) ? l1.val : 0;
            int y = (l2!=null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            if(l1 != null)   l1 = l1.next;
            if(l2 != null)   l2 = l2.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return list.next;
    }
    */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1==null && l2==null)  return null;
        ListNode list = new ListNode(0), cur = list;
        int carry = 0;
        while(l1!=null || l2!=null){
            if(l1 == null){
                int sum = l2.val + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l2 = l2.next;
                continue;
            }
            if(l2 == null){
                int sum = l1.val + carry;
                carry = sum / 10;
                cur.next = new ListNode(sum % 10);
                cur = cur.next;
                l1 = l1.next;
                continue;
            }

            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            cur.next = new ListNode(sum % 10);
            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(carry > 0){
            cur.next = new ListNode(carry);
        }
        return list.next;
    }

}