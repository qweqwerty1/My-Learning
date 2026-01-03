class Solution:
    def alternatingSum(self, nums):
        result = 0
        n = len(nums)
        for i in range(n):
            if i%2 == 0:
                result += nums[i]
            else:
                result -= nums[i]
        return result

def main():
    nums = [1,3,5,7]
    sol = Solution()
    print(sol.alternatingSum(nums))

if __name__ == "__main__":
    main()