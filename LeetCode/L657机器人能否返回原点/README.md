难度：简单

代码：

```java
public boolean judgeCircle(String moves) {
    if(moves==null) return true;
    int row = 0, col = 0;
    for(int i=0; i<moves.length(); i++) {
        switch (moves.charAt(i)) {
        case 'U':
            row += 1;
            break;
        case 'D':
            row -= 1;
            break;
        case 'L':
            col -= 1;
            break;
        case 'R':
            col += 1;
            break;
        }
    }
    if(row==0 && col==0) {
        return true;
    }else {
        return false;
    }
}
```



