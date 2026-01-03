class Solution:
    def minElement(self, nums):
        return min(sum(int(d) for d in str(num)) for num in nums)
    
def main():
    nums = [999,19,199]
    print(Solution().minElement(nums))

if __name__ == "__main__":
    main()