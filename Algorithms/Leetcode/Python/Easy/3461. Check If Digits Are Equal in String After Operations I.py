class Solution:
    def hasSameDigits(self, s):
        def operation(arr):
            n = len(arr)
            result = []
            for i in range(n-1):
                result += str((int(arr[i]) + int(arr[i+1])) % 10)
            return "".join(result)
        
        while len(s) > 2:
            s = operation(s)

        return s[0] == s[1]
    
def main():
    s = "34789"
    sol = Solution()
    print(sol.hasSameDigits(s))

if __name__ == "__main__":
    main()