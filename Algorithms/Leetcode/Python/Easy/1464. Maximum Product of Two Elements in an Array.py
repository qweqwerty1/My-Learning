class Solution:
    def maxProduct(self, nums):
        first = second = 0
        for i in nums:
            if i > first:
                second = first
                first = i
            elif i > second:
                second = i
        return (first - 1) * (second - 1)

def main():
    nums = [3,4,5,2]
    sol = Solution()
    print(sol.maxProduct(nums))

if __name__ == "__main__":
    main()