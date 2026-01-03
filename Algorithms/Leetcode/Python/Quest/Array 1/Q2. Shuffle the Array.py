class Solution():
    def shuffle(self, nums, n):
        result = []
        for i in range(n):
            result.append(nums[i])
            result.append(nums[i+n])
        return result
    
def main():
    nums = [2,5,1,3,4,7]
    n = 3
    sol = Solution()
    print(sol.shuffle(nums, n))

if __name__ == "__main__":
    main()