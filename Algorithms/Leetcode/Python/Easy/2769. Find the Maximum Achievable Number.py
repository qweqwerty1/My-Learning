class Solution(object):
    def theMaximumAchievableX(self, num, t):
        return num + 2 * t
    
num = int(input())
t = int(input())
print(Solution().theMaximumAchievableX(num, t))