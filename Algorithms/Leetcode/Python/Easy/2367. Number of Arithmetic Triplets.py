class Solution:
    def arithmeticTriplets(self, nums, diff):
        set_nums = set(nums)
        result = 0

        for i in set_nums:
            if (i + diff in set_nums) and (i + 2 * diff in set_nums):
                result += 1

        return result
        
def main():
    nums = list(map(int,input().split()))
    diff = int(input())

    print(Solution().arithmeticTriplets(nums, diff))

if __name__ == "__main__":
    main()