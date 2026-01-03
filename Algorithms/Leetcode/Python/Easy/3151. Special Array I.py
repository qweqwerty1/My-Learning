class Solution:
    def isArraySpecial(self, nums):
        n = len(nums)
        for i in range(n - 1):
            if (nums[i] & 1) == (nums[i+1] & 1):
                return False
        return True

def main():
    nums = [4,3,1,6]
    sol = Solution()
    print(sol.isArraySpecial(nums))

if __name__ == "__main__":
    main()