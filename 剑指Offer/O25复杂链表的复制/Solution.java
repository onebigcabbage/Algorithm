package O25复杂链表的复制;


class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class Solution {
	
    public RandomListNode Clone(RandomListNode pHead) {
    	if (pHead == null) {
    		return null;
    	}
    	// 复制next，A->B->C => A->A'->B->B'->C->C'
    	RandomListNode newNode = pHead;
    	while (newNode != null) {
    		RandomListNode node = new RandomListNode(newNode.label);
    		node.next = newNode.next;
    		newNode.next = node;
    		newNode = node.next;
    	}
    	// 复制random
    	newNode = pHead;
    	while (newNode != null) {
    		if (newNode.random != null) {
    			newNode.next.random = newNode.random.next;
    		}
    		newNode = newNode.next.next;
    	}
    	// 拆链表
    	newNode = pHead;
    	RandomListNode Head = newNode.next;
    	RandomListNode tempNode = Head;
    	
    	newNode.next = tempNode.next;
    	newNode = newNode.next;
    	while (newNode != null) {
    		tempNode.next = newNode.next;
    		tempNode = tempNode.next;
    		newNode.next = tempNode.next;
    		newNode = newNode.next;
    	}
    	return Head;
    }
}
