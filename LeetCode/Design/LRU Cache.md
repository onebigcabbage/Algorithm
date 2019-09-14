##### [原题链接](https://leetcode-cn.com/problems/lru-cache/) 

##### 难度 medium

##### 思路

1. 使用 map 存储给定的键值对，原因是便于快速查找密钥 (key) 是否存在于缓存中；使用双向链表存储数据，链表中的数据包括：密钥 (key)，密钥值 (value)，前向指针 pre，后向指针 next，原因是便于删除和插入头结点。
2. 获取数据 `get(key)` ：若 map 中包括密钥 (key)，先将其在链表中的位置上删掉，然后重新插入到头结点，代表访问了该数据，该数据应该放到第一位。
3. 写入数据 `put(key, value)` ：若 map 中包括密钥 (key)，和上面的操作相同；若不包含的话，插入之前需要判断下缓存是否已满，若已满，则删除链表最后一个再插入该数据。

> 难点在于想到要用 map 和双向链表两个数据结构，同时还要自己创建一个双向链表结构。

##### 代码

```java
class LRUCache {
    
    Node head = new Node(0, 0), tail = new Node(0, 0);
	Map<Integer, Node> map = new HashMap<Integer, Node>();
	int capacity;

    public LRUCache(int capacity) {
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
        	Node node = map.get(key);
        	remove(node);
        	insert(node);
        	return node.value;
        } else {
        	return -1;
        }
    }
    
    public void put(int key, int value) {
        if (map.containsKey(key)) {
    		remove(map.get(key));
    	}
    	if (map.size() == capacity) {
    		remove(tail.pre);
    	}
    	insert(new Node(key, value));
    }
    
    private void insert(Node node) {
    	map.put(node.key, node);
    	node.next = head.next;
    	head.next.pre = node;
    	head.next = node;
    	node.pre = head;
	}

	private void remove(Node node) {
		map.remove(node.key);
		node.pre.next = node.next;
		node.next.pre = node.pre;
	}
    
}

class Node {
	int key, value;
	Node pre, next;
	public Node(int key, int value) {
		this.key = key;
		this.value = value;
	}
}
```

