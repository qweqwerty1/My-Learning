class Solution():
    def getConcatenation(self, nums):
        nums.extend(nums)
        return nums

def main():
    nums = [1,2,1]
    sol = Solution()
    print(sol.getConcatenation(nums))

if __name__ == "__main__":
    main()