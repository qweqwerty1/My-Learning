from collections import Counter

class Solution(object):
    def findErrorNums(self, nums):
        count_nums = Counter(nums)
        found_key = [key for key, value in count_nums.items() if value == 2]
        set_nums = set(nums)
        original_nums = set(range(1, len(nums) + 1))
        missing_value = list(set_nums ^ original_nums)
        return [found_key[0], missing_value[0]]
        

def main():
    nums = [1,2,2,4]
    sol = Solution()
    print(sol.findErrorNums(nums))

if __name__ == "__main__":
    main()