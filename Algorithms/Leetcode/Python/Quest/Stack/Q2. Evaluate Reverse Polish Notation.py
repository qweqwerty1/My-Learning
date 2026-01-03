class Solution:
    def evalRPN(self, tokens):
        stack = []
        operations = {"+","-","*","/"}

        for i in tokens:
            if i not in operations:
                stack.append(int(i))
            else:
                b = stack.pop()
                a = stack.pop()
                stack.append(self.four_basic_operations(i, a, b))

        return stack[0]
    
    def four_basic_operations(self, str, a, b):
        match str:
            case '+':
                return a + b
            case '-':
                return a - b
            case '/':
                return int(a/b)
            case '*':
                return a * b

def main():
    tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
    sol = Solution()
    print(sol.evalRPN(tokens))

if __name__ == "__main__":
    main()