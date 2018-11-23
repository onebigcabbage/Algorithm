# <center>剑指Offer解题思路</center>



- [二进制中1的个数](#二进制中1的个数) 
- [数值的整数次方](#数值的整数次方) 
- [调整数组顺序使奇数位于偶数前面](#调整数组顺序使奇数位于偶数前面 ) 
- [包含min函数的栈](#包含min函数的栈) 
- [栈的压入、弹出序列](#栈的压入、弹出序列) 
- [字符串的排序](#字符串的排序) 





## 二进制中1的个数

### 题目描述

输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。

> 考察二进制和位运算。

### 解题思路

代码一：

 　1. 判断整数二进制最右边一位是不是1，然后整体向右移一位，最前面补0，直至整个整数为0。</br>
 　2. 例如整数10的二进制为0000 0000 0000 0000 0000 0000 0000 1010（Java的int类型占用4个字节，即32位）。只看后四位的话，右移一位变成0101，继续右移为0010、0001、0000，可见右移三次整数就变成0。若右移过程中最后一位为1，则记录下来。</br>
 　3. 至于如何判断最后一位是否为1，可以把整数和1进行与操作判断结果是否为1即可。</br>
 　4. 缺点：如果整数是负数，则代码一会报错，因为在对负数进行右移运算时，补的是1，这样会导致死循环。

代码二：

 　1. 优化：让整数和1进行与运算，判断整数的末位是否为1；让1左移，判断倒数第二位是否为1......。例如给定整数10，二进制为1010，和1即二进制0001进行与操作，结果不为1；让1左移一位，即0001变为0010，再和1与操作，结果为1，记录下来......。</br>
 　2. 缺点：整数的二进制有多少个1就要循环多少次。

代码三：

 　1. 若整数的二进制最后一位为1，减1后最后一位变成0。例如1001 - 0001 = 1000.</br>
 　2. 若整数的二进制最后一位不为1，最后那个1是第n位，则减1后第n位的1变成0，之后的0都变为1，之前的不变。例如1100，最右边的1在第2位，减1后：1100 - 0001 = 1011。</br>
 　3. 总结：把整数减1，就是将整数的二进制最右边那个1之后的0都变成1。</br>
 　4. 接着将整数和减1的结果做与运算，作用是将第n位后的1都变成0。例如1100减1后为1011，将1100和1011与运算后为1000。</br>
 　5. 继续使用减1，与运算之后的数进行循环，直至整数变为0。</br>
 　6. 优点：整数的二进制有多少位1就运行多少次。

### 代码

```java
// 代码一
public int NumberOf(int n) {
    int count = 0;
    while(n != 0){
        if((n & 1) == 1){
            count++;
        }
        count = count >> 1;
    }
    return count;
}
```

```java
// 代码二
public int NumberOf(int n) {
    int count = 0;
    int flag = 1;
    while(flag != 0){
        if((n & flag) != 0){
            count++;
        }
        flag = flag << 1;
    }
    return count;
}
```

```java
// 代码三
public int NumberOf(int n) {
    int count = 0;
    while(n != 0){
        count++;
        n = (n - 1) & n;
    }
    return count;
}
```



------



## 数值的整数次方

### 题目描述

给定一个 *double* 类型的浮点数 *base* 和 *int* 类型的整数 *exponent* 。求 *base* 的 *exponent* 次方。

### 解题思路

 1. 首先考虑 *base* 和 *exponent* 的取值范围，如下图所示：

    ![exp](https://user-images.githubusercontent.com/37443942/48931505-a70ec880-ef31-11e8-9f29-03758013e4d8.png)

 2. 时间复杂度 *O(n)* ：使用 *base* 相乘 *exponent* 次求整数次方。

 3. 时间复杂度 *O(logn)* ：快速幂求解。


### 代码

```java
public class Solution {
    public double Power(double base, int exponent) {
        int index = 0;
        double res = 1;
        if(exponent > 0){
            index = exponent;
        }else if(exponent < 0){
            if(base == 0){
                return -1;
            }
            index = -exponent;
        }else{
            if(base == 0){
                return 0;
            }
            return 1;
        }
        while(index != 0){
            if((index & 1) == 1){
                res *= base;
            }
            base *= base;
            index = index >> 1;
        }
        return exponent>0?res:(1/res);
    }
}
```



------



## 调整数组顺序使奇数位于偶数前面 

### 题目描述

　输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。

### 解题思路

方法一：利用插入排序的思想。

1. 找到第一个偶数的位置 *p* ，从下一个位置 *p+1* 开始遍历数组。例如 [1, 2, 3, 4, 5, 6, 7]，*p = 1* ，从下标 *2* 遍历数组
2. 找到第一个奇数，位置为 *j*，从 *p* 到 *j-1* 的元素依次后移一位，空出位置 *p* 放找到的那个奇数。

方法二：利用冒泡排序的思想。

1. 将最右边的偶数冒泡移到最后一位。
2. 依次将偶数往后移...

### 代码

```java
// 代码一
public void reOrderArray(int [] array) {

    if(array == null || array.length == 0)   return;

    int p = 0;
    for(int i=0; i<array.length; i++){
        if(array[i]%2 == 0){
            p = i;
            break;
        }
    }

    if(p == array.length)   return;

    for(int i=p+1; i<array.length; i++){
        if(array[i] % 2 == 1){
            int j = i;
            int temp = array[j];
            while(j > p){
                array[j] = array[j-1];
                j--;
            }
            array[p] = temp;
            p++;
        }
        
    }
}
```

```java
// 代码二
public void reOrderArray(int [] array) {
        for(int i=0; i<array.length-1; i++){
            for(int j=0; j<array.length-1-i; j++){
                if(array[j]%2==0 && array[j+1]%2==1){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
    }
```



------



## 包含min函数的栈

### 题目描述

　定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。

### 解题思路

 1. 定义一个辅助栈，用来存储当前栈中最小的数。

 2. 将数据压入栈中时，比较当前数据和辅助栈栈顶元素大小。

 3. 若栈顶元素大，则把当前数据压入辅助栈中；反之，再次压入栈顶元素。

 4. 例如入栈元素为：7 4 5 9 2 3 1 4

    辅助栈中元素为：7 4 4 4 2 2 1 1

### 代码

```java
import java.util.Stack;
public class Solution {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
        if(stack2.empty()){
            stack2.push(node);
        }else{
            int temp = stack2.peek();
            if(node<=temp){
                 stack2.push(node);   
            }else{
                stack2.push(temp);
            }
        }
    }
    
    public void pop() {
        stack1.pop();
        stack2.pop();
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        return stack2.peek();
    }
}
```



------



## 栈的压入、弹出序列

### 题目描述

　输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）。

### 解题思路

 　1. 借助一个辅助栈，将第一个序列的元素挨个压入栈中。
 　2. 压入栈中的同时和第二个序列进行比较，若相同则弹出，反之继续压入。
 　3. 当与第二个序列比较完毕后，若栈空则第二个序列是第一个序列的弹出顺序，反之不是。

### 代码

```java
import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 || popA.length==0)    return false;
        Stack<Integer> stack = new Stack<Integer>();
        int index = 0;
        for(int i=0; i<pushA.length; i++){
            stack.push(pushA[i]);
            while(!stack.empty() && stack.peek()==popA[index]){
                stack.pop();
                index++;
            }
        }
        return stack.empty();
    }
}
```



------



## 字符串的排序

### 题目描述

 　输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串 *abc,acb,bac,bca,cab* 和 *cba* 。

### 解题思路

1. 首先想到的是使用递归的回溯法，依次将每个字符交换到最前面，之后按相同的方式排列剩下的字符。如下图所示：

   ![](https://user-images.githubusercontent.com/37443942/48931489-89d9fa00-ef31-11e8-9356-81aba5dbca04.png)

### 代码

```java
public class Solution{

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<String>();
        if(str!=null && str.length()>0){
            strPermutation(str.toCharArray(), 0, list);
            // Collections.sort(list);
        }
        return list;
    }
    public void strPermutation(char[] ch, int k, ArrayList<String> list){
        if(k == ch.length-1){
            if(!list.contains(String.valueOf(ch))){
                list.add(String.valueOf(ch));
            }
        }else{
            for(int j=k; j<ch.length; j++){
                swap(ch, k, j);
                strPermutation(ch, k+1, list);
                swap(ch, k, j);
            }
        }
    }
    public void swap(char[] ch, int k, int j){
        char temp = ch[k];
        ch[k] = ch[j];
        ch[j] = temp;
    }
}
```

