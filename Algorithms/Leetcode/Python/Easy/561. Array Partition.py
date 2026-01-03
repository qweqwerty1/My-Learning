class Solution:
    def arrayPairSum(self, nums):
        return sum(sorted(nums)[::2])

def main():
    nums = [1,4,3,2]
    sol = Solution()
    print(sol.arrayPairSum(nums))

if __name__ == "__main__":
    main()