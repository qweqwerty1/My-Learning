class Solution:
    def maximizeSum(self, nums, k):
        maximum_num = max(nums)
        x = (k-1)*k//2
        return maximum_num * k + x

def main():
    nums = [5,5,5]
    k = 2
    sol = Solution()
    print(sol.maximizeSum(nums, k))

if __name__ == "__main__":
    main()