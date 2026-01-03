class Solution:
    def subarraySum(self, nums):
        result = 0
        for i in range(len(nums)):
            start = max(0, i - nums[i])
            result += sum(nums[start:i+1])
        return result
    
def main():
    nums = list(map(int,input().split()))
    print(Solution().subarraySum(nums))

if __name__ == "__main__":
    main()