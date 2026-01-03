class Solution:
    def getConcatenation(self, nums):
        return nums + nums

def main():
    nums = list(map(int,input().split()))
    print(Solution().getConcatenation(nums))

if __name__ == "__main__":
    main()