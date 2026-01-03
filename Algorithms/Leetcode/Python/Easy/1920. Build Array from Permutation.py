class Solution(object):
    def buildArray(self, nums):
        n = len(nums)
        nums = [nums[i] + n * (nums[nums[i]] % n) for i in range(n)]
        nums = [i // n for i in nums]
        return nums

nums = list(map(int,input().split()))
print(Solution().buildArray(nums))