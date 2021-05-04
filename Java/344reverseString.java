// Solution 1 - Two Pointers, iteration
public void reverseString(char[] s) {
    for (int left = 0, right = s.length - 1; left < right; left++, right--){
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
    }
}
//Time Complexity: $O(N)$ to swap N/2 element   
//Space Complexity: $O(1)$


// Solution 2 - Recursive
public void reverseString2(char[] s) {
    recurReverse(s, 0, s.length - 1);
}
public void recurReverse(char[] s, int left, int right){
    if (left >= right) return; // Base case
    char temp = s[left];
    s[left++] = s[right];
    s[right--] = temp;
    recurReverse(s, left, right);
}
//Time Complexity: $O(N)$ to swap N/2 element   
//Space Complexity: $O(N)$ to keep the *recursion stack*
