//Solution 1 - String Index Manipulation

public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') end--;
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') start--;
    return end - start; 
}

//Time Complexity: $O(N)$   
// Space Complexity: $O(1)$ 


// Solution 2 - Built-in String Functions
public int lengthOfLastWord(String s) {
    return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    // String.trim(): this function returns a copy of the string, with the leading and trailing whitespaces trimmed.
    // 
    // String.lastIndexOf(char): this function returns the index of the last occurrence of the given character.
}


//Time Complexity: $O(N)$   

//Space Complexity: $O(N)$ to hold the copy of the input string without leading and trailing whitespace.
