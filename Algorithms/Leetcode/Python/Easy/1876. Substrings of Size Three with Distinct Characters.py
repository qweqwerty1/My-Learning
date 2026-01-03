class Solution:
    def countGoodSubstrings(self, s):
        n = len(s)
        result = 0
        for i in range(n-2):
            if len(set(s[i:i+3])) == 3:
                result += 1
        return result 

def main():
    s = "owuxoelszb"
    sol = Solution()
    print(sol.countGoodSubstrings(s))

if __name__ == "__main__":
    main()