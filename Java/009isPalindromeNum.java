// Solution 1 - Convert to String

public boolean isPalindrome(int x) {
    String revStr = (new StringBuilder(x + "")).reverse().toString();
    return (x + "").equals(revStr);
}

//Time Complexity: $O(N)$  
//Space Complexity: $O(N)$ to store the reversed string.


//Solution 2 - Revert half of the number
```java
public boolean isPalindrome2(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0))
        return false;
    int revNum = 0;
    while ( x > revNum){
        revNum = revNum * 10 + x % 10;
        x /= 10;
    }
    return x == revNum || x == revNum / 10;
}
```
//Time Complexity: $O(log_10(n))$ 
//Space Complexity: $O(1)$
