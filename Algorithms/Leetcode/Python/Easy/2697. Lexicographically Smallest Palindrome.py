class Solution:
    def makeSmallestPalindrome(self, s):
        n = len(s)//2
        p1 = s[:n]
        p2 = s[-n:][::-1]
        result = ""

        for x, y in zip(p1,p2):
            if ord(x) >= ord(y):
                result += y
            else:
                result += x

        return result + result[::-1] if len(s) % 2 == 0 else result + s[n] + result[::-1]

def main():
    s = "seavaeq"
    sol = Solution()
    print(sol.makeSmallestPalindrome(s))

if __name__ == "__main__":
    main()