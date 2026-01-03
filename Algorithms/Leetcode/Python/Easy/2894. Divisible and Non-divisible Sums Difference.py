class Solution:
    def differenceOfSums(self, n, m):
        num2 = sum(i for i in range(1,n+1) if i%m == 0)
        total_num = sum(range(1,n+1))
        return total_num - 2 * num2
    
n = int(input())
m = int(input())
print(Solution().differenceOfSums(n, m))