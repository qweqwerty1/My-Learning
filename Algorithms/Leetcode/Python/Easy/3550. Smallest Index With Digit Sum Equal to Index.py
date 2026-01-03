class Solution:
    def smallestIndex(self, nums):
        for index, value in enumerate(nums):
            sum_value = sum(int(v) for v in str(value))
            if sum_value == index:
                return index
        else:
            return -1

def main():
    nums = [1,2,3]
    sol = Solution()
    print(sol.smallestIndex(nums))

if __name__ == "__main__":
    main()