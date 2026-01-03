class Node:
    def __init__(self, val = None, children = None):
        self.val = val
        self.children = children if children is not None else []

class Solution:
    def postorder(self, root):
        result = []
        
        def traverse(node):
            if not node:
                return
            
            for child in node.children:
                traverse(child)

            result.append(node.val)

        traverse(root)
        return result


def main():
    child_1_1 = Node(5)
    child_1_2 = Node(6)
    child_1 = Node(3,[child_1_1, child_1_2])
    child_2 = Node(2)
    child_3 = Node(4)
    head = Node(1,[child_1, child_2, child_3])

    sol = Solution()

    print(sol.postorder(head))

if __name__ == "__main__":
    main()