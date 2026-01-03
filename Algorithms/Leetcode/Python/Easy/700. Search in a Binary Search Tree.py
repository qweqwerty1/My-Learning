class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def searchBST(self, root, val):
        cur = root

        while cur is not None and cur.val != val:
            if cur.val > val:
                cur = cur.left
            else:
                cur = cur.right

        return cur

def main():
    left_left_node = TreeNode(1)
    left_right_node = TreeNode(3)
    left_node = TreeNode(2, left_left_node, left_right_node)
    right_node = TreeNode(7)
    root = TreeNode(4, left_node, right_node)
    sol = Solution()
    val = 4
    print(sol.searchBST(root,val))

if __name__ == "__main__":
    main()