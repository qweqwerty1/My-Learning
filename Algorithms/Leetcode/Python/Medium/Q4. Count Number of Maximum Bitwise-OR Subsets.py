import operator
import functools

class Solution:
    def countMaxOrSubsets(self, nums):
        max_value = functools.reduce(operator.or_, nums)

        def function(current_value = 0, i = 0):
            if i == len(nums):
                return 1 if current_value == max_value else 0
            
            # left
            count_left = function(current_value, i + 1)

            # right
            count_right = function(current_value|nums[i], i + 1)

            return count_left + count_right

        return function()

def main():
    nums = [3,1]
    sol = Solution()
    print(sol.countMaxOrSubsets(nums))

if __name__ == "__main__":
    main()