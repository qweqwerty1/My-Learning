class Solution:
    def canAliceWin(self, nums):
        single_digits = 0
        double_digits = 0
        for n in nums:
            if n < 10:
                single_digits += n
            else:
                double_digits += n
        return single_digits != double_digits

def main():
    nums = [1,2,3,4,10]
    sol = Solution()
    print(sol.canAliceWin(nums))

if __name__ == "__main__":
    main()