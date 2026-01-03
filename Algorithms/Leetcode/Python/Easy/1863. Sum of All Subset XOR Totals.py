class Solution:
    def subsetXORSum(self, nums):
        self.total_sum = 0

        def dfs(index, current_xor_total):
            if index == len(nums):
                self.total_sum += current_xor_total
                return 
            dfs(index + 1, current_xor_total ^ nums[index])
            dfs(index + 1, current_xor_total)

        dfs(0, 0)
        return self.total_sum

def main():
    nums = list(map(int,input().split()))
    print(Solution().subsetXORSum(nums))

if __name__ == "__main__":
    main()