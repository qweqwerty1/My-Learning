from collections import Counter

class Solution:
    def countKDifference(self, nums, k):
        count = Counter(nums)
        result = 0
        for num in count:
            result += count[num] * count.get(num + k, 0)
        return result

def main():
    nums = [1,2,2,1]
    k = 1
    print(Solution().countKDifference(nums,k))

if __name__ == "__main__":
    main()