class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def evaluateTree(self, root):
        if root.left == None:
            return root.val == 1
        
        left_value = self.evaluateTree(root.left)
        right_value = self.evaluateTree(root.right)

        if root.val == 2:
            return left_value or right_value
        else:
            return left_value and right_value
        
def main():
    leaf_for_left = TreeNode(1)
    leaf_for_right_left = TreeNode(0)
    leaf_for_right_right = TreeNode(1)

    middle_node_3 = TreeNode(3, leaf_for_right_left, leaf_for_right_right)

    root = TreeNode(2, leaf_for_left, middle_node_3)
    
    sol = Solution()
    print(sol.evaluateTree(root))

if __name__ == "__main__":
    main()