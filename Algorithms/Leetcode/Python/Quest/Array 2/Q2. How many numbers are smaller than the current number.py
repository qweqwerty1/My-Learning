class Solution(object):
    def smallerNumbersThanCurrent(self, nums):
        sort_nums = sorted(nums)
        ranked_nums = {}
        for value, key in enumerate(sort_nums):
            if key not in ranked_nums:
                ranked_nums[key] = value
        result = [ranked_nums[key] for key in nums]
        return result

def main():
        nums = [1,3,4,5,7,2,3]
        sol = Solution()
        print(sol.smallerNumbersThanCurrent(nums))
        
if __name__ == "__main__":
    main()