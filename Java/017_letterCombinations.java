//Solution - Backtracking & Recursion
public List<String> letterCombinations(String digits) {
    List<String> combinations = new ArrayList<String>();
    Map<Character,String> phoneMap = Map.of('2',"abc",'3',"def",'4',"ghi",'5',"jkl",
                                            '6',"mno",'7',"pqrs",'8',"tuv",'9',"wxyz");
    if (digits.length()!=0) backtrack(combinations,phoneMap,digits,0,new StringBuffer());
    return combinations;
}
public void backtrack(List<String> combinations, Map<Character,String> phoneMap, 
                      String digits, int index, StringBuffer combination){
    if(index==digits.length()){
        combinations.add(combination.toString());
    }else{
        String letters = phoneMap.get(digits.charAt(index));
        for(char letter:letters.toCharArray()){
            combination.append(letter);
            backtrack(combinations,phoneMap,digits,index+1,combination);
            combination.deleteCharAt(index);
        }
    }
}
//Time Complexity: $O(N· 4^N)$, where N is the length of `digits`  
//Space Complexity: $O(N)$ for recursion stack
