// Solution 1 - Campare with Reverse
public boolean isPalindrome(String s) {
    StringBuilder builder = new StringBuilder();

    for (char ch : s.toCharArray()){
        if(Character.isLetterOrDigit(ch)){
            builder.append(Character.toLowerCase(ch));
        }
    }

    return builder.toString().equals(builder.reverse().toString());

}
// Solution 2
public boolean isPalindrome2(String s) {
    for (int i = 0, j = s.length() - 1; i < j; i++, j--){
        while (i<j && !Character.isLetterOrDigit(s.charAt(i))){
            i++;
        }
        while (i<j && !Character.isLetterOrDigit(s.charAt(j))){
            j--;
        }
        if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
            return false;
    }
    return true;

}
