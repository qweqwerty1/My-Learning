class Solution:
    def maxProductDifference(self, nums):
        nums.sort()
        return (nums[-1] * nums[-2]) - (nums[0] * nums[1])

def main():
    nums = [4,2,5,9,7,4,8]
    sol = Solution()
    print(sol.maxProductDifference(nums))

if __name__ == "__main__":
    main()