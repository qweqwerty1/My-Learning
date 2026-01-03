from collections import Counter

class Solution:
    def frequencySort(self, nums):
        freq = Counter(nums)

        return sorted(nums, key=lambda x : (freq[x], -x))

def main():
    nums = [-1,1,-6,4,5,-6,1,4,1]
    sol = Solution()
    print(sol.frequencySort(nums))

if __name__ == "__main__":
    main()