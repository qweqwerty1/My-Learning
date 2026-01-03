class Solution(object):
    def findMaxConsecutiveOnes(self, nums):
        max_nums = 0
        cnt = 0
        for i in nums:
            if i == 1:
                cnt += 1
            else:
                max_nums = max(max_nums, cnt)
                cnt = 0
        max_nums = max(max_nums, cnt)
        return max_nums
        
def main():
    nums = [1,1,0,1,1,1]
    sol = Solution()
    print(sol.findMaxConsecutiveOnes(nums))
    return 0

if __name__ == "__main__":
    main()