# Solution 1: DFS
class Solution:
	def maxDepth(self, root: Optional[TreeNode]) -> int:
		if root is None: 
			return 0
		else:
			left_height = self.maxDepth(root.left)
			right_height = self.maxDepth(root.right)
			return max(left_height + right_height) + 1
    
 # Solution 2: BFS
  def maxDepth2(self, root):
    if root is None:
      return 0
    depth = 0
    level = [root]
    while level:
      depth += 1
      stack = []
      for node in level:
        if node.left:
          stack.append(node.left)
        if node.right:
          stack.append(node.right)
      level = stack
    return depth
