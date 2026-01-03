class Solution:
    def countKeyChanges(self, s):
        s = s.lower()
        n = len(s)
        result = 0

        for i in range(n-1):
            if s[i] != s[i+1]:
                result += 1

        return result
        
def main():
    s = "aAbBcCBBaaA"
    sol = Solution()
    print(sol.countKeyChanges(s))

if __name__ == "__main__":
    main()