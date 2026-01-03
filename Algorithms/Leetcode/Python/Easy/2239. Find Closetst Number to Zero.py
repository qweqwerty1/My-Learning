class Solution:
    def findClosestNumber(self, nums):
        return min(nums, key=lambda num : (abs(num), -num))
    
def main():
    nums = [-100000,-100000]
    sol = Solution()
    print(sol.findClosestNumber(nums))

if __name__ == "__main__":
    main()