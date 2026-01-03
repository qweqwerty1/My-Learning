class Solution:
    def sumOfSquares(self, nums):
        n = len(nums)
        result = 0
        for i in range(n):
            if n % (i+1) == 0:
                result += nums[i] ** 2
        return result

def main():
    nums = [1,3,4,5,7]
    sol = Solution()
    print(sol.sumOfSquares(nums))

if __name__ == "__main__":
    main()