class Solution:
    def maxDepth(self, s):
        count = 0
        result = 0
        for i in s:
            if i == "(":
                count += 1
                if count > result:
                    result = count
            elif i == ")":
                count -= 1
        return result
        
def main():
    s = "8*((1*(5+6))*(8/6))"
    print(Solution().maxDepth(s))
    
if __name__ == "__main__":
    main()