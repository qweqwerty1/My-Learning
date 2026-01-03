class Solution(object):
    def findErrorNums(self, nums):
        duplicate_num = -1
        missing_num = -1

        for num in nums:
            idx = abs(num) - 1
            
            if nums[idx] < 0:
                duplicate_num = idx + 1
            else :
                nums[idx] = -nums[idx]
            
        for i in range(len(nums)):
            if nums[i] > 0:
                missing_num = i + 1
                break

        return [duplicate_num, missing_num]


def main():
    nums = [1,3,3]
    sol = Solution()
    print(sol.findErrorNums(nums))

if __name__ == "__main__":
    main()