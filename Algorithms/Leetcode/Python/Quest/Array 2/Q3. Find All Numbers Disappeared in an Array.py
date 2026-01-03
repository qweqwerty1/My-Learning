class Solution(object):
    def findDisappearedNumbers(self, nums):
        result = []

        for num in nums:
            idx = abs(num) - 1
            if nums[idx] > 0:
                nums[idx] = -nums[idx]
        
        for i in range(len(nums)):
            if nums[i] > 0:
                result.append(i + 1)

        return result
        
def main():
    nums = [1,1]
    sol = Solution()
    print(sol.findDisappearedNumbers(nums))

if __name__ == "__main__":
    main()