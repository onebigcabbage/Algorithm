难度：中等

思路：
1. 时间复杂度：$O(m+n)$ ，空间复杂度：$O(m+n)$

   - 合并两个数组；
   - z找到中位数。

2. 滑动窗口

   - 设置字符串 *s*，设置指针 $i$ ，$j$ ；

   - 从首位字符 $i=0$ 开始，依次将字符添加到 *s* 的末尾，直至碰到有重复的字符；

   - 从字符串 *s* 得到重复字符的所在位置设为 $j‘$ ，取 *s* 从 $j‘+1$ 到 $i$ 的子串作为当前字符串；

   - 继续遍历，直至遇到重复的字符。

代码：
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        int i = 0, j = 0, count = 0;
        int[] nums = new int[m+n];
        if(m == 0 && n == 0){
            return 0.0;
        }
        if(m == 0){
            if(n % 2 == 0){
                return (nums2[n/2-1] + nums2[n/2]) / 2.0;
            }else{
                return nums2[n/2];
            }
        }
        if(n == 0){
            if(m % 2 == 0){
                return (nums1[m/2-1] + nums1[m/2]) / 2.0;
            }else{
                return nums1[m/2];
            }
        }
        while(count != (m+n)){
            if(i == m){
                while(j != n){
                    nums[count++] = nums2[j++];
                }
                break;
            }
            if(j == n){
                while(i != m){
                    nums[count++] = nums1[i++];
                }
                break;
            }
            if(nums1[i] <= nums2[j]){
                nums[count++] = nums1[i++];
            }else{
                nums[count++] = nums2[j++];
            }
        }
        if(count % 2 == 0){
            return (nums[count/2-1] + nums[count/2]) / 2.0;
        }else{
            return nums[count/2];
        }
    }
```

```java
public int lengthOfLongestSubstring(String s) {
        int count = 0;
        String temp = "";
        int j = 0;
        for(int i=0; i<s.length(); i++){
            if(temp.contains(Character.toString(s.charAt(i)))){
                temp = temp.substring(temp.indexOf(s.charAt(i))+1, temp.length());
            }
            temp += s.charAt(i);
            count = Math.max(count, temp.length());
        }
        return count;
    }
```

