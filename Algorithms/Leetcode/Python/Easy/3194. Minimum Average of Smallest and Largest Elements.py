class Solution:
    def minimumAverage(self, nums):
        nums.sort()
        i, j = 0, len(nums) - 1
        avg_nums = float('inf')
        
        while i < j:
            avg_nums = min(avg_nums, (nums[i]+nums[j])/2)
            i += 1
            j -= 1
        
        return avg_nums

def main():
    nums = [7,8,3,4,15,13,4,1]
    print(Solution().minimumAverage(nums))

if __name__ == "__main__":
    main()