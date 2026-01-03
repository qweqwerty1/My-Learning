class Solution:
    def subarraySum(self, nums):
 
        def build_prefix_sum(nums):
            if not nums:
                return []
            prefix = [0] * len(nums)
            prefix[0] = nums[0]
            for i in range(1,len(nums)):
                prefix[i] = prefix[i-1] + nums[i]
            return prefix
        
        prefix_sum = build_prefix_sum(nums)
        n = len(nums)
        total_sum = 0

        for i in range(n):
            start = max(0, i - nums[i])
            total_sum += prefix_sum[i]
            if start != 0:
                total_sum -= prefix_sum[start - 1]
        return total_sum    

def main():
    nums = list(map(int,input().split()))
    print(Solution().subarraySum(nums))

if __name__ == "__main__":
    main()