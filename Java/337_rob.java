
/*### 337. House Robber III
> Given the `root` of the binary tree, return the maximum amount of money the thief can rob without breaking *two directly-linked houses*

```
Input: root = [(3),2,3,null,(3),null,(1)]
Output: 7
Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Input: root = [3,(4),(5),1,3,null,1]
Output: 9
Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9 > (3+1+3+1) = 8
```
*/

// Solution 1 - Brute Force (DFS Recursion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public int rob(TreeNode root) {
    if (root == null) return 0;
    int money = root.val;
    if (root.left != null) 
        money += (rob(root.left.left) + rob(root.left.right));
    if (root.right != null) 
        money += (rob(root.right.left) + rob(root.right.right));
    return Math.max(money, rob(root.left) + rob(root.right));
}
/*
Time Complexity: $O(2^n)$
- The amount of operations needed, for each level of recursion, grows exponentially (x2) as the depth approaches N

Space Complexity: O(n) for recursion stack
*/

// Solution 2 - Top-down DP with Memoization (HashMap)
public int rob(TreeNode root) {
    return memo(root, new HashMap<>());
}
public int memo(TreeNode root, HashMap<TreeNode,Integer> dp) {
    if (root == null) return 0;
    if (dp.containsKey(root)) return dp.get(root);

    int money = root.val;
    if (root.left != null)
        money += memo(root.left.left,dp) + memo(root.left.right,dp);
    if (root.right != null)
        money += memo(root.right.left,dp) + memo(root.right.right,dp);

    money = Math.max(money,memo(root.left,dp)+memo(root.right,dp));
    dp.put(root,money);
    return money;
}
/*
Time Complexity: O(n)

Space Complexity: O(n) for recursion stack and HashMap
*/

//Solution 3. Bottom-up DP with Tabulation
/*
**Idea:**  
For each tree root, there are two scenarios: it *is robbed* or *is not*. 
- `rob(root)` does not distinguish between these two cases, so "information is lost as the recursion goes deeper and deeper", which results in repeated subproblems.

**Redefine robTab(root):**  
A new function which will return an array of TWO elements, 
- dp[0] denotes the maximum amount of money that can be robbed if this.root is not robbed
- dp[1]signifies the maximum amount of money robbed if it is robbed.

**Calculation:**  
DP[0] = *sum up the larger* elements of robTab(root.left) and robTab(root.right)
- since `root` is NOT robbed and we are free to rob its left and right subtrees

DP[1] = root.val + left[0] + right[0]
- since `root` is robbed and we CANNOT rob the nodes of root.left and root.right.
*/

public int rob(TreeNode root) {
    int[] dp = robTab(root);
    return Math.max(dp[0],dp[1]);
}
public int[] robTab(TreeNode root) {
    if (root == null) return new int[2];
    int[] dp = new int[2];
    int[] left = robTab(root.left);
    int[] right = robTab(root.right);

    dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
    dp[1] = root.val + left[0] + right[0];

    return dp;
}
/*
Time Complexity: O(n) 

Space Complexity: O(n) for arrays and recursion stack
*/
