class Solution:
    def minOperations(self, nums):
        maximum_value = 0
        result = 0
        for num in nums:
            if num > maximum_value:
                maximum_value = num
            else:
                maximum_value += 1
                result += maximum_value - num
        return result

def main():
    nums = [1,4,4,7,8,4,20,500,1]
    sol = Solution()
    print(sol.minOperations(nums))
    
if __name__ == "__main__":
    main()