package O36两个链表的第一个公共结点;


public class Solution {
	
	
	class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		if (pHead1 == null || pHead2 == null) {
			return null;
		}
		int len1 = 0, len2 = 0;
		ListNode temp1 = pHead1;
		ListNode temp2 = pHead2;
		while (temp1 != null) {
			len1++;
			temp1 = temp1.next;
		}
		while (temp2 != null) {
			len2++;
			temp2 = temp2.next;
		}
		
		temp1 = pHead1;
		temp2 = pHead2;
		
		if (len1 > len2) {
			for (int i = 0; i < len1 - len2; i++) {
				temp1 = temp1.next;
			}
		}else {
			for (int i = 0; i < len1 - len2; i++) {
				temp2 = temp2.next;
			}
		}
		
		while (temp1 != null && temp1 != temp2) {
			temp1 = temp1.next;
			temp2 = temp2.next;
		}
		return temp1;
		
    }

}
