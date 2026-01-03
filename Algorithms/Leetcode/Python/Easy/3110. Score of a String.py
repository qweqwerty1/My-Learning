class Solution:
    def scoreOfString(self, s):
        return sum(abs(ord(i) - ord(j)) for i, j in zip(s, s[1:]))
    
s = input()
print(Solution().scoreOfString(s))