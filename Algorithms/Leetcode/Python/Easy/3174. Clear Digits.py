class Solution:
    def clearDigits(self, s):
        stack = []
        for i in s:
            if i.isdigit():
                if stack:
                    stack.pop()
            else:
                stack.append(i)
        return "".join(stack)
        

def main():
    s = "abc"
    sol = Solution()
    print(sol.clearDigits(s))
    
if __name__ == "__main__":
    main()